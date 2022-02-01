package by.issoft.test_task.most_profit_product.dao;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import by.issoft.test_task.most_profit_product.bean.OrderItem;
import by.issoft.test_task.most_profit_product.bean.Product;

public class DAO_Impl implements DAO_Interface{
	
	@Override
	public Map<String, Product> getProducts() {
		
		Map<String, Product> result = new HashMap<>();
		
		try(BufferedReader reader = new BufferedReader(new FileReader("resources/products.csv"))) {	
			
			String line = reader.readLine();
			line = reader.readLine();
			
			while (line != null) {
				String id = line.split(",")[0];
				String name = line.split(",")[1];  
				int price = Integer.parseInt(line.split(",")[2]);				
				
				Product product = new Product(name, price);
				result.put(id, product);				
				line = reader.readLine();
			}
			
		} catch(IOException ex) {
			System.out.println("File access error products.csv!");
		}		
		
		return result;
	}

	@Override
	public Map<String, List<String>> getOrders() {
		
		Map<String, List<String>> result = new HashMap<>();	
		
		try(BufferedReader reader = new BufferedReader(new FileReader("resources/orders.csv"))) {
			
			String line = reader.readLine();
			line = reader.readLine();
			
			while (line != null) {				
				String idOrder = line.split(",")[0];
				String date = line.split(",")[1].substring(0, 10);  
				
				if (result.containsKey(date)) {
					List<String> listOrders = result.get(date);
					listOrders.add(idOrder);
					
				} else {
					List<String> listOrders = new ArrayList<>();
					listOrders.add(idOrder);
					result.put(date, new ArrayList<>(listOrders));
				}	
				line = reader.readLine();
			}
			
		} catch(IOException ex) {
			System.out.println("File access error orders.csv!");
		}
			
		return result;
	}

	@Override
	public Map<String, List<OrderItem>> getOrderItems() {
		
		Map<String, List<OrderItem>> result = new HashMap<>();
		Map<String, Product> products = getProducts();
		
		List<OrderItem> listOrderItems;
		Product product;
		OrderItem orderItem;
		
		try(BufferedReader reader = new BufferedReader(new FileReader("resources/order_items.csv"))) {	
			
			String line = reader.readLine();
			line = reader.readLine();
			
			while (line != null) {
				String idOrder = line.split(",")[0];
				String idProduct = line.split(",")[1];
				int quantity = Integer.parseInt(line.split(",")[2]);
				
				if (result.containsKey(idOrder)) {
					
					listOrderItems = result.get(idOrder);
					product = products.get(idProduct);
					orderItem = new OrderItem(product, quantity);
					listOrderItems.add(orderItem);
					
				} else {
					listOrderItems = new ArrayList<>();
					product = products.get(idProduct);
					orderItem = new OrderItem(product, quantity);
					
					listOrderItems.add(orderItem);
					result.put(idOrder, new ArrayList<>(listOrderItems));
				}									
				line = reader.readLine();
			}
			
		} catch(IOException ex) {
			System.out.println("File access error order_items.csv!");
		}
		
		return result;		
	}

}
