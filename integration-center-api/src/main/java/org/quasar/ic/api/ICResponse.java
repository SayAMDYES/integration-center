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
public class ICResponse<T, R extends ICResponse<T, R>> {
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
    public R success(T data) {
        return (R) this.setCode(SUCCESS_CODE)
                .setMessage(SUCCESS_MESSAGE)
                .setData(data);
    }

    public R success() {
        return success(SUCCESS_MESSAGE);
    }

    @SuppressWarnings("unchecked")
    public R success(String message) {
        return (R) this.setCode(SUCCESS_CODE)
                .setMessage(message);
    }

    @SuppressWarnings("unchecked")
    public R fail(Integer code, String message) {
        return (R) this.setCode(code)
                .setMessage(message);
    }
}
