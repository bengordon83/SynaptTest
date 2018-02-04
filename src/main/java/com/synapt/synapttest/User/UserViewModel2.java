package com.synapt.synapttest.User;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.support.annotation.NonNull;

import com.synapt.synapttest.AppDatabase;

import java.util.List;

/**
 * Created by Evan on 1/24/2018.
 */

public class UserViewModel2 extends AndroidViewModel {

    private final LiveData<List<User>> userList;

    public UserViewModel2(@NonNull Application application){
        super(application);

        userList = AppDatabase.getAppDatabase(getApplication()).userDao().getAllUsers();

    }

    public LiveData<List<User>> getUserList(){
        return userList;
    }
}
