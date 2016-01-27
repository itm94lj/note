package com.itm94lj;

import javax.sql.DataSource;
import com.itm94lj.Note;
import com.itm94lj.NoteDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;

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
	Note note;

	try {
	    note = this.jdbcTemplate.queryForObject(sql,
						    new Object[] {key},
						    new RowMapper<Note>() {
							public Note mapRow(ResultSet rs, int rowNum) throws SQLException {
							    Note note = new Note("", "Not found!");
							    note.setKey(rs.getString("NOTE_KEY"));
							    note.setValue(rs.getString("NOTE_VALUE"));
							    
							    return note;
							}
						    });
	
	} catch (Exception e) {
	    note = new Note("", "Not found!");
	}
	
	return note;
    }

}
