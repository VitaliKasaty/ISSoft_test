package by.issoft.test_task.most_profit_product.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import by.issoft.test_task.most_profit_product.bean.OrderItem;
import by.issoft.test_task.most_profit_product.bean.Product;
import by.issoft.test_task.most_profit_product.bean.ProductCost;
import by.issoft.test_task.most_profit_product.dao.DAO_Impl;
import by.issoft.test_task.most_profit_product.dao.DAO_Interface;

public class Service_Impl implements Service_Interface{
	
	DAO_Interface dao = new DAO_Impl();

	@Override
	public String mostProfitProductByDay(String day) {			
		
		String nameResult = "";		
		int maxSum = 0;				
		List<ProductCost> soldProducts = getSoldProductsByDay(day);
		
		for (int i = 0; i < soldProducts.size(); i++) {
			if (soldProducts.get(i).getTotalPrice() > maxSum) {
				nameResult = soldProducts.get(i).getProduct().getName();
				maxSum = soldProducts.get(i).getTotalPrice();
			}			
		}		
		return nameResult;
	}	

	@Override
	public List<ProductCost> getSoldProductsByDay(String day) {
		
		List<ProductCost> productsCostList = new ArrayList<>();
		Map<String, List<String>> ordersFull = getOrders();
		Map<String, List<OrderItem>> orderItemsFull = getOrderItems();		
		ProductCost productCost = null;	
		List<String> ordersByDay = ordersFull.get(day);
		
		for (int i = 0; i < ordersByDay.size(); i++) {
			
			List<OrderItem> orderItems = orderItemsFull.get(ordersByDay.get(i));

			for (int j = 0; j < orderItems.size(); j++) {

				Product product = orderItems.get(j).getProduct();
				int quantity = orderItems.get(j).getQuantity();
				
				if (productsCostList.isEmpty()) {					
					productCost = new ProductCost();
					productCost.setProduct(product);
					productCost.addTotalQuantity(quantity);
					productsCostList.add(productCost);	
					
				} else {
					
					boolean contains = productsCostList.stream().anyMatch(p -> p.getProduct().equals(product));
					
					if (contains) {						
						productCost = productsCostList.stream().filter(p -> p.getProduct().equals(product)).findFirst().get();
						productCost.addTotalQuantity(quantity);	
						
					} else {						
						productCost = new ProductCost();
						productCost.setProduct(product);
						productCost.addTotalQuantity(quantity);
						productsCostList.add(productCost);	
					}
				}			
			}			
		}		

		return productsCostList;
	}	
	
	@Override
	public Map<String, Product> getProducts() {		
		return dao.getProducts();
	}

	@Override
	public Map<String, List<String>> getOrders() {		
		return dao.getOrders();
	}

	@Override
	public Map<String, List<OrderItem>> getOrderItems() {		
		return dao.getOrderItems();
	}

}
