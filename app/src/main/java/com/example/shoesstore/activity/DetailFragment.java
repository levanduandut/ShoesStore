package com.example.shoesstore.activity;

import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;

import androidx.appcompat.widget.AppCompatButton;
import androidx.fragment.app.Fragment;

import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

import com.example.shoesstore.R;
import com.example.shoesstore.model.Products;

public class DetailFragment extends Fragment {
    private View view;
    private AppCompatButton btn_themvaogio;
    private TextView tv_detail_name;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        view = inflater.inflate(R.layout.fragment_detail, container, false);

        AnhXa();
        ClickSetting();
        return view;
    }

    private void ClickSetting() {
        btn_themvaogio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AddSpDialog(Gravity.CENTER);

//                CartFragment cartFragment =  new CartFragment();
//                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.container,cartFragment).commit();
            }
        });
    }
    private void AddSpDialog(int gravity){
        final Dialog dialog = new Dialog(getActivity());
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.layout_dialog_chonsize);

        Window window= dialog.getWindow();
        if(window == null){
            return;
        }

        window.setLayout(WindowManager.LayoutParams.MATCH_PARENT,WindowManager.LayoutParams.WRAP_CONTENT);
        window.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

        WindowManager.LayoutParams wLayoutParams = window.getAttributes();
        wLayoutParams.gravity = gravity;
        window.setAttributes(wLayoutParams);

        if(Gravity.BOTTOM == gravity){
            dialog.setCancelable(true);
        }
        else {
            dialog.setCancelable(false);
        }

        AppCompatButton btn_huy = dialog.findViewById(R.id.btn_dialog_no);
        AppCompatButton btn_them = dialog.findViewById(R.id.btn_dialog_them);
        btn_huy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });
        btn_them.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
                CartFragment cartFragment =  new CartFragment();
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.container,cartFragment).commit();
            }
        });
        dialog.show();
    }

    private void AnhXa() {
        btn_themvaogio = view.findViewById(R.id.btn_themvaogio);
        tv_detail_name = view.findViewById(R.id.tv_detail_name);
    }
//    public void receiveDataFromHomefragment(Products products){
////        tv_detail_name.setText(products.getName());
//    }
}