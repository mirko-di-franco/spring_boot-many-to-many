package com.generation.relazionionetomany.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.generation.relazionionetomany.entity.User;

@Repository
public interface UserRepo extends JpaRepository<User, Integer>{

}
