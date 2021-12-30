package br.com.brunheroto.springbootApiExample.config.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import br.com.brunheroto.springbootApiExample.exception.ProductExistException;



@ControllerAdvice
public class CustomRestExceptionHandler extends ResponseEntityExceptionHandler {

  @ExceptionHandler(ProductExistException.class)
  protected ResponseEntity<Object> handleException (ProductExistException ex, WebRequest request) {
    ErrorResponse errorResponse = new ErrorResponse("ProductExistException", "SKU already exist.");

    return new ResponseEntity<>(errorResponse, HttpStatus.CONFLICT);
  }


}
