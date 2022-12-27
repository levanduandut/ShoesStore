package com.example.shoesstore.activity;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.example.shoesstore.R;


public class CategoryFragment extends Fragment {
    private View view;
    private ImageView img_back;
    private RelativeLayout rl_adidas,rl_nike,rl_puma,rl_others;
    private int clickstatus;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        view =  inflater.inflate(R.layout.fragment_category, container, false);

        AnhXa();
        clickBack();
        return view;
    }

    private void clickBack() {
        img_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                HomeFragment homeFragment =  new HomeFragment();
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.container,homeFragment).commit();
            }
        });
        rl_adidas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clickstatus = 1;
                ItemCategoryFragment fragment = new ItemCategoryFragment();
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.container,fragment).commit();
            }
        });
        rl_nike.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clickstatus = 2;
                ItemCategoryFragment fragment = new ItemCategoryFragment();
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.container,fragment).commit();
            }
        });
        rl_puma.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clickstatus = 3;
                ItemCategoryFragment fragment = new ItemCategoryFragment();
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.container,fragment).commit();

            }
        });
        rl_others.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clickstatus = 4;
                ItemCategoryFragment fragment = new ItemCategoryFragment();
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.container,fragment).commit();

            }
        });
    }

    private void AnhXa() {
        img_back = view.findViewById(R.id.btn_category_back);
        rl_adidas = view.findViewById(R.id.category_adidas);
        rl_nike = view.findViewById(R.id.category_nike);
        rl_puma = view.findViewById(R.id.category_puma);
        rl_others = view.findViewById(R.id.category_orther);

    }

}