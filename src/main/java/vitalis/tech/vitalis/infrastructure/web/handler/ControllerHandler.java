package vitalis.tech.vitalis.infrastructure.web.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import vitalis.tech.vitalis.core.application.exception.DuplicadosException;

@RestControllerAdvice
public class ControllerHandler {

    @ExceptionHandler(DuplicadosException.class)
    public ResponseEntity<String> handleRecursoDuplicadoException(DuplicadosException ex) {
        return ResponseEntity.status(HttpStatus.CONFLICT).body(ex.getMessage());
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<String> handleIllegalArgumentException(IllegalArgumentException ex) {
        return ResponseEntity.badRequest().body(ex.getMessage());
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleGenericException(Exception ex) {
        return ResponseEntity.internalServerError().body("Erro interno do servidor");
    }
}
