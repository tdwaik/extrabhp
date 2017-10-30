package com.extrabhp.model;

import com.extrabhp.core.WhatCar;
import com.extrabhp.exception.QuestionNotFoundException;

/**
 * Created by stig on 9/9/17.
 */
public class WhatInMind {

    public static String questionName =  "what_in_mind";

    public static String hypercar = "hypercar";
    public static String supercar = "supercar";
    public static String musclecar = "musclecar";
    public static String german = "german";
    public static String jdm = "jdm";
    public static String all = "all";
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
