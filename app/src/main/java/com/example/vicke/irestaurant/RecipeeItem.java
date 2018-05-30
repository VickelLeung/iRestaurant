package com.example.vicke.irestaurant;

import java.io.Serializable;

public class RecipeeItem implements Serializable {

    private String name;
    private String desc;
    private String steps;
    private int img;

    public RecipeeItem(){}

    public RecipeeItem(String name, String desc, String s ,int img) {
        this.name = name;
        this.desc = desc;
        this.img = img;
        steps = s;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getSteps() {
        return steps;
    }

    public void setSteps(String steps) {
        this.steps = steps;
    }

    @Override
    public String toString() {
        return "RecipeeItem{" +
                "name='" + name + '\'' +
                ", desc='" + desc + '\'' +
                ", img=" + img +
                '}';
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }
}
