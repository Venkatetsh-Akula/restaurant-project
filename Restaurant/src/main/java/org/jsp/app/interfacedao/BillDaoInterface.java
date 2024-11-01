package org.jsp.app.interfacedao;

import java.util.List;
import java.util.Optional;

import org.jsp.app.entity.RestaurantClass;

public interface BillDaoInterface {

	List<RestaurantClass> getAllOrdersDao();

	Optional<RestaurantClass> getBillById(int id);

	RestaurantClass saveBill(RestaurantClass rest);

	void deleteBillDao(int id);
	

}
