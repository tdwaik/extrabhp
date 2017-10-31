package com.extrabhp.entity;

/**
 * @author Thaer Aldwaik <t_dwaik@hotmail.com>
 */
public class WhatCarLog {

    public static String tableName = "`extrabhp`.`what_car_log`";

    private int id;

    private String answers;

    private String result;

    private int status;

    private int isHelpful;

    private String feedback;

    private String createdAt;

    private String updatedAt;

    public int getId() {
        return id;
    }

    public WhatCarLog setId(int id) {
        this.id = id;
        return this;
    }

    public String getAnswers() {
        return answers;
    }

    public WhatCarLog setAnswers(String answers) {
        this.answers = answers;
        return this;
    }

    public String getResult() {
        return result;
    }

    public WhatCarLog setResult(String result) {
        this.result = result;
        return this;
    }

    public int getStatus() {
        return status;
    }

    public WhatCarLog setStatus(int status) {
        this.status = status;
        return this;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public WhatCarLog setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
        return this;
    }

    public int getIsHelpful() {
        return isHelpful;
    }

    public WhatCarLog setIsHelpful(int isHelpful) {
        this.isHelpful = isHelpful;
        return this;
    }

    public String getFeedback() {
        return feedback;
    }

    public WhatCarLog setFeedback(String feedback) {
        this.feedback = feedback;
        return this;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public WhatCarLog setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
        return this;
    }
}
