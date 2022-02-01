package by.issoft.test_task.most_profit_product.main;

import by.issoft.test_task.most_profit_product.service.Service_Impl;

public class Main {
	
	public static void main(String[] args) {

		Service_Impl service = new Service_Impl();

		String day = "2021-01-21";
		System.out.println("Most profit product by " + day + ": " + service.mostProfitProductByDay(day));		
	}

}



