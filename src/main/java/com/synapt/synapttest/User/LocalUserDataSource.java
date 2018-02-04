package com.synapt.synapttest.User;


import io.reactivex.Flowable;
import com.synapt.synapttest.User.UserDataSource;

public class LocalUserDataSource implements UserDataSource {
    private final UserDao mUserDao;

    public LocalUserDataSource(UserDao userDao) {
        mUserDao = userDao;
    }

    @Override
    public Flowable<User> getUser() {
        return mUserDao.getUser();
    }

    @Override
    public void insertOrUpdateUser(User user) {
        mUserDao.insertUser(user);
    }

    @Override
    public void deleteAllUsers() {
        mUserDao.deleteAllUsers();
    }
}
