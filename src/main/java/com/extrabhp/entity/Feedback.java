package com.extrabhp.entity;

/**
 * @author Thaer Aldwaik <t_dwaik@hotmail.com>
 */
public class Feedback {

    public static String tableName = "`extrabhp`.`feedback`";

    private int id;

    private boolean isRead;

    private String email;

    private String content;

    private String dateInserted;

    public int getId() {
        return id;
    }

    public Feedback setId(int id) {
        this.id = id;
        return this;
    }

    public boolean isRead() {
        return isRead;
    }

    public Feedback setRead(boolean read) {
        isRead = read;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public Feedback setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getContent() {
        return content;
    }

    public Feedback setContent(String content) {
        this.content = content;
        return this;
    }

    public String getDateInserted() {
        return dateInserted;
    }

    public Feedback setDateInserted(String dateInserted) {
        this.dateInserted = dateInserted;
        return this;
    }
}
