package com.jxufe.halu.psda.mapper;

import com.jxufe.halu.psda.pojo.Pdepart;

public interface PdepartMapper {
    int deleteByPrimaryKey(String departid);

    int insert(Pdepart record);

    int insertSelective(Pdepart record);

    Pdepart selectByPrimaryKey(String departid);

    int updateByPrimaryKeySelective(Pdepart record);

    int updateByPrimaryKey(Pdepart record);
}