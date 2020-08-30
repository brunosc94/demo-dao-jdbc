package application;

import java.util.Date;

import model.entities.Department;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) {


		Department d = new Department(10, "RH");
		Seller s = new Seller(1, "Bruno", "bruno@hotmail.com", new Date(),2000.00, d);
		System.out.println(s);

	}

}
