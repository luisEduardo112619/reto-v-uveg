package com.yahikko.mark01.exception;

import com.yahikko.mark01.dto.errors.DtoOutBusinessServiceErrors;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

public class BusinessServiceException extends RuntimeException{

    private static final String CODE_MANDATORY_PARAMETERS_MISSING = "mandatoryParametersMissing";
    private static final String MANDATORY_PARAMETERS_MISSING = "Parametros obligatorios no informados";
    private static final String CODE_INVALID_PARAMETERS = "invalidParameters";
    private static final String INVALID_PARAMETERS = "Parametros invalidos";
    private static final String CODE_USER_ALREADY_EXIST = "userAlreadyExist";
    private static final String USER_ALREADY_EXIST = "El usuario ya se encuentra registrado";

    private final HttpStatus status;
    private final LocalDateTime timestamp;
    private final String detail;

   public BusinessServiceException(String message, String detail, HttpStatus status) {
       super(message);
       this.status = status;
       this.timestamp = LocalDateTime.now();
       this.detail = detail;
   }

    public HttpStatus getStatus() {
        return status;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public String getDetail() {
        return detail;
    }

    public static BusinessServiceException mandatoryParametersMissing(){
       return new BusinessServiceException(
               CODE_MANDATORY_PARAMETERS_MISSING,
               MANDATORY_PARAMETERS_MISSING,
               HttpStatus.BAD_REQUEST
       );
   }

    public static BusinessServiceException invalidParameters(){
        return new BusinessServiceException(
                CODE_INVALID_PARAMETERS,
                INVALID_PARAMETERS,
                HttpStatus.BAD_REQUEST
        );
    }

    public static BusinessServiceException userAlreadyExist(){
        return new BusinessServiceException(
                CODE_USER_ALREADY_EXIST,
                USER_ALREADY_EXIST,
                HttpStatus.BAD_REQUEST
        );
    }



}
