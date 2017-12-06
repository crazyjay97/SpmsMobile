package com.example.admin.spmsmobile;

import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.RelativeLayout;

/**
 * Created by ZWJ on 2017/12/6 0006.
 */
public class TextViewOnclickListener implements View.OnClickListener {
	private RelativeLayout relativeLayout;
	private ViewPager viewPager;
	public TextViewOnclickListener(RelativeLayout view, ViewPager pager){
		this.relativeLayout = view;
		this.viewPager = pager;
	}
	@Override
	public void onClick(View v) {
		switch (relativeLayout.getId()){
			case R.id.rl1:viewPager.setCurrentItem(0);
				break;
			case R.id.rl2:viewPager.setCurrentItem(1);
				break;
			case R.id.rl3:viewPager.setCurrentItem(2);
				break;
			default:
				break;
		}
	}
}
