package student_mgn_khi.dao;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import student_mgn_khi.dto.Student;
import student_mgn_khi.impl.StudentDaoImpl;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class StudentDaoTest {
	private StudentDao dao = StudentDaoImpl.getInstance();

	@After
	public void tearDown() throws Exception {
		System.out.println();
	}

	@Test
	public void test01SelectStudentByAll() {
		System.out.println("testSelectStudentByAll()");
		ArrayList<Student> list = dao.selectStudentByAll();
		Assert.assertNotEquals(0, list.size());
		list.stream().forEach(System.out::println);
	}

	@Test
	public void test02SelectStudentByNo() {
		System.out.println("testSelectStudentByNo()");
		Student selectStd = dao.selectStudentByNo(new Student(1002));
		Assert.assertNotNull(selectStd);
		System.out.println(selectStd);
		
	}

	@Test
	public void test03InsertStudent() {
		System.out.println("testInsertStudent()");
		Student newStd = new Student(1003, "이가은", 70, 66, 80);
		int res = dao.insertStudent(newStd);
		Assert.assertEquals(1, res);
		test01SelectStudentByAll();
		
//		dao.deleteStudent(newStd);
	}

	@Test
	public void test04UpdateStudent() {
		System.out.println("testUpdateStudent()");
		Student selectedstd = dao.selectStudentByNo(new Student(1003));
		selectedstd.setKor(50);
		
		int res = dao.updateStudent(selectedstd);
		Assert.assertEquals(1, res);
		test01SelectStudentByAll();
		
	}

	@Test
	public void test05DeleteStudent() {
		System.out.println("testDeleteStudent()");
		int res = dao.deleteStudent(new Student(1003));
		Assert.assertEquals(1, res);
		test01SelectStudentByAll();
	}

}
