package org.quasar.ic.common.infrastructure.po;

import lombok.Data;

/**
 * @author Quasar
 * @version 1.0.0
 * @since 2023/7/23 13:15
 */
@Data
public abstract class BasePo {
    private Long id;
    private String createTime;
    private String updateTime;
}
