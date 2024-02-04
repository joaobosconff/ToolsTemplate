package jb.estudo.ferramentas.services;

import java.util.List;

import jb.estudo.ferramentas.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jb.estudo.ferramentas.dtos.UserDTO;
import jb.estudo.ferramentas.interfaces.UserService;
import jb.estudo.ferramentas.mappers.UserMapper;
import jb.estudo.ferramentas.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private UserMapper userMapper;

	public List<UserDTO> getAllUsers() {
		return userRepository.findAll().stream().map(user -> userMapper.toDTO(user)).toList();
	}

	public UserDTO createUser(User user) {
		return userMapper.toDTO(userRepository.save(user));
	}


}
