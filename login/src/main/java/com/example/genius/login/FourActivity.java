package com.example.genius.login;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.view.View.OnClickListener;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class FourActivity extends AppCompatActivity {

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
        setContentView(R.layout.activity_four);
        initFruits();

        FuritAdapter adapter =new FuritAdapter(this,R.layout.fruit_item,fruitList);
//        ArrayAdapter<String> adapter=new ArrayAdapter<String>(FourActivity.this,
//                android.R.layout.simple_list_item_1,data);
        ListView listView =(ListView)findViewById(R.id.listview);
        listView.setAdapter(adapter);
        //直接显示listview布局
//        listView.setOnClickListener(new AdapterView.OnItemClickListener());
        //显示点击图片的动作
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view,int position, long id) {
                Fruit fruit=fruitList.get(position);
                Toast.makeText(FourActivity.this,fruit.getName(),
                        Toast.LENGTH_SHORT).show();
            }
        });

    }
    private void initFruits(){
        for(int i=0;i<data.length;i++){
            Fruit apple =new Fruit(data[i],Image[i]);
            fruitList.add(apple);
        }
    }
}
