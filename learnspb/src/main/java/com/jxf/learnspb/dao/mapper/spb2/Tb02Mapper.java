package com.jxf.learnspb.dao.mapper.spb2;

import com.jxf.learnspb.entity.Tb02;
import com.jxf.learnspb.entity.Tb02Example;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface Tb02Mapper {
    int countByExample(Tb02Example example);

    int deleteByExample(Tb02Example example);

    int deleteByPrimaryKey(Integer id);

    int insert(Tb02 record);

    int insertSelective(Tb02 record);

    List<Tb02> selectByExample(Tb02Example example);

    Tb02 selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Tb02 record, @Param("example") Tb02Example example);

    int updateByExample(@Param("record") Tb02 record, @Param("example") Tb02Example example);

    int updateByPrimaryKeySelective(Tb02 record);

    int updateByPrimaryKey(Tb02 record);
}