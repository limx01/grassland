package me.limx.grassland;

import com.alibaba.dubbo.spring.boot.annotation.EnableDubboConfiguration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;

@SpringBootApplication
@EnableDubboConfiguration
public class GrasslandApplication {

    private static final Logger logger = LoggerFactory
            .getLogger(GrasslandApplication.class);

    @PostConstruct
    public void logSomething() {
        logger.debug("Sample Debug Message");
        logger.trace("Sample Trace Message");
        logger.error("Sample Error Message");
    }


    public static void main(String[] args) {
        SpringApplication.run(GrasslandApplication.class, args);
    }
}
