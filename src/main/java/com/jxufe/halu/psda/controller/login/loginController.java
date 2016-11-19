package com.jxufe.halu.psda.controller.login;

import javax.annotation.Resource;
import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;

import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.jxufe.halu.psda.cons.CommonConstant;
import com.jxufe.halu.psda.controller.BaseController;
import com.jxufe.halu.psda.mapper.PUserMapper;
import com.jxufe.halu.psda.pojo.PUser;
import com.mysql.fabric.Response;

@Controller
@RequestMapping("/loginController")
public class loginController extends BaseController{
	
	@Resource
	private PUserMapper puserMapper;
	

	@RequestMapping(value = "/login",method = RequestMethod.POST)
	public ModelAndView login(PUser user,HttpServletRequest request){
		ModelAndView view = new ModelAndView();
		view.setViewName("project");
		PUser selectUser = puserMapper.selectByPrimaryKey(user.getUserid());
		if(selectUser == null){
			view.addObject("msg", "不存在该用户！");
		} else if (selectUser.getPassword().equals(user.getUserid())) {
			view.addObject("msg","密码错误");
		}else {
			setSessionUser(request, selectUser);
			String toUrl = (String)request.getSession().getAttribute(CommonConstant.LOGIN_TO_URL);
			request.removeAttribute(CommonConstant.LOGIN_TO_URL);
			if(toUrl==null||toUrl.isEmpty()){
				toUrl = "project/project";
			}
			view.setViewName(toUrl);
		}
		return view;
	}
	

	}
	
