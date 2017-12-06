package com.example.admin.spmsmobile;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ZWJ on 2017/12/5 0005.
 */
public class HomeActivity extends FragmentActivity {
	private TextView t1;
	private TextView t2;
	private TextView t3;
	private ViewPager viewPager;
	private List<Fragment> fragmentList = new ArrayList<Fragment>() ;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_home);
		initView();
	}
	public void initView(){
		viewPager = findViewById(R.id.vp);
		t1 = findViewById(R.id.t1);
		t2 = findViewById(R.id.t2);
		t3 = findViewById(R.id.t3);
		FragmentLeft fragmentLeft = new FragmentLeft();
		FragmentMid fragmentMid = new FragmentMid();
		FragmentRight fragmentRight = new FragmentRight();
		fragmentList.add(fragmentLeft);
		fragmentList.add(fragmentMid);
		fragmentList.add(fragmentRight);
		//将fragment装入adapter
		FragmentPagerAdapter adapter = new FragmentPagerAdapter(getSupportFragmentManager()){
			@Override
			public int getCount() {
				return fragmentList.size();
			}

			@Override
			public Fragment getItem(int position) {
				return fragmentList.get(position);
			}
		};
		//将adapter注册到viewPager
		viewPager.setAdapter(adapter);
		//添加事件监听
		viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
			@Override
			public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

			}

			@Override
			public void onPageSelected(int position) {
				setTextColor(position);
			}

			@Override
			public void onPageScrollStateChanged(int state) {

			}
		});


	}

	/**
	 * change textView's color by args
	 * @param textNum
	 */
	private void setTextColor(int textNum){
		//This method has expired after sdk api 6.0
		//this.getResources().getColor(R.color.white))
		t1.setTextColor(ContextCompat.getColor(this.getApplicationContext(),R.color.white));
		t2.setTextColor(ContextCompat.getColor(this.getApplicationContext(),R.color.white));
		t3.setTextColor(ContextCompat.getColor(this.getApplicationContext(),R.color.white));
		switch (textNum){
			case 0:t1.setTextColor(ContextCompat.getColor(this.getApplicationContext(),R.color.red));
				break;
			case 1:t2.setTextColor(ContextCompat.getColor(this.getApplicationContext(),R.color.red));
				break;
			case 2:t3.setTextColor(ContextCompat.getColor(this.getApplicationContext(),R.color.red));
				break;
			default:
				break;
		}
	}
}
