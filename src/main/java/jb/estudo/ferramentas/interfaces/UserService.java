package jb.estudo.ferramentas.interfaces;

import java.util.List;

import jb.estudo.ferramentas.dtos.CreateUserDTO;
import jb.estudo.ferramentas.dtos.UserDTO;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {
	
	
	public List<UserDTO> getAllUsers();

	public UserDTO createUser(CreateUserDTO user);
	
	


}
