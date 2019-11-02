package com.gctchina.data_arc.dao.mapper;

import com.gctchina.data_arc.dao.Owner;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface OwnerMapper {
    @Select("select OwnerId,OwnerName,Description from Owner")
    List<Owner> findAll();

}
