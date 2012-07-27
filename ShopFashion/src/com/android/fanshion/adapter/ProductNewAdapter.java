package com.android.fanshion.adapter;

import java.util.ArrayList;
import java.util.jar.Attributes.Name;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.ShopFashion.R;
import com.android.ShopFashion.muangay;
import com.android.ShopFashion.product_detail;
import com.android.common.giohang;
import com.android.entity.Product;
import com.android.fanshion.ImageCache.ImageDownloader;

public class ProductNewAdapter extends BaseAdapter {
	ArrayList<Product> mListProduct;
	Context mContext;
	LayoutInflater inflater;
	private final ImageDownloader imageDownloader = new ImageDownloader();

	public ProductNewAdapter(Context context, ArrayList<Product> listProductNew) {
		// TODO Auto-generated constructor stub
		mListProduct = listProductNew;
		/* mContext = context; *//*
								 * inflater = (LayoutInflater) mContext
								 * .getSystemService
								 * (Context.LAYOUT_INFLATER_SERVICE);
								 */
		inflater = LayoutInflater.from(context);
		// dm = new DrawableManager();
		mContext = context;
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
		final ViewHolder holder;
		View vi = ConvertView;
		vi = inflater.inflate(R.layout.mitem_product, null);
		holder = new ViewHolder();
		holder.image = (ImageView) vi.findViewById(R.id.m_img_product);
		holder.image1 = (ImageView) vi.findViewById(R.id.m_img_product);
		holder.name = (TextView) vi.findViewById(R.id.name_product);
		holder.visited = (TextView) vi.findViewById(R.id.visited_product);
		holder.price = (TextView) vi.findViewById(R.id.price_product);
		holder.btnCart = (Button) vi.findViewById(R.id.btn_productnew_giohang);
		holder.btnBuyNow = (Button) vi.findViewById(R.id.btn_muangay);
		vi.setTag(holder);

		// Đẩy dữ liệu vào item
		/* Product p = mListProduct.get(positon); */
		holder.name.setText(mListProduct.get(positon).getName());
		holder.visited.setText(mListProduct.get(positon).getVisited() + "");
		holder.price.setText(mListProduct.get(positon).getPrice() + "");
		if (mListProduct.get(positon).isInCat()) {
			holder.btnCart.setBackgroundResource(R.drawable.btn_giohang);
		} else {
			holder.btnCart.setBackgroundResource(R.drawable.btn_giohang_select);
		}
		Log.d("url", mListProduct.get(positon).getUrl_thumb());
		// dm.fetchDrawableOnThread(p.getUrl_small(), holder.image);
		imageDownloader.download(mListProduct.get(positon).getUrl_thumb(),
				holder.image);
		imageDownloader.download(mListProduct.get(positon).getUrl_large(),
				holder.image1);

		holder.btnBuyNow.setOnClickListener(new OnClickListener() {

			public void onClick(View arg0) {
				// TODO Auto-generated method stub

				Intent i = new Intent(mContext, muangay.class);
				i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
				String name = mListProduct.get(positon).getName();
				i.putExtra("name", name);
				String price = mListProduct.get(positon).getPrice() + "";
				i.putExtra("price", price);
				String image = mListProduct.get(positon).getUrl_thumb();
				i.putExtra("image", image);
				mContext.startActivity(i);
			}
		});
		holder.btnCart.setOnClickListener(new OnClickListener() {

			public void onClick(View b) {
				// TODO Auto-generated method stub
				/* b.setVisibility(View.INVISIBLE); */
				if (mListProduct.get(positon).isInCat()) {
					mListProduct.get(positon).setInCat(false);
				} else {
					mListProduct.get(positon).setInCat(true);
				}
				notifyDataSetChanged();
								
				//bắt sự kiện sang giỏ hàng
				giohang.name = holder.name.getText().toString();
			}
		});
		vi.setOnClickListener(new OnClickListener() {

			@SuppressLint("ParserError")
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				try {
					Intent i = new Intent(mContext, product_detail.class);
					i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

					String name = mListProduct.get(positon).getName();
					i.putExtra("name", name);
					String price = mListProduct.get(positon).getPrice() + "";
					i.putExtra("price", price);
					String image1 = mListProduct.get(positon).getUrl_large();
					i.putExtra("image", image1);
					String visited = mListProduct.get(positon).getVisited()
							+ "";
					i.putExtra("visited", visited);
					mContext.startActivity(i);
				} catch (Exception e) {
					// TODO: handle exception
					Log.d("Err:", e.getMessage());
				}

			}
		});
		return vi;
	}

	static class ViewHolder {
		TextView name, visited, price;
		ImageView image, image1;
		Button btnCart, btnBuyNow;
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