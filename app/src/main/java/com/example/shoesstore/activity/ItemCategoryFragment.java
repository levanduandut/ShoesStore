package com.example.shoesstore.activity;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.shoesstore.R;
import com.example.shoesstore.adapter.CategoryAdapter;
import com.example.shoesstore.adapter.NewProductAdapter;
import com.example.shoesstore.model.Products;
import com.example.shoesstore.my_interface.IClickItemProduct;
import com.example.shoesstore.retrofit.ApiNewProduct;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ItemCategoryFragment extends Fragment {
    private View view;
    private RecyclerView recyclerView;
    private List<Products> mListNewProducts;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_item_category, container, false);
        AnhXa();
        Xuli();
        callApiGetProduct();
        return view;
    }

    private void Xuli() {
        LinearLayoutManager linearLayoutManager = new GridLayoutManager(getContext(),2);
        recyclerView.setLayoutManager(linearLayoutManager);
        DividerItemDecoration itemDecoration = new DividerItemDecoration(getContext(),DividerItemDecoration.VERTICAL);
        recyclerView.addItemDecoration(itemDecoration,0);
        mListNewProducts = new ArrayList<>();
    }
    private void callApiGetProduct(){
        ApiNewProduct.apiNewProduct.getListProduct("")
                .enqueue(new Callback<List<Products>>() {
                    @Override
                    public void onResponse(Call<List<Products>> call, Response<List<Products>> response) {
                        mListNewProducts = response.body();
                        List<Products> mProducts = new ArrayList<>();
                        for(int i =0;i<mListNewProducts.size();i++){
                            if(mListNewProducts.get(i).getCategory_id()==1
                            |mListNewProducts.get(i).getCategory_id()==2
                            |mListNewProducts.get(i).getCategory_id()==6
                            |mListNewProducts.get(i).getCategory_id()==7
                            |mListNewProducts.get(i).getCategory_id()==8
                            |mListNewProducts.get(i).getCategory_id()==9){
                                mProducts.add(mListNewProducts.get(i));
                            }
                        }

                        CategoryAdapter categoryAdapter = new CategoryAdapter(mProducts);
                        recyclerView.setAdapter(categoryAdapter);
                    }

                    @Override
                    public void onFailure(Call<List<Products>> call, Throwable t) {
                        Toast.makeText(getContext(),"On Loi",Toast.LENGTH_SHORT).show();
                    }
                });
    }

    private void AnhXa() {
        recyclerView = view.findViewById(R.id.recy_cate);
    }


}