package com.android.ShopFashion;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.ListView;

import com.android.common.ApiConnect;
import com.android.common.JsonPaser;
import com.android.entity.Product;
import com.android.fanshion.adapter.ProductNewAdapter;
import com.android.fanshion.adapter.itemproductAdapter;

public class ListProductActivity extends Activity{
	ProductNewAdapter productCategoryAdapter;
	ArrayList<Product> lstProductCategory = new ArrayList<Product>();
	ListView list;
	ArrayList<NameValuePair> nameValuePairs;
	ArrayList<Product> listItemProduct = new ArrayList<Product>();
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.man_productnew);
		Bundle i = getIntent().getExtras();
		int id = i.getInt("id");
		list = (ListView) findViewById(R.id.listView_productnew);	
		nameValuePairs = new ArrayList<NameValuePair>();
		nameValuePairs.add(new BasicNameValuePair("parent", id+""));
		ApiConnect apiConnect = new ApiConnect(this);
		JsonPaser js = new JsonPaser(this);
		String result = apiConnect.execPost(this, ApiConnect.GET_PRODUCT_CATEGORY, nameValuePairs);
		lstProductCategory = js.getListProduct(result);
		productCategoryAdapter = new ProductNewAdapter(this, lstProductCategory);
		list.setAdapter(productCategoryAdapter);
	}
}
