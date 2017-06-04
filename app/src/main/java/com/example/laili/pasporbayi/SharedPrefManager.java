package com.example.laili.pasporbayi;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

/**
 * Created by hera on 1/28/17.
 */

public class SharedPrefManager {

    private static SharedPrefManager mInstance;
    private static Context mCtx;

    private static final String SHARED_PREF_NAME = "paspor_shared_pref";

    public static final String KEY_TOKEN = "token";
    public static final String KEY_USERNAME = "username";
    public static final String KEY_IS_LOGGED_IN = "isloggedIn";
    public static final String KEY_USER_ID = "user_id";
    public static final String USER_ID = "0";

    private SharedPrefManager(Context context) {
        mCtx = context;
    }

    public static synchronized SharedPrefManager getmInstance(Context context) {
        if (mInstance == null) {
            mInstance = new SharedPrefManager(context);
        }
        return mInstance;
    }

    public String getUsername(){
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME,Context.MODE_PRIVATE);
        String username = sharedPreferences.getString(KEY_USERNAME,null);
        if(username!=null && !username.equals(""))
            return username;
        else return null;
    }

    public String getToken(){
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        String token = sharedPreferences.getString(KEY_TOKEN,null);
        if(token!=null && !token.equals(""))
            return token;
        else return null;
    }

    public String getUseId(){
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        String userid = sharedPreferences.getString(USER_ID,null);
        if(userid!=null && !userid.equals(""))
            return userid;
        else return null;
    }

    public boolean isLoggedIn(){
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        if(sharedPreferences.getBoolean(KEY_IS_LOGGED_IN,false) && sharedPreferences.getString(KEY_USERNAME, null) !=null){
            return true;
        }
        return false;
    }

    public void setUserID(int id){
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME,Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt(KEY_USER_ID,id);
        editor.apply();
    }

    public static void setIDUser(String id){
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME,Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(KEY_USER_ID,id);
        editor.apply();
    }

    public static int getUserId(){
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME,Context.MODE_PRIVATE);
            return sharedPreferences.getInt(KEY_USER_ID,0);
    }

    public boolean logout(){
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.clear();
        editor.apply();
        return true;
    }
}