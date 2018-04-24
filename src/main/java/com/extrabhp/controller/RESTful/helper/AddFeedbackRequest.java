package com.extrabhp.controller.RESTful.helper;

/**
 * @author Thaer Aldwaik <t_dwaik@hotmail.com>
 */
public class AddFeedbackRequest {

    private String email = null;

    private String content;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
