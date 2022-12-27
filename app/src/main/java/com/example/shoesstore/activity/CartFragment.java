package com.example.shoesstore.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatButton;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.shoesstore.R;
import com.example.shoesstore.adapter.CartAdapter;
import com.example.shoesstore.model.Cart;
import com.example.shoesstore.model.User;
import com.example.shoesstore.retrofit.ApiService;
import com.paypal.android.sdk.payments.PayPalConfiguration;
import com.paypal.android.sdk.payments.PayPalPayment;
import com.paypal.android.sdk.payments.PayPalService;
import com.paypal.android.sdk.payments.PaymentActivity;

import org.json.JSONException;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CartFragment extends Fragment {
    View view;
    private RecyclerView recy_cart;
    private List<Cart> mlistCart;
    private TextView tv_tonggia,lt5,tv_dolo;
    private TextView tv_tongthanhtoan;
    private AppCompatButton btn_thanhtoan;
    private int gia;
    private double tongthanhtoan;
    private MainActivity mainActivity;
    private String Cus_Slug;
    public static final String clientid = "AVeUaeRRNQGwE_eUW-zADC5YpujFK42GtXXUdPxGt38SGB_np_d8qLjLtK721v9A8smZvdpj1p9BL1R6";
    public static final int PAYPAL_REQUEST_CODE = 123;
    public static PayPalConfiguration configration = new PayPalConfiguration().environment(PayPalConfiguration.ENVIRONMENT_SANDBOX).clientId(clientid);

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        mainActivity = (MainActivity) getActivity();
        view = inflater.inflate(R.layout.fragment_cart, container, false);
        AnhXa();
        NhanData();

        recy_cart = view.findViewById(R.id.recy_cart);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        recy_cart.setLayoutManager(linearLayoutManager);
        DividerItemDecoration itemDecoration = new DividerItemDecoration(getContext(),DividerItemDecoration.VERTICAL);
        recy_cart.addItemDecoration(itemDecoration);
        mlistCart = new ArrayList<>();
        getListCart();
//        Log.e("Error xxx ", mlistCart.get(0).getProduct_id__name() + "");
        btn_thanhtoan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getpayment();
            }
        });
        return view;
    }
    private double Tong;
    private double TongCa;
//    private List<Cart> list ;
    private void getListCart() {
        ApiService.apiService.getListCart(Cus_Slug)
                .enqueue(new Callback<List<Cart>>() {
                    @Override
                    public void onResponse(Call<List<Cart>> call, Response<List<Cart>> response) {
                        mlistCart = response.body();
                        Log.e("Error xxx ", mlistCart.size() + "");
//                        list = mlistCart;

                        CartAdapter cartAdapter = new CartAdapter(mlistCart);
                        recy_cart.setAdapter(cartAdapter);
                        Tong = 0;
                        TongCa = 0;
                        for(int i = 0;i<mlistCart.size();i++){
                            Tong += mlistCart.get(i).getProduct_id__prices__price()*mlistCart.get(i).getQuantity();
                            TongCa += mlistCart.get(i).getProduct_id__prices__price_total()*mlistCart.get(i).getQuantity();

                        }
                        Log.e("Error xxx ", Tong + "");
                        lt5.setText(String.valueOf(String.format("%.0f", Tong - TongCa)));
                        tv_tonggia.setText(String.valueOf(String.format("%.0f", Tong)));
                        tv_tongthanhtoan.setText(String.valueOf(String.format("%.0f",TongCa + 15000)));
                        tv_dolo.setText(String.valueOf(String.format("%.0f",(TongCa + 15000)/23600) + " $"));
                    }

                    @Override
                    public void onFailure(Call<List<Cart>> call, Throwable t) {
                    }
                });
    }

    private void NhanData() {

        Cus_Slug = mainActivity.getCus_slug();
    }

    private void getpayment() {

        String tien = String.valueOf((TongCa+15000)/23600);
        PayPalPayment payPalPayment = new PayPalPayment(new BigDecimal(String.valueOf(tien)), "USD", "learn", PayPalPayment.PAYMENT_INTENT_SALE);
        Intent intent = new Intent(getActivity(), PaymentActivity.class);

        intent.putExtra(PayPalService.EXTRA_PAYPAL_CONFIGURATION, configration);
        intent.putExtra(PaymentActivity.EXTRA_PAYMENT, payPalPayment);
        startActivityForResult(intent, PAYPAL_REQUEST_CODE);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == PAYPAL_REQUEST_CODE) {
            try {
                PayPalConfiguration config = data.getParcelableExtra(PaymentActivity.EXTRA_RESULT_CONFIRMATION);
                if (config != null) {

                }
            } catch (Exception e) {
                Log.e("Error ", e.toString() + "");
            }
        } else if (requestCode == Activity.RESULT_CANCELED) {
            Log.i("Error ", " hihi");
        } else if (requestCode == PaymentActivity.RESULT_EXTRAS_INVALID) {
            Log.i("Payment ", " Invalid");
        }

    }

    private void AnhXa() {
        tv_tonggia = view.findViewById(R.id.tv_cart_tonggia);
        tv_tongthanhtoan = view.findViewById(R.id.tv_cart_tongthanhtoan);
        btn_thanhtoan = view.findViewById(R.id.btn_thanhtoan);
        lt5=view.findViewById(R.id.lt5);
        tv_dolo = view.findViewById(R.id.tv_cart_dola);

    }
}