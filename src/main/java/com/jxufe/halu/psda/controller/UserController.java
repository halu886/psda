package com.jxufe.halu.psda.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jxufe.halu.psda.mapper.PUserMapper;
import com.jxufe.halu.psda.pojo.PUser;


@Controller
@RequestMapping("/user")
public class UserController {
	@Resource
	private PUserMapper pUserMapper;
	
	@RequestMapping("/showUser")
	public String toIndex(HttpServletRequest request,Model model){
		PUser user = this.pUserMapper.selectByPrimaryKey(request.getParameter("id"));
		model.addAttribute("user", user);
		return "showUser";
	}
}

