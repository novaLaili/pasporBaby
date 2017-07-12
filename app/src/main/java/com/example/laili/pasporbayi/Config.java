package com.example.laili.pasporbayi;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;

public class Config extends Activity {

    public static final String SP_CONFIG = "AMD";
    static SharedPreferences settings;
    static SharedPreferences.Editor editor;
    //public static final String DATA_URL = "http:///192.168.0.105/pasporBayi_TA/data_anak.php?id_user=";
    public static final String DATA_URL = "http://192.168.0.102/pasporBayi_TA/data_anak.php?id_anak=";
    public static final String DATA_URL_ANAK = "http://192.168.0.102/pasporBayi_TA/riwayat_kelahiran.php?id_anak=";
    public static final String DATA_URL_RIWAYAT_KESEHATAN = "http://192.168.0.102/pasporBayi_TA/riwayat_kesehatan_bayi.php?id_anak=";
    public static final String DATA_URL_RIWAYAT_KELAHIRAN= "http://192.168.0.103/pasporBayi_TA/riwayat_kelahiran.php?id_anak=";
    public static final String DATA_URL_RIWAYAT_MEDIK_PENTING= "http://192.168.0.102/pasporBayi_TA/riwayat_medik_penting.php?id_anak=";
    public static final String DATA_URL_RIWAYAT_PENYAKIT= "http://192.168.0.102/pasporBayi_TA/riwayat_penyakit_yg_pernah_diderita.php?id_anak=";
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
