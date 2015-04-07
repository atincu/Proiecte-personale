package com.taskmanager.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	@RequestMapping(value = "/homepage", method = RequestMethod.GET)
	public String getListOfTasks(Model model) {
		
		List <String> tasks = new ArrayList<String>();
		tasks.add("Important");
		tasks.add("Urgent");
		model.addAttribute("tasks", tasks );
		
		return "home";
	}
}
