package jb.estudo.ferramentas.controllers;

import jb.estudo.ferramentas.dtos.CreateUserDTO;
import jb.estudo.ferramentas.dtos.UserDTO;
import jb.estudo.ferramentas.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("v1/public/")
public class PublicController {

    @Autowired
    private UserService userService;

    @PostMapping("sign-up")
    public ResponseEntity<UserDTO> createUser(@RequestBody CreateUserDTO user){
        return new ResponseEntity(userService.createUser(user), HttpStatus.OK);
    }
}
