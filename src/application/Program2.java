package application;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;

public class Program2 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		DepartmentDao departmentDao = DaoFactory.createDepartamentDao();
		
		System.out.println("==== TEST 1: Department findById ====");
		Department department = departmentDao.findById(3);
		System.out.println(department);
		
		System.out.println();
		System.out.println("==== TEST 2: Department findAll ====");
		List<Department> list = departmentDao.findAll();
		for(Department s : list) {
			System.out.println(s);
		}
		
		System.out.println();
		System.out.println("==== TEST 3: Department insert ====");
		Department newDepartment = new Department(null, "Sounds");
		departmentDao.insert(newDepartment);
		System.out.println("Inserted! New id = " + newDepartment.getId());
		
		System.out.println();
		System.out.println("==== TEST 4: Department update ====");
		department = departmentDao.findById(1);
		department.setName("RH");
		departmentDao.update(department);
		System.out.println("Update completed! " + department);
		
		System.out.println();
		System.out.println("==== TEST 5: Department delete ====");
		System.out.print("Informe o ID a ser deletado: ");
		int id = sc.nextInt();
		departmentDao.deleById(id);
		System.out.println("Deleted complete!");	
		sc.close();
	}

}
