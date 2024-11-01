package org.jsp.app.controller;

import org.jsp.app.entity.RestaurantClass;
import org.jsp.app.interfaceservice.BillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/bill")
public class RestaurantController {
	@Autowired
	private BillService sbill;
	@GetMapping
	public ResponseEntity<?> getorder(){
		return sbill.completeOrders();
	}
	@GetMapping(value = "/{id}")
	public ResponseEntity<?> getOrderById(@PathVariable int id){
		return sbill.orderById(id);
	}
	@PostMapping
	public ResponseEntity<?> saveBill(@RequestBody RestaurantClass rest){
		return sbill.saveBillService(rest);
	}
	@DeleteMapping(value="/{id}")
	public ResponseEntity<?> deleteBill(@PathVariable int id){
		return sbill.deleteBillService(id);
	}
	@PutMapping(value="/{id}")
	public ResponseEntity<?> updateBill(@PathVariable int id,@RequestBody RestaurantClass rest){
		return sbill.updateBillService(id,rest);
	}

}
