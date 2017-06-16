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
import bean.StudentMessage;
import dao.Check;
import dao.StudentDao;

/**
 * Servlet implementation class QueryScore
 */
@WebServlet("/QueryScore")
public class QueryScore extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QueryScore() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		if(session == null || ((String)session.getAttribute("username")).equals("admin")) {
			response.sendRedirect("login.jsp");
			return;
		} 
		request.setCharacterEncoding("UTF-8");
		StudentDao studentdao = new StudentDao();
		String username = (String)session.getAttribute("username");
		Check check = new Check();
		String id = check.checkLogin(new Register(username, username));
		if(id != null) {
			
			StudentMessage studentmessage = studentdao.queryStudentMessage(id);
			List <Integer> studentChart = new ArrayList<Integer>();
			List <Integer> studentLoginChart = new ArrayList<Integer>();
			String month = studentdao.queryStudentMonth(id);
			List<String>studentLogin = studentdao.queryStudentLogin(id);
			List<String>studentPost = studentdao.queryStudentPost(id);
			Integer integerMonth = Integer.parseInt(month);
			Boolean isItemOdd;
			//判断是第一还是第二学期
			if(integerMonth / 6 == 0) {
				isItemOdd = true;
			} else {
				isItemOdd = false;
			} 
			for(int j = 0; j < 12; j++) {
				studentChart.add(0);
			}
			for(int j = 0; j < 12; j++) {
				studentLoginChart.add(0);
			}
			for(int i = 0; i < studentPost.size(); i++) {
				String time = studentPost.get(i);
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
			for(int i = 0; i < studentLogin.size(); i++) {
				String time = studentLogin.get(i);
				String tmpStringMonth = time.substring(5, 7);
				String tmpStringDay = time.substring(8, 10);
				Integer tmpIntegerMonth = Integer.parseInt(tmpStringMonth);
				Integer tmpIntegerDay = Integer.parseInt(tmpStringDay);
				if(tmpIntegerMonth >= 3 && tmpIntegerMonth <= 6) {
					int indexDay = (tmpIntegerDay - 1) / 10;
					if(indexDay == 3) {
						indexDay = 2;
					}
					indexDay = indexDay + 1;
					int index = (tmpIntegerMonth - 3) * 3 + indexDay;
					int integerChartValue = studentLoginChart.get(index) + 1;
					studentLoginChart.set(index, integerChartValue);
				} else if(tmpIntegerMonth >= 10 && tmpIntegerMonth <= 12 || tmpIntegerMonth == 1){
					int indexDay = (tmpIntegerDay - 1) / 10;
					if(indexDay == 3) {
						indexDay = 2;
					} 
					indexDay = indexDay + 1;
					if(tmpIntegerMonth == 1) {
							tmpIntegerMonth = 13;
					}
					int index = (tmpIntegerMonth - 10) * 3 + indexDay;
					int integerChartValue = studentLoginChart.get(index) + 1;
					studentLoginChart.set(index, integerChartValue);
				}
			}
			String judgePostNum = "";
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
			if(studentPost.size() < 3) {
				judgePostNum = "您近期对该课程的学习较少，希望您提高学习积极性！建议您增加学习时间，加大学习力度，按时完成作业，在本学习平台的帮助下，逐步提高学习的积极性。若有任何学习上的困难，请及时向老师、同学寻求帮助。祝您更上一层楼!";
			} else if(studentPost.size() < 5) {
				judgePostNum = "您近期对该课程学习较为积极，希望您再接再厉！建议您在课堂学习之外，多多练习思考，可在本学习平台的辅助下，与同学加强交流，取长补短，争取真正做到学有所用。祝您一切顺利！";
			} else {
				judgePostNum = "您近期对该课程学习热情高涨，希望继续保持！建议您在学有余力的情况下，更深一步地探究专业知识，拓宽知识广度，加强与同学、老师的交流，并给予其他同学帮助。祝您学业有成！";
			}
			
			request.setAttribute("judgePostNum", judgePostNum);
			request.setAttribute("studentLoginChart", studentLoginChart);
			request.setAttribute("studentPostNum", studentPost.size());
			request.setAttribute("studentLoginNum", studentLogin.size());
			request.setAttribute("postGrade", postGrade);
			request.setAttribute("studentChart", studentChart);
			request.setAttribute("studentmessage", studentmessage);
			request.setAttribute("isIdValidate", true);
		} else {
			request.setAttribute("isIdValidate",false);
		}
		RequestDispatcher rd = request.getRequestDispatcher("/queryscore.jsp");
		rd.forward(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		if(session == null || ((String)session.getAttribute("username")).equals("admin")) {
			response.sendRedirect("login.jsp");
			return;
		} 
		request.setCharacterEncoding("UTF-8");
		StudentDao studentdao = new StudentDao();
		String username = (String)session.getAttribute("username");
		Check check = new Check();
		String id = check.checkLogin(new Register(username, username));
		if(id != null) {
			
			StudentMessage studentmessage = studentdao.queryStudentMessage(id);
			List <Integer> studentChart = new ArrayList<Integer>();
			List <Integer> studentLoginChart = new ArrayList<Integer>();
			String month = studentdao.queryStudentMonth(id);
			List<String>studentLogin = studentdao.queryStudentLogin(id);
			List<String>studentPost = studentdao.queryStudentPost(id);
			Integer integerMonth = Integer.parseInt(month);
			Boolean isItemOdd;
			//判断是第一还是第二学期
			if(integerMonth / 6 == 0) {
				isItemOdd = true;
			} else {
				isItemOdd = false;
			} 
			for(int j = 0; j < 12; j++) {
				studentChart.add(0);
			}
			for(int j = 0; j < 12; j++) {
				studentLoginChart.add(0);
			}
			for(int i = 0; i < studentPost.size(); i++) {
				String time = studentPost.get(i);
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
			for(int i = 0; i < studentLogin.size(); i++) {
				String time = studentLogin.get(i);
				String tmpStringMonth = time.substring(5, 7);
				String tmpStringDay = time.substring(8, 10);
				Integer tmpIntegerMonth = Integer.parseInt(tmpStringMonth);
				Integer tmpIntegerDay = Integer.parseInt(tmpStringDay);
				if(tmpIntegerMonth >= 3 && tmpIntegerMonth <= 6) {
					int indexDay = (tmpIntegerDay - 1) / 10;
					if(indexDay == 3) {
						indexDay = 2;
					}
					indexDay = indexDay + 1;
					int index = (tmpIntegerMonth - 3) * 3 + indexDay;
					int integerChartValue = studentLoginChart.get(index) + 1;
					studentLoginChart.set(index, integerChartValue);
				} else if(tmpIntegerMonth >= 10 && tmpIntegerMonth <= 12 || tmpIntegerMonth == 1){
					int indexDay = (tmpIntegerDay - 1) / 10;
					if(indexDay == 3) {
						indexDay = 2;
					} 
					indexDay = indexDay + 1;
					if(tmpIntegerMonth == 1) {
							tmpIntegerMonth = 13;
					}
					int index = (tmpIntegerMonth - 10) * 3 + indexDay;
					int integerChartValue = studentLoginChart.get(index) + 1;
					studentLoginChart.set(index, integerChartValue);
				}
			}
			Double postGrade = 0.0;
			String judgePostNum = "";
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
		
			if(studentPost.size() < 3) {
				judgePostNum = "您近期对该课程的学习较少，希望您提高学习积极性！建议您增加学习时间，加大学习力度，按时完成作业，在本学习平台的帮助下，逐步提高学习的积极性。若有任何学习上的困难，请及时向老师、同学寻求帮助。祝您更上一层楼!";
			} else if(studentPost.size() < 5) {
				judgePostNum = "您近期对该课程学习较为积极，希望您再接再厉！建议您在课堂学习之外，多多练习思考，可在本学习平台的辅助下，与同学加强交流，取长补短，争取真正做到学有所用。祝您一切顺利！";
			} else {
				judgePostNum = "您近期对该课程学习热情高涨，希望继续保持！建议您在学有余力的情况下，更深一步地探究专业知识，拓宽知识广度，加强与同学、老师的交流，并给予其他同学帮助。祝您学业有成！";
			}
			
			request.setAttribute("judgePostNum", judgePostNum);
			request.setAttribute("studentLoginChart", studentLoginChart);
			request.setAttribute("studentPostNum", studentPost.size());
			request.setAttribute("studentLoginNum", studentLogin.size());
			request.setAttribute("postGrade", postGrade);
			request.setAttribute("studentChart", studentChart);
			request.setAttribute("studentmessage", studentmessage);
			request.setAttribute("isIdValidate", true);
		} else {
			request.setAttribute("isIdValidate",false);
		}
		RequestDispatcher rd = request.getRequestDispatcher("/queryscore.jsp");
		rd.forward(request,response);
	}

}
