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

public class BestFoodsAdapter extends RecyclerView.Adapter<BestFoodsAdapter.viewholder> {
    ArrayList<Foods> items;
    Context context;

    public BestFoodsAdapter(ArrayList<Foods> items) {
        this.items = items;
    }

    @NonNull
    @Override
    public BestFoodsAdapter.viewholder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        context= viewGroup.getContext();
        View inflate= LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.viewholder_best_deal,viewGroup,false);
        return new viewholder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull BestFoodsAdapter.viewholder viewholder, int i) {
       viewholder.titleTxt.setText(items.get(i).getTitle());
       viewholder.priceTxt.setText("$"+items.get(i).getPrice());
       viewholder.starTxt.setText(""+items.get(i).getStar());
       viewholder.timeTxt.setText(items.get(i).getTimeValue()+" min");

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
        TextView titleTxt,starTxt,priceTxt,timeTxt;
        ImageView pic;
        public viewholder(@NonNull View itemView) {
            super(itemView);
            timeTxt=itemView.findViewById(R.id.timeTxt);
            titleTxt=itemView.findViewById(R.id.titleTxt);
            starTxt=itemView.findViewById(R.id.starTxt);
            priceTxt=itemView.findViewById(R.id.priceTxt);
            pic=itemView.findViewById(R.id.pic);
        }
    }
}
