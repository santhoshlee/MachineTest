package com.sanmobi.machinetest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.text.NumberFormat;
import java.util.Locale;

public class ProductDetailActivity extends AppCompatActivity {

    private String imgUrl,name,rate,dec;
    ImageView Pro_Img;
    TextView txt_name,txt_rate,txt_desc;
    NumberFormat format = NumberFormat.getCurrencyInstance(new Locale("en", "IN"));
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_detail);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        imgUrl=getIntent().getStringExtra("prourl");
        name=getIntent().getStringExtra("proname");
        rate=getIntent().getStringExtra("prorate");
        dec=getIntent().getStringExtra("prodesc");

        initUi();
    }

    private void initUi(){

        RequestOptions options = new RequestOptions()
                .centerCrop()
                .placeholder(R.mipmap.ic_launcher_round)
                .error(R.mipmap.ic_launcher_round);


        Pro_Img=findViewById(R.id.img_product);
        txt_name=findViewById(R.id.tv_name);
        txt_rate=findViewById(R.id.tv_rate);
        txt_desc=findViewById(R.id.tv_dec);

        txt_name.setText(name);

        if (rate.equals("")
                || rate.equals("null")){
            txt_rate.setText(format.format(Double.parseDouble("0")));
        }else {
            txt_rate.setText(format.format(Double.parseDouble(rate)));
        }

        txt_desc.setText(dec);


        Glide.with(this).load(imgUrl).apply(options).into(Pro_Img);
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                onBackPressed();
                return true;
        }

        return super.onOptionsItemSelected(item);
    }
}