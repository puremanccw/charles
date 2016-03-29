package com.charles.web.controller.user;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import ch.qos.logback.classic.Logger;

import com.charles.dal.dao.MemberDAO;
import com.charles.dal.dataobject.MemberDO;
import com.charles.web.controller.BaseController;

@Controller
public class UserController	extends BaseController {
	
	@Resource
	private MemberDAO memberDAO;
	@RequestMapping("/user")
	public String test(Model model){
		controllerLogger.info("test.......");
		MemberDO member = memberDAO.queryMemberByUsername("awdas");
		controllerLogger.info("member:" + member);
		model.addAttribute("result", "apple");
		return "user";
	}
}
