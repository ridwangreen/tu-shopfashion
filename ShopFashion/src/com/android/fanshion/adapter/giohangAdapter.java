package com.android.fanshion.adapter;

import java.util.ArrayList;

import com.android.ShopFashion.R;
import com.android.entity.Product;
import com.android.fanshion.ImageCache.ImageDownloader;
import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class giohangAdapter extends BaseAdapter{
	ArrayList<Product> mListProduct;
	Context mContext;
	LayoutInflater inflater;
	private final ImageDownloader imageDownloader = new ImageDownloader();

	public giohangAdapter(Context context, ArrayList<Product> listProduct) {
		// TODO Auto-generated constructor stub
		mListProduct = listProduct;
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
		ViewHolder holder;
		View vi = ConvertView;
		vi = inflater.inflate(R.layout.mitem_product, null);
		holder = new ViewHolder();
		holder.image = (ImageView) vi.findViewById(R.id.image_giohang);		
		holder.name = (TextView) vi.findViewById(R.id.tensanpham_giohang);		
		holder.price = (TextView) vi.findViewById(R.id.gia_giohang);				
		vi.setTag(holder);

		// Đẩy dữ liệu vào item
		/* Product p = mListProduct.get(positon); */
		holder.name.setText(mListProduct.get(positon).getName());		

		holder.price.setText(mListProduct.get(positon).getPrice() + "");
		
		// dm.fetchDrawableOnThread(p.getUrl_small(), holder.image);
		imageDownloader.download(mListProduct.get(positon).getUrl_thumb(),
				holder.image);		

		
		
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
