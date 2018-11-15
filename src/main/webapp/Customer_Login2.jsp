<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath%>" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>登录页面</title>
<script type="text/javascript" src="jquery-1.8.3.js"></script>
<script>
$(function(){
	$("#but").click(function(){
		$.post('ca/customer_login.action',{"c_name":$("#c_name").val(),"c_pwd":$("#c_pwd").val()},function(data){
			if(data.flag){
				//登录成功
				location.href="ca/customer_show.action";
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
<h3>请登录：</h3>
	用户名或手机号：<input type="text" id="c_name" name="c_name" value="张三" /><font size="1" color="red" id="errorFont"></font><br/>
	密码：<input type="password" id="c_pwd" name="c_pwd" value="123" /><br/>
	<input type="button" id="but" value="登录" />  <a href="ca/pwd_back.action">忘记密码</a><br/>
	
</body>
</html>