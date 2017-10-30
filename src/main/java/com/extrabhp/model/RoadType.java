package com.extrabhp.model;

import com.extrabhp.core.WhatCar;
import com.extrabhp.exception.QuestionNotFoundException;

/**
 * Created by stig on 9/9/17.
 */
public class RoadType {

    public static String questionName = "road_type";

    public static String track = "track";
    public static String road = "road";
    public static String what = "what";

    public static boolean is(String answer) throws QuestionNotFoundException {
        return answer().equals(answer);
    }

    public static String answer() throws QuestionNotFoundException {
        if(!WhatCar.answers.containsKey(questionName)) {
            throw new QuestionNotFoundException(questionName);
        }

        return WhatCar.answers.get(questionName).get(0);
    }
}
