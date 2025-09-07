package com.yahikko.mark01.exception;

import com.yahikko.mark01.dto.errors.DtoOutBusinessServiceErrors;
import com.yahikko.mark01.dto.errors.DtoOutCause;
import com.yahikko.mark01.exception.BusinessServiceException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    private static final String FUNCTIONAL_ERROR = "functionalError";
    private static final String INTERNAL_SERVER_ERROR = "internalServerError";

    @ExceptionHandler(BusinessServiceException.class)
    public ResponseEntity<DtoOutBusinessServiceErrors> errorsExceptionsHandler(BusinessServiceException businessServiceException, HttpServletRequest httpServletRequest) {

        DtoOutBusinessServiceErrors businessServiceErrors = new DtoOutBusinessServiceErrors(
                businessServiceException.getStatus(),
                businessServiceException.getMessage(),
                businessServiceException.getDetail(),
                httpServletRequest.getRequestURI()
        );

        return new ResponseEntity<>(businessServiceErrors, businessServiceException.getStatus());
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<DtoOutBusinessServiceErrors> handleGenericException(
            Exception ex, HttpServletRequest request) {

        DtoOutBusinessServiceErrors errorResponse = new DtoOutBusinessServiceErrors(
                HttpStatus.INTERNAL_SERVER_ERROR,
                "Error interno del servidor",
                ex.getMessage(),
                request.getRequestURI()
        );
        
        return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
