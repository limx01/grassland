package me.limx.grassland.config;

import org.springframework.cloud.context.scope.refresh.RefreshScope;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author: limingxing
 * @date: 2018/10/20 09:44
 */
@Configuration
public class MissConfiguration {

    @Bean
    public static RefreshScope refreshScope() {
        return new RefreshScope();
    }
}
