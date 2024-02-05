package jb.estudo.ferramentas.mappers;

import jb.estudo.ferramentas.dtos.CreateUserDTO;
import org.mapstruct.Mapper;

import jb.estudo.ferramentas.dtos.UserDTO;
import jb.estudo.ferramentas.models.User;
import org.mapstruct.Mapping;

@Mapper
public interface UserMapper {
	UserDTO toDTO(User user);

	@Mapping(target = "roles", ignore = true)
	User toEntity(CreateUserDTO user);

}
