package org.quasar.ic.api.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

/**
 * @author Quasar
 * @version 1.0.0
 * @since 2023/7/22 17:47
 */
@Data
public class CommodityDeleteReqDto {
    /**
     * commodity id
     */
    @NotNull(message = "commodity id can not be null")
    @Schema(description = "commodity id", requiredMode = Schema.RequiredMode.REQUIRED)
    private Long id;
}
