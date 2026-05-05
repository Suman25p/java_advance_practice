package com.kodekart.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.kodekart.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {

    User findByEmailAndPassword(String email, String password);

    User findByEmail(String email);   
}
