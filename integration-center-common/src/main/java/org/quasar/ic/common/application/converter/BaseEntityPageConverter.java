package org.quasar.ic.common.application.converter;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.quasar.ic.api.common.PageResult;
import org.quasar.ic.common.domain.entity.IEntity;

import java.util.List;

/**
 * @author Quasar
 * @version 1.0.0
 * @since 2023/7/26 21:18
 */
public abstract class BaseEntityPageConverter<T extends IEntity, R> implements IConverter<Page<T>, PageResult<R>> {
    @Override
    public PageResult<R> convert(Page<T> page) {
        List<R> list = page.getRecords().stream()
                .map(this::doConvert)
                .toList();

        return new PageResult<R>(parseInt(page.getCurrent()), parseInt(page.getSize()))
                .setTotalCount(page.getTotal())
                .setTotalPage(parseInt(page.getTotal() / page.getSize()))
                .setList(list);
    }

    protected abstract R doConvert(T pageItem);

    private static Integer parseInt(long value) {
        return (int) value;
    }
}
