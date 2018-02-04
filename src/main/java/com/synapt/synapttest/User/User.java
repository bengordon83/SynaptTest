package com.synapt.synapttest.User;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.Index;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

import java.util.List;
import java.util.UUID;

/**
 * Created by Evan on 1/23/2018.
 *
 * Represents a table within the database
 * By default, Room uses the class name as the database table name
 */

@Entity(indices = {@Index( value = {"username"}, unique = true)})
public class User {

    @NonNull
    //@PrimaryKey(autoGenerate = true) only works for integers
    @ColumnInfo(name = "userid")
    private String uID;

    @ColumnInfo(name = "username")
    private String userName;

    @ColumnInfo(name = "password")
    private String password;


    @Ignore
    public User(String userName, String password) {
        uID = UUID.randomUUID().toString();
        this.userName = userName;
        this.password = password;
    }

    public User(String id, String userName , String password) {
        this.uID = id;
        this.password = password;
        this.userName = userName;
    }

    public String getUid() {
        return uID;
    }

    public void setUid(String uid) {
        this.uID = uid;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    /**
    @ColumnInfo(name = "visible_name")
    private String name;

    @ColumnInfo(name = "school")
    private String school;

    @ColumnInfo(name = "friend_list")
    private List<User> friends;

    @ColumnInfo(name = "study_group_list"
    private List<List<User>> studyGroups;


     * implement functionality for achievements, rank, titles, time elapsed
     * since account creation, time elapsed since last login, and email
     *
     *

     */
}
