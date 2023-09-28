package org.quasar.ic.api.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author Quasar
 * @version 1.0.0
 * @since 2023/7/22 17:47
 */
@Data
public class CommodityCreateReqDto {
    /**
     * commodity name
     */
    @NotNull
    @Schema(description = "commodity name", requiredMode = Schema.RequiredMode.REQUIRED)
    private String name;

    /**
     * commodity price
     */
    @NotNull
    @Schema(description = "commodity price", requiredMode = Schema.RequiredMode.REQUIRED)
    private BigDecimal price;

    /**
     * commodity description
     */
    @Schema(description = "commodity description", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
    private String description;

    /**
     * commodity image
     */
    @Schema(description = "commodity image", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
    private String image;

    /**
     * commodity stock
     */
    @Schema(description = "commodity stock", requiredMode = Schema.RequiredMode.NOT_REQUIRED, defaultValue = "0")
    private Integer stock = 0;

    /**
     * commodity delivery type
     */
    @Size(min = 1, max = 2)
    @Schema(description = "commodity delivery type", requiredMode = Schema.RequiredMode.REQUIRED, allowableValues = {"1", "2"})
    private List<Integer> deliveryType;

    /**
     * commodity status
     */
    @Min(0)
    @Max(3)
    @Schema(description = "commodity status", requiredMode = Schema.RequiredMode.REQUIRED, defaultValue = "0", allowableValues = {"0", "1", "2", "3"})
    private Integer status = 0;
}
