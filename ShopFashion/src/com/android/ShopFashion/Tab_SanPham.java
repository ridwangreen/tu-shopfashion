package com.android.ShopFashion;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class Tab_SanPham extends Activity{
	@Override
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		TextView textView = new TextView(this);
		textView.setText("Danh mục sản phẩm");
		setContentView(textView);
	}

}
