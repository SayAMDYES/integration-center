package org.quasar.ic.common.domain.entity;

import org.quasar.ic.common.infrastructure.po.BasePo;

/**
 * @author Quasar
 * @version 1.0.0
 * @since 2023/7/25 22:17
 */
public abstract class IEntity {
    public abstract Long getId();

    protected abstract <T extends BasePo> T toPo();
}
