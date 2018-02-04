package com.synapt.synapttest.Utils;


import android.content.Context;

import com.synapt.synapttest.AppDatabase;
import com.synapt.synapttest.User.LocalUserDataSource;
import com.synapt.synapttest.User.UserDataSource;

public class Injection {
    public static UserDataSource provideUserDataSource(Context context) {
        AppDatabase database = AppDatabase.getAppDatabase(context);
        return new LocalUserDataSource(database.userDao());
    }

    public static ViewModelFactory provideViewModelFactory(Context context) {
        UserDataSource dataSource = provideUserDataSource(context);
        return new ViewModelFactory(dataSource);
    }
}
