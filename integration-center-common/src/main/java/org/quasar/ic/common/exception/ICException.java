package org.quasar.ic.common.exception;

import org.springframework.http.HttpStatus;

/**
 * @author Quasar
 * @version 1.0.0
 * @since 2023/7/23 17:28
 */
public class ICException extends RuntimeException {
    private final Integer code;

    private final HttpStatus httpStatus;

    public ICException(ICExceptionEnum exceptionEnum, String message) {
        super(message);
        this.code = exceptionEnum.getCode();
        this.httpStatus = exceptionEnum.getHttpStatus();
    }

    public ICException(ICExceptionEnum exceptionEnum) {
        super(exceptionEnum.getMessage());
        this.code = exceptionEnum.getCode();
        this.httpStatus = exceptionEnum.getHttpStatus();
    }

    public Integer getCode() {
        return code;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }
}
