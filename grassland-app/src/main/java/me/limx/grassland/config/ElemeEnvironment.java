package me.limx.grassland.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.util.StringUtils;
import org.springframework.util.SystemPropertyUtils;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Optional;

import static me.limx.grassland.config.ElemeEnvironment.CONFIG_PREFIX;

/**
 * <p>
 * 饿了么应用相关运维环境配置，使用 {@link ElemeEnvironmentFactory}获取本类实例。
 * 通过{@link ElemeHuskarConfigPostProcessor}注册为Spring Bean.
 * 在Spring Boot环境中，可作为Bean进行类型注入。
 * </p>
 *
 * @author liwei.sun  Date: 2/10/17 Time: 17:56
 */
@ConfigurationProperties(CONFIG_PREFIX)
public class ElemeEnvironment {

  @SuppressWarnings("WeakerAccess")
  public static final String PROPERTY_SOURCE_NAME = "elemeEnvironment";
  /**
   * 只匹配以"ELE_", "ele."开头的配置项
   */
  @SuppressWarnings("WeakerAccess")
  public static final String CONFIG_PREFIX = "miss.";

  /**
   * 指定获取标准环境变量的文件位置
   */
  @SuppressWarnings("WeakerAccess")
  public static final String ENV_FILE_LOCATION = "eleme.config";
  /**
   * 默认是进程当前的工作目录
   */
  @SuppressWarnings("WeakerAccess")
  public static final String DEFAULT_ENV_FILE_LOCATION = "classpath:eleme.yml,file:./eleme.yml,file:./config/eleme.yml";
  /**
   * 标识是否运行在容器内
   */
  @SuppressWarnings("WeakerAccess")
  public static final boolean IS_APPOS;

  static {
    File sched = new File("/proc/1/sched");
    if (sched.exists()) {
      try {
        String info = Files.readAllLines(sched.toPath()).get(0);
        IS_APPOS = "ele_init".equals(info.split(" ")[0]);
      } catch (Exception e) {
        throw new Error("无法获取系统信息! file=" + sched, e);
      }
    } else {
      IS_APPOS = false;
    }
  }

  /**
   * 允许用户覆盖此配置
   */
  private boolean appOs;

  private String appId;

  private String appsecLocation;
  private String envYamlLocation = "/etc/eleme/env.yaml";

  ElemeEnvironment() {
    appOs = IS_APPOS;
  }
}
