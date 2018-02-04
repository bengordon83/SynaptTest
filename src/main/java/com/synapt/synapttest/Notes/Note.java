package com.synapt.synapttest.Notes;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by Evan on 1/23/2018.
 */


@Entity(tableName = "notes")
public class Note implements Serializable{

    @PrimaryKey(autoGenerate = true)
    private long note_id;

    @ColumnInfo(name = "note_content")
    private String content;

    private String title;


    public Note(int note_id, String content, String title, Date date){
        this.note_id = note_id;
        this.content = content;
        this.title = title;
    }

    @Ignore
    public Note(String content, String title) {
        this.content = content;
        this.title = title;
    }


    public long getNote_id(){
        return note_id;
    }

    public void setNote_id(long Nid){
        this.note_id = Nid;
    }

    public String getContent(){
        return content;
    }

    public void setContent(String content){
        this.content = content;
    }

    public String getTitle(){
        return this.title;
    }

    public void setTitle(String title){
        this.title = title;
    }

    @Override
    public boolean equals(Object o){
        if(this == o) return true;
        if(!(o instanceof Note)) return false;

        Note note = (Note)o;
        if(note_id != note.note_id) return false;
        return title !=null ? title.equals(note.title) : note.title == null;
    }


    @Override
    public int hashCode(){
        int result = (int)note_id;
        result = 31*result + (title != null ? title.hashCode() :0);
        return result;
    }

    @Override
    public String toString(){
        return "Note{" +
                "note_id=" + note_id +
                ", content='" + content + '\'' +
                ", title='" + title + '\'' + '}';
    }

}
