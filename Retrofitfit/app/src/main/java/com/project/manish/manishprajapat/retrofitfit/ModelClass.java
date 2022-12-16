
package com.project.covid.manishprajapat.retrofitfit;

import com.google.gson.annotations.SerializedName;

public class ModelClass {

    private int userId;
    private int id;
    @SerializedName("body")
    private String text;
    private String body;

    public int getUserId() {
        return userId;
    }

    public ModelClass(int userId, int id, String text, String body) {
        this.userId = userId;
        this.id = id;
        this.text = text;
        this.body = body;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return text;
    }

    public void setTitle(String title) {
        this.text = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

}