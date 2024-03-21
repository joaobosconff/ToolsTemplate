package jb.estudo.ferramentas.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class LoginDTO {

    private String username;

    private String password;
}
