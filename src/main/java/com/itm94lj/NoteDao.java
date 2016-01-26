package com.itm94lj;

import com.itm94lj.Note;

public interface NoteDao 
{
    public void insert(Note note);
    public Note findNoteByKey(String key);
}


