package com.synapt.synapttest.User;


import android.arch.lifecycle.ViewModel;

import io.reactivex.Completable;
import io.reactivex.Flowable;

public class UserViewModel extends ViewModel {

    private final UserDataSource mDataSource;

    private User mUser;

    public UserViewModel(UserDataSource dataSource) {
        mDataSource = dataSource;
    }

    /**
     * Get the user name of the user.
     *
     * @return a {@link Flowable} that will emit every time the user name has been updated.
     */
    public Flowable<String> getUserName() {
        return mDataSource.getUser()
                // for every emission of the user, get the user name
                .map(user -> {
                    mUser = user;
                    return user.getUserName();
                });

    }

    /**
     * Update the user name.
     *
     * @param userName the new user name
     * @return a {@link Completable} that completes when the user name is updated
     */
    public Completable updateUserName(final String userName) {
        return Completable.fromAction(() -> {
            // if there's no use, create a new user.
            // if we already have a user, then, since the user object is immutable,
            // create a new user, with the id of the previous user and the updated user name.
            mUser = mUser == null
                    ? new User(userName,mUser.getPassword())
                    : new User(mUser.getUid(), userName);

            mDataSource.insertOrUpdateUser(mUser);
        });
    }
}
