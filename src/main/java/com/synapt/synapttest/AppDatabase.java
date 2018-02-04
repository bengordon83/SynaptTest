package com.synapt.synapttest;

/**
 * Created by Evan on 1/24/2018.
 */


import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;
import android.support.annotation.VisibleForTesting;

import com.synapt.synapttest.User.User;
import com.synapt.synapttest.User.UserDao;

/**
 * Contains the database holder and serves as the main access point for the
 * underlying connection to the app's persisted relational data
 * acquire an instance of Database by calling
 * Room.databaseBuilder() or Room.inMemoryDatabaseBuilder()
 */

@Database(entities = {User.class}, version =1)
public abstract class AppDatabase extends RoomDatabase {

    // volatile ensures the visibility of changes to variables across threads
    private static volatile AppDatabase INSTANCE;

    @VisibleForTesting
    public static final String DATABASE_NAME = "app-database-v1";

    public abstract UserDao userDao();

    //method to load the database or create one if it doesn't exist
    public static AppDatabase getAppDatabase(Context context) {
        if (INSTANCE == null) {
            synchronized (AppDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            AppDatabase.class, "user-database")
                            .build();
                }
            }
        }
        return INSTANCE;
    }

    public static void destroyInstance(){
        INSTANCE = null;
    }
}
