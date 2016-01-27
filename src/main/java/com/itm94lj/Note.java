package com.itm94lj;
    import org.springframework.stereotype.Component;

@Component
public class Note {
    int iNoteId;
    String sNoteKey;
    String sNoteValue;
	
	public Note() {
	    this.setKey("hi");
	    this.setValue("you");
	}
    
    public Note(String key, String value) {
	this.setKey(key);
	this.setValue(value);
    }

    public void setKey(String key) {
	this.sNoteKey = key;
    }

    public void setValue(String value) {
	this.sNoteValue = value;
    }

    public String getKey() {
	return this.sNoteKey;
    }

    public String getValue() {
	return this.sNoteValue;
    }

    public void setId(int id) {
	this.iNoteId = id;
    }
}
