package in.packages;

import java.util.List;
import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import in.entities.*;

public class App {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Hello Spring JDBC!");
		String file_location = "/in/packages/config.xml";
		ApplicationContext context = new ClassPathXmlApplicationContext(file_location);

		Dao dao = context.getBean("studentDaoImpl", DaoImpl.class);

		// Insert Implementatoin Student
		Student std = new Student();
		std.setId(12);
		std.setName("Nehal");
		std.setCity("Lucknow");
		int result = dao.insert(std);
		System.out.println("Student Added:" + result);

		// Update implementation
		Student std1 = new Student();
		std1.setName("Umar");
		std1.setCity("Pune");
		std1.setId(34);
		int result1 = dao.change(std);
		System.out.println("Student updated Successfully..." + result1);

		// Delete Implementation System.out.println("Enter Id to delete student!");
		int a = sc.nextInt();
		int result2 = dao.delete(a);
		System.out.println("Student Deleted..." + result2);

		// Fetch by id implementation
		System.out.println("Enter ID to find Student!");
		int id = sc.nextInt();
		Student ref = dao.getStudent(id);
		System.out.println(ref);

		// Fetch All Implementation
		List<Student> student = dao.getAllStudent();
		for (Student s : student) {
			System.out.println(s);
		}

	}
}
