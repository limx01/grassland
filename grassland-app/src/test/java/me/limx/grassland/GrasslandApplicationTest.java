package me.limx.grassland;

import me.limx.grassland.api.FooService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author: limingxing
 * @date: 2018/10/14 22:26
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class GrasslandApplicationTest {

    @Autowired
    FooService fooService;

    @Test
    public void test() {
        String x = fooService.bar();
        assert x.equals("1");
    }
}
