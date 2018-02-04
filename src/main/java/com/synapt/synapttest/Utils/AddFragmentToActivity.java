package com.synapt.synapttest.Utils;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by Evan on 1/23/2018.
 */

public abstract class AddFragmentToActivity extends AppCompatActivity {

    public static void addFragmentToActivity(FragmentManager fragManager,
                                             Fragment fragment, int frameId,
                                             String tag){
        FragmentTransaction transaction = fragManager.beginTransaction();
        transaction.replace(frameId,fragment,tag).commit();
    }
}
