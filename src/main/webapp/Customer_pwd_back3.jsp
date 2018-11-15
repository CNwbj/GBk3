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
<title>密码找回页面</title>
<script type="text/javascript" src="jquery-1.8.3.js"></script>
<script>
	function fasong(){
		var c_phone=document.getElementById("phone").value;
		document.location='ca/yzm.action?c_phone='+c_phone;
	}		
</script>


</head>
<body>
<h3>请输入：</h3>
<form action="ca/pwd_back.action" method="post">
	手机号：<input type="text" id="phone" name="phone" value="${customer.c_phone }" /><font size="1" color="red" id="errorFont"></font><br/>
	验证码：<input type="" id="yzm" name="yzm" value="" /><a onclick="fasong();">发送验证码</a><br/>
	<input type="submit"  value="提交" /><br/>
</form>	
	
</body>
</html>