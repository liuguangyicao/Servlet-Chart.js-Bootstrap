package dao;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bean.StudentMessage;
import utils.DBconn;
import utils.GetDateFormat;
public class StudentDao {
	public StudentMessage queryStudentMessage(String id)  {
		String sql = "SELECT * FROM mdl_user WHERE id = '" + id + "';";
		DBconn dbconn = new DBconn();
		ResultSet rst = null;
		StudentMessage studentmessage = new StudentMessage();
		rst = dbconn.doSelect(sql);
		try {
			if(rst.next()) {
				studentmessage.setUsername(rst.getString("username"));
				studentmessage.setFirstname(rst.getString("firstname"));
				studentmessage.setLastname(rst.getString("lastname"));
				studentmessage.setEmail(rst.getString("email"));
				studentmessage.setDescription(rst.getString("description"));
				studentmessage.setCity(rst.getString("city"));
				studentmessage.setCountry(rst.getString("country"));
			} 
		} catch(SQLException ex) {	
		}
		try {
			dbconn.close(rst);
		} catch(Exception ex) {	
		}
		return studentmessage;
	}
	
//	public void updateStudentMessage(StudentMessage studentmessage)  {
//		String sql = "UPDATE student_message SET name = '" + studentmessage.getName() + "',age = "
//	+ studentmessage.getAge()+",sexy =" + studentmessage.getSexy() + " WHERE student_id = '"+studentmessage.getStudentId()+"';";
//		DBconn dbconn = new DBconn();
//		ResultSet rst = null;
//		dbconn.doInsert(sql);
//		try {
//			dbconn.close(rst);
//		} catch(Exception ex) {	
//		}
//	}
//	public void updatePassword(Register student)  {
//		String sql = "UPDATE student_username_password SET password = '" + student.getPassword() + "' WHERE student_id = '" 
//	+ student.getUsername()+"';";
//		//System.out.println(sql);
//		DBconn dbconn = new DBconn();
//		ResultSet rst = null;
//		dbconn.doInsert(sql);
//		try {
//			dbconn.close(rst);
//		} catch(Exception ex) {	
//		}
//	}
//	public StudentClass queryStudentClass(String username)  {
//		String sql = "SELECT * FROM student_class WHERE student_id = '" + username + "';";
//		DBconn dbconn = new DBconn();
//		ResultSet rst = null;
//		StudentClass studentclass = new StudentClass();
//		rst = dbconn.doSelect(sql);
//		try {
//			if(rst.next()) {
//				studentclass.setStudent_id(rst.getString("student_id"));
//				studentclass.setAcademy(rst.getString("academy"));
//				studentclass.setDepartment(rst.getString("department"));
//				studentclass.setMajor(rst.getString("major"));
//				studentclass.setClass_name(rst.getString("major")+rst.getString("grade")+rst.getString("class_id"));
//			}
//		} catch(SQLException ex) {	
//		}
//		try {
//			dbconn.close(rst);
//		} catch(Exception ex) {	
//		}
//		return studentclass;
//	}
	public String queryStudentMonth(String id)  {
		String sql = "SELECT timecreated FROM mdl_user WHERE id = '" + id +"';";
		DBconn dbconn = new DBconn();
		ResultSet rst = null;
		String month = null;
		rst = dbconn.doSelect(sql);
		try {
			if(rst.next()) {
				String time = GetDateFormat.getDateFormat(Long.parseLong(rst.getString("timecreated")));
				month = time.substring(5, 7);
			}
		} catch(SQLException ex) {	
		}
		try {
			dbconn.close(rst);
		} catch(Exception ex) {	
		}
		return month;
	}
	public List<String> queryStudentPost(String id)  {
		String sql = "SELECT created FROM mdl_forum_posts WHERE userid= '" + id + "';";
		DBconn dbconn = new DBconn();
		ResultSet rst = null;
		List<String> studentPost = new ArrayList<String>( );
		rst = dbconn.doSelect(sql);
		try {
			while(rst.next()) {
				String tmp = GetDateFormat.getDateFormat(Long.parseLong(rst.getString("created")));
				studentPost.add(tmp);
			}
		} catch(SQLException ex) {	
		}
		try {
			dbconn.close(rst);
		} catch(Exception ex) {	
		}
	return studentPost;
	}
	public Double queryStudentRawGrade(String id)  {
		String sql = "SELECT rawgrade FROM mdl_grade_grades WHERE userid= '" + id + "';";
		DBconn dbconn = new DBconn();
		ResultSet rst = null;
		String grade = null;
		rst = dbconn.doSelect(sql);
		try {
			if(rst.next()) {
				grade = rst.getString("rawgrade");
			
			}
		} catch(SQLException ex) {	
		}
		try {
			dbconn.close(rst);
		} catch(Exception ex) {	
		}
	if(grade == null) {
		return 0.0;
	}
	return Double.parseDouble(grade);
	}
	public List<String> queryStudentLogin(String id)  {
		String sql = "SELECT timeend  FROM mdl_stats_user_monthly WHERE userid= '" + id + "';";
		String sql2 = "SELECT timeend  FROM mdl_stats_user_weekly WHERE userid= '" + id + "';";
		DBconn dbconn = new DBconn();
		ResultSet rst = null;
		List<String> studentPost = new ArrayList<String>( );
		rst = dbconn.doSelect(sql);
		try {
			while(rst.next()) {
				String tmp = GetDateFormat.getDateFormat(Long.parseLong(rst.getString("timeend")));
				studentPost.add(tmp);
			}
		} catch(SQLException ex) {	
		}
		rst = dbconn.doSelect(sql2);
		try {
			while(rst.next()) {
				String tmp = GetDateFormat.getDateFormat(Long.parseLong(rst.getString("timeend")));
				studentPost.add(tmp);
			}
		} catch(SQLException ex) {	
		}
		try {
			dbconn.close(rst);
		} catch(Exception ex) {	
		}
	return studentPost;
	}
//	public void adminAddClass(StudentClass studentclass, AdminClass adminclass)  {
//		String sql = "INSERT INTO student_class(student_id, academy, department, major, class_id, grade) values('" + studentclass.getStudent_id() + "','"
//	+ studentclass.getAcademy()+"','" + studentclass.getDepartment() + "','"+studentclass.getMajor()+"',"+ adminclass.getClass_id()+","+adminclass.getGrade()+");";
//		String sql2= "INSERT INTO student_username_password(student_id, password) values('"+ studentclass.getStudent_id() + "','"+ studentclass.getStudent_id()+"');";
//		//System.out.println(sql2);
//		//System.out.println(sql);
//		DBconn dbconn = new DBconn();
//		ResultSet rst = null;
//		dbconn.doInsert(sql);
//		dbconn.doInsert(sql2);
//		try {
//			dbconn.close(rst);
//		} catch(Exception ex) {	
//		}
//	}
//	public void adminUpdateClass(StudentClass studentclass, AdminClass adminclass)  {
//		String sql = "UPDATE student_class SET academy = '" + studentclass.getAcademy() + "',department= '"
//				+ studentclass.getDepartment()+"',major ='" + studentclass.getMajor() + "',class_id="+adminclass.getClass_id()+",grade="+
//				adminclass.getGrade()+" WHERE student_id = '"+studentclass.getStudent_id()+"';";
//		//System.out.println(sql2);
//		//System.out.println(sql);
//		DBconn dbconn = new DBconn();
//		ResultSet rst = null;
//		dbconn.doInsert(sql);
//		try {
//			dbconn.close(rst);
//		} catch(Exception ex) {	
//		}
//	}
//	public List<Lesson> adminQueryLesson()  {
//		String sql = "SELECT * FROM class_name;";
//		DBconn dbconn = new DBconn();
//		ResultSet rst = null;
//		List<Lesson> lesson = new ArrayList<Lesson>( );
//		rst = dbconn.doSelect(sql);
//		try {
//			while(rst.next()) {
//				Lesson tmp = new Lesson();
//				tmp.setClass_name(rst.getString("class_name"));
//				tmp.setClass_term(rst.getString("class_term"));
//				tmp.setClass_major(rst.getString("class_major"));
//				lesson.add(tmp);
//			}
//		} catch(SQLException ex) {	
//		}
//		try {
//			dbconn.close(rst);
//		} catch(Exception ex) {	
//		}
//	return lesson;
//	}
//	public void adminUpdateLesson(Lesson lesson)  {
//		String sql = "DELETE FROM class_name WHERE class_name = '" + lesson.getClass_name() + "' and class_term= '"
//				+ lesson.getClass_term()+"' and class_major ='" + lesson.getClass_major() + "';";
//		DBconn dbconn = new DBconn();
//		ResultSet rst = null;
//		dbconn.doInsert(sql);
//		try {
//			dbconn.close(rst);
//		} catch(Exception ex) {	
//		}
//	}
//	public void adminAddLesson(Lesson lesson)  {
//		String sql = "INSERT INTO class_name(class_term, class_name, class_major) values('" + lesson.getClass_term() + "','"
//	+ lesson.getClass_name()+"','" + lesson.getClass_major() + "');";
//		
//		DBconn dbconn = new DBconn();
//		ResultSet rst = null;
//		dbconn.doInsert(sql);
//		try {
//			dbconn.close(rst);
//		} catch(Exception ex) {	
//		}
//	}
//	public List<Grade> adminQueryGrade(String student_id)  {
//		String sql = "SELECT class_name, class_term, class_score FROM class_name join class_score on class_name.id = class_score.student_class_id WHERE student_id = '"
//	+ student_id + "';";
//		System.out.println(sql);
//		DBconn dbconn = new DBconn();
//		ResultSet rst = null;
//		List<Grade> lesson = new ArrayList<Grade>( );
//		rst = dbconn.doSelect(sql);
//		try {
//			while(rst.next()) {
//				Grade tmp = new Grade();
//				tmp.setClass_name(rst.getString("class_name"));
//				tmp.setClass_term(rst.getString("class_term"));
//				tmp.setClass_score(rst.getString("class_score"));
//				lesson.add(tmp);
//			}
//		} catch(SQLException ex) {	
//		}
//		try {
//			dbconn.close(rst);
//		} catch(Exception ex) {	
//		}
//	return lesson;
//	}
//	public String adminQueryLesson(Lesson lesson)  {
//		String sql = "SELECT id FROM class_name WHERE class_term= '" + lesson.getClass_term() + "'and class_name='"+lesson.getClass_name()+"'and class_major='"
//	+lesson.getClass_major()+"';";
//		//System.out.println(sql);
//		String ans = "";
//		DBconn dbconn = new DBconn();
//		ResultSet rst = null;
//		rst = dbconn.doSelect(sql);
//		try {
//			if(rst.next()) {
//				ans = rst.getString("id");
//			}
//		} catch(SQLException ex) {	
//		}
//		try {
//			dbconn.close(rst);
//		} catch(Exception ex) {	
//		}
//	return ans;
//}
//	public void adminAddGrade(String student_class_id, String student_id, String class_score)  {
//		String sql = "INSERT INTO class_score(student_class_id, student_id, class_score) values('" + student_class_id + "','"
//	+ student_id +"','" + class_score + "');";
//		//System.out.println(sql);
//		DBconn dbconn = new DBconn();
//		ResultSet rst = null;
//		dbconn.doInsert(sql);
//		try {
//			dbconn.close(rst);
//		} catch(Exception ex) {	
//		}
//	}
//	public void adminDeleteGrade(String student_class_id, String student_id, String class_score)  {
//		String sql = "DELETE FROM class_score WHERE student_class_id = '" + student_class_id + "' and student_id = '"
//	+ student_id +"' and class_score = '" + class_score + "';";
//	//	System.out.println(sql);
//		DBconn dbconn = new DBconn();
//		ResultSet rst = null;
//		dbconn.doInsert(sql);
//		try {
//			dbconn.close(rst);
//		} catch(Exception ex) {	
//		}
//	}
}
