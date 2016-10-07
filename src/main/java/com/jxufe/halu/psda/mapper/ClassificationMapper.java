package com.jxufe.halu.psda.mapper;

import com.jxufe.halu.psda.pojo.Classification;

public interface ClassificationMapper {
    int deleteByPrimaryKey(String classid);

    int insert(Classification record);

    int insertSelective(Classification record);

    Classification selectByPrimaryKey(String classid);

    int updateByPrimaryKeySelective(Classification record);

    int updateByPrimaryKey(Classification record);
}