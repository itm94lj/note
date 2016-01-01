package com.itm94lj;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HelloController  {
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String printWelcom(ModelMap model) {
	model.addAttribute("message", "This is my first");
	return "hello";
    }
}
