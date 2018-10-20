package me.limx.grassland.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.context.config.ConfigFileApplicationListener;
import org.springframework.boot.context.properties.bind.Binder;
import org.springframework.boot.env.EnvironmentPostProcessor;
import org.springframework.boot.env.YamlPropertySourceLoader;
import org.springframework.core.Ordered;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.MutablePropertySources;
import org.springframework.core.env.PropertiesPropertySource;
import org.springframework.core.env.PropertySource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.UrlResource;
import org.springframework.util.ResourceUtils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.List;
import java.util.Properties;

import static org.springframework.boot.context.config.ConfigFileApplicationListener.APPLICATION_CONFIGURATION_PROPERTY_SOURCE_NAME;

/**
 * @author: limingxing
 * @date: 2018/10/20 07:25
 */
public class MissConfPostProcessor implements EnvironmentPostProcessor, Ordered {

    @Override
    public void postProcessEnvironment(ConfigurableEnvironment environment, SpringApplication application) {
       /* MutablePropertySources propertySources = environment.getPropertySources();
        Binder binder = Binder.get(environment);
        MissConfProperties properties  = binder.bind(MissConfProperties.CONFIG_PREFIX, MissConfProperties.class).get();
        MissConfPropertySourceLocator locator = new MissConfPropertySourceLocator(properties);
        PropertySource propertySource = locator.locate();
        propertySources.addBefore(APPLICATION_CONFIGURATION_PROPERTY_SOURCE_NAME, propertySource);*/

        MutablePropertySources sources = environment.getPropertySources();
        YamlPropertySourceLoader loader = new YamlPropertySourceLoader();
        URL url = null;
        try {
            url = ResourceUtils.getURL("classpath:grassland.yml");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        UrlResource resource = new UrlResource(url);
        List<PropertySource<?>> propertySources = null;
        try {
            propertySources = loader.load("classpath:grassland.yml", resource);
        } catch (IOException e) {
            e.printStackTrace();
        }
        for(PropertySource<?> propertySource : propertySources){
            sources.addLast(propertySource);
        }
    }

    @Override
    public int getOrder() {
        return ConfigFileApplicationListener.DEFAULT_ORDER + 1;
    }
}
