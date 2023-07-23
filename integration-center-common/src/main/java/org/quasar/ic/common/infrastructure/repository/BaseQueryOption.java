package org.quasar.ic.common.infrastructure.repository;

import lombok.Data;

/**
 * @author Quasar
 * @version 1.0.0
 * @since 2023/7/23 13:23
 */
@Data
public abstract class BaseQueryOption {
    private Integer currentPage;
    private Integer pageSize;

    public BaseQueryOption() {
        currentPage = 1;
        pageSize = 10;
    }

    public BaseQueryOption(Integer currentPage, Integer pageSize) {
        this.currentPage = currentPage;
        this.pageSize = pageSize;
    }
}
