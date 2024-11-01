package org.jsp.app.dao;

import java.util.List;
import java.util.Optional;

import org.jsp.app.entity.RestaurantClass;
import org.jsp.app.interfacedao.BillDaoInterface;
import org.jsp.app.repository.BillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class BillDao implements BillDaoInterface {
	
	@Autowired
	private BillRepository billrepo;

	@Override
	public List<RestaurantClass> getAllOrdersDao() {
		return billrepo.findAll();
	}

	@Override
	public Optional<RestaurantClass> getBillById(int id) {
		return billrepo.findById(id);
	}

	@Override
	public RestaurantClass saveBill(RestaurantClass rest) {
		return billrepo.save(rest);
	}

	@Override
	public void deleteBillDao(int id) {
		billrepo.deleteById(id);
	}

}
