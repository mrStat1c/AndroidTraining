package com.example.androidtraining.vk.utils;

import android.net.Uri;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.Scanner;

public class NetworkHelper {

    private static final String VK_API_BASE_URL = "https://api.vk.com/method/";
    private static final String VK_USERS_GET = "users.get";
    private static final String PARAM_USER_IDS = "user_ids";
    private static final String PARAM_VERSION = "v";
    private static final String PARAM_TOKEN = "access_token";
    private static final String PARAM_TOKEN_VALUE = "793475ea793475ea793475eae27943e32c77934793475ea19b1f8071901e6b55d034135";

    public static URL generateUrl(String userIds) {
        Uri builtUri = Uri.parse(VK_API_BASE_URL + VK_USERS_GET)
                .buildUpon()
                .appendQueryParameter(PARAM_USER_IDS, userIds)//можно передавать несколько через запятую (будет список)
                .appendQueryParameter(PARAM_VERSION, "5.130")
                .appendQueryParameter(PARAM_TOKEN, PARAM_TOKEN_VALUE)
                .build();
        try {
            return new URL(builtUri.toString());
        } catch (MalformedURLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String gerResponseFromUrl(URL url) throws IOException {
        HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
        try {
            InputStream in = urlConnection.getInputStream();
            Scanner scanner = new Scanner(in);
            scanner.useDelimiter("\\A");// "\\A" обозначает начало строки
            if (scanner.hasNext()) {
                return scanner.next();
            } else {
                return null;
            }
        } catch (UnknownHostException e) {
            return null;
        } finally {
            urlConnection.disconnect();
        }
    }
}
