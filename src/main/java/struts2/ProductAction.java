package struts2;

import java.io.File;
import java.io.FileInputStream;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.interceptor.ServletRequestAware;

import com.opensymphony.xwork2.ActionSupport;

import dao.CategoryDAOImpl;
import dao.ProductDAOImpl;
import model.Category;
import model.Product;

public class ProductAction extends ActionSupport implements ServletRequestAware {

	private int categoryId;
	private List<Category> categories;
	private List<Product> products;
	private Category category;
	private String categoryName;
	private String categoryName1;

	private String categoryName_ID;

	private int productID;
	private String productName;
	private String productDesc;
	private File productImg;
	private double productPrice;

	private Product product;

	
	

	private HttpServletRequest servletRequest;

	public String execute() {

		CategoryDAOImpl categoryDAOImpl = new CategoryDAOImpl();
		ProductDAOImpl productDAOImpl = new ProductDAOImpl();
		Category category = categoryDAOImpl.getCategoryById(categoryId);
		products = productDAOImpl.getProductListByCategory(category);
		categories = categoryDAOImpl.getList();
		return SUCCESS;

	}

	public String add_product_view() {

		ProductDAOImpl productDAOImpl = new ProductDAOImpl();
		CategoryDAOImpl categoryDAOImpl = new CategoryDAOImpl();

		categories = categoryDAOImpl.getList();

		products = productDAOImpl.getList();
		return SUCCESS;
	}

	public String add_product() {

		System.out.println("Dau vao: ------");
		System.out.println(productID);
		System.out.println(productName);
		System.out.println(categoryName_ID);
		System.out.println(productDesc);
		System.out.println(productImg);
		System.out.println(productPrice);
		
		byte[] bFile = new byte[(int) productImg.length()];

		try {
			FileInputStream fileInputStream = new FileInputStream(productImg);
			fileInputStream.read(bFile);
			fileInputStream.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		ProductDAOImpl productDAOImpl = new ProductDAOImpl();
		CategoryDAOImpl categoryDAOImpl = new CategoryDAOImpl();
		categoryId = categoryDAOImpl.getCategoryIdByName(categoryName_ID);
		category = categoryDAOImpl.getCategoryById(categoryId);
		
		Product product = new Product();
		product.setProductID(productID);
		product.setProductName(productName);
		product.setProductDesc(productDesc);
		product.setProductImg(bFile);
		product.setProductPrice(productPrice);
		product.setCategory(category);
		

		


		productDAOImpl.addProduct(product);
		products = productDAOImpl.getList();
		categories = categoryDAOImpl.getList();

		for (Product product_ : products) {
			System.out.println("----------Cac thong so: --------------");
			System.out.println(product_.getProductID());
			System.out.println(product_.getProductName());
			System.out.println(product_.getProductImg());
			System.out.println(product_.getProductDesc());
			System.out.println(product_.getProductPrice());
			System.out.println(product_.getCategory().getCategoryName());
		}

		return SUCCESS;

	}

	public String delete_product() {

		ProductDAOImpl productDAOImpl = new ProductDAOImpl();
		Product product = productDAOImpl.getProductById(productID);
		productDAOImpl.delProduct(product);
		products = productDAOImpl.getList();
		CategoryDAOImpl categoryDAOImpl = new CategoryDAOImpl();

		categories = categoryDAOImpl.getList();

		for (Product product2 : products) {
			System.out.println(product2.getProductID());
			System.out.println(product2.getProductName());
			System.out.println(product2.getProductDesc());
			System.out.println(product2.getProductImg());
			System.out.println(product2.getProductPrice());
		}

		return SUCCESS;
	}

	public String edit_product_view() {
		System.out.println(productID);
		ProductDAOImpl productDAOImpl = new ProductDAOImpl();
		CategoryDAOImpl categoryDAOImpl = new CategoryDAOImpl();
		product = productDAOImpl.getProductById(productID);
		products = productDAOImpl.getList();
		categories = categoryDAOImpl.getList();
		System.out.println(product.getProductName());
		System.out.println(product.getProductPrice());
		System.out.println(product.getProductID());
		System.out.println(product.getProductPrice());

		return SUCCESS;
	}

	public String edit_product() {
		System.out.println(productID);
		
		
		// khai bao mang byte chua hinh anh
		byte[] bFile = new byte[(int) productImg.length()];

		try {
			FileInputStream fileInputStream = new FileInputStream(productImg);
			fileInputStream.read(bFile);
			fileInputStream.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		ProductDAOImpl productDAOImpl = new ProductDAOImpl();
		CategoryDAOImpl categoryDAOImpl = new CategoryDAOImpl();
		product = productDAOImpl.getProductById(productID);
		product.setProductName(productName);
		product.setProductID(productID);
		product.setProductDesc(productDesc);
		product.setProductImg(bFile);
		product.setProductPrice(productPrice);
		productDAOImpl.updateProduct(product);

		products = productDAOImpl.getList();
		categories = categoryDAOImpl.getList();
		System.out.println(product.getProductName());
		System.out.println(product.getProductPrice());
		System.out.println(product.getProductID());
		System.out.println(product.getProductPrice());

		return SUCCESS;
	}

	public String product_detail() {
		CategoryDAOImpl categoryDAOImpl = new CategoryDAOImpl();
		ProductDAOImpl productDAOImpl = new ProductDAOImpl();
		categories = categoryDAOImpl.getList();
		product = productDAOImpl.getProductById(productID);
		System.out.println("Thong so product detail: -----");
		System.out.println(product.getProductName() + "\n" + product.getProductImg() + "\n" + product.getProductDesc());
		return SUCCESS;
	}

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	public List<Category> getCategories() {
		return categories;
	}

	public void setCategories(List<Category> categories) {
		this.categories = categories;
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

	

	public File getProductImg() {
		return productImg;
	}

	public void setProductImg(File productImg) {
		this.productImg = productImg;
	}

	public double getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(double productPrice) {
		this.productPrice = productPrice;
	}

	public String getCategoryName_ID() {
		return categoryName_ID;
	}

	public void setCategoryName_ID(String categoryName_ID) {
		this.categoryName_ID = categoryName_ID;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public String getCategoryName1() {
		return categoryName1;
	}

	public void setCategoryName1(String categoryName1) {
		this.categoryName1 = categoryName1;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	

	public HttpServletRequest getServletRequest() {
		return servletRequest;
	}

	public void setServletRequest(HttpServletRequest servletRequest) {
		this.servletRequest = servletRequest;
	}

}
