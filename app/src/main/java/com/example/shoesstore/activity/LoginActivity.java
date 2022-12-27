package com.example.shoesstore.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.shoesstore.R;
import com.example.shoesstore.model.User;
import com.example.shoesstore.retrofit.ApiService;
import com.google.android.material.textfield.TextInputEditText;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class LoginActivity extends AppCompatActivity {
    TextView txtregister;

    TextInputEditText edt_email;
    TextInputEditText edt_password;
    AppCompatButton btn_login;
    List<User> mListUser;
    private  User mUser;
    private String strEmail ;
    private String strPass ;
    private String strName ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login2);
        initView();

        mListUser = new ArrayList<>();

        txtregister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LoginActivity.this, RegisterActivity.class));
            }
        });

        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clickLogin();
            }
        });
    }
    private  void clickLogin(){
        strEmail = edt_email.getText().toString().trim();
        strPass = edt_password.getText().toString().trim();
        strName = edt_email.getText().toString().trim();
        getListUser();
        Log.d("duckduck", "have login");
        if(mListUser == null || mListUser.isEmpty()){
            Log.d("duckduck", "have null login");
            return;
        }
        boolean isHasUser = false;
        for (User user : mListUser){
            if(user.getUsername().equals(strEmail)){
                isHasUser = true;
                mUser = user;
                break;
            }
        }
        mListUser = null;
        if(isHasUser){
            Intent intent = new Intent(LoginActivity.this, MainActivity.class);
            Bundle bundle = new Bundle();
            bundle.putSerializable("name",mUser.getName());
            bundle.putSerializable("email",mUser.getEmail());
            bundle.putSerializable("username",mUser.getUsername());
            bundle.putSerializable("ngaysinh",mUser.getCustomer_id().getBirthday());
            bundle.putSerializable("phone",mUser.getPhone());
            bundle.putSerializable("password",mUser.getPassword());
            bundle.putSerializable("address",mUser.getCustomer_id().getAddress());
            bundle.putSerializable("slug",mUser.getCustomer_id().getSlug());
            intent.putExtras(bundle);
            startActivity(intent);
            Log.d("duckduck", "yes login");

        }
        else {
            Log.d("duckduck", "no login");
            Toast.makeText(LoginActivity.this, "Sai Gmail hoặc Mật khẩu !" ,Toast.LENGTH_SHORT).show();
        }

    }

    private void getListUser() {
        ApiService.apiService.getListUsers(strEmail,strPass)
//        ApiService.apiService.getListUsers("")
                .enqueue(new Callback<List<User>>() {
                    @Override
                    public void onResponse(Call<List<User>> call, Response<List<User>> response) {
                        mListUser = response.body();
                        if(mListUser != null){
                            Log.d("List user ",mListUser.size()+"");
                            for (User user : mListUser){
                                Log.d("List user ",user.getCustomer_id().getBirthday() +"");

                            }
                        }
                        else {
                            Toast.makeText(LoginActivity.this, "Sai pass, Hãy nhập lại",Toast.LENGTH_SHORT).show();
                        }
                    }
                    @Override
                    public void onFailure(Call<List<User>> call, Throwable t) {
                        Toast.makeText(LoginActivity.this, "Sai pass",Toast.LENGTH_SHORT).show();
                    }
                });
    }

    private void initView() {
        edt_email = findViewById(R.id.edt_email);
        edt_password = findViewById(R.id.edt_password);
        txtregister = findViewById(R.id.txtregister);
        btn_login = findViewById(R.id.btnLogin);
    }
}