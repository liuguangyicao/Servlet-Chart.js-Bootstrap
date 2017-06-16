<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
<meta name="viewport" content="width=device-width, initial-scale=1.0"><meta name="viewport" content="width=device-width, initial-scale=1.0">
<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
<link href="bootstrap/css/style_admin.css" rel="stylesheet" type="text/css"/>
<script type='text/javascript' src='https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.1.4/Chart.min.js'></script>
<script src="http://code.jquery.com/jquery-latest.js"></script>
<script src="bootstrap/js/bootstrap.min.js"></script>
<!--[if lt IE 9]>
   <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
   <script src="https://oss.maxcdn.com/libs/respond.js/1.3.0/respond.min.js"></script>
<![endif]-->

<script type='text/javascript' >
      window.onload = function(){
        var ctx = document.getElementById("myChart").getContext("2d");

        var myChart = new Chart(ctx, {
          type: 'line',
          data: {
            labels: ['3.1-3.10', '3.11-3.20', '3.21-3.31', '4.1-4.10', '4.11-4.20', '4.21-4.30', '5.1-5.10','5.11-5.20','5.21-5.31','6.1-6-10','6.11-6.20','6.21-6.30'],
            title:'学生平均登陆频率图',
            datasets: [{
              label: '自己',
              data: [${doubleAvgStudentPost[0]},${doubleAvgStudentPost[1]},${doubleAvgStudentPost[2]},${doubleAvgStudentPost[3]},${doubleAvgStudentPost[4]},${doubleAvgStudentPost[5]},${doubleAvgStudentPost[6]},${doubleAvgStudentPost[7]},${doubleAvgStudentPost[8]},${doubleAvgStudentPost[9]},${doubleAvgStudentPost[10]},${doubleAvgStudentPost[11]}],
              backgroundColor: "rgba(153,255,51,0.4)",
              lineTension: 0
            }]
          },
          options:{
            title: {
                  display: true,
                  text: '学生十天发布频率图',
                  fontSize:20
              }
          }
        });
       
      }
    </script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>admin</title>
</head>
<body>
<div class="container">
	<div class="row clearfix">
		<div class="col-md-12 column">
			<div class="row clearfix">
				<div class="col-md-2 column">
					<ul class="nav nav-stacked nav-pills">
						<li>
						<h3>Administrator</h3>
						</li>
						<li >
							 <a href="AdminQueryMessage">查询学生信息</a>
						</li>
						<li class = "active">
							 <a href="AdminQueryClass">查询班级信息</a>
						</li>
						<li>
							 <a href="AdminAddStudent">学生管理</a>
						</li>
						<li>
							 <a href="AdminUpdateLesson">学生排名信息</a>
						</li>
						<li>
							 <a href="admingrade。jsp">提问词云</a>
						</li>
								</ul>
				</div>
				<div class="col-md-8 column">
					 <ul class="breadcrumb">
						<li class = "pull-right">
						 <a href="Logout"><span class="glyphicon glyphicon-log-out"></span>登出</a>
						</li>
					</ul>
					<form action="AdminQueryClass" method="POST">
						<table>
							<tbody>
								<tr>
									<td>
									查询班级
									<dl class="dl-horizontal">
									<dt>输入学号左边界：</dt>
									<dd><input class="form-control" name="studentIdLeft" type="text" ><br/></dd>
									<dt>输入学号右边界：</dt>
									<dd><input class="form-control" name="studentIdRight" type="text"><br/></dd>
									<dt></dt>
									<dd><button type="submit" class="btn btn-info ">查询</button></dd>
									</dl>
									</td>
									</tr>
							</tbody>
						</table>
					</form>
					<hr/>
				<div class="tabbable" id="tabs-392080">
					<ul class="nav nav-pills">
						<li class="active">
							 <a href="#1" data-toggle="tab">班级平时成绩</a>
						</li>
						<li>
							 <a href="#2" data-toggle="tab">班级平均发布频率图</a>
						</li>
					</ul>
				<div class="tab-content">
					<div class="tab-pane active" id="1"> 
						<table class="table table-striped">
							<thead>
								<tr>
								<th>学号</th><th>发帖数</th><th>登录数</th><th>平时分</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach var="student" items="${studentGrade}" >  
								<tr>
								<td align = "center">${student.studentId}</td>  
								<td align = "center">${student.integerPostNum}</td>  
								<td align = "center">${student.integerLoginNum}</td>  
								<td align = "center">${student.doubleAvgGrade}</td>  
								</tr>
								</c:forEach>
							</tbody>
						</table> 
					</div>
					<div class="tab-pane" id="2">
						<canvas id='myChart' ></canvas>
				</div>
				</div>
			</div>
		</div>
	</div>
</div>
</div>
</div>			
</body>
</html>