package com.niladri.product_service.entity;

public enum COLORS {
    Black("Black"),
    White("White"),
    Blue("Blue"),
    Red("Red"),
    Green("Green"),
    Yellow("Yellow"),
    Gray("Gray"),;

    private String color;

    COLORS(String color) {
        this.color = color;
    }

    public String getColor() {
        return color;
    }
}
