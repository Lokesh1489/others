package com.softtek.controller;
/**
 * 
 * @author sanjay.bannigol
 *
 */
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.softtek.entity.Order;
import com.softtek.service.ShopService;

@RestController
@RequestMapping("/order")
public class Controller {

	@Autowired
	private ShopService service;

	@PostMapping("/order")
	public ResponseEntity<String> insertOrderRecord(@RequestBody Order order) {
		try {
			String msg = service.insert(order);
			return new ResponseEntity<String>(msg, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>("Order is not Inserted", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
