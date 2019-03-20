package com.pursuit.viewpagerappfromscratch;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class DisplayFragment extends Fragment {
    private static final String ARG_ZODIAC_NAME = "param1";
    private static final String ARG_ZODIAC_NUMBER = "param2";
    private static final String ARG_ZODIAC_IMAGE = "param3";
    private String mParam1;
    private String mParam2;
    private String mParam3;
    private TextView nameTextview;
    private TextView numberTextview;
    private ImageView imageImageView;

    public DisplayFragment() {
    }

    public static DisplayFragment newInstance(String param1, String param2, String param3) {
        DisplayFragment fragment = new DisplayFragment();
        Bundle args = new Bundle();
        args.putString(ARG_ZODIAC_NAME, param1);
        args.putString(ARG_ZODIAC_NUMBER, param2);
        args.putString(ARG_ZODIAC_IMAGE, param3);
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_ZODIAC_NAME);
            mParam2 = getArguments().getString(ARG_ZODIAC_NUMBER);
            mParam3 = getArguments().getString(ARG_ZODIAC_IMAGE);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_dipslay, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        nameTextview = view.findViewById(R.id.name_textview);
        numberTextview = view.findViewById(R.id.number_textview);
        imageImageView = view.findViewById(R.id.image_imageview);
        nameTextview.setText(mParam1);
        numberTextview.setText(mParam2);
        Picasso.get().load(mParam3).into(imageImageView);
    }
}
