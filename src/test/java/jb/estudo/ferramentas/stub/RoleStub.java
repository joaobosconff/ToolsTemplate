package jb.estudo.ferramentas.stub;

import jb.estudo.ferramentas.models.Role;

public class RoleStub {

    public static Role getStub(){
        return Role.builder()
                .name("ADMIN")
                .build();
    }
}
