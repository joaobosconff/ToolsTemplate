package jb.estudo.ferramentas.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class UserDTO {
	
	private Integer id;
	
	private String name;

}
