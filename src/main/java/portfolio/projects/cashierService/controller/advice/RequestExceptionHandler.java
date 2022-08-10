package portfolio.projects.cashierService.controller.advice;

import java.time.Instant;
import javax.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import portfolio.projects.cashierService.exceptions.CashierServiceException;
import portfolio.projects.cashierService.exceptions.ResponseErrorTemplate;

@ControllerAdvice
public class RequestExceptionHandler {

    @ExceptionHandler(CashierServiceException.class)
    public ResponseEntity<ResponseErrorTemplate> serviceException(CashierServiceException error, HttpServletRequest request){
        HttpStatus status = error.getResponseCode() != null ? HttpStatus.valueOf(error.getResponseCode()) : HttpStatus.BAD_REQUEST;
        ResponseErrorTemplate responseError = new ResponseErrorTemplate(Instant.now(), request.getRequestURI(), error.getMessage());
        return ResponseEntity.status(status).body(responseError);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ResponseErrorTemplate> unknownException(CashierServiceException error, HttpServletRequest request){
        ResponseErrorTemplate responseError = new ResponseErrorTemplate(Instant.now(), request.getRequestURI(), "this shouldn't be happening");
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseError);
    }
}
