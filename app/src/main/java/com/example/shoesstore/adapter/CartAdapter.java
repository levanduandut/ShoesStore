package com.example.shoesstore.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.shoesstore.R;
import com.example.shoesstore.model.Cart;

import java.util.List;

public class CartAdapter extends RecyclerView.Adapter<CartAdapter.CartViewHolder>{
    List<Cart> mCartList;
    public CartAdapter(List<Cart> mCartList){
        this.mCartList = mCartList;
    }
    @NonNull
    @Override
    public CartViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cart_item_layout,parent,false);
        return new CartViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CartViewHolder holder, int position) {
        Cart cart = mCartList.get(position);
        if(cart==null){
            return;
        }
        holder.tv_nameorder.setText(String.valueOf(cart.getProduct_id__name()));
        holder.tv_order_sale.setText(String.valueOf(cart.getProduct_id__prices__sale()) + " %");
        holder.tv_order_price.setText(String.valueOf(cart.getProduct_id__prices__price()));
//        float x = cart.getProduct_id__prices__price()*cart.getProduct_id__prices__price();
        holder.tv_order_totalprice.setText(String.valueOf(cart.getProduct_id__prices__price_total()));
        holder.tv_ordersize.setText(String.valueOf(cart.getSize()));
        holder.tv_order_count.setText(String.valueOf(cart.getQuantity()));
        Glide.with(holder.img_orders.getContext()).load(cart.getProduct_id__photo_products__name()).into(holder.img_orders);
    }

    @Override
    public int getItemCount() {
        if(mCartList!=null){
            return mCartList.size();
        }
        return 0;
    }

    public class CartViewHolder extends RecyclerView.ViewHolder{
        private ImageView img_orders;
        private TextView tv_nameorder,tv_ordersize,tv_order_count,tv_order_totalprice,tv_order_price,tv_order_sale;

        public CartViewHolder(@NonNull View itemView) {
            super(itemView);
            img_orders = itemView.findViewById(R.id.img_orders);
            tv_nameorder = itemView.findViewById(R.id.tv_nameorder);
            tv_ordersize = itemView.findViewById(R.id.tv_ordersize);
            tv_order_count = itemView.findViewById(R.id.tv_order_count);
            tv_order_totalprice = itemView.findViewById(R.id.tv_order_totalprice);
            tv_order_price = itemView.findViewById(R.id.tv_order_price);
            tv_order_sale = itemView.findViewById(R.id.tv_order_sale);

        }
    }
}
