package com.extrabhp.controller;

import com.google.gson.Gson;

import java.util.HashMap;

/**
 * Created by stig on 7/14/17.
 */
abstract class AbstarctController {

    /**
     * add ")]}',\n" to prefix of json to JSON Vulnerability Protection
     * @param data
     * @return
     */
    public static String toJson(Object data) {
        Gson gson = new Gson();
        return ")]}',\n" + gson.toJson(data);
    }

}
