package helloweb;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Register;
import bean.StudentGrade;
import dao.Check;
import dao.StudentDao;
import utils.GetStudentCV;

/**
 * Servlet implementation class AdminQueryClass
 */
@WebServlet("/AdminQueryClass")
public class AdminQueryClass extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminQueryClass() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		if(session == null || !((String)session.getAttribute("username")).equals("admin")) {
			response.sendRedirect("login.jsp");
			return;
		} 
		response.sendRedirect("adminclass.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		Check check = new Check();
		StudentDao studentdao = new StudentDao();
		String studentIdLeft = request.getParameter("studentIdLeft");
		String studentIdRight = request.getParameter("studentIdRight");
		Integer integerStudentIdLeft = Integer.parseInt(studentIdLeft);
		Integer integerStudentIdRight = Integer.parseInt(studentIdRight);
		Integer integerStudentIdRange = integerStudentIdRight - integerStudentIdLeft;
		List<Double> doubleAvgStudentPost = new ArrayList<Double>();
		List<Boolean> integerMonthList = new ArrayList<Boolean>();
		List<Double> studentCVList = new ArrayList<Double>();
		List<StudentGrade> studentGrade = new ArrayList<StudentGrade>();
		for(int i = 0; i < 12; i ++) {
			doubleAvgStudentPost.add(0.0);
		}
		for(Integer i = integerStudentIdLeft; i <= integerStudentIdRight; i++) {
			String integerStudentId = i.toString();
			String id = check.checkLogin(new Register(integerStudentId, integerStudentId));
			if(id != null) {
				StudentGrade grade = new StudentGrade();
				grade.setStudentId(i);
				List <Integer> studentChart = new ArrayList<Integer>();
				String month = studentdao.queryStudentMonth(id);
				List<String>studentPost = studentdao.queryStudentPost(id);
				List<String>studentLogin = studentdao.queryStudentLogin(id);
				Double studentRawGrade = studentdao.queryStudentRawGrade(id);
				Double postGrade = 0.0;
				if(studentPost.size() > 6) {
					postGrade = 10.0;
				} else {
					postGrade = studentPost.size() * 6.0 / 6;
					if(studentLogin.size() > 10) {
						postGrade += 4;
					} else {
						postGrade += studentLogin.size() * 4.0 / 10;
					}
				}
				grade.setIntegerPostNum(studentPost.size());
				grade.setIntegerLoginNum(studentLogin.size());
				grade.setDoubleAvgGrade(postGrade);
				grade.setDoubleGrade(3*postGrade+0.7*studentRawGrade);
				Integer integerMonth = Integer.parseInt(month);
				Boolean isItemOdd;
				//判断是第一还是第二学期
				if(integerMonth / 6 == 0) {
					isItemOdd = true;
				} else {
					isItemOdd = false;
				} 
				integerMonthList.add(isItemOdd);
				for(int j = 0; j < 12; j++) {
					studentChart.add(0);
				}
				for(int j = 0; j < studentPost.size(); j++) {
					String time = studentPost.get(j);
					String tmpStringMonth = time.substring(5, 7);
					String tmpStringDay = time.substring(8, 10);
					Integer tmpIntegerMonth = Integer.parseInt(tmpStringMonth);
					Integer tmpIntegerDay = Integer.parseInt(tmpStringDay);
					if(isItemOdd) {
						int indexDay = (tmpIntegerDay - 1) / 10;
						if(indexDay == 3) {
							indexDay = 2;
						}
						indexDay = indexDay + 1;
						int index = (tmpIntegerMonth - 3) * 3 + indexDay;
						int integerChartValue = studentChart.get(index) + 1;
						studentChart.set(index, integerChartValue);
					} else {
						int indexDay = (tmpIntegerDay - 1) / 10;
						if(indexDay == 3) {
							indexDay = 2;
						} 
						indexDay = indexDay + 1;
						if(tmpIntegerMonth == 1) {
								tmpIntegerMonth = 13;
						}
						int index = (tmpIntegerMonth - 10) * 3 + indexDay;
						int integerChartValue = studentChart.get(index) + 1;
						studentChart.set(index, integerChartValue);
					}
				}
				for(int j = 0; j < 12; j++) {
					Double doubleChartValue = (double)studentChart.get(j);
					Double doubleAvgStudentValue = doubleAvgStudentPost.get(j);
					doubleAvgStudentPost.set(j, doubleChartValue + doubleAvgStudentValue);
				}
				Double studentCV = GetStudentCV.getStudentCV(studentChart);
				studentCVList.add(studentCV);
				studentGrade.add(grade);
			}
		}
		for(int i = 0; i < 12; i++) {
			doubleAvgStudentPost.set(i, doubleAvgStudentPost.get(i)/integerStudentIdRange);
		}
		request.setAttribute("studentGrade", studentGrade);
		request.setAttribute("doubleAvgStudentPost", doubleAvgStudentPost);
		RequestDispatcher rd = request.getRequestDispatcher("/adminclass.jsp");
		rd.forward(request,response);
	}

}
