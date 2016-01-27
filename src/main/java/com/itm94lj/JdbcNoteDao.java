package com.itm94lj;

import javax.sql.DataSource;
import com.itm94lj.Note;
import com.itm94lj.NoteDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.jdbc.core.JdbcTemplate;

@Repository
public class JdbcNoteDao implements NoteDao 
{
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public void setDataSource(DataSource dataSource) {
	this.jdbcTemplate = new JdbcTemplate(dataSource);
    }
	    

    public void insert(Note note) {
	String sql = "INSERT INTO NOTE_TABLE" +
	    "(NOTE_ID, NOTE_KEY, NOTE_VALUE) VALUES (NULL, ?, ?)";
	    
	    this.jdbcTemplate.update(sql,
			       new Object[] { note.getKey(), note.getValue() });
    }

    public Note findNoteByKey(String key) {
	String sql = "SELECT * FROM NOTE_TABLE WHERE NOTE_KEY = ?";
	    Note note = new Note("1", "2");
	return note;
    }

}
