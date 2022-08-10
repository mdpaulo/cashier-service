package portfolio.projects.cashierService.exceptions;

import java.io.Serial;
import lombok.Getter;

public class CashierServiceException extends RuntimeException{
    @Serial
    private static final long serialVersionUID = 1L;
    @Getter
    private Integer responseCode;

    public CashierServiceException(String message, Integer responseCode, Exception capturedException){
        super(message, capturedException);
        this.responseCode = responseCode;
    }

    public CashierServiceException(String message, Integer responseCode) {
        super(message);
        this.responseCode = responseCode;
    }

    public CashierServiceException(String message) {
        super(message);

    }

    public CashierServiceException(Exception capturedException) {
        super(capturedException);
    }

    public CashierServiceException(){}
}
