<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%
	String path = request.getContextPath();
	String basepath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basepath%>"/>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<script type="text/javascript" src="<%=basepath %>js/jquery-1.8.3.js"></script>
<script type="text/javascript">
	function gopage(mypage) {
		var cp = $("#cp").val();
		var cpCount=$("#cpCount").val();
		if(parseInt(mypage)<1){
			alert("已经是首页了");
		}else if (parseInt(mypage)>cpCount){
			alert("已经是尾页了");
		}else{
			$("#cp").val(mypage);
			$("#showinfo").submit();
		}
	}
	
	function find() {
		$("#cp").val(1);
		$("#showinfo").submit();
	}
</script>
</head>
<body>
	<form action="fc/showFlowmeter" method="get" id="showinfo">
		<input type="hidden" value="${fq.cp }" name="cp" id="cp"/>
		<input type="hidden" value="${fq.cpCount }" name="cpCount" id="cpCount"/>
		<label>流水类型:</label>
		<select name="type">
			<option value="0">--请选择--</option>
			<c:forEach items="${ftlist }" var="ft">
				<option value="${ft.flowmeter_type}" ${ft.flowmeter_type==fq.type?"selected":"" }>${ft.flowmeter_typename }</option>
			</c:forEach>
		</select>
		<label>时间:</label>
		<input type="date" value="<fmt:formatDate value='${fq.first}' pattern='yyyy-MM-dd' />" name="first"/>-
		<input type="date" value="<fmt:formatDate value='${fq.last }' pattern='yyyy-MM-dd' />" name="last">
		<input type="button" value="查询" onclick="find()"/>
	</form>
	<table border="1px" cellpadding="1px" cellspacing="1px">
	
		<tr>
			<th>流水号</th>
			<th>时间</th>
			<th>订单编号</th>
			<th>记账摘要内容</th>
			<th>订单金额</th>
			<th>账户余额</th>
			<th></th>
		</tr>
		<c:forEach items="${list }" var="e">
			<tr>
				<td>${e.flowmeter.flowmeter_id }</td>
				<td><fmt:formatDate value="${e.flowmeter.flowmeter_time }" pattern="yyyy-MM-dd" /></td>
				<td>${e.sale.saleid }</td>
				<td>${e.flowtype.flowmeter_typename}</td>
				<td>${e.sale.goodscount*e.material.material_price }</td>
				<td>${e.flowmeter.now_balance }</td>
				<td>
					<a href="fc/show?fm_id=${e.flowmeter.fm_id }">查看详情</a>
				</td>
			</tr>
		</c:forEach>
	</table>
	${fq.cp }/${fq.cpCount }
	<input type="button" value="首页" onclick="gopage(1)"/>
	<input type="button" value="上一页" onclick="gopage(${fq.cp-1})"/>
	<input type="button" value="下一页" onclick="gopage(${fq.cp+1})"/>
	<input type="button" value="尾页"/ onclick="gopage(${fq.cpCount})">
</body>
</html>