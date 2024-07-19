package in.entities2;

import java.util.List;

import in.packages.Student;

public interface Dao {

	public int insert(Student student);

	public int change(Student student);

	public int delete(int sId);

	public Student getStudent(int sId);

	public List<Student> getAllStudent();

}
