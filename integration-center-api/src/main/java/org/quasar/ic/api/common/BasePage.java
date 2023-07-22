package org.quasar.ic.api.common;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * @author Quasar
 * @version 1.0.0
 * @since 2023/7/22 18:22
 */
@Data
public abstract class BasePage {
    @Schema(description = "current page", defaultValue = "1")
    private Integer currentPage = 1;

    @Schema(description = "page size", defaultValue = "10")
    private Integer pageSize = 10;
}
