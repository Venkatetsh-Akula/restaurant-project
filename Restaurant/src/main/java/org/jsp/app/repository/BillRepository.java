package org.jsp.app.repository;

import org.jsp.app.entity.RestaurantClass;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BillRepository extends JpaRepository<RestaurantClass, Integer>{

}
