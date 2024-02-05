package jb.estudo.ferramentas.controllers;

import java.util.List;

import jb.estudo.ferramentas.dtos.CreateUserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jb.estudo.ferramentas.dtos.UserDTO;
import jb.estudo.ferramentas.interfaces.UserService;

@RestController
@RequestMapping("v1/users")
public class UserController {

	@Autowired
	private UserService userService;
	

	@GetMapping
	public ResponseEntity<List<UserDTO>> getAllUsers(){
		return ResponseEntity.ok(userService.getAllUsers());
	}

	@PostMapping
	public ResponseEntity<UserDTO> createUser(@RequestBody CreateUserDTO user){
		return new ResponseEntity(userService.createUser(user), HttpStatus.OK);
	}

}
