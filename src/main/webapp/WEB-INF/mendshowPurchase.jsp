<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";%>
	
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href=<%=basePath %> />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<h3>采购表修改</h3>
<body>
	<form action="mel/showup?id=${pu.purchase_id }" method = "post">
		<table >
			<tr><th>编号:</th><td>${pu.purchase_id }</td></tr>
			<tr><th>物资名:</th><td>${pu.material.material_name }</td></tr>
			<tr><th>采购数量</th><td>${pu.purchase.orders_sum }</td></tr>
			<tr><th>销售价格</th><td>￥${pu.material.material_price }</td></tr>
			<tr><th>采购价格</th><td>￥${pu.purchase.cost_price }</td></tr>
			<tr><th>采购时间</th><td><fmt:formatDate value="${pu.sale.submit_date }" pattern="yyyy-MM-dd"/></td></tr>
			<tr><th>采购到期时间</th><td><fmt:formatDate value="${pu.sale.first_date }" pattern="yyyy-MM-dd"/></td></tr>
			
			<tr><th>物资图片</th><td><img style="width: 250px;height: 150px;" src="${pu.material.material_url}"/></td></tr>
			<tr><th>仓库地址</th><td>${pu.depot.depot_name }</td></tr>
			<tr><th>库存数</th><td>${pu.depot.depot_sum }</td></tr>
			<tr><th>采购人</th><td>${pu.sysuser.loginname }</td></tr>
			<tr><th>物资详情</th><td>${pu.material.material_details }</td>
			<tr><th>合计价格</th><td>￥${pu.purchase.cost_price*pu.purchase.orders_sum }</td>
			</tr><tr align="center"><td colspan="2"><input type="submit" name="sub" value="修改"/></td></tr>
										
		
		
		</table>
	</form>

</body>
</html>