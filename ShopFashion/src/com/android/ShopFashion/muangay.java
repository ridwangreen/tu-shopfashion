package com.android.ShopFashion;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.fanshion.ImageCache.ImageDownloader;


public class muangay extends Activity {

	String name, price, image;
	ImageDownloader imageDownloader;
	Button btn_mg;
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.mua_ngay);
		imageDownloader = new ImageDownloader();
		Bundle i = getIntent().getExtras();
		name = i.getString("name");
		price = i.getString("price" + "");
		image = i.getString("image"+"");
		TextView edit1 = (TextView) findViewById(R.id.ten_muangay);
		TextView edit2 = (TextView) findViewById(R.id.gia_muangay);
		ImageView image1 = (ImageView)findViewById(R.id.image_muangay);
		edit1.setText(name);
		edit2.setText(price);
		
		imageDownloader.download(image, image1);
		
		/*TextView edit4 = (TextView) findViewById(R.id.ten_muangay);
		edit4.setText(name);
		
		
		TextView edit5 = (TextView) findViewById(R.id.gia_muangay);
		edit5.setText(price);
		
	
		ImageView image2 = (ImageView) findViewById(R.id.image_muangay);
		imageDownloader.download(image, image2);*/
		
		btn_mg = (Button) findViewById(R.id.btn_muangay);
		btn_mg.setOnClickListener(new OnClickListener() {
			
			public void onClick(View b) {
				// TODO Auto-generated method stub
				
				muangay.this.finish();
			}
		});

	}

}
