package com.extrabhp.model.Question;

import com.extrabhp.core.WhatCar;
import com.extrabhp.exception.QuestionNotFoundException;

/**
 * @author Thaer AlDwaik <t_dwaik@hotmail.com>
 */
public class LookingFor {

    public static String questionName = "looking_for";

    public static String drivingExperience = "driving-experience";
    public static String luxury = "luxury";
    public static String rare = "rare";
    public static String beautiful = "beautiful";
    public static String performance = "performance";
    public static String practical = "practical";

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
