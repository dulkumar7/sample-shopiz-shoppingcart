package com.shoppingcart.shoppingservice.restcontrollers;

import java.util.List;

import org.codehaus.jackson.map.SerializationConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.google.gson.Gson;
import com.salesmanager.core.model.customer.Customer;
import com.shoppingcart.shoppingservice.entities.ShoppingCart;
import com.shoppingcart.shoppingservice.services.ShopCartService;
import com.shoppingcart.shoppingservice.support.entities.ShoppingCartResponse;

import lombok.extern.java.Log;
import lombok.extern.log4j.Log4j;
import lombok.extern.slf4j.Slf4j;

@RestController("/shoppingcart")
public class ShoppingcartRestController {
	
	@Autowired 
	ObjectMapper objectMapper;
	
	@Autowired
	private ShopCartService shopCartService;
	
	@RequestMapping(value="/shoppingcart", method=RequestMethod.GET)
	public String getAll() {
		
		List<ShoppingCart> value1 = shopCartService.getAllShoppingcart();
		try {
			return objectMapper.writeValueAsString(value1);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "";
		//return shopCartService.getAllShop();
		}
	
	/*@RequestMapping(value="/shoppingcart/{id}", method=RequestMethod.GET)
//	//@GetMapping("shoppingcart/{id}", )
	public String getById(@PathVariable(value ="id") long id) {
		ShoppingCart value = shopCartService.getShoppingcartById(id);
		try {
			return objectMapper.writeValueAsString(value);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "";
	}
	
	
	@RequestMapping(value="/shoppingcart/{id}", method=RequestMethod.GET)
	//@GetMapping("shoppingcart/{id}", )
	public String getShoppingCart(@PathVariable(value ="id") long id) {
		Customer customer = new Customer();
		ShoppingCart value = shopCartService.getShoppingCart(customer);
		try {
			return objectMapper.writeValueAsString(value);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "";
	}
	*/
	
	@RequestMapping(value="/shoppingcart/{id}/{code}", method=RequestMethod.GET)
	
	//@GetMapping("shoppingcart/{id}", )
	public ShoppingCartResponse getShoppingCartByCode(@PathVariable(value ="id") int id, @PathVariable(value ="code") String code) {
		return shopCartService.getShoppingcartByCode(id, code);
//		if(null != value) {
//			ObjectMapper mapper = new ObjectMapper();
//			mapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
//			try {
//				return mapper.writeValueAsString(value);
//			} catch (JsonProcessingException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}
//		return "";
	}
	
	

	
	
}