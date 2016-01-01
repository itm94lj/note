package com.itm94lj;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class NoteController  {
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String printWelcom(ModelMap model) {
	model.addAttribute("key", "love");
	model.addAttribute("value", "you");
	return "shownote";
    }
}
