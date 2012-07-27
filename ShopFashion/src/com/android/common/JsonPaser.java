package com.android.common;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.android.entity.Product;

import android.content.Context;
import android.widget.Toast;

public class JsonPaser {
	Context mContext;

	public JsonPaser(Context context) {
		this.mContext = context;
	}

	// Paser sản phẩm mới

	public ArrayList<Product> getListPhoto(String json) {
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

					if (productJson.opt("name") != null) {
						product.setName(productJson.getString("name"));
					}
				}
				if (productJson.opt("price") != null) {
					product.setPrice(productJson.getDouble("price"));
				}
				if (productJson.opt("visited") != null) {
					product.setVisited(productJson.getInt("visited"));
				}
				if (productJson.opt("image") != null) {
					product.setUrl_large(Constant.URL_IMAGE
							+ productJson.getString("image"));
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
}
