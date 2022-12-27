package com.example.shoesstore.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.shoesstore.R;
import com.example.shoesstore.model.Products;
import com.example.shoesstore.my_interface.IClickItemProduct;

import java.util.ArrayList;
import java.util.List;

public class NewProductAdapter extends RecyclerView.Adapter<NewProductAdapter.NewProductHolder> implements Filterable {
    private List<Products> mListNewProducts;
    private List<Products> mListNewProductsOld;
    public IClickItemProduct iClickItemProduct;
    public NewProductAdapter(List<Products> mListNewProducts,IClickItemProduct ltn) {
        this.mListNewProducts = mListNewProducts;
        this.iClickItemProduct = ltn;
        this.mListNewProductsOld = mListNewProducts;

    }


    @NonNull
    @Override
    public NewProductHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_product,parent,false);
        return new NewProductHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NewProductHolder holder, int position) {
        final Products products = mListNewProducts.get(position);
        if(products==null){
            return;
        }
//        holder.tv_price.setText(String.valueOf(products.getPrices()));
        if(products.getName() != null){
            holder.tv_name.setText(String.valueOf(products.getName()));
        }


        //Glide.with(holder.imgImageView.getContext()).load(products.getPhoto_products().get(position).getName()).into(holder.imgImageView);
        if(String.valueOf(products.getSex()) !="") {
            switch (products.getSex()){
                case 1:
                    holder.tv_sex.setText("Nam");
                    break;
                case 2:
                    holder.tv_sex.setText("Nữ");
                    break;
                default:
                    holder.tv_sex.setText("Unisex");
            }
        }

        if(products.getPrices() != null && products.getPrices().size() != 0) {
            holder.tv_price.setText(String.valueOf(products.getPrices().get(0).getPrice()));
            float price = (100-products.getPrices().get(0).getSale())*(products.getPrices().get(0).getPrice())/100;

            holder.tv_last_price.setText("Giảm còn :"+String.valueOf(String.format("%.0f", price)));
        }
        if(products.getPrices() != null && products.getPrices().size() != 0) {
            holder.tv_sale.setText("SALE " +String.valueOf(products.getPrices().get(0).getSale()) + "%");
        }

        if (products.getPhoto_products() != null && products.getPhoto_products().size() != 0){
            Glide.with(holder.imgImageView.getContext()).load(products.getPhoto_products().get(0).getName()).into(holder.imgImageView);
        }
        holder.relItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                iClickItemProduct.onClickItemProducts(products);
            }
        });

    }

    @Override
    public int getItemCount() {
        if(mListNewProducts!=null){
            return mListNewProducts.size();
        }
        return 0;
    }



    public class NewProductHolder extends RecyclerView.ViewHolder{
        private RelativeLayout relItem;
        private final ImageView imgImageView;
        private final TextView tv_name,tv_price,tv_sex,tv_sale,tv_last_price;

        public NewProductHolder(@NonNull View itemView) {
            super(itemView);
            relItem = itemView.findViewById(R.id.layout_item);
            imgImageView = (ImageView) itemView.findViewById(R.id.pic_product);
            tv_name = itemView.findViewById(R.id.tv_nameproduct);
            tv_price = itemView.findViewById(R.id.tv_price);
            tv_sex = itemView.findViewById(R.id.tv_sex);
            tv_sale = itemView.findViewById(R.id.tv_sale);
            tv_last_price = itemView.findViewById(R.id.tv_last_price);
        }
    }
    @Override
    public Filter getFilter() {
        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence charSequence) {
                String search = charSequence.toString();
                if(search.isEmpty()){
                    mListNewProducts = mListNewProductsOld;
                }
                else {
                    List<Products> list = new ArrayList<>();
                    for(Products products : mListNewProductsOld){
                        if(products.getName().toLowerCase().contains(search.toLowerCase())){
                            list.add(products);
                        }
                    }
                    mListNewProducts = list;
                }
                FilterResults filtResults = new FilterResults();
                filtResults.values = mListNewProducts;
                return filtResults;
            }

            @Override
            protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
                mListNewProducts = (List<Products>) filterResults.values;
                notifyDataSetChanged();
            }
        };
    }
}
