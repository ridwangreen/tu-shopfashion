package com.android.ShopFashion;

import android.app.TabActivity;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.TabHost;
import android.widget.TextView;

public class Tab_TabHost extends TabActivity {
	private TabHost mTabHost;

	/* PageViewAdapter adapter; */

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		Resources res = getResources();
		mTabHost = getTabHost();
		TabHost.TabSpec spec;
		Intent intent;
		// Home Tab
		intent = new Intent().setClass(this, ProductNewActivity.class);
		spec = mTabHost.newTabSpec("home")
				.setIndicator("Home", res.getDrawable(R.drawable.home))
				.setContent(intent);
		mTabHost.addTab(spec);

		// SanPham Tab
		intent = new Intent().setClass(this, ProductActivity.class);
		spec = mTabHost.newTabSpec("sản phẩm")
				.setIndicator("Sản Phẩm", res.getDrawable(R.drawable.sanpham))
				.setContent(intent);
		mTabHost.addTab(spec);


		// Liên He Tab
		intent = new Intent().setClass(this, TabCart.class);
		spec = mTabHost.newTabSpec("giỏ hàng")
				.setIndicator("Giỏ Hàng", res.getDrawable(R.drawable.giohang))
				.setContent(intent);
		mTabHost.addTab(spec);

		// Tro Giup Tab
		intent = new Intent().setClass(this, Tab_TroGiup.class);
		spec = mTabHost.newTabSpec("trợ giúp")
				.setIndicator("Trợ Giúp", res.getDrawable(R.drawable.trogiup))
				.setContent(intent);
		mTabHost.addTab(spec);
		mTabHost.setCurrentTab(4);
		for (int i = 0; i < mTabHost.getTabWidget().getChildCount(); i++) {
			TextView tv = (TextView) mTabHost.getTabWidget().getChildAt(i)
					.findViewById(android.R.id.title); // Unselected Tabs
			tv.setTextColor(this.getResources().getColorStateList(
					R.color.common_tab_state_color));
		}
	}

}
