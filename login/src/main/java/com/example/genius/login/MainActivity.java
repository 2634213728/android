package com.example.genius.login;

import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText editText;
    private Button button_1,button_2;
    private EditText editText2;
    private TextView textView1,textView,textView2;
    private CheckBox remember;
    private ImageView imageView1,imageView2,imageView3,imageView4;

    private SharedPreferences pref;
    private SharedPreferences.Editor editor;

//    使用SharedPreferences存贮数据实现暂存密码的功能

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pref =PreferenceManager.getDefaultSharedPreferences(this);

        button_1=(Button)findViewById(R.id.button_1);
        button_2=(Button)findViewById(R.id.button_2);
        editText =(EditText)findViewById(R.id.login_1);
        editText2 =(EditText)findViewById(R.id.login_2);
        textView =(TextView)findViewById(R.id.forget);
        textView2 =(TextView)findViewById(R.id.add_user);
        imageView1=(ImageView)findViewById(R.id.qq);
        imageView2=(ImageView)findViewById(R.id.wechat);
        imageView3=(ImageView)findViewById(R.id.github);
        imageView4=(ImageView)findViewById(R.id.facebook);

        remember=(CheckBox)findViewById(R.id.remenber_pass);

        button_1.setOnClickListener(this);
        button_2.setOnClickListener(this);
        textView2.setOnClickListener(this);

        boolean isRemember =pref.getBoolean("remember_password",false);
        if (isRemember){
            //将账号移入页面显示
            String account =pref.getString("account","");
            String password=pref.getString("password","");
            editText.setText(account);
            editText2.setText(password);
            remember.setChecked(true);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.add_item:
                Toast.makeText(this,"you choose add",Toast.LENGTH_SHORT).show();
//                Uri uri = Uri.parse("https://www.baidu.com");//浏览器

                Intent intent = new Intent().setAction(Intent.ACTION_VIEW);
//                 intent.setAction(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("https://www.baidu.com"));
                startActivity(intent);
                Log.d("进入浏览器", "onClick: ");
                break;
            case R.id.remove_item:
                Toast.makeText(this,"you chose Remove",Toast.LENGTH_SHORT).show();
                break;
                default:
                    break;
        }
        return true;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.button_1:
                add_password();//实现保存密码
                Toast.makeText(this,"登陆成功",Toast.LENGTH_SHORT).show();


//                添加按钮一操作
//                textView1.setText("显示账号："+editText.getText());
                Log.d("AppCompatActivity", "显示账号:"+editText.getText());
//                intent 的显式操作
                Intent intent =new Intent(this,SecondActivity.class);
//                String name=editText.getText().toString();
                intent.putExtra("name",editText.getText().toString());//显式操作中的传值

//                intent的隐式操作，在androidMainFrist.xml中先设置属性实现
//                Intent intent =new Intent("android.intent.action.ACTION_START");
                startActivity(intent);


                break;

            case R.id.button_2:
//                添加按钮二操作
                Toast.makeText(this,"正在取消登录",Toast.LENGTH_SHORT).show();
                button_2.setBackgroundColor(0xFF0000FF);
                break;
            case R.id.forget:
//               忘记密码操作
//                Toast.makeText(this,"忘记密码",Toast.LENGTH_SHORT).show();
//                textView1.setText("显示密码"+editText2.getText());
                Log.d("AppCompatActivity", "忘记密码:"+editText2.getText());
                break;
            case R.id.add_user:
                Intent intent2 =new Intent(this,Add_user.class);
                startActivity(intent2);
//              用户注册操作
                Log.d("Add_user.class", "用户注册");
                break;
            case R.id.qq:
//                点击qq
                Toast.makeText(this,"正在使用QQ登陆",Toast.LENGTH_SHORT).show();
                break;
                default:

                    break;
        }
    }
    private void add_password(){
        String account=editText.getText().toString();
        String password =editText2.getText().toString();
        editor=pref.edit();
        if (remember.isChecked()){
            editor.putBoolean("remember_password",true);
            editor.putString("account",account);
            editor.putString("password",password);
        }else {
            editor.clear();
        }
        editor.apply();
    }
}
