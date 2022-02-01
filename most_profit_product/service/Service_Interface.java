package by.issoft.test_task.most_profit_product.service;

import java.util.List;
import java.util.Map;

import by.issoft.test_task.most_profit_product.bean.OrderItem;
import by.issoft.test_task.most_profit_product.bean.Product;
import by.issoft.test_task.most_profit_product.bean.ProductCost;

public interface Service_Interface {	
	
	Map<String, Product> getProducts();
	Map<String, List<String>> getOrders();
	Map<String, List<OrderItem>> getOrderItems();
	List<ProductCost> getSoldProductsByDay(String day);
	String mostProfitProductByDay(String day);
	
}
