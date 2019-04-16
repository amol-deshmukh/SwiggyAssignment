package com.deshmukh.swiggyassignment.network;

/**
 * Created by
 *
 * @author Amol Deshmukh
 * @since 16/04/19
 */
public class NetworkUtils {


    public static final int ASYNC_HTTP_TIMEOUT = 40*1000;
    private static String DOMAIN_NAME = "https://api.myjson.com/";

    public static String getDomainName(){
        return DOMAIN_NAME;
    }

}

