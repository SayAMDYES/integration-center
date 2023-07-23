package org.quasar.ic.commodity.infrastructure.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author Quasar
 * @version 1.0.0
 * @since 2023/7/23 16:53
 */
@MapperScan(basePackages = "org.quasar.ic.commodity.infrastructure.repository.mapper")
@Configuration
public class MapperConfiguration {
}
