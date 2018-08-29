package com.itpvt.tanish.Adapters;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.itpvt.tanish.Categories;
import com.itpvt.tanish.Pojo.Sub_Categories_pojo;
import com.itpvt.tanish.R;

import java.util.ArrayList;

/**
 * Created by Itpvt on 13-Jan-18.
 */

public class Recycler_Adapter_Sub_catagories extends RecyclerView.Adapter<Recycler_Adapter_Sub_catagories.MyViewHolder>{

    ArrayList<Sub_Categories_pojo> arrayList= new ArrayList<>();
    Activity activity;
    String WebUrl;

    public Recycler_Adapter_Sub_catagories(ArrayList<Sub_Categories_pojo> arrayList, Context context)
    {
        this.arrayList=arrayList;
        activity=(Activity)context;

    }

    @Override
    public Recycler_Adapter_Sub_catagories.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.categories_item,parent,false);
        return new Recycler_Adapter_Sub_catagories.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(Recycler_Adapter_Sub_catagories.MyViewHolder holder, final int position) {


        holder.name.setText(arrayList.get(position).getName());
        holder.name.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    Intent intent = new Intent(activity,Categories.class);
                    intent.putExtra("id",arrayList.get(position).getCategory_id());
                    intent.putExtra("title",arrayList.get(position).getName());
                    activity.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public static class MyViewHolder extends  RecyclerView.ViewHolder
    {
        Button name;
        public MyViewHolder(View itemView) {
            super(itemView);
            name=(Button)itemView.findViewById(R.id.name);
        }
    }
}
