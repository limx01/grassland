package me.limx.grassland.service;

import me.limx.grassland.api.FooService;
import me.limx.grassland.data.OrderMapper;
import me.limx.grassland.domain.Order;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author: limingxing
 * @date: 2018/10/13 20:54
 */
@Service
public class FooServiceImpl implements FooService {

    @Resource
    private OrderMapper orderMapper;

    @Override
    public String bar() {
        Order orderEntity = orderMapper.selectOrder();
        return String.valueOf(orderEntity.getOrderId());
    }
}
