package com.example.shoesstore.activity;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.shoesstore.R;

public class ProfileFragment extends Fragment {
    private View mview;
    private TextView tv_profile_name;
    private TextView tv_profile_email;
    private TextView tv_profile_nameuser;
    private TextView tv_profile_myemail;
    private TextView tv_profile_phone;
    private TextView tv_profile_myname;
    private TextView tv_profile_chi;
    private ImageView img_profile_setting;
    private ImageView img_profile_payment;
    private MainActivity mainActivity;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        mainActivity = (MainActivity) getActivity();
        mview =  inflater.inflate(R.layout.fragment_profile, container, false);
        AnhXa();
        NhanData();
        ClickSetting();
        return mview;
    }

    private void ClickSetting() {
        img_profile_setting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SettingFragment settingFragment = new SettingFragment();
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.container,settingFragment).commit();
            }
        });
        img_profile_payment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CartFragment cartFragment =  new CartFragment();
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.container,cartFragment).commit();
            }
        });
    }

    private void AnhXa() {
        tv_profile_myname = mview.findViewById(R.id.tv_profile_myname);
        tv_profile_email = mview.findViewById(R.id.tv_profile_myemail);
        tv_profile_name = mview.findViewById(R.id.tv_profile_name);
        tv_profile_nameuser = mview.findViewById(R.id.tv_profile_nameuser);
        tv_profile_myemail = mview.findViewById(R.id.tv_profile_ngaysinh);
        tv_profile_phone = mview.findViewById(R.id.tv_profile_phone);
        img_profile_setting = mview.findViewById(R.id.img_profile_setting);
        img_profile_payment = mview.findViewById(R.id.img_profile_thanhtoan);
        tv_profile_chi = mview.findViewById(R.id.tv_profile_chi);

    }
    private void NhanData(){
        tv_profile_myname.setText(mainActivity.getName());
        tv_profile_name.setText(mainActivity.getName());
        tv_profile_nameuser.setText(mainActivity.getUserName());
        tv_profile_email.setText(mainActivity.getEmail());
        tv_profile_myemail.setText(mainActivity.getNgaysinh());
        tv_profile_phone.setText(mainActivity.getPhone());
        tv_profile_chi.setText(mainActivity.getAddress());

    }
}