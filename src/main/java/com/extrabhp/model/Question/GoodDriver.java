package com.extrabhp.model.Question;

import com.extrabhp.core.WhatCar;
import com.extrabhp.exception.QuestionNotFoundException;

/**
 * @author Thaer AlDwaik <t_dwaik@hotmail.com>
 */
public class GoodDriver {

    public static String questionName = "good_driver";

    public static String pro = "pro";
    public static String yes = "yes";
    public static String modest = "modest";
    public static String stupid = "stupid";

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
