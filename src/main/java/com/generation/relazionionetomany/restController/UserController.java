package com.generation.relazionionetomany.restController;

import java.util.List;
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

import com.generation.relazionionetomany.dto.UserDTO;
import com.generation.relazionionetomany.entity.User;
import com.generation.relazionionetomany.service.UserServ;

@RestController
@RequestMapping("api/user")
public class UserController {

	@Autowired
	UserServ userServ;
	
	@GetMapping
	public List<User> getAll(){
		List<User> users = userServ.all();
		return users;
	}
	
	
	@PostMapping
	public ResponseEntity<?> add(@RequestBody UserDTO userDTO){
		
		User user = new User(userDTO.getName());
		
		User newUser = userServ.addOrModify(user);
		
		return new ResponseEntity<>(newUser, HttpStatus.OK);
	}
	
	
	@GetMapping("/{id-user}")
	public ResponseEntity<?> findById(@PathVariable("id-user") int idUser){
		Optional<User> user = userServ.getById(idUser);
		if(user.isEmpty()) {
			return new ResponseEntity<>(new User(), HttpStatus.NOT_FOUND);
		}else {
			return new ResponseEntity<>(user.get(), HttpStatus.OK);
		}
	}
}
