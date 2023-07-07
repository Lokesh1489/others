package com.softtek.service;

/**
 * 
 * @author sanjay.bannigol
 *
 */
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.softtek.entity.Customer;
import com.softtek.entity.Order;
import com.softtek.entity.Product;
import com.softtek.repo.CustomerRepo;
import com.softtek.repo.OrderRepo;
import com.softtek.repo.ProductRepo;

@Service
public class ShopService {

	@Autowired
	private CustomerRepo Consrepo;

	@Autowired
	private OrderRepo Odrepo;

	@Autowired
	private ProductRepo Prodrepo;

	public String insert(Order order) {
		List<Product> Plist = order.getProducts();
		Optional<Customer> Id = Consrepo.findById(order.getCustomer().getId());
		if (Id.isPresent()) {
			order.setCustomer(Id.get());
			order.setDeliveryDate(LocalDate.now().plusDays(2));
			order.setOrderDate(LocalDate.now());   
			order.setStatus("Ordered");
			List<Product> listOfProducts = new ArrayList<Product>();
			Plist.forEach(i -> listOfProducts.add(Prodrepo.findById(i.getProduct_id()).get()));
			order.setProducts(listOfProducts);
			Odrepo.save(order);
			return "Inserted succesfully";
		}
		return "Not inserted";
	}

	public List<Product> listOfProduct() {
		return Prodrepo.findAll();
	}

	public List<Order> listOfOrders() {
		return Odrepo.findAll();
	}

}
