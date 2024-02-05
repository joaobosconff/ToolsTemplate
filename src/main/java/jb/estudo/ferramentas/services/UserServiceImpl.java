package jb.estudo.ferramentas.services;

import java.util.List;

import jb.estudo.ferramentas.dtos.CreateUserDTO;
import jb.estudo.ferramentas.interfaces.RoleService;
import jb.estudo.ferramentas.models.Role;
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
	private RoleService roleService;
	
	@Autowired
	private UserMapper userMapper;

	public List<UserDTO> getAllUsers() {
		return userRepository.findAll().stream().map(user -> userMapper.toDTO(user)).toList();
	}

	public UserDTO createUser(CreateUserDTO userDTO) {
		User user = userMapper.toEntity(userDTO);
		List<Role> roles = userDTO.roles.stream().map(id ->roleService.getRoleById(id)).toList();
		user.setRoles(roles);
		return userMapper.toDTO(userRepository.save(user));
	}


}
