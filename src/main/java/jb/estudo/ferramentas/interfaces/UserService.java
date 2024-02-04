package jb.estudo.ferramentas.interfaces;

import java.util.List;

import jb.estudo.ferramentas.dtos.UserDTO;
import jb.estudo.ferramentas.models.User;

public interface UserService {
	
	
	public List<UserDTO> getAllUsers();

	public UserDTO createUser(User user);
	
	


}
