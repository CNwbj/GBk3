<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%
	String path = request.getContextPath();
	String basepath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basepath%>"/>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
	<h3>流水详情</h3>
	<div><label>流水号:${et.flowmeter.flowmeter_id }</label></div>
	<br/>
	<div><label>流水时间:<fmt:formatDate value="${et.flowmeter.flowmeter_time }" pattern="yyyy-MM-dd" /></label></div>
	<br/>
	<div><label>流水类型:${et.flowtype.flowmeter_typename }</label></div>
	<br/>
	<div><label>订单号:${et.sale.saleid }</label></div>
	<br/>
	<div><label>订单金额:${et.sale.goodscount*et.material.material_price }</label></div>
	<br/>
	<div><label>利润金额:${et.sale.goodscount*et.bill.profit }</label></div>
	<br/>
	<div><label>账户初始余额:${et.flowmeter.old_balance }</label></div>
	<br/>
	<div><label>账户现在余额:${et.flowmeter.old_balance+et.sale.goodscount*et.material.material_price }</label></div>
	<br/>
</body>
</html>