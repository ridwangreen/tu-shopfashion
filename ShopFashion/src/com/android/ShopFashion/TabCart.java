package com.android.ShopFashion;

import java.io.InputStream;
import java.util.ArrayList;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.android.entity.Product;
import com.android.fanshion.adapter.ProductNewAdapter;
import com.android.fanshion.adapter.giohangAdapter;

public class TabCart extends Activity {
	ProductNewAdapter adapter;
	ListView list;
	InputStream is;
	String mResult;// --
	Button btnCart;
	TextView name;
	public static ArrayList<Product> listProductCart = new ArrayList<Product>();
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.gio_hang);
		
		btnCart = (Button) findViewById(R.id.btn_cart);
		btnCart.setOnClickListener(new OnClickListener() {
			
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
			Intent i = new Intent(TabCart.this,giohang_btnCart.class);
			startActivity(i);
			}
		});
		list = (ListView) findViewById(R.id.lv_gio_hang);	
		adapter = new ProductNewAdapter(getApplicationContext(), listProductCart);
		list.setAdapter(adapter);


	}
	@Override
	protected void onResume() {
		adapter.notifyDataSetChanged();
		super.onResume();
	}
	public static void addInListCart(Product p){
		if(!listProductCart.contains(p))
		listProductCart.add(p);
	}
	
	public static void removeProductCart(Product p){
		if(listProductCart.contains(p)) listProductCart.remove(listProductCart.indexOf(p));
	}
	
	

	
}
