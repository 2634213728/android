package com.example.genius.login;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.view.View.OnClickListener;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Add_item extends AppCompatActivity {

    private  String[] data={"老鼠","老虎","狗狗","猫猫","兔子",
            "猴子","梅花鹿","猪猪"};
    private  int[] Image={R.mipmap.s1,R.mipmap.s2,R.mipmap.s3,R.mipmap.s4,
            R.mipmap.s5,R.mipmap.s6,R.mipmap.s7,R.mipmap.s8};
    private List<Fruit>fruitList=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_five);
        initFruits();
        RecyclerView recyclerView =(RecyclerView) findViewById(R.id.recycler_view);
        //实现瀑布布局增加一下一行，并屏蔽以下第二行
//        StaggeredGridLayoutManager layoutManager =new StaggeredGridLayoutManager(3,StaggeredGridLayoutManager.VERTICAL);
        LinearLayoutManager layoutManager=new LinearLayoutManager(this);//在竖向布局和横向布局的时候解封**************
        //实现横向布局
        // 增加仅此一行
//        layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        recyclerView.setLayoutManager(layoutManager);
//        第二参数this，传入activity，让在Adpter中也可使用activity的相关的方法和函数
        Add_item_Adpter adpter_rec =new Add_item_Adpter(fruitList,this);
        recyclerView.setAdapter(adpter_rec);
    }
    private void initFruits(){
        for(int i=0;i<data.length;i++){
            Fruit apple =new Fruit(data[i],Image[i]);
            fruitList.add(apple);
        }
    }
}
