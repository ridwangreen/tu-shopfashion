package com.android.fanshion.adapter;

import java.util.ArrayList;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.ShopFashion.ListProductActivity;
import com.android.ShopFashion.R;
import com.android.ShopFashion.product_detail;
import com.android.entity.Category;
import com.android.fanshion.ImageCache.ImageDownloader;


public class CategoryAdapter extends BaseAdapter {
	Context mContext;
	ArrayList<Category> lstCategory;
	LayoutInflater mInflater;
	private final ImageDownloader imageDownloader = new ImageDownloader();
	
	public CategoryAdapter(Context context, ArrayList<Category> lstCategory) {
		this.lstCategory = lstCategory;
		mInflater = LayoutInflater.from(context);
	}
	
	  public ImageDownloader getImageDownloader() {
	        return imageDownloader;
	    }
	public int getCount() {
		// TODO Auto-generated method stub
		return lstCategory.size();
	}

	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return lstCategory.get(position);
	}

	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	public View getView(final int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		ViewHolder holder;
		View vi = convertView;
		if (vi == null) {
			vi = mInflater.inflate(R.layout.customview_product, null);
			holder = new ViewHolder();
			holder.txtName = (TextView) vi.findViewById(R.id.txt_product);
			holder.imgProduct = (ImageView) vi.findViewById(R.id.img_product);
			vi.setTag(holder);
		} else {
			holder = (ViewHolder) vi.getTag();
		}
		holder.txtName.setText(lstCategory.get(position).getCategoryName());
		imageDownloader.download(lstCategory.get(position).getCategoryUrl(), holder.imgProduct);

		return vi;

	}

	static class ViewHolder {
		TextView txtName;
		ImageView imgProduct;
	}

}
