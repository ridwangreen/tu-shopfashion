package com.android.ShopFashion;

import java.io.InputStream;
import java.util.ArrayList;

import org.apache.http.NameValuePair;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.entity.Product;
import com.android.fanshion.ImageCache.ImageDownloader;

public class product_detail extends Activity{
	ArrayList<Product> listProductNew;
	// Khai bao them bien de luu id
	String visted, name,image, price;
	Button btn1,btn2;
	InputStream is;
	ImageDownloader imageDownloader;


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.detail_product);

		imageDownloader = new ImageDownloader();
		Bundle i = getIntent().getExtras();
		name = i.getString("name");
		price = i.getString("price" + "");
		image = i.getString("image"+"");
		visted = i.getString("visited"+"");
		TextView edit1 = (TextView) findViewById(R.id.name_detail_product);
		TextView edit2 = (TextView) findViewById(R.id.detail_price_product);
		ImageView image1 = (ImageView)findViewById(R.id.img_detail_product);
		TextView edit3 = (TextView) findViewById(R.id.detail_visited_product);
		edit1.setText(name);
		edit2.setText(price);
		edit3.setText(visted);
		imageDownloader.download(image, image1);
		
		btn1 = (Button) findViewById(R.id.btn_detail_giohang);
		btn1.setOnClickListener(new OnClickListener() {
			
			public void onClick(View b) {
				// TODO Auto-generated method stub
				b.setBackgroundResource(R.drawable.btn_giohang);
			}
		});
		
		btn2 = (Button) findViewById(R.id.btn_detail_muangay);
		btn2.setOnClickListener(new OnClickListener() {
			
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent i = new Intent(product_detail.this, muangay.class);				
				i.putExtra("name", name);				
				i.putExtra("price", price );				
				i.putExtra("image", image );
				startActivity(i);
			}
		});
	
		
		
		
	}	
	
}
