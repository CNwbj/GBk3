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
<title>用户修改信息页面</title>
</head>
<body>
<h3>客户账号修改页面</h3>
<form action=" ca/update.action?c_id=${customer.c_id }" method="post">
	手机号：<input type="text" name="c_phone" value="${customer.c_phone }"><br/>
	密码：<input type="text" name="c_pwd"><br/>
	公司名称：<input type="text" name="c_company" value="${customer.c_company }"><br/>
	邮箱：<input type="text" name="c_mail" value="${customer.c_mail }"><br/>
	地址：<input type="text" name="c_address" value="${customer.c_address }"><br/>
	职业：<input type="text" name="c_work" value="${customer.c_work }"><br/>
	学历：<SELECT name="c_eduid"> 		 			    
		    <OPTION value="${customer.c_eduid }">小学 </OPTION>
		    <OPTION value="${customer.c_eduid }">初中 </OPTION>
		    <OPTION value="${customer.c_eduid }">高中 </OPTION>
		    <OPTION value="${customer.c_eduid }">大专 </OPTION>
		    <OPTION value="${customer.c_eduid }">本科 </OPTION>
		    <OPTION value="${customer.c_eduid }">硕士及以上 </OPTION>		    						
	    </SELECT>
	<input type="submit" value="提交">
</form>
	
</body>
</html>