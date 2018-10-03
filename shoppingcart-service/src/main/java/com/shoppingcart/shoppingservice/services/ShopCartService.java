package com.shoppingcart.shoppingservice.services;

import java.lang.reflect.InvocationTargetException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.salesmanager.core.model.customer.Customer;
import com.shoppingcart.shoppingservice.entities.ShoppingCart;
import com.shoppingcart.shoppingservice.entities.ShoppingCartItem;
import com.shoppingcart.shoppingservice.repository.ShoppingCartRepository;
import com.shoppingcart.shoppingservice.support.entities.ShoppingCartResponse;

@Service
public class ShopCartService {

	@Autowired
	private ShoppingCartRepository shoppingCartRepository;

	public List<ShoppingCart> getAllShoppingcart() {
		return shoppingCartRepository.findAll();
	}

	public ShoppingCart getShoppingcartById(Long id) {
		return shoppingCartRepository.findByCustomer(id);
	}

	public ShoppingCart getShoppingCart(final Customer customer) {

		return shoppingCartRepository.findByCustomer(customer.getId());

	}

	public  ShoppingCartResponse  getShoppingcartByCode(int id, String code) {
		ShoppingCartResponse response = null;
//		try {
//			BeanUtils.copyProperties(cart, shoppingCartRepository.findByCode(id, code));
//			cart.getLineItems();
//		} catch (IllegalAccessException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (InvocationTargetException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		ShoppingCart cart = shoppingCartRepository.findByCode(id, code);
		 Set<ShoppingCartItem> lineItems = new HashSet<ShoppingCartItem>();
//		ShoppingCart response = new ShoppingCart();
		if (null != cart) {
			response = new ShoppingCartResponse();
			response.setId(cart.getId());
			 
			response.setAuditSection(cart.getAuditSection());
			response.setCustomerId(cart.getCustomerId());
			lineItems =cart.getLineItems();
			response.setLineItems(lineItems);
			response.setMerchantStore(cart.getMerchantStore());
			response.setShoppingCartCode(cart.getShoppingCartCode());
		}
		return response;
	}

}
