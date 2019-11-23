package edu.mum.gof;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.*;
import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.core.env.Environment;
import org.springframework.validation.Validator;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.*;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.UrlBasedViewResolver;
import org.springframework.web.servlet.view.tiles3.TilesConfigurer;
import org.springframework.web.servlet.view.tiles3.TilesView;

import edu.mum.gof.interceptor.NoticeInterceptor;

@EnableWebMvc
@Configuration
@ComponentScan(basePackages = { "edu.mum.gof" })
@PropertySource(value="classpath:application.properties")
public class Dispatcher extends WebMvcConfigurerAdapter {

	@Autowired 
	Environment environment;

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler(environment.getProperty("staticResourceAlias")).addResourceLocations(environment.getProperty("staticResourceLocation"));
	}

	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
		configurer.enable();
	}

	@Bean
	public InternalResourceViewResolver jspViewResolver() {
		InternalResourceViewResolver bean = new InternalResourceViewResolver();
		bean.setPrefix(environment.getProperty("viewResolver.prefix"));
		bean.setSuffix(environment.getProperty("viewResolver.suffix"));
		return bean;
	}

	@Override
	public void addInterceptors(InterceptorRegistry registry) 
	{
		registry.addInterceptor(new NoticeInterceptor())
		.addPathPatterns("/");
	}
	@Bean
	public MessageSourceAccessor getMessageSourceAccessor() {
	  return new MessageSourceAccessor(messageSource());
	}
	@Bean(name = "messageSource")
	public ReloadableResourceBundleMessageSource messageSource() {
		ReloadableResourceBundleMessageSource resource = new ReloadableResourceBundleMessageSource();
		resource.setBasename("classpath:messages");
		resource.setDefaultEncoding("UTF-8");
		resource.setCacheSeconds(0);
		resource.setUseCodeAsDefaultMessage(true);
		return resource;
	}



	@Bean(name = "validator")
	public LocalValidatorFactoryBean validator() {
		LocalValidatorFactoryBean bean = new LocalValidatorFactoryBean();
		bean.setValidationMessageSource(messageSource());
		return bean;
	}

	@Override
	public Validator getValidator(){
		return validator();
	}




}
