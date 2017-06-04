package com.example.laili.pasporbayi;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

public class Config extends Activity {

    public static final String SP_CONFIG = "AMD";
    static SharedPreferences settings;
    static SharedPreferences.Editor editor;
    //public static final String DATA_URL = "http:///192.168.0.105/pasporBayi_TA/data_anak.php?id_user=";
    public static final String DATA_URL = "http://192.168.1.112/pasporBayi_TA/data_anak.php?id_user=";
    public static final String DATA_URL_ANAK = "http://192.168.1.112/pasporBayi_TA/riwayat_kelahiran.php?id_anak=";
    public static final String JSON_ARRAY = "result";

    public static void SetString(Activity act, String key, String value){
        settings = act.getSharedPreferences(SP_CONFIG, Context.MODE_PRIVATE);;
        editor = settings.edit();
        editor.putString(key, value);
        editor.commit();
    }

    public static String GetString(Activity act, String key){
        settings = act.getSharedPreferences(SP_CONFIG, 0);
        String val = settings.getString(key, "");
        return val;
    }
}
