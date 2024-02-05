package jb.estudo.ferramentas.dtos;

import lombok.Data;

import java.util.List;

@Data
public class CreateUserDTO {

    public String login;

    public String password;

    public String name;

    public List<Integer> roles;


}
