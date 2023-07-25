package org.quasar.ic.common.domain.factory;

import org.quasar.ic.common.domain.entity.IEntity;

/**
 * @author Quasar
 * @version 1.0.0
 * @since 2023/7/25 22:36
 */
public interface IFactory<T extends IEntity> {
    T create(Long id);
}
