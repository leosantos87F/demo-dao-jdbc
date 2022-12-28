package application;

import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;

public class Program2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		DepartmentDao departmentDao = DaoFactory.createDepartmentDao();

		System.out.println("=== TEST 1: DEPARTMENT findById =====");
		Department dep = departmentDao.findById(2);
		System.out.println("Department has been found: " + dep);
		System.out.println();

		System.out.println("=== TEST 2: DEPARTMENT findAll =====");
		List<Department> list = departmentDao.findAll();
		System.out.println("List of Departments: ");
		for (Department department : list) {
			System.out.println(department);
		}
		
		System.out.println();
		System.out.println("====TEST 4 : DEPARTMENT insert =======");
		dep = new Department(12, "Quality");
		departmentDao.insert(dep);
		System.out.println("(insert).A new department has been added. Insert completed. id = " + dep.getId() + ", Name = " + dep.getName());
		System.out.println();

		System.out.println("=== TEST 5: DEPARTMENT update =====");
		dep = departmentDao.findById(7);
		dep.setName("A4");
		departmentDao.update(dep);
		System.out.println("(update). A department has been updated. Update completed. " + dep);
		System.out.println();
		
		System.out.println("=== TEST 6: DEPARTMENT delete =====");
		System.out.print("(delete). Enter id department to remove: ");
		int id = sc.nextInt();
		departmentDao.deleteById(id);
		System.out.println("(delete). A department has been removed. Delete completed. ");
		
		
		sc.close();

	}

}
