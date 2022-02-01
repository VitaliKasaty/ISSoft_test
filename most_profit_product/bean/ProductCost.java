package by.issoft.test_task.most_profit_product.bean;

import java.io.Serializable;

public class ProductCost implements Serializable{
	
	private static final long serialVersionUID = 692335406042254723L;
	
	private Product product;
	private int totalQuantity = 0;
		
	
	public ProductCost() {		
	}
	
	public ProductCost(Product product) {		
		this.product = product;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public int getTotalQuantity() {
		return totalQuantity;
	}

	public void addTotalQuantity(int totalQuantity) {
		this.totalQuantity += totalQuantity;
	}
	
	public int getTotalPrice() {
		
		return product.getPrice() * totalQuantity;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((product == null) ? 0 : product.hashCode());
		result = prime * result + totalQuantity;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ProductCost other = (ProductCost) obj;
		if (product == null) {
			if (other.product != null)
				return false;
		} else if (!product.equals(other.product))
			return false;
		if (totalQuantity != other.totalQuantity)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ProductCost [product=" + product + ", totalQuantity=" + totalQuantity + "]";
	}	

}
