package by.issoft.test_task.most_profit_product.bean;

import java.io.Serializable;

public class OrderItem implements Serializable{	
	
	private static final long serialVersionUID = -8712504337517510696L;
	
	private Product product;
	private int quantity ;
	
	public OrderItem() {		
	}

	public OrderItem(Product product, int quantity) {		
		this.product = product;
		this.quantity = quantity;
	}	

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((product == null) ? 0 : product.hashCode());
		result = prime * result + quantity;
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
		OrderItem other = (OrderItem) obj;
		if (product == null) {
			if (other.product != null)
				return false;
		} else if (!product.equals(other.product))
			return false;
		if (quantity != other.quantity)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "OrderItem [product=" + product + ", quantity=" + quantity + "]";
	}

}
