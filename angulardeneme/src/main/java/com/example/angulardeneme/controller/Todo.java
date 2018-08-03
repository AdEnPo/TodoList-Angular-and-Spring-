package com.example.angulardeneme.controller;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Todo {
    private int id;
    @JsonProperty("text")
    private String text;
    private boolean checked;
    public Todo(){}
    public Todo(String text,boolean checked){
        this.text=text;
        this.checked=checked;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getText() {
        return text;
    }
    public void setText(String text) {
        this.text = text;
    }

    public boolean getChecked() { return checked; }
    public void setChecked(boolean checked) { this.checked = checked; }
}