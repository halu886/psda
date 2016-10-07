package com.jxufe.halu.psda.mapper;

import com.jxufe.halu.psda.pojo.Keywords;

public interface KeywordsMapper {
    int deleteByPrimaryKey(String keyword);

    int insert(Keywords record);

    int insertSelective(Keywords record);

    Keywords selectByPrimaryKey(String keyword);

    int updateByPrimaryKeySelective(Keywords record);

    int updateByPrimaryKey(Keywords record);
}