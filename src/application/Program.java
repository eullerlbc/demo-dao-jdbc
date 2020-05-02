package application;

import java.util.Date;
import java.util.List;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) {
		
		SellerDao sellerdao = DaoFactory.createSellerDao();
		
		System.out.println("=== Teste1: seller findById ===");
		Seller seller = sellerdao.findById(3);
		System.out.println(seller);
		
		System.out.println("\n=== Teste2: seller findByDepartment ===");
		Department department = new Department(2, null);
		List<Seller> list = sellerdao.findByDepartment(department);
		for(Seller obj : list) {
			System.out.println(obj);
		}
		
		System.out.println("\n=== Teste3: seller findAll ===");
		list = sellerdao.findAll();
		for(Seller obj : list) {
			System.out.println(obj);
		}
		
		System.out.println("\n=== Teste4: seller Insert ===");
		Seller newSeller = new Seller(null, "Greg", "greg@gmail.com", new Date(), 4000.0, department);
		sellerdao.insert(newSeller);
		System.out.println("Inserted! New ID = " + newSeller.getId());	
		
		System.out.println("\n=== Teste5: seller Update ===");
		seller = sellerdao.findById(1);
		seller.setName("Martha Wayne");
		sellerdao.update(seller);
		System.out.println("Update Completed");
	}
}
