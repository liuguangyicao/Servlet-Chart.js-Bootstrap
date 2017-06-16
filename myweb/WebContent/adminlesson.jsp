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
<script type='text/javascript' src='https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.1.4/Chart.min.js'></script>
<script>
window.onload = function(){
  var ctx = document.getElementById("myChart").getContext("2d");

  var ctx = document.getElementById("myChart").getContext('2d');
  var myChart = new Chart(ctx, {
    type: 'horizontalBar',
    data: {
      labels: ["10161256","10161282","10161356","10161387","10161482","10161383","10161280","10161480","10161290","10161355", "10161239", "10161269","10161257","10161289", "10161245", "10161291", "10161280","10161250","10161374","10161199","10161371","10161357", "10161274","10161271"],
      datasets: [{
        label: '登陆次数',
        data: [28*3,27*3,79,75,24*3,24*3,69,69,20*3,58,58,19*3,55,55,17*3,47,12*3,35,34,33,33,9*3,7*3,4*3],
        backgroundColor: "rgba(255,153,0,0.4)",
      }]
    },
    options:{
      title: {
            display: true,
            text: '学生登陆次数排名图',
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
						<li class = "active">
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
					<div class="tabbable" id="tabs-392080">
					<ul class="nav nav-pills">
						<li class="active">
							 <a href="#1" data-toggle="tab">总体登录次数排行图</a>
						</li>
						<li>
							 <a href="#2" data-toggle="tab">用户提问回答散点图</a>
						</li>
						
					</ul>
					<div class="tab-content">
						<div class="tab-pane active" id="1">
									<canvas id='myChart' ></canvas>
				
						</div>
						<div class="tab-pane" id="2">
							<img  src="bootstrap/img/1.png" class="img-responsive center-block"  />
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