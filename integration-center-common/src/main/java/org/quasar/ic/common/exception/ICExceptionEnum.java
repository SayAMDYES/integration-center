package org.quasar.ic.common.exception;

import org.springframework.http.HttpStatus;

/**
 * @author Quasar
 * @version 1.0.0
 * @since 2023/7/23 17:29
 */
public enum ICExceptionEnum {
    ILLEGAL_API_ARGUMENT(400, "Illegal API Argument", HttpStatus.BAD_REQUEST),
    NOT_FOUND(404, "Not Found", HttpStatus.NOT_FOUND),
    INTERNAL_SERVER_ERROR(500, "Internal Server Error", HttpStatus.INTERNAL_SERVER_ERROR),
    ;

    ICExceptionEnum(Integer code, String message, HttpStatus httpStatus) {
        this.code = code;
        this.message = message;
        this.httpStatus = httpStatus;
    }

    private final Integer code;
    private final String message;
    private final HttpStatus httpStatus;

    public Integer getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }
}
