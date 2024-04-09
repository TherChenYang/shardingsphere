package com.yang.demo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yang.demo.domain.EquipmentOee;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
* @author hzhang
* @description 针对表【equipment_oee(oee 相关指标)】的数据库操作Mapper
* @createDate 2023-08-29 10:52:43
* @Entity com.example.testsharding.generator.domain.EquipmentOee
*/
@Mapper
public interface EquipmentOeeMapper extends BaseMapper<EquipmentOee> {

    List<EquipmentOee> queryList();


}




