package com.example.admin.spmsmobile;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//全屏
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);//去掉标题栏
		this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);//去掉信息栏
		//将布局文件引入main_activity
		setContentView(R.layout.activity_main);
		TextView view = (TextView) findViewById(R.id.text);
		view.setText("Hello World!");
		view.setTextSize(30f);
	}
}
