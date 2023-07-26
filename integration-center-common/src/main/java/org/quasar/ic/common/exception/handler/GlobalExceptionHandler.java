package org.quasar.ic.common.exception.handler;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
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
    private static final Log log = LogFactory.getLog(GlobalExceptionHandler.class);

    @ExceptionHandler(Throwable.class)
    public Object process(Throwable ignored) {
        log.error(ignored.getMessage(), ignored);
        return new ResponseEntity<>(new ICResponse<>().fail(ICExceptionEnum.INTERNAL_SERVER_ERROR.getCode(), ICExceptionEnum.INTERNAL_SERVER_ERROR.getMessage()), ICExceptionEnum.INTERNAL_SERVER_ERROR.getHttpStatus());
    }

    @ExceptionHandler(ICException.class)
    public Object process(ICException e) {
        return new ResponseEntity<>(new ICResponse<>().fail(e.getCode(), e.getMessage()), e.getHttpStatus());
    }
}
