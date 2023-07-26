package org.quasar.ic.api.common;

import io.swagger.v3.oas.annotations.media.Schema;
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

    @Schema(description = "current page", defaultValue = "1")
    private Integer currentPage = 1;

    @Schema(description = "page size", defaultValue = "10")
    private Integer pageSize = 10;
}
