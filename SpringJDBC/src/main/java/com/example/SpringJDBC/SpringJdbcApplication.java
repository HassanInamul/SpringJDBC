package com.example.SpringJDBC;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.example.SpringJDBC.model.Student;
import com.example.SpringJDBC.service.StudentService;

@SpringBootApplication
public class SpringJdbcApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(SpringJdbcApplication.class, args);
		Student st= context.getBean(Student.class);
		st.setRollNo(104);
		st.setName("Mohana");
		st.setMarks(89);
		StudentService service= context.getBean(StudentService.class);
		//service.addStudent(st);
		
		List<Student> students=service.getAllStudents();
		System.out.println(students);
	}

}
