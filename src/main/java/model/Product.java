package model;

import java.util.Arrays;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

@Entity
@Table(name = "PRODUCT")
public class Product {
	@Id
	@GeneratedValue
	@Column(name = "PRODUCT_ID")
	private int productID;

	@Column(name = "PRODUCT_NAME")
	private String productName;

	@Column(name = "PRODUCT_DESC")
	private String productDesc;
	
	
	/*@Lob*/
	@Column(name = "PRODUCT_IMG", nullable = false, columnDefinition = "bytea") // MySQL: columnDefinition = "mediumblob"
	private byte[] productImg;

	@Column(name = "PRODUCT_PRICE")
	private double productPrice;

	@ManyToOne
	@JoinColumn(name = "category_id")
	private Category category;

	public Product() {

	}

	public Product(int productID, String productName, String productDesc, byte[] productImg, double productPrice,
			Category category) {
		super();
		this.productID = productID;
		this.productName = productName;
		this.productDesc = productDesc;
		this.productImg = productImg;
		this.productPrice = productPrice;
		this.category = category;
	}

	public int getProductID() {
		return productID;
	}

	public void setProductID(int productID) {
		this.productID = productID;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductDesc() {
		return productDesc;
	}

	public void setProductDesc(String productDesc) {
		this.productDesc = productDesc;
	}

	public byte[] getProductImg() {
		return productImg;
	}

	public void setProductImg(byte[] productImg) {
		this.productImg = productImg;
	}

	public double getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(double productPrice) {
		this.productPrice = productPrice;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	@Override
	public String toString() {
		return "Product [productID=" + productID + ", productName=" + productName + ", productDesc=" + productDesc
				+ ", productImg=" + Arrays.toString(productImg) + ", productPrice=" + productPrice + ", category="
				+ category + "]";
	}

	
}
