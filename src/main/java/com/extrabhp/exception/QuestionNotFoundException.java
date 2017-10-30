package com.extrabhp.exception;

/**
 * Created by stig on 9/9/17.
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
