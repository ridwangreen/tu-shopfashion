package com.android.ShopFashion;
import java.util.ArrayList;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

import com.android.common.ApiConnect;
import com.android.common.JsonPaser;
import com.android.entity.Category;
import com.android.fanshion.adapter.CategoryAdapter;

public class ProductActivity extends Activity {
	ArrayList<Category> lstCategory = new ArrayList<Category>();
	ListView lvCategory;
/*	PageViewAdapter adapter;*/
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main_product);
		ApiConnect apiConnect = new ApiConnect(this);
		String result = apiConnect.execGet(this, ApiConnect.GET_CATEGORY);
		
		JsonPaser js = new JsonPaser(this);
		lstCategory = js.getListCategory(result);
		Log.d("Category",lstCategory.size()+"");
		lvCategory = (ListView) findViewById(R.id.listView_product);
		lvCategory.setAdapter(new CategoryAdapter(getApplicationContext(), lstCategory));	
		lvCategory.setOnItemClickListener(new OnItemClickListener() {

			public void onItemClick(AdapterView<?> arg0, View arg1, int position,
					long arg3) {
				// TODO Auto-generated method stub
				Intent i  = new Intent(getApplicationContext(),ListProductActivity.class);
				i.putExtra("id", lstCategory.get(position).getId());
				startActivity(i);
			}
		});
	}

}
