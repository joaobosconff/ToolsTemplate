package jb.estudo.ferramentas.dtos;

import jakarta.annotation.Nonnull;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class CreateUserDTO {

    public String login;

    public String password;

    public String name;

    @Nonnull
    public List<Integer> roles = new ArrayList<>();


}
