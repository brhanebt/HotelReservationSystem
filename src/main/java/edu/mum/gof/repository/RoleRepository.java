package edu.mum.gof.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import edu.mum.gof.domain.Role;

@Repository
public interface RoleRepository extends CrudRepository<Role, Long>  {
	
	@Query("SELECT r FROM auth_role r INNER JOIN r.users WHERE auth_user_id = :userId")
	public List<Role> getAllRolesByUserId(@Param("userId") Long userId);

}
