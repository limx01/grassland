package me.limx.grassland.api;

import com.alibaba.dubbo.config.annotation.Service;

/**
 * @author: limingxing
 * @date: 2018/10/13 20:56
 */
@Service(version = "1.0")
public interface FooService {
    String bar();
}
