package me.limx.grassland.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringApplicationRunListener;
import org.springframework.cloud.bootstrap.BootstrapApplicationListener;
import org.springframework.cloud.bootstrap.config.PropertySourceBootstrapConfiguration;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.util.ClassUtils;

/**
 * Created by liwei.sun on 9/30/17.
 */
public abstract class MissApplicationRunListener implements SpringApplicationRunListener {

  public static final String BOOTSTRAP_CLASS = "org.springframework.cloud.bootstrap.BootstrapApplicationListener";
  public static final String BOOTSTRAP_CONFIGURATION = "org.springframework.cloud.bootstrap.config.PropertySourceBootstrapConfiguration";
  protected final SpringApplication application;

  public MissApplicationRunListener(SpringApplication application, String[] args) {
    this.application = application;
  }

  public static boolean isBootstrap(SpringApplication application) {
    return ClassUtils.isPresent(BOOTSTRAP_CONFIGURATION, application.getClassLoader()) &&
        application.getSources().contains(PropertySourceBootstrapConfiguration.class);
  }

  public static boolean isBootstrap(ConfigurableEnvironment environment) {
    return ClassUtils.isPresent(BOOTSTRAP_CLASS, null) &&
        environment.getPropertySources()
            .contains(BootstrapApplicationListener.BOOTSTRAP_PROPERTY_SOURCE_NAME);
  }

  @Override
  public final void starting() {
    if (isBootstrap(application)) {
      return;
    }
    onStarting();
  }

  protected void onStarting() {
  }

  @Override
  public final void environmentPrepared(ConfigurableEnvironment environment) {
    if (isBootstrap(environment)) {
      return;
    }
    onEnvironmentPrepared(environment);
  }

  protected void onEnvironmentPrepared(ConfigurableEnvironment environment) {
  }

  @Override
  public final void contextPrepared(ConfigurableApplicationContext context) {
    if (isBootstrap(context.getEnvironment())) {
      return;
    }
    onContextPrepared(context);
  }

  protected void onContextPrepared(ConfigurableApplicationContext context) {
  }

  @Override
  public final void contextLoaded(ConfigurableApplicationContext context) {
    if (isBootstrap(context.getEnvironment())) {
      return;
    }
    onContextLoaded(context);
  }

  protected void onContextLoaded(ConfigurableApplicationContext context) {
  }

  protected void onFinished(ConfigurableApplicationContext context, Throwable exception) {
  }
}
