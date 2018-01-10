package com.ashish.hangman;

import android.app.Application;

import com.ashish.hangman.network.RestClient;

/**
 * @author ashish
 * @since 09/01/18
 */
public class HangManApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        RestClient.init();
    }
}
