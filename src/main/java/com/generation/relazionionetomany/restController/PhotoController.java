package com.generation.relazionionetomany.restController;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.generation.relazionionetomany.entity.Photo;
import com.generation.relazionionetomany.entity.User;
import com.generation.relazionionetomany.service.PhotoServ;
import com.generation.relazionionetomany.service.UserServ;

@RestController
@RequestMapping("/api/photos")
public class PhotoController {
	
	@Autowired
	PhotoServ photoServ;
	
	@Autowired
	UserServ userServ;
	
	
	
	@GetMapping("/{id-photo}/")
	public ResponseEntity<Photo> cercaPerId(@PathVariable("id-photo") int idPhoto){
		Optional<Photo> photo = photoServ.findById(idPhoto);
		if(photo.isEmpty()) {
			return new ResponseEntity<>(new Photo(), HttpStatus.NOT_FOUND);
		}else {
			return new ResponseEntity<>(photo.get(), HttpStatus.OK);
		}
	}
	
	
	@PostMapping("/user/{id-user}/")
	public ResponseEntity<?> addPhotoUtente(@RequestBody Photo photo, @PathVariable("id-user") int userId){
		
		
		try {
			
			
			Optional<User> userOptional = userServ.getById(userId);
	        if (userOptional.isPresent()) {
	            User user = userOptional.get();
	            
	            //associo l'utente alla foto
	            photo.setUser(user);
	            
	            photoServ.addOrModify(photo);
	            
	            return ResponseEntity.ok(photo);
	        } else {
	            return ResponseEntity.notFound().build();
	        }
			
			
		}catch(Exception e) {
			return ResponseEntity.internalServerError().build();
		}
	}
}
