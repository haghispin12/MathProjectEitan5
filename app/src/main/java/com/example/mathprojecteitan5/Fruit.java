package com.example.mathprojecteitan5;

public class Fruit {
    private String name;
    private int drawable;


    public Fruit(String name, int drawable) {
        this.name = name;
        this.drawable=drawable;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDrawable() {
        return drawable;
    }

    public void setDrawable(int drawable) {
        this.drawable = drawable;
    }
}
