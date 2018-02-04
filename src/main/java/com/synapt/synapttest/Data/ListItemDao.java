package com.synapt.synapttest.Data;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

import static android.arch.persistence.room.OnConflictStrategy.REPLACE;

/**
 * Created by Evan on 1/23/2018.
 */

@Dao
public interface ListItemDao {

    @Query("SELECT * FROM ListItem")
    LiveData<List<ListItem>> getListOfData();

    @Query("SELECT * FROM ListItem WHERE itemId = itemId")
    LiveData<ListItem> getListItemById(String itemId);

    @Insert(onConflict = REPLACE )
    Long insertListItem(ListItem listItem);

    @Delete
    void deleteListItem(ListItem listItem);

}
