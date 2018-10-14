package me.limx.grassland.data;

import me.limx.grassland.domain.Order;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author: limingxing
 * @date: 2018/10/14 19:37
 */
@Mapper
public interface OrderMapper {

    List<Order> selectOrders();
}
