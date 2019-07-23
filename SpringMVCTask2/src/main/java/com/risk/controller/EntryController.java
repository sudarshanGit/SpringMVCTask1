package com.risk.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.risk.model.User;
import com.risk.service.UserService;

@Controller
public class EntryController {

	@Autowired
	private UserService userService;

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String registerPage(Model model) {
		model.addAttribute("user", new User());
		return "register";
	}

	@RequestMapping(value = "/registerSuccess", method = RequestMethod.POST)
	public String registerSuccess(@Valid @ModelAttribute("user") User user, BindingResult result) {

		if (user.getName().isEmpty()) {
			throw new  	RuntimeException();
		}
		if (result.hasErrors()) {
			return "register";
		}
		userService.addUserList(user);
		return "redirect:/listUsers";
	}

	@RequestMapping(value = "/listUsers", method = RequestMethod.GET)
	public ModelAndView registerSuccess(ModelAndView modelAndView) {
		modelAndView.setViewName("UserList");
		List<User> userList = userService.getUserList();
		modelAndView.addObject("userList", userList);
		return modelAndView;

	}
	
	@ModelAttribute
	public void headerMessage(Model model){
		model.addAttribute("headerMessage", "Welcome to Risk Technology");
		
		
	}

	@ExceptionHandler(value = RuntimeException.class)
	public String myExceptionClass() {
		return "exception";
	}
}
