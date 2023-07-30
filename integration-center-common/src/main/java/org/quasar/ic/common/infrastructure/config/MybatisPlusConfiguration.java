package org.quasar.ic.common.infrastructure.config;

import com.baomidou.mybatisplus.autoconfigure.MybatisPlusProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

/**
 * @author Quasar
 * @version 1.0.0
 * @since 2023/7/30 16:29
 */
@Configuration
public class MybatisPlusConfiguration {
    @Primary
    @Bean
    public MybatisPlusProperties mybatisPlusProperties(MybatisPlusProperties properties) {
        properties.setMapperLocations(new String[]{"classpath:db/liquibase/mapper/*.xml"});
        properties.setTypeHandlersPackage("org.quasar.ic.common.infrastructure.po.extension");
        return properties;
    }
}
