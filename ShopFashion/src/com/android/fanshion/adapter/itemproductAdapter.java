package com.android.fanshion.adapter;

import java.util.ArrayList;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.ShopFashion.R;
import com.android.entity.Product;
import com.android.fanshion.ImageCache.ImageDownloader;

public class itemproductAdapter extends BaseAdapter{

	ArrayList<Product> mListProduct;
	Context mContext;
	LayoutInflater inflater;
	private final ImageDownloader imageDownloader = new ImageDownloader();

	public itemproductAdapter(Context context, ArrayList<Product> listItemProduct) {
		// TODO Auto-generated constructor stub
		mListProduct = listItemProduct;
		/*mContext = context;	*/	/*inflater = (LayoutInflater) mContext
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);*/
		inflater = LayoutInflater.from(context);
		// dm = new DrawableManager();
		mContext = context ;
	}
	  public ImageDownloader getImageDownloader() {
	        return imageDownloader;
	    }

	public int getCount() {
		// TODO Auto-generated method stub
		return mListProduct.size();
	}

	@SuppressLint("ParserError")
	public View getView(final int positon, View ConvertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		// Thiết đặt layout cho từng item
		ViewHolder holder;
		View vi = ConvertView;
		if (vi == null) {
			vi = inflater.inflate(R.layout.itemproduct, null);
			holder = new ViewHolder();
			holder.image = (ImageView) vi.findViewById(R.id.m_img_itemproduct);
			/*holder.image1 = (ImageView)vi.findViewById(R.id.m_img_itemproduct);*/
			holder.name = (TextView) vi.findViewById(R.id.name_itemproduct);
			holder.visited = (TextView) vi.findViewById(R.id.visited_itemproduct);
			holder.price = (TextView) vi.findViewById(R.id.price_itemproduct);
			holder.btn1 = (Button) vi.findViewById(R.id.btn_itemproduct_giohang);
			holder.btn2 = (Button) vi.findViewById(R.id.btn_itemmuangay);
			vi.setTag(holder);
		} else {
			holder = (ViewHolder) vi.getTag();
		}

		// Đẩy dữ liệu vào item
		/*Product p = mListProduct.get(positon);*/
		holder.name.setText(mListProduct.get(positon).getName());
		holder.visited.setText(mListProduct.get(positon).getVisited() + "");
		holder.price.setText(mListProduct.get(positon).getPrice() + "");
		holder.parent.setText(mListProduct.get(positon).getParent()+"");
		
		Log.d("url", mListProduct.get(positon).getUrl_thumb());
		// dm.fetchDrawableOnThread(p.getUrl_small(), holder.image);
		imageDownloader.download(mListProduct.get(positon).getUrl_thumb(),holder.image);
		/*imageDownloader.download(mListProduct.get(positon).getUrl_large(), holder.image1);*/
		
		/*holder.btn2.setOnClickListener(new OnClickListener() {
			
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				
				Intent i = new Intent(mContext, muangay.class);
				i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
				String name = mListProduct.get(positon).getName();
				i.putExtra("name", name);
				String price = mListProduct.get(positon).getPrice()+"";
				i.putExtra("price", price );
				String image = mListProduct.get(positon).getUrl_thumb();
				i.putExtra("image", image );
				mContext.startActivity(i);	
			}
		});*/
		holder.btn1.setOnClickListener(new OnClickListener() {
			
			public void onClick(View b) {
				// TODO Auto-generated method stub
			/*b.setVisibility(View.INVISIBLE);*/
				b.setBackgroundResource(R.drawable.btn_giohang);
			
			}
		});
		/*vi.setOnClickListener(new OnClickListener() {
			
			@SuppressLint("ParserError")
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				try {
					Intent i = new Intent(mContext, product_detail.class);
					i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
					
					String name = mListProduct.get(positon).getName();
					i.putExtra("name", name);
					String price = mListProduct.get(positon).getPrice()+"";
					i.putExtra("price", price );
					String image1 = mListProduct.get(positon).getUrl_large();
					i.putExtra("image", image1 );
					String visited = mListProduct.get(positon).getVisited()+"";
					i.putExtra("visited", visited );
					mContext.startActivity(i);		
				} catch (Exception e) {
					// TODO: handle exception
					Log.d("Err:", e.getMessage());
				}
				
			}
		});*/
		return vi;
	}

	static class ViewHolder {
		TextView name, visited, price, parent;
		ImageView image,image1;
		Button btn1, btn2;
	}

	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return mListProduct.get(position);
	}

	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}

}