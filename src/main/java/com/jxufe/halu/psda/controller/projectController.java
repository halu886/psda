package com.jxufe.halu.psda.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.annotation.Resource;
import javax.json.Json;
import javax.json.JsonObject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.POST;
import javax.ws.rs.PathParam;

import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.jxufe.halu.psda.mapper.ProjectMapper;
import com.jxufe.halu.psda.pojo.Project;
import com.sun.org.apache.xml.internal.serialize.Printer;

@Controller
@RequestMapping("/projectController")
public class projectController {
	
	@Resource
	private ProjectMapper projectMapper;
	
	@POST
	@RequestMapping("/addProject")
	public String  saveTask(Project project,HttpServletRequest request, 
			HttpServletResponse response) throws IOException {
		JSONObject json = new JSONObject();
		if(projectMapper.selectByPrimaryKey(project.getProjectid())==null){
			json.put("errorMsg", "新建用户以失败,用户已存在");
		} else{
			projectMapper.insert(project);
			json.put("errorMsg", "新建用户成功");
			json.put("Success",true);
		}
		response.setContentType("text/html;charset=utf-8");
		PrintWriter printWriter = response.getWriter();
		printWriter.println(json.toString());
		printWriter.flush();
		printWriter.close();
		return null;
	}
	
	@RequestMapping("/editProject")
	public String editProject(HttpServletRequest request,  
            HttpServletResponse response,@PathParam("id")String id,Project project) throws IOException{
		JSONObject json = new JSONObject();
		if(projectMapper.updateByPrimaryKey(project)==0){
			json.put("errorMsg", "修改用户以失败");
		} else{
			json.put("Msg", "修改用户成功");
			json.put("Success",true);
		}
		response.setContentType("text/html;charset=utf-8");
		PrintWriter printWriter = response.getWriter();
		printWriter.println(json.toString());
		printWriter.flush();
		printWriter.close();
		return null;
	}
	
	@RequestMapping("/projectList")
	public void taskList(HttpServletRequest request,  
            HttpServletResponse response) throws IOException {
		int page = ServletRequestUtils.getIntParameter(request, "page", 0);
		int row = ServletRequestUtils.getIntParameter(request, "row", 1);
		List<Project> projects = projectMapper.selectProjectsByPage(--	page, row);
		JSONArray jsonArray = (JSONArray)JSONArray.toJSON(projects);
		response.setContentType("text/html;charset=utf-8");
		PrintWriter printWriter = response.getWriter();
		printWriter.println(jsonArray.toString());
		printWriter.flush();
		printWriter.close();
	}
}
