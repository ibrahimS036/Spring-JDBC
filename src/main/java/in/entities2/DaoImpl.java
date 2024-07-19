package in.entities2;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import in.packages.Student;

@Component
public class DaoImpl implements Dao {

	@Autowired
	private JdbcTemplate jdbctemp;

	// insert query

	@Override
	public int insert(Student student) {
		String query = "insert into student (id,name,city) values(?,?,?)";
		int result = jdbctemp.update(query, 2, student.getId(), student.getName(), student.getCity());
		return result;
	}

	// Update query

	@Override
	public int change(Student student) {
		String query = "update student set name=?, city=? where id=?";
		int result = jdbctemp.update(query, student.getName(), student.getCity(), student.getId());
		return result;
	}

	// delete query

	@Override
	public int delete(int sId) {
		String query = "delete from student where id=?";
		int result = jdbctemp.update(query, sId);
		return result;
	}

	// Fetch query by id

	@Override
	public Student getStudent(int sId) {
		String query = "select * from student where id=?";
		RowMapper<Student> rowMapper = new RowMapperImpl();
		Student student = jdbctemp.queryForObject(query, rowMapper, sId);
		return student;
	}

	// Fetch all query
	@Override
	public List<Student> getAllStudent() {
		String query = "select * from student";
		List<Student> list = jdbctemp.query(query, new RowMapperImpl());
		return list;
	}

	// getter setter
	public JdbcTemplate getJdbctemp() {
		return jdbctemp;
	}

	public void setJdbctemp(JdbcTemplate jdbctemp) {
		this.jdbctemp = jdbctemp;
	}

}
