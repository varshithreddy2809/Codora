package com.internmo.hashnode.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.internmo.hashnode.entity.User;

public interface UserRepository extends JpaRepository<User, Long>{

	public abstract User getUserByName(String name);

}
