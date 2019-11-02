package com.example.genius.login;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class FuritAdapter extends ArrayAdapter<Fruit> {
    private int resourcsid;
    public FuritAdapter(Context context, int textViewResourceId,List<Fruit> objects){
        super(context,textViewResourceId,objects);
        resourcsid=textViewResourceId;
    }
    public View getView(int position, View converView, ViewGroup patent){
        Fruit fruit =getItem(position);
        View view = LayoutInflater.from(getContext()).inflate(resourcsid,patent,false);
        ImageView fruitImage =(ImageView) view.findViewById(R.id.furit_image);
        TextView fruitName =(TextView)view.findViewById(R.id.furit_name);
        fruitImage.setImageResource(fruit.getimageId());
        fruitName.setText(fruit.getName());
        return view;
    }

}
