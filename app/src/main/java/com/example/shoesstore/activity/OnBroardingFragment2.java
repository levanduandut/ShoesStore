package com.example.shoesstore.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.appcompat.widget.AppCompatButton;
import androidx.fragment.app.Fragment;

import com.example.shoesstore.R;

public class OnBroardingFragment2 extends Fragment {
    private AppCompatButton buttonStart;
    private View mview;

    public OnBroardingFragment2() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        mview = inflater.inflate(R.layout.fragment_on_broarding2, container, false);
        buttonStart = (AppCompatButton) mview.findViewById(R.id.btnGetStart);
        buttonStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(),LoginActivity.class);
                getActivity().startActivity(intent);
            }
        });
        return mview;
    }
}