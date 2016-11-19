package com.jxufe.halu.psda.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.jxufe.halu.psda.pojo.Project;

public interface ProjectMapper {
    int deleteByPrimaryKey(String projectid);

    int insert(Project record);

    int insertSelective(Project record);

    Project selectByPrimaryKey(String projectid);
    
    public List<Project> selectProjectsByUserId(String userID);

    public List<Project> selectGroupProject(String userID);
    
    int updateByPrimaryKeySelective(Project record);

    int updateByPrimaryKey(Project record);

    public List<Project> selectProjectsByPage(@Param("startPos")int startPos,@Param("pageSize")int pageSize);
}