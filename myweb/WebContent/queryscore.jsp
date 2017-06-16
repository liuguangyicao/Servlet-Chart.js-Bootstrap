<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta name="viewport" content="width=device-width, initial-scale=1.0"><meta name="viewport" content="width=device-width, initial-scale=1.0">
<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
<link href="bootstrap/css/style.css" rel="stylesheet" type="text/css"/>
<script type='text/javascript' src='https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.1.4/Chart.min.js'></script>
<script src="http://code.jquery.com/jquery-latest.js"></script>
<script src="bootstrap/js/bootstrap.min.js"></script>
<style type=text/css>
.userinfo {
text-align:left;
font-size:17px;
color: #797C80;
}
</style>
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
        var ctx3 = document.getElementById("myChart3").getContext('2d');
        var myChart3 = new Chart(ctx3, {
          type: 'pie',
          data: {
            labels: ["平时分得分", "平时分失分"],
            datasets: [{
              backgroundColor: [
                "#FF6384",
                "#FF3684",
              ],
              hoverBackgroundColor: [
                      "#2ecc71",
                      "#95a5a6",
              ],
              data: [${postGrade}, ${10-postGrade}]
            }]
          }
        });
      }
    </script>
<!--[if lt IE 9]>
   <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
   <script src="https://oss.maxcdn.com/libs/respond.js/1.3.0/respond.min.js"></script>
<![endif]-->
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<div class="container">
			<div class="row clearfix">
				<div class="col-md-12 column">
					<nav class="navbar navbar-default navbar-static-top">
						<div class="navbar-header">
							<a class="navbar-brand" href="StudentQuery">学生管理系统</a>
						</div>
						<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1" >
							<ul class="nav navbar-nav navbar-right">
								<li>
								<a href="StudentQuery"><span class="glyphicon glyphicon-user"></span>欢迎您！${username}</a>
									
								</li>
								<li>
									 <a href="Logout"><span class="glyphicon glyphicon-log-out"></span>登出</a>
								</li>
							</ul>
						</div>	
					</nav>
					<ul class="nav nav-tabs nav-justified" >
						<li><a href="StudentQuery">个人信息</a></li>
						<li class="active"><a href="QueryScore">查询成绩</a></li>
					</ul>
					<div class="panel panel-success">
						<div class="recommended-info panel-title">
							<h3 style="margin:10px;">平时成绩查询</h3>
						</div>
						<div class="panel-body ">
						<hr/>
						<div class="row clearfix">
							<div class="col-md-3 column">
								<ul class="nav nav-stacked nav-pills">
									<li class = "active">
										 <a href="QueryScore">查询成绩</a>
									</li>
								
								</ul>
							</div>
							<div class="col-md-9 column">
								<div class="tabbable" id="tabs-392080">
									<ul class="nav nav-pills">
										<li class="active">
											 <a href="#1" data-toggle="tab">平时成绩</a>
										</li>
										<li>
											 <a href="#2" data-toggle="tab">发布频率图</a>
										</li>
										<li>
											 <a href="#3" data-toggle="tab">访问频率图</a>
										</li>
									</ul>
									<hr/>
									<div class="tab-content">
										<div class="tab-pane active" id="1">
											<p> 您当前的平时分为${postGrade},请再接再励</p>
											<canvas id='myChart3' ></canvas>
										</div>
										<div class="tab-pane" id="2">
										<p> 您的发布次数为为${studentPostNum},请再接再励</p>
											<canvas id='myChart' ></canvas>
										</div>	
										<div class="tab-pane" id="3">
										<p> 您的发布次数为为${studentLoginNum},请再接再励</p>
											<canvas id='myChart2' ></canvas>
										</div>	
									</div>
								</div>
								<hr/>
								<div class = 'userinfo'>${judgePostNum}</div>
							</div>
						</div>
						</div>
						</div>
				</div>
			</div>
		</div>
</body>
</html>