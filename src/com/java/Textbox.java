package com.java;

public class Textbox extends UIControl{
    private String text = "";

    public Textbox() {
        super(true);
        System.out.println("Textbox");
    }

    public void setText(String text) {
        this.text = text;
    }

    public void clear() {
        text = "";
    }
}
