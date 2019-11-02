package com.example.genius.login;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import org.litepal.LitePal;

public class SevenActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seven);
        Button createDatabase =(Button) findViewById(R.id.create);
//        createDatabase.setOnClickListener(this);

        createDatabase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("创建数据库", "onClick: ");
                LitePal.getDatabase();
            }
        });
    }

//    @Override
//    public void onClick(View v) {
//        switch (v.getId()){
//            case R.id.create:
//                Log.d("创建数据库", "onClick: ");
////                LitePal.getDatabase();
//                Log.d("创建22222222数据库", "onClick: ");
//                break;
//                default:
//                    break;
//        }
//    }
}
