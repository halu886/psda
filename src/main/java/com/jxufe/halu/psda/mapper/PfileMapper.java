package com.jxufe.halu.psda.mapper;

import com.jxufe.halu.psda.pojo.Pfile;

public interface PfileMapper {
    int deleteByPrimaryKey(String fileid);

    int insert(Pfile record);

    int insertSelective(Pfile record);

    Pfile selectByPrimaryKey(String fileid);

    int updateByPrimaryKeySelective(Pfile record);

    int updateByPrimaryKey(Pfile record);
}