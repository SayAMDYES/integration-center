package org.quasar.ic.api.common;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Quasar
 * @version 1.0.0
 * @since 2023/7/22 18:22
 */
@Data
@NoArgsConstructor
public abstract class BasePage {
    public BasePage(Integer currentPage, Integer pageSize) {
        this.currentPage = currentPage;
        this.pageSize = pageSize;
    }

    @Min(value = 1, message = "current page must be greater than 0")
    @Schema(description = "current page", defaultValue = "1", minimum = "1")
    private Integer currentPage = 1;

    @Min(value = 10, message = "page size must be greater than 10")
    @Max(value = 100, message = "page size must be less than 100")
    @Schema(description = "page size", defaultValue = "10", minimum = "10", maximum = "100")
    private Integer pageSize = 10;
}
