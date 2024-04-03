package jb.estudo.ferramentas.stub;

import jb.estudo.ferramentas.dtos.UserDTO;

public class UserDTOStub {

    public static UserDTO getStub(){
        return UserDTO.builder()
                .id(1)
                .name("JB")
                .build();
    }
}
