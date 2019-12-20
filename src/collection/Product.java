package collection;

public class Product {
		
	private String productID;
	private String productName;
	private String productPrice;
	
	Product(){}
	Product(String id,String name,String price){
		productID=id;
		productName=name;
		productPrice=price;
	}
	
	public int hashCode() {
		return productID.hashCode();
	}
	public boolean equals(Object obj) {
		if(obj!=null && obj instanceof Product) {
			Product p=(Product) obj;
			if(productID.equals(p.getProductID())) {
				return true;
			}
		}
		return false;
	}
	public String getProductID() {
		return productID;
	}
	public String getProductName() {
		return productName;
	}
	public String getProductPrice() {
		return productPrice;
	}
	public void setProductID(String productID) {
		this.productID = productID;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public void setProductPrice(String productPrice) {
		this.productPrice = productPrice;
	}
}
