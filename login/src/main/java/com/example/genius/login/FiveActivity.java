package com.example.genius.login;

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

public class FiveActivity extends AppCompatActivity {

    private  String[] data={"菠萝","草莓","橙子","奇异果","苹果",
            "火龙果","橘子","牛油果","葡萄","绿苹果",
            "山竹","西瓜","西红柿","椰子","葡萄",
            "哈密瓜"};
    private  int[] Image={R.mipmap.j1,R.mipmap.j2,R.mipmap.j3,R.mipmap.j4,
            R.mipmap.j5,R.mipmap.j6,R.mipmap.j7,R.mipmap.j8,
            R.mipmap.j9,R.mipmap.j10,R.mipmap.j11,R.mipmap.j12,
            R.mipmap.j13,R.mipmap.j14,R.mipmap.j15,R.mipmap.j16};
    private List<Fruit>fruitList=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_five);
        initFruits();
        RecyclerView recyclerView =(RecyclerView) findViewById(R.id.recycler_view);
        //实现瀑布布局增加一下一行，并屏蔽以下第二行
        StaggeredGridLayoutManager layoutManager =new StaggeredGridLayoutManager(3,StaggeredGridLayoutManager.VERTICAL);
//        LinearLayoutManager layoutManager=new LinearLayoutManager(this);//在竖向布局和横向布局的时候解封**************
        //实现横向布局
        // 增加仅此一行
//        layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);

        recyclerView.setLayoutManager(layoutManager);
        FruitAdpter_Rec adpter_rec =new FruitAdpter_Rec(fruitList);
        recyclerView.setAdapter(adpter_rec);

    }
    private void initFruits(){
        for(int i=0;i<data.length;i++){
            Fruit apple =new Fruit(getRandomName(data[i]),Image[i]);
            fruitList.add(apple);
        }
    }
    private String getRandomName(String name){
        Random random =new Random();
        int length =random.nextInt(20)+1;
        StringBuilder builder =new StringBuilder();
        for(int i=0;i<length;i++){
            builder.append(name);
        }
        return builder.toString();
    }
}
