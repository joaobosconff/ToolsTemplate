package jb.estudo.ferramentas.services;

import java.util.List;

import jb.estudo.ferramentas.dtos.CreateUserDTO;
import jb.estudo.ferramentas.interfaces.RoleService;
import jb.estudo.ferramentas.models.Role;
import jb.estudo.ferramentas.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
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

	private PasswordEncoder passwordEncoder(){
		return new BCryptPasswordEncoder();
	}

	public List<UserDTO> getAllUsers() {
		return userRepository.findAll().stream().map(user -> userMapper.toDTO(user)).toList();
	}

	public UserDTO createUser(CreateUserDTO userDTO) {
		Boolean existsUser = userRepository.existsUserByLogin(userDTO.getLogin());

		if(Boolean.TRUE.equals(existsUser)){
			throw new RuntimeException();
		}

		User user = userMapper.toEntity(userDTO);
		List<Role> roles = userDTO.roles.stream().map(id ->roleService.getRoleById(id)).toList();
		user.setRoles(roles);
		user.setPassword(passwordEncoder().encode(user.getPassword()));
		return userMapper.toDTO(userRepository.save(user));
	}


	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		return userRepository.findByLogin(username).orElseThrow();
	}
}
