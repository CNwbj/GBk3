<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
	<base href="<%=basePath%>" />
		<meta charset="utf-8">
		<title>手机验证码登录</title>
		<link rel="stylesheet" href="css/bootstrap.css" />
		<link rel="stylesheet" href="css/bootstrap-theme.css" />
		<script src="js/jquery.js"></script>
		<script src="js/bootstrap.js"></script>
		<script>
			$(function(){
				//$(parent.document.getElementById("registerFrame")).attr("height",0);				
				var height = document.body.scrollHeight;
				console.log(height);
				$(parent.document.getElementById("registerFrame")).attr("height",1600);				
			}); 
			
			function fasong(){
				var c_phone=document.getElementById("exampleInputEmail1").value;
				document.location='ca/yzm.action?c_phone='+c_phone;
			}
		</script>
	</head>
	<body>
		<div class="container">
			<div class="row clearfix">
				<div class="col-md-12 column">
					<div class="jumbotron">
						<h1>
							这里可以展示今天的天气
						</h1>
						<p>
							不忘初心,方得始终.初心易得,始终难觅.
						</p>
						<p>
							<a class="btn btn-primary btn-large" href="#">Learn more</a>
						</p>
					</div>
					<form role="form" >
						<div class="form-group" >
							<label for="exampleInputEmail1">手机号：</label>
							<input type="test" class="form-control" id="exampleInputEmail1"  name="phone" value="${customer.c_phone }"   /><font size="1" color="red" id="errorFont"></font>
						</div>
						<div class="form-group" >
							<label for="exampleInputPassword1">验证码：</label>&nbsp;&nbsp;&nbsp;&nbsp;<a onclick="fasong();">发送</a>
							<input type="text" class="form-control" id="exampleInputPassword1"  name="yzm" value=""/>
						</div>						 
						<button type="button" id="but" class="btn btn-default col-md-2">登陆</button>			
					</form>
				</div>
			</div>
		</div>
	</body>
</html>
