package com.jxufe.halu.psda.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.jxufe.halu.psda.pojo.Project;

public interface ProjectMapper {
    int deleteByPrimaryKey(String projectid);

    int insert(Project record);

    int insertSelective(Project record);

    Project selectByPrimaryKey(String projectid);

    int updateByPrimaryKeySelective(Project record);

    int updateByPrimaryKey(Project record);
    
    /**
     * @param page
     * @param userId
     */
    public List<Project> selectProductsByPage(@Param(value="startPos") Integer startPos,
    		@Param(value="pageSize") Integer pageSize);
}