package com.jxf.learnspb.dao.mapper.learnspb;

import com.jxf.learnspb.entity.Newtb;
import com.jxf.learnspb.entity.NewtbExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface NewtbMapper {
    int countByExample(NewtbExample example);

    int deleteByExample(NewtbExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Newtb record);

    int insertSelective(Newtb record);

    List<Newtb> selectByExample(NewtbExample example);

    Newtb selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Newtb record, @Param("example") NewtbExample example);

    int updateByExample(@Param("record") Newtb record, @Param("example") NewtbExample example);

    int updateByPrimaryKeySelective(Newtb record);

    int updateByPrimaryKey(Newtb record);
}