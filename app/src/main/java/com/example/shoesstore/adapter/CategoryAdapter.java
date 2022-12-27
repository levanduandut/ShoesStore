package com.example.shoesstore.adapter;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.shoesstore.R;
import com.example.shoesstore.model.Products;

import java.util.List;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.CategoryHolder>{
    private final   List<Products> mListNewProducts;


    public CategoryAdapter(List<Products> mListNewProducts) {
        this.mListNewProducts = mListNewProducts;
    }

    @NonNull
    @Override
    public CategoryHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_product,parent,false);
        return new CategoryHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryHolder holder, int position) {
        Products products = mListNewProducts.get(position);

        if(products==null){
            return;
        }

            holder.tv_name.setText(String.valueOf(products.getName()));

            //Glide.with(holder.imgImageView.getContext()).load(products.getPhoto_products().get(position).getName()).into(holder.imgImageView);
            switch (products.getSex()) {
                case 1:
                    holder.tv_sex.setText("Nam");
                    break;
                case 2:
                    holder.tv_sex.setText("Nữ");
                    break;
                default:
                    holder.tv_sex.setText("Unisex");
            }
            if (products.getPrices() != null && products.getPrices().size() != 0) {
                holder.tv_price.setText(String.valueOf(products.getPrices().get(0).getPrice()));
                float price = (100 - products.getPrices().get(0).getSale()) * (products.getPrices().get(0).getPrice()) / 100;

                holder.tv_last_price.setText("Giảm còn :" + String.valueOf(String.format("%.0f", price)));
            }
            if (products.getPrices() != null && products.getPrices().size() != 0) {
                holder.tv_sale.setText("SALE " + String.valueOf(products.getPrices().get(0).getSale()) + "%");
            }
            if (products.getPrices() != null && products.getPhoto_products().size() != 0){
                Glide.with(holder.imgImageView.getContext()).load(products.getPhoto_products().get(0).getName()).into(holder.imgImageView);
            }


    }

    @Override
    public int getItemCount() {
        if(mListNewProducts!=null){
            return mListNewProducts.size();
        }
        return 0;
    }

    public static class CategoryHolder extends RecyclerView.ViewHolder{
        private final ImageView imgImageView;
        private final TextView tv_name,tv_price,tv_sex,tv_sale,tv_last_price;
        public CategoryHolder(@NonNull View itemView) {
            super(itemView);
            imgImageView = (ImageView) itemView.findViewById(R.id.pic_product);
            tv_name = itemView.findViewById(R.id.tv_nameproduct);
            tv_price = itemView.findViewById(R.id.tv_price);
            tv_sex = itemView.findViewById(R.id.tv_sex);
            tv_sale = itemView.findViewById(R.id.tv_sale);
            tv_last_price = itemView.findViewById(R.id.tv_last_price);
        }
    }
}
