package com.android.ShopFashion;

import java.io.InputStream;
import java.util.ArrayList;

import org.apache.http.NameValuePair;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
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
	Button btnCart,btnByNow;
	InputStream is;
	ImageDownloader imageDownloader;
	Product p;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.detail_product);

		imageDownloader = new ImageDownloader();
		Bundle i = getIntent().getExtras();
		p =(Product) i.getSerializable("product");
/*		name = i.getString("name");
		price = i.getString("price" + "");
		image = i.getString("image"+"");
		visted = i.getString("visited"+"");*/
		
		TextView txtProductName = (TextView) findViewById(R.id.name_detail_product);
		TextView txtProductPrice = (TextView) findViewById(R.id.detail_price_product);
		ImageView imgProduct = (ImageView)findViewById(R.id.img_detail_product);
		TextView txtNumbVisited = (TextView) findViewById(R.id.detail_visited_product);
		btnCart = (Button) findViewById(R.id.btn_detail_giohang);
		btnByNow = (Button) findViewById(R.id.btn_detail_muangay);
		txtProductName.setText(p.getName());
		txtProductPrice.setText(p.getPrice()+"");
		txtNumbVisited.setText(p.getVisited()+"");
		if(TabCart.listProductCart.contains(p)){
			btnCart.setBackgroundResource(R.drawable.btn_giohang);
		}else {
			btnCart.setBackgroundResource(R.drawable.btn_giohang_select);
		}
		imageDownloader.download(p.getUrl_medium(), imgProduct);

		btnCart.setOnClickListener(new OnClickListener() {
			
			public void onClick(View b) {
				if(TabCart.listProductCart.contains(p)){
					b.setBackgroundResource(R.drawable.btn_giohang_select);
					TabCart.removeProductCart(p);
				}else {
					TabCart.addInListCart(p);
					b.setBackgroundResource(R.drawable.btn_giohang);				}
			}
		});
		
		
		btnByNow.setOnClickListener(new OnClickListener() {
			
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent i = new Intent(product_detail.this, muangay.class);	
				String name = p.getName();
				i.putExtra("name", name);	
				String price = p.getPrice()+"";
				i.putExtra("price", price );	
				String image = p.getUrl_thumb();
				i.putExtra("image", image );
				startActivity(i);
			}
		});
	
		
		
		
	}	
	
}
