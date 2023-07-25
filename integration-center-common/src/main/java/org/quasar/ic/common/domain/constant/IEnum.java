package org.quasar.ic.common.domain.constant;

/**
 * @author Quasar
 * @version 1.0.0
 * @since 2023/7/25 22:48
 */
public interface IEnum<E extends Enum<E>> {
    int value();
}
