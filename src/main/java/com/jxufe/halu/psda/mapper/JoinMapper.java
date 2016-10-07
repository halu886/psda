package com.jxufe.halu.psda.mapper;

import com.jxufe.halu.psda.pojo.Join;
import com.jxufe.halu.psda.pojo.JoinKey;

public interface JoinMapper {
    int deleteByPrimaryKey(JoinKey key);

    int insert(Join record);

    int insertSelective(Join record);

    Join selectByPrimaryKey(JoinKey key);

    int updateByPrimaryKeySelective(Join record);

    int updateByPrimaryKey(Join record);
}