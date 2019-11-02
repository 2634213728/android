package com.example.genius.login;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Map;

public class Add_user extends AppCompatActivity implements View.OnClickListener{

    private int item;
    private String item_name;
    private ImageView imageView;
    private EditText editText1,editText2,editText3;
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_user);
        Button button_1=(Button)findViewById(R.id.button_1);
        Button button_2=(Button)findViewById(R.id.button_2);
        imageView =(ImageView)findViewById(R.id.add_item);
        editText1=findViewById(R.id.add_1);
        editText2=findViewById(R.id.add_2);
        editText3=findViewById(R.id.add_3);
        button_1.setOnClickListener(this);
        button_2.setOnClickListener(this);
        imageView.setOnClickListener(this);
        editText3.setOnClickListener(this);
        editText2.setOnClickListener(this);
        editText1.setOnClickListener(this);

        Map<String,String> userInfo=FileSaveQQ.getUserInfo(this);
//        Log.d("拿到的数据", userInfo.get("number"));
        if(userInfo!=null){
            editText1.setText(userInfo.get("number"));
            editText2.setText(userInfo.get("password"));
            editText3.setText(userInfo.get("password"));
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.add_item:
                Intent intent =new Intent(this,Add_item.class);
                startActivityForResult(intent,1);
                Log.d("进入选头像", "onClick: ");
                break;
            case R.id.button_1:
                createUser();
                break;
                default:
                    break;
        }
    }
    public void createUser(){
        String number=editText1.getText().toString().trim();
        String password =editText3.getText().toString().trim();
        String password1 =editText2.getText().toString().trim();
        if(TextUtils.isEmpty(number)){
            Toast.makeText(this,"请输入账号",Toast.LENGTH_SHORT).show();
            return;
        }
        if(password1.isEmpty()||password.isEmpty()){
            Toast.makeText(this,"请输入密码",Toast.LENGTH_SHORT).show();
            return;
        }
        if(password.equals(password1)){
            Toast.makeText(this,"正在登陆",Toast.LENGTH_SHORT).show();
            boolean isSaveSuccess=FileSaveQQ.SaveUserInfo(this,number,password);
            if (isSaveSuccess){
                Toast.makeText(this,"保存成功",Toast.LENGTH_SHORT).show();
            }else {
                Toast.makeText(this,"保存失败",Toast.LENGTH_SHORT).show();
            }
        }

    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode==1){
            if (resultCode==1){
                item=data.getIntExtra("data",0);
                Log.d("传回的数据","");
                imageView.setImageResource(item);

            }
            if (resultCode==2){
                item_name=data.getStringExtra("data");
                Log.d("传回的数据", item_name);
            }
        }
    }
}
