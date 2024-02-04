package jb.estudo.ferramentas.mappers;

import org.mapstruct.Mapper;

import jb.estudo.ferramentas.dtos.UserDTO;
import jb.estudo.ferramentas.models.User;

@Mapper
public interface UserMapper {
	
	UserDTO toDTO(User user);

}
