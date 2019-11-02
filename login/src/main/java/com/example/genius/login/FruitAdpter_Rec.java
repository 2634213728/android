package com.example.genius.login;


import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class FruitAdpter_Rec extends RecyclerView.Adapter<FruitAdpter_Rec.ViewHolder> {

    private List<Fruit>mFruitList;
    static class ViewHolder extends RecyclerView.ViewHolder{
        View fruitView;//响应
        TextView fruitName;
        ImageView fruitImage;
        public ViewHolder(View view){

            super(view);

            fruitView =view;//响应

            fruitImage =(ImageView) view.findViewById(R.id.furit_image_rec);
            fruitName =(TextView) view.findViewById(R.id.furit_name_rec);
        }
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Fruit fruit =mFruitList.get(position);
        holder.fruitName.setText(fruit.getName());
        holder.fruitImage.setImageResource(fruit.getimageId());
    }

    @Override
    public int getItemCount() {
        return mFruitList.size();
    }

    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//        View view =LayoutInflater.from(parent.getContext()).inflate(R.layout.fruit_item_rec,parent,false);
//        fruit_item_rec2使用横向布局格式
//        fruit_item_rec3使用瀑布布局格式
        View view =LayoutInflater.from(parent.getContext()).inflate(R.layout.fruit_item_rec,parent,false);

//        ViewHolder holder =new ViewHolder(view);//使用响应时解锁
//        开启响应
        final ViewHolder holder =new ViewHolder(view);
        holder.fruitView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position =holder.getAdapterPosition();
                Fruit fruit=mFruitList.get(position);
                Toast.makeText(v.getContext(),"现在选中文字"+fruit.getName(),Toast.LENGTH_LONG).show();
            }
        });
        holder.fruitImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position =holder.getAdapterPosition();
                Fruit fruit=mFruitList.get(position);
                Toast.makeText(v.getContext(),"现在选中图片"+fruit.getName(),Toast.LENGTH_LONG).show();
            }
        });

        return holder;
    }
    public FruitAdpter_Rec(List<Fruit> fruitList){
        mFruitList=fruitList;
    }
}
