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
<base href="<%=basepath %>>"/>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
	<h3>订单详情</h3>
	<div><label>订单号:${fh.sale.saleid }</label></div>
	<br/>
	<div><label>订单时间:<fmt:formatDate value="${fh.sale.create_date }" pattern="yyyy-MM-dd" /></label></div>
	<br/>
	<div><label>商品名称:${fh.material.material_name }</label></div>
	<br/>
	<div><label>商品样式:</label><img  src="${fh.material.material_url }"> </div>
	<br/>
	<div><label>商品单价:${fh.material.material_price }</label></div>
	<br/>
	<div><label>订单数量:${fh.sale.goodscount }</label></div>
	<br/>
	<div><label>订单金额:${fh.sale.goodscount*fh.material.material_price }</label></div>
	<br/>
	<div><label>付款方式:${fh.payment.payment }</label></div>
	<br/>
	<div><label>客户:${fh.customer.c_name}</label></div>
	<br/>
	<div><label>联系电话:${fh.customer.c_phone }</label></div>
	<br/>
	<div><label>收货地址:</label></div>
	<br/>
	
</body>
</html>