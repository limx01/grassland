package me.limx.grassland;

import com.alibaba.dubbo.spring.boot.annotation.EnableDubboConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableDubboConfiguration
public class GrasslandApplication {
    public static void main(String[] args) {
        SpringApplication.run(GrasslandApplication.class, args);
    }
}
