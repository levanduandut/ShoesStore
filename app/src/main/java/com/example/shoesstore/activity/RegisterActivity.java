package com.example.shoesstore.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import com.example.shoesstore.R;
import com.example.shoesstore.model.Register;
import com.example.shoesstore.retrofit.ApiService;

import java.util.Calendar;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegisterActivity extends AppCompatActivity {
    EditText dkemail,dkpass,dkrepass,dkusername,dkname,dkphone,dkadress;
    String dkbirthday;
    AppCompatButton btnRegister;
    private Button datepick;
    private  DatePickerDialog datePickerDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        initView();
        initDatepick();
        clickDk();
        datepick.setText(gettodayDate());
    }

    private String gettodayDate() {
        Calendar cal = Calendar.getInstance();
        int nam = cal.get(Calendar.YEAR);
        int thang = cal.get(Calendar.MONTH);
        thang = thang = 1;
        int ngay = cal.get(Calendar.DAY_OF_MONTH);
        return makeDateString(ngay,thang,nam);

    }

    private void initDatepick() {
        DatePickerDialog.OnDateSetListener onDateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int nam, int thang, int ngay) {
                thang = thang + 1;
                String date = makeDateString(ngay,thang,nam);
                datepick.setText(date);
            }
        };
        Calendar cal = Calendar.getInstance();
        int nam = cal.get(Calendar.YEAR);
        int thang = cal.get(Calendar.MONTH);
        int ngay = cal.get(Calendar.DAY_OF_MONTH);

        int Style = AlertDialog.THEME_HOLO_LIGHT;
        datePickerDialog = new DatePickerDialog(this,Style,onDateSetListener,nam,thang,ngay);
        datePickerDialog.getDatePicker().setMaxDate(System.currentTimeMillis());

    }

    private String makeDateString(int ngay, int thang, int nam) {
        return thang +"//" + ngay +"//" + nam;
    }

    private void clickDk(){
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Register register = new Register(dkusername.getText().toString(),dkemail.getText().toString(),dkpass.getText().toString(),dkname.getText().toString(),dkphone.getText().toString(),dkadress.getText().toString(),null);
                ApiService.apiService.sendRegister(register).enqueue(new Callback<Register>() {
                    @Override
                    public void onResponse(Call<Register> call, Response<Register> response) {
                        Toast.makeText(RegisterActivity.this,"Đăng kí thành công !",Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(RegisterActivity.this,LoginActivity.class);
                        startActivity(intent);
                    }

                    @Override
                    public void onFailure(Call<Register> call, Throwable t) {
                        Toast.makeText(RegisterActivity.this,"Trùng username !",Toast.LENGTH_SHORT).show();
                    }
                });

            }
        });
    }

    private void initView() {
        dkemail = findViewById(R.id.dkemail);
        dkpass = findViewById(R.id.dkpass);
        dkrepass = findViewById(R.id.dkrepass);
        dkadress = findViewById(R.id.dk_address);
        dkphone = findViewById(R.id.dk_phone);
        dkname = findViewById(R.id.dk_ten);
        dkusername = findViewById(R.id.dk_username);

        btnRegister = findViewById(R.id.btnRegister);
        datepick = findViewById(R.id.btn_dk_ngaysinh);
    }

    public void Opendatepick(View view) {
        datePickerDialog.show();
    }
}