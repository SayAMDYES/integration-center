package org.quasar.ic.common.application.converter;

/**
 * @author Quasar
 * @version 1.0.0
 * @since 2023/7/26 21:36
 */
public interface IConverter<T, R> {
    R convert(T t);
}
