package com.jxufe.halu.psda.controller;

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
			if(toUrl.isEmpty()){
				toUrl = "index";
			}
			view.setViewName(toUrl);
		}
		return view;
//		return "project";
	}
	
	@RequestMapping(value = "/testLogin",method = RequestMethod.POST)
	public ModelAndView login(HttpServletRequest request, PUser user) {
//		PUser dbUser = PUserMapper.getUserByUserName(user.getUserName());
		ModelAndView mav = new ModelAndView();
		mav.setViewName("forward:/login.jsp");
//		if (dbUser == null) {
//			mav.addObject("errorMsg", "用户名不存在");
//		} else if (!dbUser.getPassword().equals(user.getPassword())) {
//			mav.addObject("errorMsg", "用户密码不正确");
//		} else if (dbUser.getLocked() == User.USER_LOCK) {
//			mav.addObject("errorMsg", "用户已经被锁定，不能登录。");
//		} else {
//			dbUser.setLastIp(request.getRemoteAddr());
//			dbUser.setLastVisit(new Date());
//			userService.loginSuccess(dbUser);
//			setSessionUser(request,dbUser);
//			String toUrl = (String)request.getSession().getAttribute(CommonConstant.LOGIN_TO_URL);
//			request.getSession().removeAttribute(CommonConstant.LOGIN_TO_URL);
			//如果当前会话中没有保存登录之前的请求URL，则直接跳转到主页
//			if(StringUtils.isEmpty(toUrl)){
//				toUrl = "/index.html";
//			}
			mav.setViewName("project");
//		}
			return mav;
		}
	}
	
