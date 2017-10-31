package com.extrabhp.model.Question;

import com.extrabhp.core.WhatCar;
import com.extrabhp.exception.QuestionNotFoundException;

/**
 * @author Thaer AlDwaik <t_dwaik@hotmail.com>
 */
public class InductionType {

    public static String questionName = "induction_type";

    public static String naturallyAspirated = "na";
    public static String forcedInduction = "forced-induction";
    public static String both = "both";
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
