package me.limx.grassland.config;

import org.springframework.core.env.CompositePropertySource;
import org.springframework.core.env.MapPropertySource;
import org.springframework.core.env.PropertySource;

import java.util.HashMap;

/**
 * @author: limingxing
 * @date: 2018/10/20 07:27
 */
public class MissConfPropertySourceLocator {
    private MissConfProperties missConfProperties;

    public MissConfPropertySourceLocator(MissConfProperties missConfProperties) {
        this.missConfProperties = missConfProperties;
    }

    public PropertySource<?> locate() {
        CompositePropertySource propertySource = new CompositePropertySource(MissConfProperties.CONFIG_PREFIX);
        propertySource.addPropertySource(new MapPropertySource("server", new HashMap<>()));
        return propertySource;
    }
}
