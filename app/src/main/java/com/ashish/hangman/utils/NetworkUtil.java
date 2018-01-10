package com.ashish.hangman.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/**
 * @author ashish
 * @since 10/01/18
 */
public class NetworkUtil {

    private static int[] validNetworkType = {
            ConnectivityManager.TYPE_MOBILE,
            ConnectivityManager.TYPE_WIFI
    };

    public static boolean isNetworkAvailable(Context context) {
        try {
            ConnectivityManager cm = (ConnectivityManager)context.getSystemService(Context.CONNECTIVITY_SERVICE);
            for (int networkType : validNetworkType) {
                NetworkInfo netInfo = cm.getNetworkInfo(networkType);
                if (netInfo != null && netInfo.getState() == NetworkInfo.State.CONNECTED) {
                    return true;
                }
            }
        } catch (Exception e) {
            return false;
        }
        return false;
    }

}

/*public final class NetworkConnectivity {

    private static NetworkConnectivity instance = new NetworkConnectivity();

    public static NetworkConnectivity getInstance() {
        return instance;
    }

    *//**
     * Check if internet connection is available or not
     *
     * @return true if internet is available else false
     *//*
    public boolean isInternetConnectionAvaliable(Context context) {
        if (null == context) {
            return true;
        }
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        // test for connection
        NetworkInfo netInfo = null;
        if (null != connectivityManager) {
            netInfo = connectivityManager.getActiveNetworkInfo();
        }
        if (null != netInfo && netInfo.isAvailable() && netInfo.isConnected()) {
            return true;
        } else {
            AppLogger.logInfo(context.getString(R.string.noInternet));
            return false;
        }
    }
}*/

