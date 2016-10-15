package com.jxufe.halu.psda.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.json.Json;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.jxufe.halu.psda.mapper.ProjectMapper;
import com.jxufe.halu.psda.pojo.Project;

@Controller
@RequestMapping("/taskController")
public class TaskController {
	
	@Resource
	private ProjectMapper projectMapper;
	
	@RequestMapping("/addUser")
	public void  saveTask(Project project,HttpServletRequest httpServletRequest, 
			HttpServletResponse httpServletResponse) {
//		Json json = new Json();
		if(projectMapper.selectByPrimaryKey(project.getProjectid())!=null){
			projectMapper.insert(project);
		}
	}
	
	@RequestMapping("/taskList")
	public void taskList(HttpServletRequest request,  
            HttpServletResponse response) {
		int page = ServletRequestUtils.getIntParameter(request, "page", 1);
		int row = ServletRequestUtils.getIntParameter(request, "row", 0);
		List<Project> tasks = projectMapper.selectProductsByPage(page, row);
		JSONObject result = new JSONObject();
		JSONArray jsonArray = new JSONArray();
		jsonArray.addAll(tasks);
		request.setAttribute("tasks", tasks);
	}
}
