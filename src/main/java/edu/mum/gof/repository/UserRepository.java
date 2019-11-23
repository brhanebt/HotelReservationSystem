package edu.mum.gof.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.mum.gof.domain.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{

}
