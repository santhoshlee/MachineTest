package com.sanmobi.machinetest.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.sanmobi.machinetest.R;
import com.sanmobi.machinetest.model.ProductModel;
import java.util.ArrayList;


public class ProductListAdapter extends RecyclerView.Adapter<ProductListAdapter.MyViewHolder> {

    private RecyclerView.RecycledViewPool viewPool = new RecyclerView.RecycledViewPool();
    public ArrayList<ProductModel> PrductList;
    public Context context;


    public ProductListAdapter(Context context,ArrayList<ProductModel> prductList) {
        this.context = context;
        PrductList = prductList;
    }

    public void SetProductList(ArrayList<ProductModel> prductList){
        this.PrductList=prductList;
        notifyDataSetChanged();
    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.list_item_product_parent,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        ProductModel product=this.PrductList.get(position);
        holder.tvCategory.setText(product.getTitle());

        GridLayoutManager gridLayoutManager = new GridLayoutManager(holder.rv_child.getContext(),
                1, GridLayoutManager.HORIZONTAL, false);

        // Create sub item view adapter
        ProductChildAdapter subItemAdapter = new ProductChildAdapter(context,product.getProductChild());

        holder.rv_child.setLayoutManager(gridLayoutManager);
        holder.rv_child.setAdapter(subItemAdapter);
        holder.rv_child.setRecycledViewPool(viewPool);


        holder.img_expend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!product.isIsexpend()){
                    product.setIsexpend(true);
                    notifyDataSetChanged();
                }else{
                    product.setIsexpend(false);
                    notifyDataSetChanged();
                }

            }
        });

        holder.rv_child.setVisibility(product.isIsexpend()?View.VISIBLE:View.GONE);
        holder.img_expend.setImageResource(product.isIsexpend()?R.drawable.ic_expend_down:R.drawable.ic_expend_up);
        //holder.img_expend.setImageDrawable(context.getResources().getDrawable(R.drawable.ic_expend_down));
    }


    @Override
    public int getItemCount() {
       if (this.PrductList !=null){
           return this.PrductList.size();
       }
       return 0;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        TextView tvCategory;
        RecyclerView rv_child;
        ImageView img_expend;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            tvCategory=itemView.findViewById(R.id.txt_cat);
            rv_child=itemView.findViewById(R.id.rv_child);
            img_expend=itemView.findViewById(R.id.img_expend);


        }
    }
}
