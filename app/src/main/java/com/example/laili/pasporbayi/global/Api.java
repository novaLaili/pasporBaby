package com.example.laili.pasporbayi.global;

/**
 * Created by Bend on 6/15/2017.
 */

public class Api {

    private static final String HTTP_PREFIX = "http://";
    private static final String BASE_URL = "novarizqi.hol.es/pasporBayi_TA/";

    private static String getBaseUrl(){
        return HTTP_PREFIX + BASE_URL;
    }

    public static final String URL_LOGIN = getBaseUrl() + "login.php";
}
