package com.example.admin.spmsmobile;

import android.app.Activity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

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
		TextView view = (TextView) findViewById(R.id.text);
		view.setText("Hello World!");
		view.setTextSize(30f);
	}
}
