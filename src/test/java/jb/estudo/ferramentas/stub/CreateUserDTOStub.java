package jb.estudo.ferramentas.stub;

import jb.estudo.ferramentas.dtos.CreateUserDTO;

import java.util.List;

public class CreateUserDTOStub {

    public static CreateUserDTO getStub(){
        return CreateUserDTO.builder()
                .login("joao@joao.com")
                .password("123")
                .roles(List.of(1))
                .name("JB")
                .build();
    }
}
