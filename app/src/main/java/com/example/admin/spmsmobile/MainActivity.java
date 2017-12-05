package com.example.admin.spmsmobile;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;

//工具默认集成AppCompatActivity  与设置无标题栏有冲突 这里继承 Activity
public class MainActivity extends Activity {

	//倒计时
	protected  int num;
	//内部类无法访问局部变量
	Timer timer = new Timer();


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//全屏
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);//去掉标题栏
		this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);//去掉信息栏
		//将布局文件引入main_activity
		setContentView(R.layout.activity_main);
		num = 3;
		TimerTask task = new TimerTask() {
			@Override
			public void run() {
				//如果不用ui线程会报错->为使用同一线程
				runOnUiThread(new Runnable() {
					@Override
					public void run() {
						TextView view = findViewById(R.id.countDown);
						if(num==0){
							view.setVisibility(View.GONE);
							Button button = findViewById(R.id.button);
							button.setVisibility(View.VISIBLE);
							System.out.println(num);
							timer.cancel();
						}else {
							view.setText(String.valueOf(num));
							System.out.println(num);
							num--;
						}
					}
				});
			}
		};
		timer.schedule(task,1000*1,1000*1);
	}
	//事件不加View参数 会找不到该方法引起报错
	public void onClick(View view){
		Intent intent = new Intent(MainActivity.this,HomeActivity.class);
		//清除activity 防止返回时推导此页面
		intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK|Intent.FLAG_ACTIVITY_NEW_TASK);
		MainActivity.this.startActivity(intent);
		//淡入淡出
		overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
		//切入切出
		//overridePendingTransition(android.R.anim.slide_in_left, android.R.anim.slide_out_right);
	}


}
