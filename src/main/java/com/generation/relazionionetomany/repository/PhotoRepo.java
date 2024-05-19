package com.generation.relazionionetomany.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.generation.relazionionetomany.entity.Photo;

@Repository
public interface PhotoRepo extends JpaRepository<Photo, Integer>{

}
