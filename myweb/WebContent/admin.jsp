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
 <script type='text/javascript' >
      window.onload = function(){
        var ctx = document.getElementById("myChart").getContext("2d");

        var myChart = new Chart(ctx, {
          type: 'line',
          data: {
            labels: ['3.1-3.10', '3.11-3.20', '3.21-3.31', '4.1-4.10', '4.11-4.20', '4.21-4.30', '5.1-5.10','5.11-5.20','5.21-5.31','6.1-6-10','6.11-6.20','6.21-6.30'],
            title:'登陆频率图',
            datasets: [{
              label: '自己',
              data: [${studentChart[0]},${studentChart[1]},${studentChart[2]},${studentChart[3]},${studentChart[4]},${studentChart[5]},${studentChart[6]},${studentChart[7]},${studentChart[8]},${studentChart[9]},${studentChart[10]},${studentChart[11]}],
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
        var ctx2 = document.getElementById("myChart2").getContext("2d");

        var myChart2 = new Chart(ctx2, {
          type: 'line',
          data: {
            labels: ['3.1-3.10', '3.11-3.20', '3.21-3.31', '4.1-4.10', '4.11-4.20', '4.21-4.30', '5.1-5.10','5.11-5.20','5.21-5.31','6.1-6-10','6.11-6.20','6.21-6.30'],
            title:'登陆频率图',
            datasets: [{
              label: '自己',
              data: [${studentLoginChart[0]},${studentLoginChart[1]},${studentLoginChart[2]},${studentLoginChart[3]},${studentLoginChart[4]},${studentLoginChart[5]},${studentLoginChart[6]},${studentLoginChart[7]},${studentLoginChart[8]},${studentLoginChart[9]},${studentLoginChart[10]},${studentLoginChart[11]}],
              backgroundColor: "rgba(153,255,51,0.4)",
              lineTension: 0
            }]
          },
          options:{
            title: {
                  display: true,
                  text: '学生十天登陆频率图',
                  fontSize:20
              }
          }
        });
      }
    </script>
<!--[if lt IE 9]>
   <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
   <script src="https://oss.maxcdn.com/libs/respond.js/1.3.0/respond.min.js"></script>
<![endif]-->
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
						<li class = "active">
							 <a href="AdminQueryMessage">查询学生信息</a>
						</li>
						<li>
							 <a href="AdminQueryClass">查询班级信息</a>
						</li>
						<li>
							 <a href="AdminAddStudent">学生管理</a>
						</li>
						<li>
							 <a href="AdminUpdateLesson">学生排名信息</a>
						</li>
						<li>
							 <a href="admingrade.jsp">提问词云</a>
						</li>
								</ul>
				</div>
				<div class="col-md-8 column">
					 <ul class="breadcrumb">
						<li class = "pull-right">
						 <a href="Logout"><span class="glyphicon glyphicon-log-out"></span>登出</a>
						</li>
					</ul>
					<hr/>
					<div class="tabbable" id="tabs-392080">
					<ul class="nav nav-pills">
						<li class="active">
							 <a href="#1" data-toggle="tab">个人信息</a>
						</li>
						<li>
							 <a href="#2" data-toggle="tab">发布频率图</a>
						</li>
						<li>
							 <a href="#3" data-toggle="tab">访问频率图</a>
						</li>
					</ul>
					<div class="tab-content">
						<div class="tab-pane active" id="1">
							<dl class="dl-horizontal">
								<dt>用户名:</dt>
								<dd>${studentmessage.username}<br/><br/></dd>	
								<dt>姓名:</dt>
								<dd>${studentmessage.firstname}<br/><br/></dd>
								<dt>学号:</dt>
								<dd>${studentmessage.lastname}<br/><br/></dd>
								<dt>邮箱:</dt>
								<dd>${studentmessage.email}<br/><br/></dd>
								<dt>城市:</dt>
								<dd>${studentmessage.city}<br/><br/></dd>
								<dt>国家:</dt>
								<dd>${studentmessage.country}<br/><br/></dd>
								<dt>个人描述:</dt>
								<dd>${studentmessage.description}<br/><br/></dd>
								<dt>发帖数:</dt>
								<dd>${studentPostNum}<br/><br/></dd>
								<dt>登录数:</dt>
								<dd>${studentLoginNum}<br/><br/></dd>
								<dt>平时成绩:</dt>
								<dd>${postGrade}<br/><br/></dd>
							</dl>
						</div>
						<div class="tab-pane" id="2">
							<canvas id='myChart' ></canvas>
							<p>发帖数:${studentPostNum}</p>
						</div>	
						<div class="tab-pane" id="3">
							<canvas id='myChart2' ></canvas>
							<p>登录数:${studentLoginNum}</p>
						</div>	
					</div>
				</div>
					
					<hr/>
					<form action="AdminQueryMessage" method="POST">
					输入学号
					<input class="form-control"  name="student_id" type="text"><br/>
					<button type="submit" class="btn btn-primary ">查询</button>
					</form>
				</div>
			</div>
		</div>
	</div>
</div>
			
</body>
</html>