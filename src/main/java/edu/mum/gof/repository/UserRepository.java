package edu.mum.gof.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import edu.mum.gof.domain.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

	@Query("SELECT u from auth_user u WHERE u.userName = :userName")
	public User findByUserName(@Param("userName") String userName);
	
	@Query("SELECT u from auth_user u WHERE u.userName = :userName and u.password = :password")
	public User findByUserNameAndPassword(@Param("userName") String userName, @Param("password") String password);

}
