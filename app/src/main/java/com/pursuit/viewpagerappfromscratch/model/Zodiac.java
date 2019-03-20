package com.pursuit.viewpagerappfromscratch.model;

public class Zodiac {
    public final String name;
    public final String number;
    public final String image;

    public Zodiac(String name, String number, String image) {
        this.name = name;
        this.number = number;
        this.image = image;
    }


    public String getNumber() {
        return number;
    }

    public String getImage() {
        return image;
    }

    public String getName() {
        return name;
    }


    @Override
    public String toString() {
        return "ClassPojo [number = " + number + ", image = " + image + ", name = " + name + "]";
    }

}
