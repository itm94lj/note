package com.itm94lj;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.PathVariable;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletRequest;

@Controller
public class NoteController  {
    private String value;
    private String key;

    @RequestMapping(value = "search", method = RequestMethod.GET)
    public void searchNote(HttpServletRequest httpRequest, 
              HttpServletResponse httpResponse) throws java.io.IOException
    {
	String key = httpRequest.getParameter("key");
	
	if (key.equals("love"))
	{
	    this.key = key;
	    this.value = "you";
	}
        else if (key.equals("fuck"))
	{
	    this.key = key;
	    this.value = "you";
        }
	else
	{
	    this.value = "not found";
	}

	httpResponse.getWriter().write(this.value);
	
	return ;
    }

    @RequestMapping(value = "procadd", method = RequestMethod.GET)
	public void addNote(HttpServletRequest httpRequest,
			    HttpServletResponse httpResponse) throws java.io.IOException
    {
	String key = httpRequest.getParameter("key");
	String value = httpRequest.getParameter("value");
	
	httpResponse.getWriter().write("add note success."+key+":"+value);
	return ;
    }								     

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String addNote(ModelMap model) {
	return "addnote";
    }
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String showNote(ModelMap model) {	

	/*	if (key.equals("love"))
	{
	    this.key = key;
	    this.value = "you";
	}
        else if (key.equals("fuck"))
	{
	    this.key = key;
	    this.value = "xiaojing";
        }
	
	model.addAttribute("key", this.key);
	model.addAttribute("value", this.value);*/
	return "shownote";
    }


}
