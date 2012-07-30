package com.android.ShopFashion;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.ListView;

import com.android.common.ApiConnect;
import com.android.common.JsonPaser;
import com.android.entity.Product;
import com.android.fanshion.adapter.ProductNewAdapter;

public class ProductNewActivity extends Activity {
	ProductNewAdapter adapter;
	ListView lvProductNew;
	public static ArrayList<Product> lstProductNew = new ArrayList<Product>();

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.man_productnew);

		lvProductNew = (ListView) findViewById(R.id.listView_productnew);

		ApiConnect apiConnect = new ApiConnect(this);
		JsonPaser js = new JsonPaser(this);
		String result = apiConnect.execGet(this, ApiConnect.GET_PRODUCT_NEW);
		lstProductNew = js.getListProduct(result);
		for (Product p : lstProductNew) {
			p.setNew(true);
		}
		adapter = new ProductNewAdapter(this, lstProductNew);
		lvProductNew.setAdapter(adapter);

	}
	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		adapter.notifyDataSetChanged();
		super.onResume();
	}
}
