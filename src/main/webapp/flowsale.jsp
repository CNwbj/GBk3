<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%
	String path = request.getContextPath();
	String basepath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<base href="<%=basepath%>"/>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<script type="text/javascript" src="<%=basepath %>js/jquery-1.8.3.js"></script>
<script type="text/javascript">
	function jump(stateid,saleid) {
		location.href="fc/returnSale?stateid="+stateid+"&saleid="+saleid;
	}
	function gopage(mypage) {
		var allpage = $("#allpage").val();
		if(parseInt(mypage)<1){
			alert("已经是第一页了");
		}else if(parseInt(mypage)>allpage){
			alert("已经是最后一页了");
		}else{
			$("#cp").val(mypage);
			$("#flowsale").submit();
		}
	}
</script>
</head>
<body>
	
	<h3>订单审核</h3>
	<table border="1" cellpadding="1" cellspacing="1">
		<tr>
			<th>订单号</th>
			<th>订单时间</th>
			<th>订单金额</th>
			<th>审核1</th>
			<th>审核2</th>
			<th>审核3</th>
			<th>审核4</th>
			<th>操作</th>
			<th>详情</th>
			<th>客户</th>
		</tr>
		<c:forEach items="${fulist }" var="fu">
			<tr>
				<td>${fu.sale.saleid }</td>
				<td><fmt:formatDate value="${fu.sale.create_date }" pattern="yyyy-MM-dd" /></td>
				<td>${fu.sale.goodscount*fu.material.material_price }</td>
				<c:forEach items="${stalist }" var="sta" >
					<c:if test="${fu.sale.column1==sta.stateid }"><td>${sta.statename }</td></c:if>
				</c:forEach>
				<c:forEach items="${stalist }" var="sta" >
					<c:if test="${fu.sale.column2==sta.stateid }"><td>${sta.statename }</td></c:if>
				</c:forEach>
				<c:forEach items="${stalist }" var="sta" >
					<c:if test="${fu.sale.column3==sta.stateid }"><td>${sta.statename }</td></c:if>
				</c:forEach>
				<c:forEach items="${stalist }" var="sta" >
					<c:if test="${fu.sale.column4==sta.stateid }"><td>${sta.statename }</td></c:if>
				</c:forEach>
				<td>
					<c:if test="${fu.sale.column1==6}">
					<input type="button" value="审核" onclick="jump(7,${fu.sale.saleid });"/>
					<input type="button" value="驳回" onclick="jump(22,${fu.sale.saleid });"/>
					</c:if>
				</td>
				<td><a href="fc/flowsaleshow?saleid=${fu.sale.saleid }">查看</a></td>
				<td>${fu.customer.c_name }</td>
			</tr>
		</c:forEach>
	</table>
	${cp }/${allpage}
	<form action="fc/showSale" id="flowsale">
		<input type="hidden" value="${cp }" id="cp" name="cp" />
		<input type="hidden" value="${allpage}" id="allpage" name="allpage" />
		<input type="button" value="首页" onclick="gopage(1)"/>
		<input type="button" value="上一页" onclick="gopage(${cp-1})"/>
		<input type="button" value="下一页" onclick="gopage(${cp+1})"/>
		<input type="button" value="尾页"/ onclick="gopage(${allpage})">
	</form>
</body>
</html>