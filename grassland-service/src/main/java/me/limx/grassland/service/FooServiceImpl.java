package me.limx.grassland.service;

import me.limx.grassland.api.FooService;
import me.limx.grassland.data.CityMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author: limingxing
 * @date: 2018/10/13 20:54
 */
@Service
public class FooServiceImpl implements FooService {

    @Autowired
    private CityMapper cityMapper;

    @Override
    public String bar() {
        return String.valueOf(cityMapper.findByState());
    }
}
