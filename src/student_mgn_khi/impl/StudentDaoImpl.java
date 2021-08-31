package student_mgn_khi.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import student_mgn_khi.dao.StudentDao;
import student_mgn_khi.dto.Student;
import student_mgn_khi.util.JdbcUtil;

public class StudentDaoImpl implements StudentDao {
	private static final StudentDaoImpl instance = new StudentDaoImpl();
	
	public static StudentDaoImpl getInstance() {
		return instance;
	}

	private StudentDaoImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public ArrayList<Student> selectStudentByAll() {
		String sql = "select stdno, stdname, kor, eng, math from student";
		ArrayList<Student> list = null;
		try(Connection con = JdbcUtil.getConnection();
			PreparedStatement pstmt = con.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery()){
			list = new ArrayList<Student>();
			while(rs.next()) {
				list.add(getStudent(rs));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public Student selectStudentByNo(Student student) {
		String sql = "select stdno, stdname, kor, eng, math from student where stdno = ?";
		try(Connection con = JdbcUtil.getConnection();
			PreparedStatement pstmt = con.prepareStatement(sql);) {
			pstmt.setInt(1, student.getStdNo());
			try(ResultSet rs = pstmt.executeQuery()){
				if(rs.next()) {
					return getStudent(rs);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	private Student getStudent(ResultSet rs) throws SQLException {
		int stdNo = rs.getInt("stdno");
		String stdName = rs.getString("stdname");
		int kor = rs.getInt("kor");
		int eng = rs.getInt("eng");
		int math = rs.getInt("math");
		
		return new Student(stdNo, stdName, kor, eng, math);
	}

	@Override
	public int insertStudent(Student student) {
		String sql = "insert into student values(?, ?, ?, ?, ?)";
		try(Connection con = JdbcUtil.getConnection();
			PreparedStatement pstmt = con.prepareStatement(sql);){
			pstmt.setInt(1, student.getStdNo());
			pstmt.setString(2, student.getStdName());
			pstmt.setInt(3, student.getKor());
			pstmt.setInt(4, student.getEng());
			pstmt.setInt(5, student.getMath());
			return pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int updateStudent(Student student) {
		String sql = "update student set kor = ? where stdno = ?";
		try(Connection con = JdbcUtil.getConnection();
			PreparedStatement pstmt = con.prepareStatement(sql)){
			pstmt.setInt(1, student.getKor());
			pstmt.setInt(2, student.getStdNo());
			return pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int deleteStudent(Student student) {
		String sql = "delete from student where stdno = ?";
		try(Connection con = JdbcUtil.getConnection();
			PreparedStatement pstmt = con.prepareStatement(sql)){
			pstmt.setInt(1, student.getStdNo());
			return pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

}
