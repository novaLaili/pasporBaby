package com.example.laili.pasporbayi.global;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by Bend on 6/14/2017.
 */

public class SessionManager {

    private static SessionManager instance;

    public static synchronized SessionManager getInstance(Context context){
        if(instance == null) instance = new SessionManager(context);

        return instance;
    }

    private SharedPreferences pref;
    private SharedPreferences.Editor editor;

    private static final String PREF_NAME = "com.example.laili.pasporbayi.login";

    /**
     * Preferences for login
     */
    private static final String SESSION_IS_LOGIN = "is_login";
    private static final String SESSION_ID_USER = "id_user";

    private SessionManager(Context context){
        pref = context.getSharedPreferences(PREF_NAME, 0);
        this.editor = pref.edit();
    }

    public void createSession(String idUser){
        editor.putBoolean(SESSION_IS_LOGIN, true);
        editor.putString(SESSION_ID_USER, idUser);
        editor.commit();
    }

    public boolean isLogin(){
        return pref.getBoolean(SESSION_IS_LOGIN, false);
    }

    public String getIdUser(){
        return pref.getString(SESSION_ID_USER, null);
    }

    public void destroySession(){
        editor.clear();
        editor.commit();
    }
}
