package me.limx.grassland;

import me.limx.grassland.api.OrderService;
import me.limx.grassland.api.dto.OrderDto;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * @author: limingxing
 * @date: 2018/10/14 22:26
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class GrasslandApplicationTest {

    @Autowired
    OrderService fooService;

    @Test
    public void test() {
        List<OrderDto> x = fooService.getOrders();
        assert x.size() == 1;
    }
}
