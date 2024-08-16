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
import com.example.foodorderapp2.Activity.DetailActivity;
import com.example.foodorderapp2.Domain.Foods;
import com.example.foodorderapp2.R;

import java.util.ArrayList;

public class FoodListAdapter extends RecyclerView.Adapter<FoodListAdapter.viewholder> {
    ArrayList<Foods> items;
    Context context;

    public FoodListAdapter(ArrayList<Foods> items) {
        this.items = items;
    }

    @NonNull
    @Override
    public FoodListAdapter.viewholder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        context=viewGroup.getContext();
        View inflate= LayoutInflater.from(context).inflate(R.layout.viewholder_list_food,viewGroup,false);
        return new viewholder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull FoodListAdapter.viewholder viewholder, int i) {
           viewholder.titleTxt.setText(items.get(i).getTitle());
           viewholder.timeTxt.setText(items.get(i).getTimeValue()+" min");
           viewholder.priceTxt.setText("$" + items.get(i).getPrice());
           viewholder.rateTxt.setText(""+items.get(i).getStar());

           Glide.with(context)
                   .load(items.get(i).getImagePath())
                   .transform(new CenterCrop(),new RoundedCorners(30))
                   .into(viewholder.pic);

           viewholder.itemView.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View v) {
                   Intent intent=new Intent(context, DetailActivity.class);
                   intent.putExtra("object",items.get(i));
                   context.startActivity(intent);
               }
           });
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public class viewholder extends RecyclerView.ViewHolder{
        TextView titleTxt,priceTxt,rateTxt,timeTxt;
        ImageView pic;
        public viewholder(@NonNull View itemView) {
            super(itemView);

            titleTxt=itemView.findViewById(R.id.titleText);
            priceTxt=itemView.findViewById(R.id.priceText);
            rateTxt=itemView.findViewById(R.id.rateText);
            timeTxt=itemView.findViewById(R.id.timeText);
            pic=itemView.findViewById(R.id.img);
        }
    }
}
