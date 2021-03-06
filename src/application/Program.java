package application;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		SellerDao sellerDao = DaoFactory.createSellerDao();
		
		System.out.println("==== TEST 1: Seller findById ====");
		Seller seller = sellerDao.findById(3);
		System.out.println(seller);
		
		System.out.println();
		System.out.println("==== TEST 2: Seller findByDepartment ====");
		Department department = new Department(2, null);
		List<Seller> list = sellerDao.findByDepartment(department);
		for(Seller s : list) {
			System.out.println(s);
		}
		
		System.out.println();
		System.out.println("==== TEST 3: Seller findAll ====");
		list = sellerDao.findAll();
		for(Seller s : list) {
			System.out.println(s);
		}
		
		System.out.println();
		System.out.println("==== TEST 4: Seller insert ====");
		Seller newSeller = new Seller(null, "Greg", "greg@gmail.com", new Date(), 4000.00, department);
		sellerDao.insert(newSeller);
		System.out.println("Inserted! New id = " + newSeller.getId());
		
		System.out.println();
		System.out.println("==== TEST 5: Seller update ====");
		seller = sellerDao.findById(1);
		seller.setName("Martha Waine");
		sellerDao.update(seller);
		System.out.println("Update completed! " + seller);
		
		System.out.println();
		System.out.println("==== TEST 6: Seller delete ====");
		System.out.print("Informe o ID a ser deletado: ");
		int id = sc.nextInt();
		sellerDao.deleById(id);
		System.out.println("Deleted complete!");	
		sc.close();
	}

}
