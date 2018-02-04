package com.synapt.synapttest.User;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

import io.reactivex.Flowable;

/**
 * Created by Evan on 1/24/2018.
 *
 * contains the methods used for accessing the database
 *
 * I've seen several people wrap Lists in Live Data maybe this is something
 * I should look into. If the only benefit is avoiding the main thread it
 * probably isn't worth it... I added two anyway to see why people do this
 */

@Dao
public interface UserDao {

    @Query("SELECT * FROM User")
    Flowable<User> getUser();

    @Query("SELECT * FROM User")
    LiveData<List<User>> getAllUsers();

    @Query("SELECT * FROM User")
    List<User> getAll();

    @Query("SELECT * FROM User WHERE uID IN (:userIds)")
    List<User> loadUsersByIds(int[] userIds);

    @Query("SELECT * FROM User WHERE uID = :id LIMIT 1")
    LiveData<List<User>> findUserById(long id);

    @Query("SELECT * FROM User WHERE username LIKE :userName LIMIT 1")
    LiveData<List<User>> findUserByUsername(String userName);

    @Query("SELECT * FROM User where username LIKE  :username")
    Flowable<User> findByUsername(String username);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertUser(User user);

    @Update
    void updateUser(User user);

    @Delete
    void delete(User user);

    @Query("DELETE FROM User")
    void deleteAllUsers();
}
