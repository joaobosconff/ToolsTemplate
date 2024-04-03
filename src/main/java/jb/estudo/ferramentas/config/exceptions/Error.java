package jb.estudo.ferramentas.config.exceptions;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class Error {

    private Long timeStamp;

    private String message;

    private String path;
}
