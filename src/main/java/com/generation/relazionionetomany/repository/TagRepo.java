package com.generation.relazionionetomany.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.generation.relazionionetomany.entity.Tag;

@Repository
public interface TagRepo extends JpaRepository<Tag, Integer>{

}
