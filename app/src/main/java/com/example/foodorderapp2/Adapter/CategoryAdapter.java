package com.example.foodorderapp2.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.example.foodorderapp2.Activity.ListFoodsActivity;
import com.example.foodorderapp2.Domain.Category;
import com.example.foodorderapp2.Domain.Foods;
import com.example.foodorderapp2.R;

import java.util.ArrayList;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.viewholder> {
    ArrayList<Category> items;
    Context context;

    public CategoryAdapter(ArrayList<Category> items) {
        this.items = items;
    }

    @NonNull
    @Override
    public CategoryAdapter.viewholder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        context= viewGroup.getContext();
        View inflate= LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.viewholder_category,viewGroup,false);
        return new viewholder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryAdapter.viewholder viewholder, int i) {
        viewholder.titleTxt.setText(items.get(i).getName());

        switch (i){
            case 0:{
                viewholder.pic.setBackgroundResource(R.drawable.cat_0_background);
                break;
            }
            case 1:{
                viewholder.pic.setBackgroundResource(R.drawable.cat_1_background);
                break;
            }
            case 2:{
                viewholder.pic.setBackgroundResource(R.drawable.cat_2_background);
                break;
            }
            case 3:{
                viewholder.pic.setBackgroundResource(R.drawable.cat_3_background);
                break;
            }
            case 4:{
                viewholder.pic.setBackgroundResource(R.drawable.cat_4_background);
                break;
            }
            case 5:{
                viewholder.pic.setBackgroundResource(R.drawable.cat_5_background);
                break;
            }
            case 6:{
                viewholder.pic.setBackgroundResource(R.drawable.cat_6_background);
                break;
            }
            case 7:{
                viewholder.pic.setBackgroundResource(R.drawable.cat_7_background);
                break;
            }
        }
        int drawableResourceId=context.getResources().getIdentifier(items.get(i).getImagePath(),"drawable",
                viewholder.itemView.getContext().getPackageName());
        Glide.with(context)
                .load(drawableResourceId)
                .into(viewholder.pic);

        viewholder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(context, ListFoodsActivity.class);
                intent.putExtra("CategoryId",items.get(i).getId());
                intent.putExtra("CategoryName",items.get(i).getName());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public class viewholder extends RecyclerView.ViewHolder{
        TextView titleTxt;
        ImageView pic;
        public viewholder(@NonNull View itemView) {
            super(itemView);
            titleTxt=itemView.findViewById(R.id.catNameTxt);
            pic=itemView.findViewById(R.id.imgCat);
        }
    }
}
