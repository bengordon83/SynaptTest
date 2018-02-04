package com.synapt.synapttest.Notes;

/**
 * Created by Evan on 1/23/2018.
 */

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import com.synapt.synapttest.Utils.Constants;

@Database(entities = {Note.class}, version = 1)
public abstract class NoteDatabase extends RoomDatabase {

    public abstract NoteDao getNoteDao();

    private static NoteDatabase noteDb;

    public static NoteDatabase getInstance(Context context){
        if(noteDb == null){
            noteDb = buildDataBaseInstance(context);
        }
        return noteDb;
    }

    /**
     *
     * TODO
     * DO NOR GO PUBLIC WITH THE APP WHILE THE ALLOW MAIN THREAD QUERIES
     * IS IN THE BUILD DATABASE METHOD --> ROOM DATABASES SHOULD BE BUILT ON
     * A THREAD ASIDE FROM THE MAIN THREAD USE ASYNC TASK INSTEAD
     */

    private static NoteDatabase buildDataBaseInstance(Context context){
        return Room.databaseBuilder(context, NoteDatabase.class, Constants.DB_NAME)
                .allowMainThreadQueries().build();
    }

    public void cleanUp(){
        noteDb = null;
    }
}
