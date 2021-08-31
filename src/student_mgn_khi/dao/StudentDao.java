package student_mgn_khi.dao;

import java.util.ArrayList;

import student_mgn_khi.dto.Student;

public interface StudentDao {
	ArrayList<Student> selectStudentByAll();
	Student selectStudentByNo(Student student);
	int insertStudent(Student student);
	int updateStudent(Student student);
	int deleteStudent(Student student);
	
}
