package com.example.genius.login;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class ThridActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText editText;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thrid);
        Button button =(Button)findViewById(R.id.botton3_1);
        editText =(EditText) findViewById(R.id.text3_1);
        button.setOnClickListener(this);
//        EditText.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.botton3_1:
                Intent intent =new Intent();
                intent.putExtra("data",editText.getText().toString());
                setResult(RESULT_OK,intent);
                Log.d("输入的数据", editText.getText().toString());
                finish();
                break;
        }
    }
}
