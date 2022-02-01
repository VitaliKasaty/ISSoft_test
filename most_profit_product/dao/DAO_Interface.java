package by.issoft.test_task.most_profit_product.dao;

import java.util.List;
import java.util.Map;

import by.issoft.test_task.most_profit_product.bean.OrderItem;
import by.issoft.test_task.most_profit_product.bean.Product;

public interface DAO_Interface {
	
	Map<String, Product> getProducts();
	Map<String, List<String>> getOrders();
	Map<String, List<OrderItem>> getOrderItems();
	
}
