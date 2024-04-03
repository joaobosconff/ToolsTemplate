package jb.estudo.ferramentas.config.exceptions;

import jakarta.servlet.http.HttpServletRequest;
import jb.estudo.ferramentas.exceptions.BadRequestException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ExceptionHandlerConfig extends ResponseEntityExceptionHandler {
    @ExceptionHandler(BadRequestException.class)
    protected ResponseEntity<Error> handleBadRequest(BadRequestException e, HttpServletRequest request) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(Error.builder()
                        .timeStamp(System.currentTimeMillis())
                        .message(e.getMessage())
                        .path(request.getRequestURI())
                        .build());
    }

    @ExceptionHandler(AuthenticationException.class)
    public ResponseEntity<Error> handleAuthenticationException(Exception ex, HttpServletRequest request) {

        return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                .body(Error.builder()
                        .timeStamp(System.currentTimeMillis())
                        .message(ex.getMessage())
                        .path(request.getRequestURI())
                        .build());
    }

    @ExceptionHandler({AccessDeniedException.class})
    public ResponseEntity<Object> handleAccessDeniedException(
            Exception ex, HttpServletRequest request) {
        return ResponseEntity.status(HttpStatus.FORBIDDEN)
                .body(Error.builder()
                        .timeStamp(System.currentTimeMillis())
                        .message(ex.getMessage())
                        .path(request.getRequestURI())
                        .build());
    }
}


