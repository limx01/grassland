package me.limx.grassland.config;

import org.springframework.core.Ordered;
import org.springframework.core.env.PropertySource;

/**
 * @author: limingxing
 * @date: 2018/10/20 08:45
 */
public class MissEnvironmentPropertySource extends PropertySource<ElemeEnvironment> implements Ordered {

    MissEnvironmentPropertySource(ElemeEnvironment source) {
        super(ElemeEnvironment.PROPERTY_SOURCE_NAME, source);
    }

    @Override
    public Object getProperty(String name) {
        return null;
    }

    @Override
    public int getOrder() {
        return LOWEST_PRECEDENCE;
    }
}
