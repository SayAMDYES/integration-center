package org.quasar.ic.api.common;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * @author Quasar
 * @version 1.0.0
 * @since 2023/7/22 18:21
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class PageResult<T> extends BasePage {
    @Schema(description = "total count")
    private Long totalCount;

    @Schema(description = "total page")
    private Integer totalPage;

    @Schema(description = "list")
    private List<T> list;
}
