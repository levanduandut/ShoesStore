package com.example.shoesstore.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import androidx.appcompat.widget.Toolbar;

import android.widget.TextView;
import android.widget.Toast;
import android.widget.ViewFlipper;

import com.bumptech.glide.Glide;
import com.example.shoesstore.R;
import com.example.shoesstore.model.Products;
import com.example.shoesstore.model.User;
import com.google.android.material.badge.BadgeDrawable;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;
import com.google.android.material.navigation.NavigationView;
import com.paypal.android.sdk.payments.PayPalConfiguration;
import com.paypal.android.sdk.payments.PayPalPayment;
import com.paypal.android.sdk.payments.PayPalService;
import com.paypal.android.sdk.payments.PaymentActivity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class MainActivity extends AppCompatActivity  {
    ViewFlipper viewFlipper;
    DrawerLayout drawerLayout;
    ImageView imageMenu;
    BottomNavigationView bottomNavigationView;
    HomeFragment homeFragment = new HomeFragment();
    SettingFragment settingFragment = new SettingFragment();
    ProfileFragment profileFragment = new ProfileFragment();
    CartFragment cartFragment = new CartFragment();
    CategoryFragment categoryFragment = new CategoryFragment();

    private String userName;
    private String passWord;
    private String email;
    private String name;
    private String phone;
    private String ngaysinh;
    private String address;
    private String Cus_slug;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AnhXa();

//        ActionViewFlipper();
        if (isConnected(this)){
            //Toast.makeText(getApplicationContext(),"Ok",Toast.LENGTH_LONG).show();
        }
        else {
            Toast.makeText(getApplicationContext(),"Khong co internet",Toast.LENGTH_LONG).show();
        }
        getThongTinUser();
        NavControl();
    }

    private void NavControl() {
        BadgeDrawable badgeDrawable = bottomNavigationView.getOrCreateBadge(R.id.cart);
        badgeDrawable.setVisible(true);
        badgeDrawable.setNumber(8);


        getSupportFragmentManager().beginTransaction().replace(R.id.container,homeFragment).commit();
        bottomNavigationView.setItemIconTintList(null);
        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.home:
                        getSupportFragmentManager().beginTransaction().replace(R.id.container,homeFragment).commit();
                        return true ;
                    case R.id.loaisp:
                        getSupportFragmentManager().beginTransaction().replace(R.id.container,categoryFragment).commit();
                        return true;
                    case R.id.cart:
                        getSupportFragmentManager().beginTransaction().replace(R.id.container,cartFragment).commit();
                        return true;
                    case R.id.profile:
                        getSupportFragmentManager().beginTransaction().replace(R.id.container,profileFragment).commit();
                        return true;
                    case R.id.setting:
                        getSupportFragmentManager().beginTransaction().replace(R.id.container,settingFragment).commit();
                        return true;
                }
                return false;
            }
        });
    }



    private void AnhXa(){
        bottomNavigationView = findViewById(R.id.bottomnav);
//        drawerLayout = findViewById(R.id.drawerlayout);
//        imageMenu = findViewById(R.id.imageMenu);
//        viewFlipper = findViewById(R.id.viewFlipper);

    }
    private boolean isConnected(Context context){
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo wifi = connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI);
        NetworkInfo mobile = connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_MOBILE);
        if ((wifi != null && wifi.isConnected()) || (mobile!=null && mobile.isConnected())){
            return  true;
        }
        else {
            return  false;
        }
    }
    private void getThongTinUser(){
        //User user = (User) getIntent().getExtras().get("object_user");

        userName = (String) getIntent().getExtras().get("username");
        passWord = (String) getIntent().getExtras().get("password");
        email = (String) getIntent().getExtras().get("email");
        name = (String) getIntent().getExtras().get("name");
        phone = (String) getIntent().getExtras().get("phone");
        ngaysinh = (String) getIntent().getExtras().get("ngaysinh");
        address = (String) getIntent().getExtras().get("address");
        Cus_slug = (String) getIntent().getExtras().get("slug");

        Toast.makeText(getApplicationContext(),userName + " " + passWord,Toast.LENGTH_LONG).show();
    }
    public String getUserName(){
        return userName;
    }
    public String getEmail(){
        return email;
    }
    public String getName(){return  name;}
    public String getPhone(){return  phone;}
    public String getPassWord(){return  passWord;}
    public String getNgaysinh(){return ngaysinh;}
    public String getAddress(){return address;}
    public String getCus_slug(){
        return Cus_slug;
    }

//    @Override
//    public void senData(Products products) {
//        DetailFragment detailFragment = (DetailFragment) getSupportFragmentManager().findFragmentById(R.id.detai_fragment);
//        detailFragment.receiveDataFromHomefragment(products);
//    }
}