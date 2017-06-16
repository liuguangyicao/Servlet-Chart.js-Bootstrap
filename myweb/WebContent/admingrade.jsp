<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
<meta name="viewport" content="width=device-width, initial-scale=1.0"><meta name="viewport" content="width=device-width, initial-scale=1.0">
<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
<link href="bootstrap/css/style_admin.css" rel="stylesheet" type="text/css"/>
<script src="http://code.jquery.com/jquery-latest.js"></script>
<script src="bootstrap/js/bootstrap.min.js"></script>
 <script type='text/javascript' >
      window.onload = function(){
        var ctx = document.getElementById("myChart").getContext("2d");

        var myChart = new Chart(ctx, {
          type: 'line',
          data: {
            labels: ['第1周', '第2周', '第3周', '第4周', '第5周', '第6周', '第7周','第8周','第9周','第10周'],
            title:'登陆频率图',
            datasets: [{
              label: '自己',
              data: [${studentChart[0]},${studentChart[1]},${studentChart[2]},3,5,7,5,5,7,3],
              backgroundColor: "rgba(153,255,51,0.4)",
              lineTension: 0
            }, {
              label: '平均水平',
              data: [1,2,3,2,2,4,3,4,6,1],
              backgroundColor: "rgba(255,153,0,0.4)",
              lineTension: 0
            }]
          },
          options:{
            title: {
                  display: true,
                  text: '学生一周登陆频率图',
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
						<li>
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
						<li class = "active">
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
							 <a href="#1" data-toggle="tab">提问词云</a>
						</li>
					</ul>
					<hr/>
					<div class="tab-content">
						<div class="tab-pane active" id="1">
								<img  src="bootstrap/img/2.png" class="img-responsive center-block"  />
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