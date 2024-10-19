package com.example.SpringJDBC.repo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.example.SpringJDBC.model.Student;

@Repository
public class StudentRepository {
	
	private JdbcTemplate jdbc;
	
	
	public JdbcTemplate getJdbc() {
		return jdbc;
	}
	@Autowired
	public void setJdbc(JdbcTemplate jdbc) {
		this.jdbc = jdbc;
	}

	public void save(Student st) {
		String sql="insert into student (rollno,name,marks) values (?,?,?)";
		int rows=jdbc.update(sql,st.getRollNo(),st.getName(),st.getMarks());
		System.out.println(rows+" affected");
	}

	public List<Student> findAll() {
		String sql="select * from student";
		
		RowMapper<Student> mapper=(rs,rowNum) -> {
				Student s= new Student();
				s.setRollNo(rs.getInt("rollno"));
				s.setName(rs.getString("name"));
				s.setMarks(rs.getInt("marks"));
				return s;
		};
		
		return jdbc.query(sql, mapper);
	}

}
