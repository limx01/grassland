package me.limx.grassland.data;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * @author: limingxing
 * @date: 2018/10/13 23:40
 */
@Mapper
public interface CityMapper {

    @Select("SELECT count(*) FROM t_security")
    int findByState();

}
