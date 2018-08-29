package com.itpvt.tanish.Adapters;


import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.itpvt.tanish.Pojo.Product_pojo;
import com.itpvt.tanish.R;
import com.itpvt.tanish.Pojo.Product_pojo;
import com.itpvt.tanish.R;

import java.util.ArrayList;

//import com.bumptech.glide.Glide;

/**
 * Created by Itpvt on 13-Jan-18.
 */

public class Recycler_Adapter_All_Products_new extends RecyclerView.Adapter<Recycler_Adapter_All_Products_new.MyViewHolder>{

    ArrayList<Product_pojo> arrayList= new ArrayList<>();
    Activity activity;


    public Recycler_Adapter_All_Products_new(ArrayList<Product_pojo> arrayList, Context context)
    {

        this.arrayList=arrayList;
        activity=(Activity)context;
    }

    @NonNull
    @Override
    public Recycler_Adapter_All_Products_new.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view =LayoutInflater.from(parent.getContext()).inflate(R.layout.product_item_new,parent,false);
       MyViewHolder viewHolder = new MyViewHolder(view);
       return  viewHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {
        holder.name.setText(arrayList.get(position).getPro_name());
        holder.price.setText(arrayList.get(position).getPrice());
        Glide.with(activity).load(arrayList.get(position).getImg_url()).into(holder.imageView);

        holder.imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent intent = new Intent(activity, Product_Details.class);
//                intent.putExtra("product_id",arrayList.get(position).getProduct_id());
//                intent.putExtra("SKU",arrayList.get(position).getSKU());
//                activity.startActivity(intent);
            }
        });
        holder.name.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent intent = new Intent(activity, Product_Details.class);
//                intent.putExtra("product_id",arrayList.get(position).getProduct_id());
//                intent.putExtra("SKU",arrayList.get(position).getSKU());
//                activity.startActivity(intent);

//
            }
        });

//        holder.Model_Thumbnail.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
////                Toast.makeText(activity,arrayList.get(position).getUsername(),Toast.LENGTH_SHORT).show();
////                Intent intent = new Intent(activity,Home_profile_model.class);
////                intent.putExtra("Username",arrayList.get(position).getUsername());
////                activity.startActivity(intent);
//            }
//        });
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public static class MyViewHolder extends  RecyclerView.ViewHolder
    {
        TextView name;
        TextView price;
        ImageView imageView;
        public MyViewHolder(View itemView) {
             super(itemView);
            name=(TextView)itemView.findViewById(R.id.tvmodelname);
            imageView=(ImageView)itemView.findViewById(R.id.thumbnail);
            price=(TextView)itemView.findViewById(R.id.tvprice);
        }
    }
}
