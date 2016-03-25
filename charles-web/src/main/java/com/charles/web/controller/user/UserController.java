package com.charles.web.controller.user;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.charles.web.controller.BaseController;

@Controller
public class UserController	extends BaseController {

	@RequestMapping("/user")
	public String test(Model model){
		controllerLogger.info("test.......");
		model.addAttribute("result", "apple");
		return "user";
	}
}
