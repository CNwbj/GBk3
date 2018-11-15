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
<title>用户信息页面</title>
</head>
<body>
<h3>客户账号展示页面</h3>
<h4><a href="ca/preupdate.action?c_id=${customer.c_id }">资料修改</a></h4>
<h4><a href="ca/prefindsalelist?c_id=${customer.c_id }">历史订单</a></h4>
<h4><a href="ca/money_manage?c_id=${customer.c_id }">余额管理</a></h4>
	
</body>
</html>