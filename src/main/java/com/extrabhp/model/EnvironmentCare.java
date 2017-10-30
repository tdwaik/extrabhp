package com.extrabhp.model;

import com.extrabhp.core.WhatCar;
import com.extrabhp.exception.QuestionNotFoundException;

/**
 * Created by stig on 9/9/17.
 */
public class EnvironmentCare {

    public static String questionName = "environment_care";

    public static String aLot = "a-lot";
    public static String aLittle = "a-little";
    public static String no = "no";

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
