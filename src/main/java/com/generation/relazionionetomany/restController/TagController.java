package com.generation.relazionionetomany.restController;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.generation.relazionionetomany.entity.Photo;
import com.generation.relazionionetomany.entity.Tag;
import com.generation.relazionionetomany.service.PhotoServ;
import com.generation.relazionionetomany.service.TagServ;

@RestController
@RequestMapping("api/tags")
public class TagController {
	
	private static final Logger logger = LoggerFactory.getLogger(TagController.class);


	@Autowired
	TagServ tagServ;
	
	@Autowired
	PhotoServ photoServ;
	
	
	@PostMapping("/photo/{id-photo}/")
	public ResponseEntity<?> addTagPhoto(@RequestBody Tag tag, @PathVariable("id-photo") int idPhoto){
		try {
			//cerco la foto
			Optional<Photo> photoOptional = photoServ.findById(idPhoto);
			//se la photo esiste, allora gli aggiungo il tag
			if(photoOptional.isPresent()) {
				Photo photo = photoOptional.get();
				//associo il tag alla foto
				photo.getTags().add(tag);
				tag.getPhotos().add(photo);
				
				tagServ.addOrModify(tag);
				
				return ResponseEntity.ok(tag);
				//se la foto non esiste, allora invio l'errore 404
			}else {
				return ResponseEntity.notFound().build();
			}
			
		}catch(Exception e) {
			logger.error("Error Photo", e);
			return ResponseEntity.internalServerError().build();
		}
	}
}
