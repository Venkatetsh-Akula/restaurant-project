package org.jsp.app.service;

import java.util.List;
import java.util.Optional;

import org.jsp.app.entity.RestaurantClass;
import org.jsp.app.exception.InvalidDataException;
import org.jsp.app.exception.NoElementsFoundException;
import org.jsp.app.interfacedao.BillDaoInterface;
import org.jsp.app.interfaceservice.BillService;
import org.jsp.app.structure.ResponseStructure;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class BillConcreateService implements BillService{
	
	@Autowired
	private BillDaoInterface ibill;

	@Override
	public ResponseEntity<?> completeOrders() {
		List<RestaurantClass>  bli=ibill.getAllOrdersDao();
		if(bli.size()<=0) {
			throw NoElementsFoundException.builder().message("No Elements found").build();
		}
		else {
			return ResponseEntity.status(HttpStatus.OK.value()).body(ResponseStructure.builder().httpcode(HttpStatus.OK.value())
					.message("Bills Found").body(bli).build());
		}
	}

	
	@Override
	public ResponseEntity<?> orderById(int id) {
		Optional<RestaurantClass> or=ibill.getBillById(id);
		if(or.isEmpty()) {
			throw NoElementsFoundException.builder().message("No element Found Based on Given Id").build();
		}
		else {
			return ResponseEntity.status(HttpStatus.OK.value()).body(ResponseStructure.builder().httpcode(HttpStatus.OK.value())
					.message("This Elements Found Based On Given Id").body(or.get()).build());
		}
	}


	@Override
	public ResponseEntity<?> saveBillService(RestaurantClass rest) {
		if(rest.getAddress()==null && rest.getBill()<0) {
			throw InvalidDataException.builder().message("Invalid Data").build();
		}
		else {
			RestaurantClass sb=ibill.saveBill(rest);
			return ResponseEntity.status(HttpStatus.OK.value()).body(ResponseStructure.builder().httpcode(HttpStatus.OK.value())
					.message("Bill Saved").body(sb).build());
		}
	}


	@Override
	public ResponseEntity<?> deleteBillService(int id) {
		Optional<RestaurantClass> rbill=ibill.getBillById(id);
		if(id<=0 && rbill.isEmpty()) {
			throw InvalidDataException.builder().message("Invalid Data").build();
		}
		else {
			ibill.deleteBillDao(id);
			return ResponseEntity.status(HttpStatus.OK.value()).body(ResponseStructure.builder().httpcode(HttpStatus.OK.value())
					.message("Bill Deleted").body(rbill).build());
		}
	}


	@Override
	public ResponseEntity<?> updateBillService(int id, RestaurantClass rest) {
		Optional<RestaurantClass> rbill=ibill.getBillById(id);
		if(rbill.isEmpty()) {
			throw InvalidDataException.builder().message("No Data Found On Given Id").build();
		}
		else {
			RestaurantClass res= ibill.saveBill(rest);
			return ResponseEntity.status(HttpStatus.OK.value()).body(ResponseStructure.builder().httpcode(HttpStatus.OK.value())
					.message("Given Data Updated").body(res).build());
		}
	}
	
	

}
