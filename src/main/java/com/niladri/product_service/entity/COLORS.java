package com.niladri.product_service.entity;

public enum COLORS {
    BLACK("Black"),
    WHITE("White"),
    BLUE("Blue"),
    RED("Red"),
    GREEN("Green"),
    YELLOW("Yellow"),
    GRAY("Gray");

    private String color;

    COLORS(String s) {
        color = s;
    }

    public String getColor() {
        return color;
    }
}
