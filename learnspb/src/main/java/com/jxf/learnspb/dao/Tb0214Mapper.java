package com.jxf.learnspb.dao;

import com.jxf.learnspb.entity.Tb0214;
import com.jxf.learnspb.entity.Tb0214Example;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface Tb0214Mapper {
    int countByExample(Tb0214Example example);

    int deleteByExample(Tb0214Example example);

    int deleteByPrimaryKey(Integer id);

    int insert(Tb0214 record);

    int insertSelective(Tb0214 record);

    List<Tb0214> selectByExample(Tb0214Example example);

    Tb0214 selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Tb0214 record, @Param("example") Tb0214Example example);

    int updateByExample(@Param("record") Tb0214 record, @Param("example") Tb0214Example example);

    int updateByPrimaryKeySelective(Tb0214 record);

    int updateByPrimaryKey(Tb0214 record);
}