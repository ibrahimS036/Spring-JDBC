package in.packages2;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import in.entities.Dao;
import in.entities.DaoImpl;
import in.packages.Student;

public class App {

	public static void main(String[] args) {
		System.out.println("Hello Spring JDBC....");
		ApplicationContext context = new AnnotationConfigApplicationContext(javaConfiguration.class);
		DaoImpl dao = context.getBean("getStudentDao", DaoImpl.class); // Adjust the type to DaoImpl

		List<Student> students = dao.getAllStudent();
		for (Student s : students) {
			System.out.println(s);
		}
	}
}
