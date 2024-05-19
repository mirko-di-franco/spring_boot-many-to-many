package com.generation.relazionionetomany.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.generation.relazionionetomany.entity.Tag;
import com.generation.relazionionetomany.repository.TagRepo;

@Service
public class TagServ {

	@Autowired
	TagRepo tagRepo;
	
	
	public Tag addOrModify(Tag tag) {
		Tag newTag = tagRepo.save(tag);
		return null;
	}
}
