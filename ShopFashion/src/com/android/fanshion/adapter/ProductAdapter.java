package com.android.fanshion.adapter;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.ShopFashion.R;
import com.android.entity.Product;

import com.android.fanshion.ImageCache.ImageDownloader;


public class ProductAdapter extends BaseAdapter {
	Context mContext;
	ArrayList<Product> searchArrayList;
	LayoutInflater mInflater;
	private final ImageDownloader imageDownloader = new ImageDownloader();
	
	public ProductAdapter(Context context, ArrayList<Product> results) {
		searchArrayList = results;
		mInflater = LayoutInflater.from(context);
	}
	
	  public ImageDownloader getImageDownloader() {
	        return imageDownloader;
	    }
	public int getCount() {
		// TODO Auto-generated method stub
		return searchArrayList.size();
	}

	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return searchArrayList.get(position);
	}

	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		ViewHolder holder;
		View vi = convertView;
		if (vi == null) {
			vi = mInflater.inflate(R.layout.customview_product, null);
			holder = new ViewHolder();
			holder.txtName = (TextView) vi.findViewById(R.id.txt_product);
			holder.txtDescription = (TextView) vi.findViewById(R.id.txt_description_product);
			holder.imgProduct = (ImageView) vi.findViewById(R.id.img_product);
			vi.setTag(holder);
		} else {
			holder = (ViewHolder) vi.getTag();
		}
		holder.txtName.setText(searchArrayList.get(position).getTxtName());
		holder.txtDescription.setText(searchArrayList.get(position).getTxtDescription());
		//Truyền vào Url ảnh và ImageView để nạp ảnh vào View và lưu vào thẻ nhớ
		//Ép kiểu Context thành kiểu Activity
		imageDownloader.download(searchArrayList.get(position).getUrl_thumb(), holder.imgProduct);
		return vi;

	}

	static class ViewHolder {
		TextView txtName;
		TextView txtDescription;
		ImageView imgProduct;
	}

}
