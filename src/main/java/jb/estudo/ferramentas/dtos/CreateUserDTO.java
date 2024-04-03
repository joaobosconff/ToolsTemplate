package jb.estudo.ferramentas.dtos;

import jakarta.annotation.Nonnull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
public class CreateUserDTO {

    public String login;

    public String password;

    public String name;

    @Nonnull
    public List<Integer> roles = new ArrayList<>();


}
