package com.extrabhp.exception;

/**
 * @author Thaer AlDwaik <t_dwaik@hotmail.com>
 */
public class QuestionNotFoundException extends Exception {

    private String questionName;

    public QuestionNotFoundException(String questionName) {
        this.questionName = questionName;
    }

    public String getQuestionName() {
        return questionName;
    }

}
