package org.quasar.ic.common.exception.handler;

import org.quasar.ic.api.ICResponse;
import org.quasar.ic.common.exception.ICException;
import org.quasar.ic.common.exception.ICExceptionEnum;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author Quasar
 * @version 1.0.0
 * @since 2023/7/23 17:32
 */
@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(Throwable.class)
    public Object process(Throwable ignored) {
        return new ResponseEntity<>(ICResponse.fail(ICExceptionEnum.ILLEGAL_API_ARGUMENT.getCode(), ICExceptionEnum.ILLEGAL_API_ARGUMENT.getMessage()), ICExceptionEnum.ILLEGAL_API_ARGUMENT.getHttpStatus());
    }

    @ExceptionHandler(ICException.class)
    public Object process(ICException e) {
        return new ResponseEntity<>(ICResponse.fail(e.getCode(), e.getMessage()), e.getHttpStatus());
    }
}
