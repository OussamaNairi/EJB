package tn.essat.service;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateful;

import tn.essat.dto.Productdto;

@Stateful
@LocalBean
public class ShopService {
	@EJB
	CalculatriceService calculatriceService;
	
	private List<Productdto> products = new ArrayList<>();
	private double total;

	public void add(Productdto product) {
		products.add(product);
	}

	public List<Productdto> listProducts() {
		return products;
	}
	public void delete(int index) {
		products.remove(index);
	}
	public void update(Productdto updateProduct,int index) {
		products.set(index,updateProduct);
		
	}
	
	public double getTotal() {
		
		total=0;
		for(Productdto p:products) {
			total=calculatriceService.add(total, calculatriceService.mult(p.getQuantity(), p.getPrice()));
			
		}
		return total;
	}
}
