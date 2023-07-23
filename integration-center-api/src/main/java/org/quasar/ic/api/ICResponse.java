package org.quasar.ic.api;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author Quasar
 * @version 1.0.0
 * @since 2023/7/22 17:58
 */
@Data
@Accessors(chain = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ICResponse<T> {
    public static final Integer SUCCESS_CODE = 0;
    public static final String SUCCESS_MESSAGE = "success";

    /**
     * status code:0,success
     */
    @Schema(description = "status code:0,success", requiredMode = Schema.RequiredMode.REQUIRED)
    private Integer code;

    /**
     * message
     */
    @Schema(description = "message", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
    private String message;

    /**
     * data
     */
    @Schema(description = "data", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
    private T data;

    @SuppressWarnings("unchecked")
    public static <T> ICResponse<T> success(T data) {
        return (ICResponse<T>) new ICResponse<>()
                .setCode(SUCCESS_CODE)
                .setMessage(SUCCESS_MESSAGE)
                .setData(data);
    }

    public static <T> ICResponse<T> success() {
        return success(SUCCESS_MESSAGE);
    }

    @SuppressWarnings("unchecked")
    public static <T> ICResponse<T> success(String message) {
        return (ICResponse<T>) new ICResponse<>()
                .setCode(SUCCESS_CODE)
                .setMessage(message);
    }

    @SuppressWarnings("unchecked")
    public static <T> ICResponse<T> fail(Integer code, String message) {
        return (ICResponse<T>) new ICResponse<>()
                .setCode(code)
                .setMessage(message);
    }
}
