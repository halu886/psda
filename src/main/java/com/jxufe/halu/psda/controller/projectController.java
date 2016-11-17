package com.jxufe.halu.psda.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;
import javax.json.Json;
import javax.json.JsonObject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PathParam;

import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.jxufe.halu.psda.mapper.ProjectMapper;
import com.jxufe.halu.psda.pojo.PUser;
import com.jxufe.halu.psda.pojo.Project;
import com.jxufe.halu.psda.util.TreeUtil;
import com.sun.org.apache.xml.internal.serialize.Printer;

@Controller
@RequestMapping("/projectController")
//@SessionAttributes(value={"user"},types={PUser.class})
public class projectController {
	
	@Resource
	private ProjectMapper projectMapper;
	
	
	/*
	 * 请求任务界面并且保存projectTree属性
	 */
	@GET
	@RequestMapping("/project")
	public ModelAndView login(HttpServletRequest request,HttpServletResponse response){
		ModelAndView modelAndView = new ModelAndView("project");
		modelAndView.addObject("projectTree",projectTree());
//		modelAndView.addObject("projects", );
		return new ModelAndView("project");
//		return "project";
	}
	
	/*
	 *将任务列表转换为树结构
	 */
	public  JSONArray projectTree(){
		List<Project> projects = projectMapper.selectProjectsByUserId("1");
		TreeUtil treeUtil = new TreeUtil(projects);//调用Util工具类
		return treeUtil.nodeToJSONArray(); //返回树结构的jsonArray
	}
	
	@POST
	@RequestMapping("/addProject")
	public String  saveTask(Project project,HttpServletRequest request, 
			HttpServletResponse response) throws IOException {
		JSONObject json = new JSONObject();
		if(projectMapper.selectByPrimaryKey(project.getProjectid())!=null){
			json.put("errorMsg", "获取失败");
		} else{
			projectMapper.insert(project);
			json.put("Msg", "获取成功");
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
			json.put("errorMsg", "获取失败");
		} else{
			json.put("Msg", "获取成功");
			json.put("Success",true);
		}
		
		response.setContentType("text/html;charset=utf-8");
		PrintWriter printWriter = response.getWriter();
		printWriter.println(json.toString());
		printWriter.flush();
		printWriter.close();
		return null;
	}
	
	/*
	 * 获取任务列表
	 */
	@RequestMapping("/projectList")
	public void projectList(HttpServletRequest request,  
            HttpServletResponse response) throws Exception {
		int page = ServletRequestUtils.getIntParameter(request, "page");
		int row = ServletRequestUtils.getIntParameter(request, "rows");
		List<Project> projects = projectMapper.selectProjectsByPage((--	page)*row, row);
		JSONArray jsonArray = (JSONArray)JSONArray.toJSON(projects);
		JSONObject result = new JSONObject();
		result.put("rows", jsonArray);
		result.put("total", projects.size());
		response.setContentType("text/html;charset=utf-8");
		PrintWriter printWriter = response.getWriter();
		printWriter.println(result);
		printWriter.flush();
		printWriter.close();
	}
	
	@RequestMapping("/projectDelete")
	@POST
	public void projectDelete(HttpServletRequest request,
			HttpServletResponse response,Project project) throws IOException{
		JSONObject json = new JSONObject();
		if(projectMapper.deleteByPrimaryKey(project.getProjectid())==0){
			json.put("errorMSG", "获取失败");
		}else {
			json.put("success",true);
		}
		PrintWriter printWriter = response.getWriter();
		printWriter.println(json.toString());
		printWriter.flush();
		printWriter.close();
	}
}

