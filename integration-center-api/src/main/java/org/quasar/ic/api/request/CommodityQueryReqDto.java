package org.quasar.ic.api.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.quasar.ic.api.ICPageReqDto;

import java.util.List;

/**
 * @author Quasar
 * @version 1.0.0
 * @since 2023/7/22 19:25
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class CommodityQueryReqDto extends ICPageReqDto {
    /**
     * commodity name
     */
    @Schema(description = "commodity name", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
    private String name;

    /**
     * delivery type
     */
    @Schema(description = "delivery type", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = {"1", "2"})
    private Integer deliveryType;

    /**
     * commodity status
     */
    @Schema(description = "commodity status", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = {"0", "1", "2", "3"})
    private Integer status;

    /**
     * create time
     */
    @Schema(description = "create time", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
    private List<String> createTime;
}
