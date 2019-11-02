package com.example.genius.uselitepal;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import org.litepal.LitePal;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button1=(Button)findViewById(R.id.create_database);
        Button button2=(Button)findViewById(R.id.add_data);
        Button button3=(Button)findViewById(R.id.delete_data);
        Button button4=(Button)findViewById(R.id.update_data);
        Button button5=(Button)findViewById(R.id.query_data);
        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);
        button4.setOnClickListener(this);
        button5.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.create_database:
                Log.d("数据库", "onClick: ");
                LitePal.getDatabase();
                break;
            case R.id.add_data:
                Book book=new Book();
                book.setName("搞黄色百科全输");
                book.setId(001);
                book.setName("王桐文");
                book.setPages(100);
                book.setPrice(111);
                book.setPress("GHS");
                book.save();
                Log.d("成功添加作者王桐文", "onClick: ");
                break;
                default:
                    break;
        }
    }
}
