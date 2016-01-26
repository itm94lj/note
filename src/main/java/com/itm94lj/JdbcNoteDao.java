package com.itm94lj;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.sql.DataSource;
import com.itm94lj.Note;
import com.itm94lj.NoteDao;

public class JdbcNoteDao implements NoteDao 
{
    private DataSource dataSource;

    public void setDataSource(DataSource dataSource) {
	this.dataSource = dataSource;
    }

    public void insert(Note note) {
	String sql = "INSERT INTO NOTE_TABLE" +
	    "(NOTE_ID, NOTE_KEY, NOTE_VALUE) VALUES (NULL, ?, ?)";
	Connection conn = null;

	try {
	    conn = dataSource.getConnection();
	    PreparedStatement ps = conn.prepareStatement(sql);
	    ps.setString(1, note.getKey());
	    ps.setString(2, note.getValue());
	    ps.executeUpdate();
	    ps.close();
	} catch (SQLException e) {
	    throw new RuntimeException(e);
	} finally {
	    if (conn != null) {
		try {
		    conn.close();
		} catch (SQLException e) {}
	    }
	}
    }

    public Note findNoteByKey(String key) {
	String sql = "SELECT * FROM NOTE_TABLE WHERE NOTE_KEY = ?";

	Connection conn = null;

	try {
	    conn = dataSource.getConnection();
	    PreparedStatement ps = conn.prepareStatement(sql);
	    ps.setString(1, key);
	    Note note = null;
	    ResultSet rs = ps.executeQuery();
	    if (rs.next()) {
		note = new Note(rs.getString("NOTE_KEY"), 
				rs.getString("NOTE_VALUE"));
	    }
	    rs.close();
	    ps.close();
	    return note;
	} catch (SQLException e) {
	    throw new RuntimeException(e);
	} finally {
	    if (conn != null) {
		try {
		    conn.close();
		} catch (SQLException e) {}
	    }
	}

    }

}
