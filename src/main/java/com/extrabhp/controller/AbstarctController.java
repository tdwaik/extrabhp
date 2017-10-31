package com.extrabhp.controller;

import com.google.gson.Gson;

import java.util.HashMap;

/**  * @author Thaer AlDwaik <t_dwaik@hotmail.com>  */
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
