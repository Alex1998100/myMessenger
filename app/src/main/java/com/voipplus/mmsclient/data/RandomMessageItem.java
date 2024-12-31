package com.voipplus.mmsclient.data;
import java.util.Random;

public class RandomMessageItem {
    private int icon;
    private String text;

    public RandomMessageItem(int icon, String text) {
        this.icon = icon;
        this.text = text;
    }

    public int getIcon() {
        return icon;
    }

    public String getText() {
        return text;
    }
}

