package com.itm94lj;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.PathVariable;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletRequest;
import com.itm94lj.JdbcNoteDao;
import com.itm94lj.Note;
    import org.springframework.beans.factory.annotation.Autowired;

@Controller
public class NoteController  {
    private String value;
    private String key;

    public JdbcNoteDao noteDao;

    @Autowired
    public void setNoteDao(JdbcNoteDao noteDao) {
	this.noteDao = noteDao;
    }

    @RequestMapping(value = "search", method = RequestMethod.GET)
    public void searchNote(HttpServletRequest httpRequest, 
              HttpServletResponse httpResponse) throws java.io.IOException
    {
	Note note;
	String key = httpRequest.getParameter("key");
	note = noteDao.findNoteByKey(key);
	httpResponse.getWriter().write(note.getValue());
	
	return ;
    }

    @RequestMapping(value = "procadd", method = RequestMethod.GET)
	public void addNote(HttpServletRequest httpRequest,
			    HttpServletResponse httpResponse) throws java.io.IOException
    {
	String key = httpRequest.getParameter("key");
	String value = httpRequest.getParameter("value");
	Note note = new Note(key, value);
	noteDao.insert(note);
	
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
