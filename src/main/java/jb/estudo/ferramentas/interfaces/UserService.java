package jb.estudo.ferramentas.interfaces;

import java.util.List;

import jb.estudo.ferramentas.dtos.CreateUserDTO;
import jb.estudo.ferramentas.dtos.UserDTO;

public interface UserService {
	
	
	public List<UserDTO> getAllUsers();

	public UserDTO createUser(CreateUserDTO user);
	
	


}
