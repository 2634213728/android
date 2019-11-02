package com.example.genius.login;

import android.content.Intent;
import android.net.Uri;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity implements View.OnClickListener {
//    private Button button1;


    private TextView textView2;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Button button1 =(Button)findViewById(R.id.botton2);
        Button button2 =(Button)findViewById(R.id.botton3);
        Button button3 =(Button)findViewById(R.id.botton4);
        Button button4 =(Button)findViewById(R.id.botton5);
        Button button5 =(Button)findViewById(R.id.botton6);
        Button button6 =(Button)findViewById(R.id.botton7);
        TextView textView1=(TextView)findViewById(R.id.text1);
        textView2=(TextView)findViewById(R.id.text2);
        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);
        button4.setOnClickListener(this);
        button5.setOnClickListener(this);
        button6.setOnClickListener(this);
        textView1.setOnClickListener(this);
//      textView2.setOnClickListener(this);

//        显式操作的intent传值读取
        Intent intent =getIntent();
        String data = intent.getStringExtra("name");

        Log.d("传递的值", data);
        textView1.setText("欢迎登录"+data);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        switch (requestCode){
            case 1:
                if(resultCode==RESULT_OK){
                    String returneData =data.getStringExtra("data");
                    Log.d("传回来的数据", returneData);
                    textView2.setText("返回的数据："+returneData);
                    break;
                }
            default:
                break;
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.botton2:
                Intent intent = new Intent().setAction(Intent.ACTION_VIEW);
//                 intent.setAction(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("https://www.baidu.com"));
                startActivity(intent);
                Log.d("进入浏览器", "onClick: ");
                break;
            case R.id.text1:
                Log.d("点击标题", "onClick");
                break;
            case R.id.botton3:
                Log.d("进入下一页", "onClick");
                Intent intent1 =new Intent(this,ThridActivity.class);
                startActivityForResult(intent1,1);
//                startActivity(intent1);
                break;
            case R.id.botton4:
                Intent intent2 =new Intent(this,FourActivity.class);
                startActivity(intent2);
                break;
            case R.id.botton5:
                Intent intent3 =new Intent(this,FiveActivity.class);
                startActivity(intent3);
                break;
            case R.id.botton6:
                Intent intent4 =new Intent(this,SixActivity.class);
                startActivity(intent4);
                Log.d("点击", "进入聊天模式");
                break;
            case R.id.botton7:
                Intent intent5 =new Intent(this,SevenActivity.class);
                startActivity(intent5);
                Log.d("点击", "进入数据库");
                break;
                default:
                    break;
        }
    }
}
