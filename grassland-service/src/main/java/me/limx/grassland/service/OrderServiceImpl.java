package me.limx.grassland.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import me.limx.grassland.api.OrderService;
import me.limx.grassland.api.dto.OrderDto;
import me.limx.grassland.data.OrderMapper;
import me.limx.grassland.domain.Order;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author: limingxing
 * @date: 2018/10/13 20:54
 */
@Service
public class OrderServiceImpl implements OrderService {

    @Resource
    private OrderMapper orderMapper;


    @Override
    public List<OrderDto> getOrders() {
        List<Order> orders = orderMapper.selectOrders();
        return new ModelMapper().map(orders, new TypeToken<List<OrderDto>>(){}.getType());
    }
}
