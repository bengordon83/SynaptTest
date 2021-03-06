package com.synapt.synapttest.Notes;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.synapt.synapttest.Utils.Constants;

import java.util.List;

/**
 * Created by Evan on 1/23/2018.
 */

@Dao
public interface NoteDao {

    @Query("SELECT * FROM user" + Constants.TABLE_NAME_NOTE)
    List<Note> getNotes();

    @Insert
    void insertNote(Note note);

    @Update
    void updateNote(Note note);

    @Delete
    void deleteNote(Note note);

}
