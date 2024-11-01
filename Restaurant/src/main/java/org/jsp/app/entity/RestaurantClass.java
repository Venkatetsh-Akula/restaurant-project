package org.jsp.app.entity;

import java.util.HashMap;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RestaurantClass {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String restName;
	private String address;
	private double bill;
	static HashMap<String, Integer> items;
	public static void main(String[] args) {
		items.put("staterd",150);
		items.put("biryani", 250);
		items.put("dessert",120);
		items.put("drink",70);
	}
}
