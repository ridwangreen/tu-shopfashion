package com.android.entity;

import java.io.Serializable;


public class Product implements Serializable {

	private static final long serialVersionUID = 1L;
	private String txtName = "";
	private String txtDescription = "";
	private String url_thumb = "";
	private boolean isNew = false;
	private boolean isInCart = false;
	public boolean isInCat() {
		return isInCart;
	}

	public void setInCat(boolean isInCat) {
		this.isInCart = isInCat;
	}

	public boolean isNew() {
		return isNew;
	}

	public void setNew(boolean isNew) {
		this.isNew = isNew;
	}

	public String getTxtName() {
		return txtName;
	}

	public void setTxtName(String txtName) {
		this.txtName = txtName;
	}

	public String getTxtDescription() {
		return txtDescription;
	}

	public void setTxtDescription(String txtDescription) {
		this.txtDescription = txtDescription;
	}

	public String getUrl_thumb() {
		return url_thumb;
	}

	public void setUrl_thumb(String url_thumb) {
		this.url_thumb = url_thumb;
	}

	int product_id;
	private String url_small;
	String url_medium;
	private String url_large;
	String product_name;
	double price;
	String name;
	String detail_short;
	/*String image;

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}*/

	public String getDetail_short() {
		return detail_short;
	}

	public void setDetail_short(String detail_short) {
		this.detail_short = detail_short;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	int sold;
	int visited;
	int quantity_on_hand;
	int parent;

	public int getProduct_id() {
		return product_id;
	}

	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}

	public String getUrl_small() {
		return url_small;
	}

	public void setUrl_small(String url_small) {
		this.url_small = url_small;
	}

	public String getUrl_medium() {
		return url_medium;
	}

	public void setUrl_medium(String url_medium) {
		this.url_medium = url_medium;
	}

	public String getUrl_large() {
		return url_large;
	}

	public void setUrl_large(String url_large) {
		this.url_large = url_large;
	}

	public String getProduct_name() {
		return product_name;
	}

	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getSold() {
		return sold;
	}

	public void setSold(int sold) {
		this.sold = sold;
	}

	public int getVisited() {
		return visited;
	}

	public void setVisited(int visited) {
		this.visited = visited;
	}

	public int getQuantity_on_hand() {
		return quantity_on_hand;
	}

	public void setQuantity_on_hand(int quantity_on_hand) {
		this.quantity_on_hand = quantity_on_hand;
	}

	public int getParent() {
		return parent;
	}

	public void setParent(int parent) {
		this.parent = parent;
	}
}
