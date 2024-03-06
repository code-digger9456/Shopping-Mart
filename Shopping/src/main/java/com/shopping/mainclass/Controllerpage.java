package com.shopping.mainclass;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Controllerpage {

	@GetMapping("/login")
	public String view()
	{
		return "login";
	}
	@GetMapping("/registration")
	public String reg()
	{
		return "kuchbhi/registration";
	}
}
