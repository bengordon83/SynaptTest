package com.synapt.synapttest.Data;

import android.arch.lifecycle.LiveData;

import java.util.List;

import javax.inject.Inject;

/**
 * Created by Evan on 1/23/2018.
 */

public class ListItemRepository {
    //depends on the data access object itself (not the database)
    //another layer of abstraction

    private final ListItemDao listItemDao;

    @Inject
    public ListItemRepository (ListItemDao listItemDao){
        this.listItemDao = listItemDao;
    }

    /**wrap the listItem in a live data object */
    public LiveData<ListItem> getListItem(String itemId){
        return listItemDao.getListItemById(itemId);
    }

    /** can also return a variable here to determine if the item
     *  was correctly added or deleted */
    public void deleteListItem(ListItem listItem){
        listItemDao.deleteListItem(listItem);
    }

    public void insetListItem(ListItem listItem){
        listItemDao.insertListItem(listItem);

    }
}
