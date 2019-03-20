package com.pursuit.viewpagerappfromscratch.network;

import com.pursuit.viewpagerappfromscratch.model.MyPojo;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ZodiacService {
    @GET("JDVila/storybook/master/zodiac.json")
    Call<MyPojo> getZodiac();
}
