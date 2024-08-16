package com.example.foodorderapp2.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.bumptech.glide.Glide;
import com.example.foodorderapp2.Domain.Foods;
import com.example.foodorderapp2.Helper.ManagmentCart;
import com.example.foodorderapp2.R;
import com.example.foodorderapp2.databinding.ActivityDetailBinding;

public class DetailActivity extends AppCompatActivity {
ActivityDetailBinding binding;
private Foods object;
private int num=1;
private ManagmentCart managmentCart;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityDetailBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        getIntentExtra();
        setVariable();
    }
    private void setVariable(){
        managmentCart= new ManagmentCart(this);
        binding.backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        Glide.with(DetailActivity.this)
                .load(object.getImagePath())
                .into(binding.pic);

        binding.priceTxt.setText("$"+object.getPrice());
        binding.titleTxt.setText(object.getTitle());
        binding.descriptionTxt.setText(object.getDescription());
        binding.rateTxt.setText(object.getStar()+" Ratings");
        binding.totalTxt.setText(num*object.getPrice()+"$");

        binding.plusBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                num=num+1;
                binding.numTxt.setText(num+" ");
                binding.totalTxt.setText("$"+(num*object.getPrice()));
            }
        });
        binding.minusBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               if(num>1){
                   num=num-1;
                   binding.numTxt.setText(num+"");
                   binding.totalTxt.setText("$"+(num*object.getPrice()));
               }
            }
        });
        binding.add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                object.setNumberInCart(num);
                managmentCart.insertFood(object);
            }
        });
    }
    private void getIntentExtra(){
        object=(Foods) getIntent().getSerializableExtra("object");
    }
}