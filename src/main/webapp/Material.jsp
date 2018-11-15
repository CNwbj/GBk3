<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()+ path + "/";
%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href=<%=basePath%> />
<script type="text/javascript" src="jquery-1.8.3.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>信息中心</title>
<style type="text/css">
a {
	text-decoration: none;
}
</style>

<script type="text/javascript">
 	onload = function(){
 		var pagination = geld("pagination").value
 		if(pagination==""){
 			document.location="ml/ch";
 		}
		
	} 
function geld(id){
	return document.getElementById(id);
}

<!--分页的方法 -->
function gotoPage(pageNum){
	var pagenum = parseInt(pageNum);
	var allpag = parseInt(geld("pag").value);
	/* alert(allpag); */
	var page = geld("pagination");
	/* alert(page); */
	if(pagenum<=1){
		page.value = 1
	}else if(pagenum>=allpag){
		page.value = allpag;
	}else{
		page.value = pagenum;
	}
	lookml.submit();
}
function a(){
	var page = geld("pagination");
	page.value = 1;
	book.submit();
}
</script>
</head>
<body style="text-align: center;">
	<div style="width: 1000px; height: 700px;">
		<form action="ml/ch" name="lookml" id="lookbook" method="GET">
			<input type="hidden" name="pagination" id="pagination" value="${pagination }" /> 
			<input type="hidden" name="pag" id="pag"value="${allpag }" />
																<br /> 
			搜索文档:<input type="text" name="linchpin" value="${linchpin }" /> 
			价格搜索:<input type="date" name="startTime" value="${startTime }" />-<input type="date" name="stopTime" value="${stopTime }" /> 
			<select name="statename">
			<option>--请选择--</option>
					<c:if test="${!empty statename }">
						<option value="${statename }" selected>${statename }</option>
					</c:if>
					<option value="已发货">已发货</option>
					<option value="未发货">未发货</option>
			  </select>
			
			<input type="submit" value="搜索" /><br />
		</form>
			
			<table border="1" align="center">
				<tr>
					<th >编号</th>
					<th >物资名</th>
					<th >价格</th>
					<th >数量</th>
					<th>下单时间</th>
					<th>结束时间</th>
					<th>客户名</th>
					<th >金额</th>
					<th >仓库地址</th>
					<th >订单状态</th>
					<th >审核人</th>
					<th >物资详情</th>
				</tr>
				<c:if test="${!empty shlist}">
					<c:forEach items="${shlist }" var="sh">
					<tr>
						<td width="5%">${sh.shipment_id }</td>
						<td width="10%">${sh.material.material_name }</td>
						<td width="5%">${sh.material.material_price}</td>
						<td width="10%">${sh.depot.depot_sum}</td>
						<td width="10%"><fmt:formatDate value="${sh.sale.submit_date }" pattern="yyyy-MM-dd"/></td>
						<td width="10%"><fmt:formatDate value="${sh.sale.submit_date }" pattern="yyyy-MM-dd"/></td>
						<td width="15%">${sh.customer.c_name}</td> 
						<td width="15%">${sh.material.material_price*sh.depot.depot_sum}</td> 
						<td width="15%">${sh.depot.depot_name}</td> 
						<td width="10%">${sh.state.statename}</td>
						<td width="10%">${sh.sysuser.loginname}</td>
						<td width="20%">${sh.material.material_details}</td>
						
					</tr>
					</c:forEach>
				</c:if>
			</table>
			<table align="center">
		<tr align="center">
			<td><input type="button" name="firstPage" value="首页" onclick="gotoPage(1);"/></td>
			<td><input type="button" name="previous" value="上一页" onclick="gotoPage(${pagination}-1);"/></td>
			<td>总共:${allpag }页&nbsp;&nbsp;&nbsp; 当前第:${pagination }页</td>
			<td><input type="button" name="next" value="下一页" onclick="gotoPage(${pagination}+1);"/></td>
			<td><input type="button" name="last" value="最后一页" onclick="gotoPage(${allpag});"/></td>
		</tr>
	</table>
</div>
</body>
</html>