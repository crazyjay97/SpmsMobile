package com.example.admin.spmsmobile;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by ZWJ on 2017/12/5 0005.
 */
public class Test {

	public static int num;

	public static void main(String... args){
		Timer timer = new Timer();
		num = 3;
		TimerTask task = new TimerTask() {
			@Override
			public void run() {
				System.out.println(num);
				num--;
			}
		};
		timer.schedule(task,1000*1);
	}
}
