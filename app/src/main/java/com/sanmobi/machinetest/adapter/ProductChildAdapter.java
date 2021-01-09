package com.sanmobi.machinetest.adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.sanmobi.machinetest.ProductDetailActivity;
import com.sanmobi.machinetest.R;
import com.sanmobi.machinetest.model.ProductChild;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Locale;

public class ProductChildAdapter extends RecyclerView.Adapter<ProductChildAdapter.SubItemViewHolder> {

      private ArrayList<ProductChild> subItemList;
      private Context context;
    NumberFormat format = NumberFormat.getCurrencyInstance(new Locale("en", "IN"));
        ProductChildAdapter(Context context,ArrayList<ProductChild> subItemList) {
        this.subItemList = subItemList;
        this.context=context;
    }

    @NonNull
    @Override
    public SubItemViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_item_product_chid, viewGroup, false);
        return new SubItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SubItemViewHolder subItemViewHolder, int i) {
        ProductChild subItem = subItemList.get(i);

        RequestOptions options = new RequestOptions()
                .centerCrop()
                .placeholder(R.mipmap.ic_launcher_round)
                .error(R.mipmap.ic_launcher_round);

        Glide.with(context).load(subItem.getProUrl()).apply(options).into(subItemViewHolder.imgProuct);

        subItemViewHolder.tvSubItemTitle.setText(subItem.getTitle());

        if (subItem.getPrice().equals("")
                ||  subItem.getPrice().equals("null")){
            subItemViewHolder.tvSubItemRate.setText(format.format(Double.parseDouble("0")));
        }else {
            subItemViewHolder.tvSubItemRate.setText(format.format(Double.parseDouble(subItem.getPrice())));
        }


    }

    @Override
    public int getItemCount() {
        if (subItemList!=null){
            return subItemList.size();
        }
        return 0;
    }

    class SubItemViewHolder extends RecyclerView.ViewHolder {
        TextView tvSubItemTitle;
        TextView tvSubItemRate;
        ImageView imgProuct;
        SubItemViewHolder(View itemView) {
            super(itemView);
            tvSubItemTitle = itemView.findViewById(R.id.tv_child_name);
            tvSubItemRate = itemView.findViewById(R.id.tv_child_rate);
            imgProuct = itemView.findViewById(R.id.img_product);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent detail_intent=new Intent(context, ProductDetailActivity.class);
                    Bundle bundle = new Bundle();
                    ProductChild productChild =subItemList.get(getAbsoluteAdapterPosition());
                    bundle.putString("prourl", productChild.getProUrl());
                    bundle.putString("proname", productChild.getTitle());
                    bundle.putString("prorate", productChild.getPrice());
                    bundle.putString("prodesc", productChild.getDescription());
                    detail_intent.putExtras(bundle);
                    context.startActivity(detail_intent);
                }
            });
        }
    }
}
