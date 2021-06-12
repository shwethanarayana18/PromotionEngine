package com.test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.main.Product;
import com.main.PromotionEngine;


/**
 * @author Shwetha
 * Test class of PromotionEngine to execute different  discount scenarios
 */
class PromortionEngineTest {
	PromotionEngine promotionEngine=new PromotionEngine();
	@Test
	void testGetTotalPrice() {
		 // creating an arraylist for scenario 1
		List<Product> scenario1List = new ArrayList<>();
		scenario1List.add(new Product("A",1));
		scenario1List.add(new Product("B",1));
		scenario1List.add(new Product("C",1));
		assertEquals(100,promotionEngine.getTotalPrice(scenario1List));  
		
		// creating an arraylist for scenario 2
		List<Product> scenario2List = new ArrayList<>();
		scenario2List.add(new Product("A",5));
		scenario2List.add(new Product("B",5));		
		scenario2List.add(new Product("C",1));		
		assertEquals(370,promotionEngine.getTotalPrice(scenario2List));  
		
		// creating an arraylist for scenario 3
		List<Product> scenario3List = new ArrayList<>();
		scenario3List.add(new Product("A",3));
		scenario3List.add(new Product("B",5));
		scenario3List.add(new Product("C",1));
		scenario3List.add(new Product("D",1));
		assertEquals(280,promotionEngine.getTotalPrice(scenario3List)); 
		
	}

}
