package com.pursuit.viewpagerappfromscratch;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.os.Bundle;

import com.pursuit.viewpagerappfromscratch.model.MyPojo;
import com.pursuit.viewpagerappfromscratch.model.Zodiac;
import com.pursuit.viewpagerappfromscratch.network.RetrofitSingleton;
import com.pursuit.viewpagerappfromscratch.network.ZodiacService;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainActivity extends FragmentActivity {
    List<Fragment> fragmentList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final ViewPager viewPager = findViewById(R.id.view_pager_activity_main);

        Retrofit retrofit = RetrofitSingleton.getInstance();
        ZodiacService zodiacService = retrofit.create(ZodiacService.class);
        zodiacService.getZodiac().enqueue(new Callback<MyPojo>() {
            @Override
            public void onResponse(Call<MyPojo> call, Response<MyPojo> response) {
                List<Zodiac> zodiacList = Arrays.asList(response.body().getZodiac());
                for (int i = 0; i < zodiacList.size(); i++) {
                    Zodiac zodiac = zodiacList.get(i);
                    fragmentList.add(DisplayFragment.newInstance(zodiac.name, zodiac.number, zodiac.image));
                    viewPager.setAdapter(new ViewPagerAdapter(getSupportFragmentManager(), fragmentList));
                }
            }

            @Override
            public void onFailure(Call<MyPojo> call, Throwable t) {

            }
        });
    }
}
