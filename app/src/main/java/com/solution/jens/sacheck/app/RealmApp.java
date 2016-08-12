package com.solution.jens.sacheck.app;

import android.app.Application;

import com.solution.jens.sacheck.realm.model.SimpleRealmModel;

import io.realm.Realm;
import io.realm.RealmConfiguration;

/**
 * Created by Jens on 8/10/2016.
 */
public class RealmApp extends Application {

    private static RealmApp instance;

    @Override
    public void onCreate() {
        super.onCreate();
        RealmConfiguration config = new RealmConfiguration.Builder(getApplicationContext()).setModules(new SimpleRealmModel()).build();
        Realm.setDefaultConfiguration(config);
    }

    public static RealmApp getInstance(){
        return instance;
    }
}
