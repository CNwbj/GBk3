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
		<title>登陆</title>
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
			
			 $(function(){
				$("#but").click(function(){
					$.post('ca/customer_login.action',{"c_name":$("#exampleInputEmail1").val(),"c_pwd":$("#exampleInputPassword1").val()},function(data){
						if(data.flag){
							//登录成功
							location = "cate_pencil.jsp";
						}else if(data.flag==false){
							//登录失败
							$("#errorFont").html("用户名或密码错误!!!");
						}else{
							$("#errorFont").html("账号已禁用，请联系客服!!!");
						}
					},'json');
				});
			}) 
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
							<label for="exampleInputEmail1">用户名或手机号：</label>
							<input type="test" class="form-control" id="exampleInputEmail1" name="c_name" value="张三"  /><font size="1" color="red" id="errorFont"></font>
						</div>
						<div class="form-group" >
							<label for="exampleInputPassword1">密码：</label>
							<input type="password" class="form-control" id="exampleInputPassword1" name="c_pwd" value="123" />
						</div>
						
						<div class="checkbox">
							<label><input type="checkbox" />记住密码</label>
						</div> 
						<button type="button" id="but" class="btn btn-default col-md-2">登陆</button>
						&nbsp;&nbsp;<a href="loginpwd_back.jsp">忘记密码?</a>
					</form>
				</div>
			</div>
		</div>
	</body>
</html>
