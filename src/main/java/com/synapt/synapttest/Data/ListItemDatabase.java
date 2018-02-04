package com.synapt.synapttest.Data;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import java.util.List;

/**
 * Created by Evan on 1/23/2018.
 */

@Database(entities = {ListItem.class}, version =1)
public abstract class ListItemDatabase extends RoomDatabase {

    public abstract ListItemDao ListItemDao();
}
