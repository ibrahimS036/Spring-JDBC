package in.packages2;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import in.entities.Dao;
import in.entities.DaoImpl;

@Configuration
@ComponentScan(basePackages = {"in.entities2"})
public class javaConfiguration {

	@Bean
	public DataSource getDataSource() {
		DriverManagerDataSource ds = new DriverManagerDataSource();
		ds.setDriverClassName("com.mysql.cj.jdbc.Driver");
		ds.setUrl("jdbc:mysql://localhost:3306/springjdbc");
		ds.setUsername("root");
		ds.setPassword("goodtogo");
		return ds;
	}

	@Bean
	public JdbcTemplate getTemplate() {
		JdbcTemplate temp = new JdbcTemplate();
		temp.setDataSource(getDataSource());
		return temp;
	}

	@Bean
	public Dao getStudentDao() {
		DaoImpl ref = new DaoImpl();
		ref.setJdbctemp(getTemplate());
		return ref;

	}

}
