package com.pursuit.viewpagerappfromscratch.model;

public class MyPojo {

    private Zodiac[] zodiac;

    public Zodiac[] getZodiac() {
        return zodiac;
    }

    //     public void setZodiac (Zodiac[] zodiac)
    //   {
    //     this.zodiac = zodiac;
    //}

    @Override
    public String toString() {
        return "ClassPojo [zodiac = " + zodiac + "]";
    }
}
