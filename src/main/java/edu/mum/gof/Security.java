package edu.mum.gof;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
 
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity( prePostEnabled = true )
public class Security extends WebSecurityConfigurerAdapter
{
     @Autowired
    private DataSource dataSource;
 

 	@Value("${spring.queries.users-query}")
 	private String usersQuery;

 	@Value("${spring.queries.roles-query}")
 	private String rolesQuery;
 	
    @Autowired
    public void configureGlobal( AuthenticationManagerBuilder auth ) throws Exception
    {
/*      The authentication provider below uses JDBC to retrieve your credentials
        The data source bean configuration can be found at the bottom of this file
        The first example uses the default Spring Security tables, see link below
        http://docs.spring.io/spring-security/site/docs/current/reference/appendix-schema.html
    
    	auth
          .jdbcAuthentication()
          .dataSource( dataSource )
          .passwordEncoder( new ShaPasswordEncoder() );
 */

 
		/*
		 * The second example shows how you can override the default queries in order to
		 * use your own tables rather than Spring Security's default tables The SQL is
		 * relatively simple and should be easy to figure out and map to your needs
		 */
        auth
          .jdbcAuthentication()
          .dataSource( dataSource )
          .passwordEncoder( passwordEncoder() )
          .usersByUsernameQuery( usersQuery ) //"select username,password,enabled from users where username=?"
          .authoritiesByUsernameQuery(rolesQuery ); //"select u1.username, u2.authority from users u1, authorities u2 where u1.username = u2.username and u1.username =?" 
    }
 
 
     @Override
    protected void configure( HttpSecurity http ) throws Exception
    {
        http
 
        /*
           The authorizeRequests configuration is where we specify what roles are allowed access to what URLs.
            One of the most important things is the order of the intercept-urls,
            the most catch-all[default] type patterns should at the bottom of the list as the matches are executed
            in the order they are configured below.   
 			(anyRequest()) should always be at the bottom of the list.     
         */
           .authorizeRequests()
           .antMatchers("/","Booking","/user/login","/user/signup" ).permitAll()
           .antMatchers( "/Customers","/Rooms" ).permitAll()
           .anyRequest().permitAll()
             .and()
             .csrf().disable().formLogin()
                .loginPage( "/user/login" )
                .failureUrl("/user/login?error=true")
                .loginProcessingUrl("/postlogin")
                .defaultSuccessUrl("/Booking")
                .permitAll()
                 .and()
 
				/*
				 * This is where the logout page and process is configured. 
				 * The logoutRequestMatcher is the URL to send the user to in order to logout, 
				 * e.g., <a href="<spring:url  value="/dologout" />">Logout</a> 
				 * the logout-success-url is where to go to if the logout is successful, and
				 *  the delete-cookies and invalidate-session make sure that we clean up after
				 * logout
				 */ 
             .logout()
                .logoutRequestMatcher( new AntPathRequestMatcher( "/logout" ) )
                .logoutSuccessUrl( "/Booking" ) // .logoutSuccessUrl( "/logout" ) -- optional
                .deleteCookies( "JSESSIONID" )
                .invalidateHttpSession( true )
                
                .and()
                // access-denied-page: this is the page users will be
                // redirected to when they try to access protected areas.
                .exceptionHandling()
                    .accessDeniedPage( "/accessDenied" );

     }
    
     //password encoder
    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
    	BCryptPasswordEncoder passwordEncoder =  new BCryptPasswordEncoder();
    	return passwordEncoder;
    }

}