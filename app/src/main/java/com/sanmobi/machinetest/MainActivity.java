package com.sanmobi.machinetest;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.sanmobi.machinetest.adapter.ProductListAdapter;
import com.sanmobi.machinetest.model.Category;
import com.sanmobi.machinetest.model.ProductModel;
import com.sanmobi.machinetest.viewmodel.ProductViewModel;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<ProductModel> ProductList;
    private RecyclerView Product_List_RV;
    private TextView TX_no;
    private ProductListAdapter productListAdapter;
    private ProductViewModel viewModel;
    ProgressDialog progressDoalog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initUi();
    }

    //Method
    private void initUi() {
        Product_List_RV=findViewById(R.id.rv_product_list);
        TX_no=findViewById(R.id.txt_no_result);
        LinearLayoutManager layoutManager =new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        Product_List_RV.setLayoutManager(layoutManager);
        productListAdapter=new ProductListAdapter(this,ProductList);
        Product_List_RV.setAdapter(productListAdapter);

        progressDoalog = new ProgressDialog(MainActivity.this);
        progressDoalog.setMessage("Loading Product....");
        progressDoalog.show();

        viewModel = ViewModelProviders.of(this).get(ProductViewModel.class);
        viewModel.getProductListObserver().observe(this, new Observer<Category>() {
            @Override
            public void onChanged(Category productModels) {
                if (productModels!=null){
                    progressDoalog.dismiss();
                    ProductList=productModels.getModelList();
                    productListAdapter.SetProductList(productModels.getModelList());
                    TX_no.setVisibility(View.GONE);
                }else{
                    progressDoalog.dismiss();
                    TX_no.setVisibility(View.VISIBLE);
                }
            }
        });

        viewModel.makeApiCall();
    }
}