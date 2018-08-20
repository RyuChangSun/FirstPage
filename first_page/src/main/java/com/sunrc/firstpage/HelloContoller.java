package com.sunrc.firstpage;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloContoller {

	@RequestMapping("/")
	public String index(Model model)
	{
		model.addAttribute("name","hello springBoot1234");

		return "hello";
	}
}
