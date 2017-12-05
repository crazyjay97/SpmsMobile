package com.example.admin.spmsmobile;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

//工具默认集成AppCompatActivity  与设置无标题栏有冲突 这里继承 Activity
public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//全屏
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);//去掉标题栏
		this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);//去掉信息栏
		//将布局文件引入main_activity
		setContentView(R.layout.activity_main);
	}
	//事件不加View参数 会找不到该方法引起报错
	public void onClick(View view){
		Intent intent = new Intent(MainActivity.this,HomeActivity.class);
		//清除activity 防止返回时推导此页面
		intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK|Intent.FLAG_ACTIVITY_NEW_TASK);
		MainActivity.this.startActivity(intent);
	}
}
