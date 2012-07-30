package com.android.common;


import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.widget.Toast;

import com.android.ShopFashion.R;

/**
 * Api Connect class
 * 
 * @author DuyTX
 * 
 */
public class ApiConnect{
	/** Base API URL */
	private static final String BASE_API_URL = "http://tinhocsp2.net/api/";
	/** API Group */
	public static final String GET_CATEGORY = "getAllCategory";
	public static final String GET_PRODUCT_NEW = "getProductNew";
	public static final String GET_PRODUCT_CATEGORY = "getProductCategory";

	private static Context mContext;

	public  UIHandler uiHandler;

	private final class UIHandler extends Handler {
		public static final int DISPLAY_UI_TOAST = 0;
		public static final int DISPLAY_UI_DIALOG = 1;

		public UIHandler(Looper looper) {
			super(looper);
		}

		@Override
		public void handleMessage(Message msg) {
			switch (msg.what) {
			case UIHandler.DISPLAY_UI_TOAST: {

				Toast t = Toast.makeText(mContext, (String) msg.obj,
						Toast.LENGTH_LONG);
				t.show();
			}
			case UIHandler.DISPLAY_UI_DIALOG:
				showErrorDialog(msg);
				// TBD
			default:
				break;
			}
		}
		
		/**
		 * show error dialog when have error
		 * 
		 * @param msg
		 */
		public void showErrorDialog(Message msg) {

			AlertDialog.Builder builder = new AlertDialog.Builder(mContext);
			builder.setMessage((String) msg.obj).setCancelable(true)
					.setNegativeButton("OK", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int id) {
							dialog.cancel();
						}
					});
			AlertDialog alert = builder.create();
			alert.show();
		}
	}

	public ApiConnect(Activity context) {
		// TODO Auto-generated constructor stub
		mContext = context;
	}

	protected void handleUIRequest(String message) {
		Message msg = uiHandler.obtainMessage(UIHandler.DISPLAY_UI_DIALOG);
		msg.obj = message;
		uiHandler.sendMessage(msg);
	}

	

	public static String exectGet(String strUrl) {
		try {
			URL url = new URL(strUrl);
			HttpURLConnection http;
			http = (HttpURLConnection) url.openConnection();
			http.setRequestMethod("GET");
			http.connect();
			InputStream is = http.getInputStream();
			String ret = inputStreem2str(is);
			is.close();

			return ret;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;

	}

	/**
	 * Get method
	 * 
	 * @param group
	 *            : Server API Group đang sử dụng (A,F,L...)
	 * 
	 * @param method
	 *            : Method để get dữ liệu về
	 * 
	 * @param paramList
	 *            : Danh sách các tham số dạng NameValuePair
	 * 
	 * @return JSON
	 */
	public static String execGet(Context context, String group,
			List<NameValuePair> paramList) {
		try {
			String strUrl = BASE_API_URL + group + ".php";
			if (null != paramList) {
				strUrl += getStrParam(paramList);
			}
			mContext = context;

			// Request to Server
			Log.v("URL", strUrl);
			URL url = new URL(strUrl);

			HttpURLConnection http;
			http = (HttpURLConnection) url.openConnection();
			http.setRequestMethod("GET");
			http.connect();
			InputStream is = http.getInputStream();
			String ret = inputStreem2str(is);
			is.close();

			return ret;

		} catch (Exception e) {
			Log.e("ApiConnectexecGet", e.getMessage());
			// Thread uiThread = new HandlerThread("UIHandler");
			// uiThread.start();
			// uiHandler = new UIHandler(((HandlerThread)
			// uiThread).getLooper());
			return "";
		}
	}
	public static String execGet(Context context, String group) {
		try {
			String strUrl = BASE_API_URL + group + ".php";
			mContext = context;
			
			// Request to Server
			Log.v("URL", strUrl);
			URL url = new URL(strUrl);
			
			HttpURLConnection http;
			http = (HttpURLConnection) url.openConnection();
			http.setRequestMethod("GET");
			http.connect();
			InputStream is = http.getInputStream();
			String ret = inputStreem2str(is);
			is.close();
			
			return ret;
			
		} catch (Exception e) {
			Log.e("ApiConnectexecGet", e.getMessage());
			// Thread uiThread = new HandlerThread("UIHandler");
			// uiThread.start();
			// uiHandler = new UIHandler(((HandlerThread)
			// uiThread).getLooper());
			return "";
		}
	}

	/**
	 * Post method
	 * 
	 * @param group
	 *            : Server API Group đang sử dụng (A,F,L...)
	 * 
	 * @param method
	 *            : Method để lấy dữ liệu về hoặc post dữ liệu lên server
	 * 
	 * @param paramList
	 *            : Danh sách các tham số dạng NameValuePair
	 * 
	 * @return JSON
	 */
	public static String execPost(Context context, String group,
			List<NameValuePair> paramList) {
		HttpClient httpclient = new DefaultHttpClient();
		HttpPost httppost = new HttpPost(BASE_API_URL + group + ".php");
		mContext = context;
		try {
			httppost.setEntity(new UrlEncodedFormEntity(paramList));
			HttpResponse response = httpclient.execute(httppost);
			ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
			response.getEntity().writeTo(byteArrayOutputStream);

			if (HttpStatus.SC_OK == response.getStatusLine().getStatusCode()) {
				String ret = byteArrayOutputStream.toString();
				return ret;
			} else {
				Log.e("DbApiMgr#execPost",
						"HttpStatus is "
								+ Integer.toString(response.getStatusLine()
										.getStatusCode()));
				return "";
			}

		} catch (Exception e) {
			Log.e("ApiConnectexecPost", e.getMessage());
			return "";
		}
	}
	

	/**
	 * Build URL
	 * 
	 * @param params
	 * 
	 * @return params URL
	 */
	static private String getStrParam(List<NameValuePair> params) {
		String ret = "?";
		boolean flgAdd = false;

		for (int i = 0; params.size() > i; i++) {
			NameValuePair nvp = params.get(i);

			if (flgAdd) {
				ret += "&";
			}

			ret += nvp.getName() + "=" + nvp.getValue();

			flgAdd = true;

		}

		return ret;

	}

	/**
	 * InputStream to String
	 * 
	 * @param is
	 *            InputStream
	 * @return String
	 * @throws IOException
	 */
	private static String inputStreem2str(InputStream is) throws IOException {

		BufferedReader reader = new BufferedReader(new InputStreamReader(is,
				"UTF-8"));
		StringBuffer buf = new StringBuffer();
		String str;
		while (null != (str = reader.readLine())) {
			buf.append(str);
			buf.append("\n");
		}
		return buf.toString();
	}

	/**
	 * Get Bit map from URL
	 * 
	 * @param str
	 * @return Bitmap
	 * @throws IOException
	 * @throws MalformedURLException
	 */
	public static Bitmap loadBitmap(String url) throws MalformedURLException,
			IOException {
		return ((BitmapDrawable) loadImage(url)).getBitmap();
	}

	/**
	 * Get Drawalbe from URL
	 * 
	 * @param str
	 * @return Drawable
	 * @throws IOException
	 * @throws MalformedURLException
	 */
	public static Drawable loadImage(String url) throws MalformedURLException,
			IOException {

		HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(url)
				.openConnection();

		httpURLConnection.setRequestMethod("GET");

		httpURLConnection.connect();

		InputStream stream = httpURLConnection.getInputStream();

		Drawable drawable = Drawable.createFromStream(stream, "");

		stream.close();

		return drawable;
	}
	
	
}
