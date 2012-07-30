package com.android.common;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.android.entity.Category;
import com.android.entity.Product;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

public class JsonPaser {
	Context mContext;

	public JsonPaser(Context context) {
		this.mContext = context;
	}

	// Paser sản phẩm mới

	public ArrayList<Product> getListProduct(String json) {
		ArrayList<Product> lstProduct = new ArrayList<Product>();
		try {
			JSONArray productArray = new JSONArray(json);
			Product product = null;
			JSONObject productJson = null;
			for (int i = 0; i < productArray.length(); i++) {
				productJson = productArray.getJSONObject(i);
				product = new Product();
				if (productJson.opt("image") != null) {
					product.setUrl_thumb(Constant.URL_IMAGE
							+ productJson.getString("image"));
				}
				if (productJson.opt("id") != null) {
					product.setProduct_id(productJson.getInt("id"));
				}
				if (productJson.opt("name") != null) {
					product.setName(productJson.getString("name"));
				}
				if (productJson.opt("price") != null) {
					product.setPrice(productJson.getDouble("price"));
				}
				if (productJson.opt("visited") != null) {
					product.setVisited(productJson.getInt("visited"));
				}
				if (productJson.opt("detail_short") != null) {
					product.setDetail_short(productJson.getString("detail_short"));
				}
				if (productJson.opt("image_medium") != null) {
					product.setUrl_medium(Constant.URL_IMAGE
							+ productJson.getString("image_medium"));
					lstProduct.add(product);
				}
			}
		}

		catch (JSONException e) {
			// TODO: nothing
			Toast.makeText(mContext, e.getMessage(), Toast.LENGTH_LONG).show();
		}
		return lstProduct;
	}
	public ArrayList<Category> getListCategory(String json) {
		ArrayList<Category> lstCategory = new ArrayList<Category>();
		try {
			JSONArray cateArray = new JSONArray(json);
			Category category = null;
			JSONObject categoryJson = null;
			for (int i = 0; i < cateArray.length(); i++) {
				categoryJson = cateArray.getJSONObject(i);
				category = new Category();
				/*if (categoryJson.opt("image") != null) {
					category.setCategoryUrl(Constant.URL_IMAGE
							+ categoryJson.getString("image"));
				}*/
				if (categoryJson.opt("image") != null) {
					category.setCategoryUrl(categoryJson.getString("image"));
				}
				if (categoryJson.opt("name") != null) {
					category.setCategoryName(categoryJson.getString("name"));
				}
				if (categoryJson.opt("id") != null) {
					category.setId(categoryJson.getInt("id"));
				}
				lstCategory.add(category);
			}
		}
		
		catch (JSONException e) {
			// TODO: nothing
			Toast.makeText(mContext, e.getMessage(), Toast.LENGTH_LONG).show();
		}
		return lstCategory;
	}
}
