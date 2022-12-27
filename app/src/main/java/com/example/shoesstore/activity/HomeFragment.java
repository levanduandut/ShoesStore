package com.example.shoesstore.activity;

import android.app.SearchManager;
import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.core.view.MenuItemCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.Toast;
import android.widget.ViewFlipper;

import com.bumptech.glide.Glide;
import com.example.shoesstore.R;
import com.example.shoesstore.adapter.NewProductAdapter;
import com.example.shoesstore.model.Products;
import com.example.shoesstore.my_interface.IClickItemProduct;
import com.example.shoesstore.retrofit.ApiNewProduct;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeFragment extends Fragment {
    private ViewFlipper viewFlipper;
    private RecyclerView recyclerViewPro;

    private List<Products> mListNewProducts;
    private Products mNewProducts;
    private MenuItem menuItem;
    private SearchView searchView;
    private androidx.appcompat.widget.Toolbar toolbar;
    private NewProductAdapter newProductAdapter;


//    private ISendData mISendData;

//    public interface ISendData{
//        void senData(Products products);
//    }

//    @Override
//    public void onAttach(@NonNull Context context) {
//        super.onAttach(context);
//        mISendData = (ISendData) getActivity();
//    }

    View v;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.fragment_home, container, false);
        viewFlipper =  (ViewFlipper) v.findViewById(R.id.viewFlipper);
        List<String> mangquangcao = new ArrayList<>();
        mangquangcao.add("https://graphicsfamily.com/wp-content/uploads/edd/2021/07/Professional-E-Commerce-Shoes-Banner-Design-1180x664.jpg");
        mangquangcao.add("https://i.ytimg.com/vi/fBonRLiYdYA/maxresdefault.jpg");
        mangquangcao.add("https://static.vecteezy.com/system/resources/thumbnails/008/564/775/small/sport-shoes-banner-for-website-with-button-ui-design-illustration-vector.jpg");
        for (int i = 0; i < mangquangcao.size(); i++) {
            ImageView imageView = new ImageView(getContext());
            Glide.with(getContext()).load(mangquangcao.get(i)).into(imageView);
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            viewFlipper.addView(imageView);
        }

        toolbar = v.findViewById(R.id.toolbar);
        AppCompatActivity appCompatActivity =  (AppCompatActivity) getActivity();
        appCompatActivity.setSupportActionBar(toolbar);
        appCompatActivity.getSupportActionBar().setTitle("");



        viewFlipper.setFlipInterval(3000);
        viewFlipper.setAutoStart(true);
        Animation slide_in = AnimationUtils.loadAnimation(getContext(), R.anim.slide_m_right);
        Animation slide_out = AnimationUtils.loadAnimation(getContext(), R.anim.slide_out_right);
        viewFlipper.setInAnimation(slide_in);
        viewFlipper.setOutAnimation(slide_out);

        recyclerViewPro = v.findViewById(R.id.recy_pro);
        LinearLayoutManager linearLayoutManager = new GridLayoutManager(getContext(),2);
        recyclerViewPro.setLayoutManager(linearLayoutManager);
        DividerItemDecoration itemDecoration = new DividerItemDecoration(getContext(),DividerItemDecoration.VERTICAL);
        recyclerViewPro.addItemDecoration(itemDecoration,0);
        mListNewProducts = new ArrayList<>();

        callApiGetProduct();

        return v;
    }
    private void callApiGetProduct(){
        ApiNewProduct.apiNewProduct.getListProduct("")
                .enqueue(new Callback<List<Products>>() {
                    @Override
                    public void onResponse(Call<List<Products>> call, Response<List<Products>> response) {
                        mListNewProducts = response.body();

                        newProductAdapter= new NewProductAdapter(mListNewProducts, new IClickItemProduct() {
                            @Override
                            public void onClickItemProducts(Products products) {
                                onClickdetail(products);
                            }
                        });
                        recyclerViewPro.setAdapter(newProductAdapter);
                    }

                    @Override
                    public void onFailure(Call<List<Products>> call, Throwable t) {
                        Toast.makeText(getContext(),"On Loi",Toast.LENGTH_SHORT).show();
                    }
                });
    }
    private void onClickdetail(Products products){
//        sendDataToDetailFragemt(products);
        DetailFragment detailFragment =  new DetailFragment();
        getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.container,detailFragment).commit();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        setHasOptionsMenu(true);
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        inflater.inflate(R.menu.main_menu ,menu);
        menuItem = menu.findItem(R.id.search);
        searchView = (SearchView) MenuItemCompat.getActionView(menuItem);
        searchView.setIconified(true);

        SearchManager searchManager = (SearchManager) getActivity().getSystemService(Context.SEARCH_SERVICE);
        searchView.setSearchableInfo(searchManager.getSearchableInfo(getActivity().getComponentName()));
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
//                try {
                    newProductAdapter.getFilter().filter(query);
//                }
//                catch (Exception e){
//                };
                return false;
            }
            @Override
            public boolean onQueryTextChange(String newText) {
                newProductAdapter.getFilter().filter(newText);
                return false;
            }
        });

        super.onCreateOptionsMenu(menu, inflater);
    }


    //    private void sendDataToDetailFragemt(Products products) {
//        mISendData.senData(products);
//    }


}