package br.edu.iff.ccc.bsi.perfumaria.exception;

import jdk.jfr.StackTrace;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.Instant;

@RestControllerAdvice
public class ApiRestControllerAdvice extends ResponseEntityExceptionHandler {

    @ExceptionHandler(Exception.class)
    ProblemDetail handleDefaultException(Exception e) {
        ProblemDetail problemDetail = ProblemDetail.forStatusAndDetail(HttpStatus.NOT_FOUND,e.getLocalizedMessage());
        problemDetail.setTitle("Um erro inesperado ocorreu!");
        problemDetail.setProperty("StackTrace", e.getStackTrace());
        problemDetail.setProperty("Timestamp", Instant.now());
        return problemDetail;
    }
}
