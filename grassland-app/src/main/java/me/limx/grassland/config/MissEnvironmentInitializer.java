package me.limx.grassland.config;

import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.MutablePropertySources;

import java.net.MalformedURLException;
import java.util.Map;

/**
 * @author: limingxing
 * @date: 2018/10/20 08:00
 */
@Order(Ordered.HIGHEST_PRECEDENCE)
public class MissEnvironmentInitializer extends MissApplicationRunListener {

    public MissEnvironmentInitializer(SpringApplication application, String[] args) {
        super(application, args);
    }

    @Override
    protected void onEnvironmentPrepared(ConfigurableEnvironment environment) {
        initialize(environment);
    }

    public ElemeEnvironment initialize(ConfigurableEnvironment environment) {
        //MissEnvironmentPropertySource propertySource = new MissEnvironmentPropertySource(environment);
        //MutablePropertySources propertySources = environment.getPropertySources();
        //propertySources.addLast(propertySource);
        return new ElemeEnvironment();
    }

    @Override
    public void started(ConfigurableApplicationContext context) {

    }

    @Override
    public void running(ConfigurableApplicationContext context) {

    }

    @Override
    public void failed(ConfigurableApplicationContext context, Throwable exception) {

    }
}
