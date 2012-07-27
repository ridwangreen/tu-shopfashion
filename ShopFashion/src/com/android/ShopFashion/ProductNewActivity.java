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

import com.android.common.JsonPaser;
import com.android.entity.Product;
import com.android.fanshion.adapter.ProductNewAdapter;



public class ProductNewActivity extends Activity {
	ProductNewAdapter adapter;
	ListView list;
	InputStream is;
	String mResult;// --
	Button b;
	public static ArrayList<Product> listProductNew = new ArrayList<Product>();
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.man_productnew);

		list = (ListView) findViewById(R.id.listView_productnew);	
		
		mResult = getData();// --		
	
	}
	 

	private String getData() {
		String result = "";
		// http post
		try {
			// tạo 1 đối tượng là đường dẫn khách mặc định
			HttpClient httpClient = new DefaultHttpClient();
			// tạo 1 đối tượng là đường dẫn post bài từ địa chỉ đã cho
			HttpPost httpPost = new HttpPost(
					"http://tinhocsp2.net/api/getAll.php");
			//httpPost.setEntity(new UrlEncodedFormEntity(nameValuePairs));
			// Lấy phản hồi từ server theo giao thức http
			HttpResponse response = httpClient.execute(httpPost);
			// Lấy thực thể của response
			HttpEntity entity = response.getEntity();
			// Lấy luồng dữ liệu
			is = entity.getContent();  
		} catch (Exception e) {
			// TODO: handle exception
			Log.e("Log_tag", "Error in http connection" + e.toString());

		}
		// convert response to string
		try {

			BufferedReader reader = new BufferedReader(new InputStreamReader(
					is, "utf-8"), 8);
			StringBuilder sb = new StringBuilder();
			String line = null;
			while ((line = reader.readLine()) != null) {
				sb.append(line + "\n");
			}
			is.close();

			result = sb.toString();
			Log.d("Result", result);
		} catch (Exception e) {
			Log.e("log_tag", "Error converting result " + e.toString());
		}

		// parse json data
		
		JsonPaser js = new JsonPaser(getApplicationContext());
		listProductNew = js.getListPhoto(result);
		Log.d("Tổng kết quả", listProductNew.size()+"");
		if (listProductNew.size() > 0) {
			adapter = new ProductNewAdapter(getApplicationContext(), listProductNew);
			list.setAdapter(adapter);
		}

		return result;// --

	}
}
