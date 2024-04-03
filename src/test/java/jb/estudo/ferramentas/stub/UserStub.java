package jb.estudo.ferramentas.stub;

import jb.estudo.ferramentas.models.User;

public class UserStub {

    public static User getStub(){
        return User.builder()
                .login("joao@joao.com")
                .password("123")
                .name("JB")
                .build();

    }
}
