package org.quasar.ic.common.infrastructure.repository;

import org.quasar.ic.common.infrastructure.po.BasePo;

import java.util.Optional;

/**
 * @author Quasar
 * @version 1.0.0
 * @since 2023/7/23 13:14
 */
public interface IRepository<T extends BasePo> {
    Optional<T> find(Long id);

    void save(T po);

    void update(T po);

    void updateSelective(T po);

    void delete(Long id);
}
