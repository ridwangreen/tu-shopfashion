package com.android.ShopFashion;
import java.util.ArrayList;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.AdapterView.OnItemClickListener;

import com.android.entity.Product;
import com.android.fanshion.adapter.ProductAdapter;

public class ProductActivity extends Activity {
/*	PageViewAdapter adapter;*/
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main_product);
		/*ViewPager myPager = (ViewPager) findViewById(R.id.page_view);
		adapter = new PageViewAdapter();
		myPager.setAdapter(adapter);
		myPager.setCurrentItem(0);
		*/
		ArrayList<Product> SearchResults = GetSearchResults();
		final ListView lv1 = (ListView) findViewById(R.id.listView_product);
		lv1.setAdapter(new ProductAdapter(this, SearchResults));
		/*lv1.setOnItemClickListener(new OnItemClickListener() {

			public void onItemClick(AdapterView<?> arg0, View arg1,
					int position, long arg3) {
				// TODO Auto-generated method stub
				try {
					
							Intent i = new Intent(ProductActivity.this,
									product_detail.class);
							
							Product q = listProductNew.get(position);
							String id = q.getProduct_id() + "";
							String name = q.getProduct_name();
							String price = q.getPrice() + "";
							String image = q.getUrl_small();
							String detail_short = q.getDetail_short();
							String visited = q.getVisited() + "";
							Log.d("Tổng kết quả", listProductNew.size()+"");
							i.putExtra("id", id);
							i.putExtra("result", mResult);
							i.putExtra("name", name);
							i.putExtra("price", price);
							i.putExtra("image", image);
							i.putExtra("detail_short", detail_short);
							i.putExtra("visited", visited);
							Log.d("Tổng kết quả", listProductNew.size()+"");
							// Toast.makeText(GetlocalhostActivity.this, id,
							// Toast.LENGTH_SHORT).show();
							startActivity(i);
				} catch (Exception e) {Log.e("log_tag", "loi o day " + e.toString());
					// TODO: handle exception
				}
				Log.d("OK","ok");
				 
			}
		});*/
		
		

	}

	private ArrayList<Product> GetSearchResults() {
		ArrayList<Product> results = new ArrayList<Product>();

		Product sr1 = new Product();
		sr1.setTxtName("ÁO SƠ MI");
		sr1.setTxtDescription("Click to select");
		sr1.setUrl_thumb("http://247thoitrang.files.wordpress.com/2012/03/cong-so-han-quoc-2012.jpg?w=150");
		results.add(sr1);

		sr1 = new Product();
		sr1.setTxtName("ÁO THUN");
		sr1.setTxtDescription("Click to select");
		sr1.setUrl_thumb("http://enbac10.vcmedia.vn/thumb_w/150/up_new/2011/11/05/item/541/541141/20111105174225_29.jpg");
		results.add(sr1);

		sr1 = new Product();
		sr1.setTxtName("ÁO ĐÔI");
		sr1.setTxtDescription("Click to select");
		sr1.setUrl_thumb("http://shop.sw1.com.vn/sw/pictures/ProductPictures/HuongLyBH/Thumbnails/2011.11.29.02.57.ao%20doi%204%20800k.jpg");
		results.add(sr1);

		sr1 = new Product();
		sr1.setTxtName("ĐẦM");
		sr1.setTxtDescription("Click to select");
		sr1.setUrl_thumb("http://enbac10.vcmedia.vn/thumb_w/150/up_new/2011/12/09/item/559/558890/20111209113523_1322138348940121038_574_0.jpg");
		results.add(sr1);

		sr1 = new Product();
		sr1.setTxtName("CÔNG SỞ");
		sr1.setTxtDescription("Click to select");
		sr1.setUrl_thumb("http://mysite.vn/Shop/thoitrangmoi/Product/Medium/CONG-SO-TRE-TRUNG--MS072_21112011080702.png");
		results.add(sr1);

		sr1 = new Product();
		sr1.setTxtName("PHỤ KIỆN");
		sr1.setTxtDescription("Click to select");
		sr1.setUrl_thumb("http://blog.brandsfavor.com/wp-content/themes/arthemia/scripts/timthumb.php?src=http://blog.brandsfavor.com/wp-content/uploads/2012/02/banner-baraka-300x250.jpg&w=150&h=150&zc=1&q=100");
		results.add(sr1);

		return results;
	}

}
