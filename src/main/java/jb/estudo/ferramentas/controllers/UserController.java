package jb.estudo.ferramentas.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import jb.estudo.ferramentas.dtos.UserDTO;
import jb.estudo.ferramentas.interfaces.UserService;

@RestController
@RequestMapping("users")
public class UserController {

	@Autowired
	private UserService userService;
	

	@GetMapping
	public ResponseEntity<List<UserDTO>> getAllUsers(){
		return ResponseEntity.ok(userService.getAllUsers());
	}

	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@GetMapping("/admin")
	public String ugaAdmin(){
		return "Admin autorized";
	}

	@PreAuthorize("hasRole('ROLE_USER')")
	@GetMapping("/user")
	public String bungaUser(){
		return "User autorized";
	}



}
