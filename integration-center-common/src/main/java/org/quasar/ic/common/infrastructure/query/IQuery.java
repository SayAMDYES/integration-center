package org.quasar.ic.common.infrastructure.query;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.quasar.ic.common.infrastructure.BaseQueryOption;
import org.quasar.ic.common.infrastructure.po.BasePo;

import java.util.Optional;

/**
 * @author Quasar
 * @version 1.0.0
 * @since 2023/7/26 20:30
 */
public interface IQuery<T extends BasePo, O extends BaseQueryOption> {
    Optional<T> find(Long id);

    Page<T> findAll(O option);
}
