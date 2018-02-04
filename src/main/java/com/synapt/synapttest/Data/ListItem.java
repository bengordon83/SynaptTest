package com.synapt.synapttest.Data;

/**
 * Created by Evan on 1/21/2018.
 */

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

/**
 * Room will use the Class name as a default table name.
 *
 * This can be changed by setting @Entity(tableName = "tableName")
 */
@Entity
public class ListItem {

    //itemId is simply a value based on the current date, to the second.
    //Most importantly, it should always be a unique value, however you choose to determine it.
    @PrimaryKey
    @NonNull
    private String itemId;
    private String message;
    private int colorResource;

    public ListItem(String itemId, String message, int colorResource) {
        this.itemId = itemId;
        this.message = message;
        this.colorResource = colorResource;
    }

    public int getColorResource() {
        return colorResource;
    }

    public void setColorResource(int colorResource) {
        this.colorResource = colorResource;
    }

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }


    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}