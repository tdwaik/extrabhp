package com.extrabhp.model;

import com.extrabhp.core.WhatCar;
import com.extrabhp.exception.QuestionNotFoundException;

/**
 * Created by stig on 9/9/17.
 */
public class TransmissionType {

    public static String questionName = "transmission_type";

    public static String manual = "track";
    public static String auto = "road";
    public static String semiAuto = "semi-auto";
    public static String cvt = "cvt";
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
