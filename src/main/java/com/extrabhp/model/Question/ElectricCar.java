package com.extrabhp.model.Question;

import com.extrabhp.core.WhatCar;
import com.extrabhp.exception.QuestionNotFoundException;

/**  * @author Thaer AlDwaik <t_dwaik@hotmail.com>  */
public class ElectricCar {

    public static String questionName = "electric_car";

    public static String noWay = "no-way";
    public static String yesOption = "yes-option";
    public static String onlyFast = "only-fast";
    public static String onlyElectric = "only-electric";

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
