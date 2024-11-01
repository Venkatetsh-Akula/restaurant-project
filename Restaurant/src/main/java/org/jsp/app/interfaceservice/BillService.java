package org.jsp.app.interfaceservice;

import org.jsp.app.entity.RestaurantClass;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


public interface BillService {

	ResponseEntity<?> completeOrders();

	ResponseEntity<?> orderById(int id);

	ResponseEntity<?> saveBillService(RestaurantClass rest);

	ResponseEntity<?> deleteBillService(int id);

	ResponseEntity<?> updateBillService(int id, RestaurantClass rest);

}
