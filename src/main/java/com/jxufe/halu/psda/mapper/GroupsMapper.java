package com.jxufe.halu.psda.mapper;

import com.jxufe.halu.psda.pojo.Groups;

public interface GroupsMapper {
    int deleteByPrimaryKey(String groupid);

    int insert(Groups record);

    int insertSelective(Groups record);

    Groups selectByPrimaryKey(String groupid);

    int updateByPrimaryKeySelective(Groups record);

    int updateByPrimaryKey(Groups record);
}