<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib  uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <title></title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<script type="text/javascript" src="jquery-1.8.3.js"></script>
<script src="jquery.table2excel.js"></script>
<script>
	function tijiao(stateid6){
	
		quotation.action="pc/updatestateid?stateid6="+stateid6;
		quotation.submit();
	}
	
/* 	function songshen(stateid7){
		
		quotation.action="pc/updatestateid?stateid7="+stateid7;
		quotation.submit();
	}
	function bohui(stateid22){
		
		quotation.action="pc/updatestateid?stateid22="+stateid22;
		quotation.submit();
	} */
</script>
  </head>
  <body>
		<form action="qa/gofenye" method="post"  name="splitform">
	  			客户姓名:	<select name="query.qcid">
		  					<option value="">--请选择--</option>
		  					<c:forEach items="${customlist }" var ="cl">
		  						<option value="${cl.c_id }" ${fy.query.qcid==cl.c_id?'selected':'' }> ${cl.c_name} </option>
		  					</c:forEach>
	  					</select>
	  			付款方式:<select name="query.qcpaymentid">
		  					<option value="">--请选择--</option>
		  					<c:forEach items="${paymentlist }" var ="pt">
		  						<option value="${pt.c_paymentid }" ${fy.query.qcpaymentid==pt.c_paymentid?'selected':'' }> ${pt.payment} </option>
		  					</c:forEach>
	  					</select>
	  			<input type="submit" value="搜索">
	  	</form> 
		
		<table id="tb" bordercolor="gray" border="1" width="100%" cellspacing="0" >
		<tr align="center">
			<td>选项</td>
			<td>报价单编号</td>
			<td>物品名称</td>
			<td>付款方式</td>
			<td>求购数量</td>
			<td>客户报价</td>
			<td>客户名称</td>
			<td>联系电话</td>
			<td>客户住址</td>
			<td>报价日期</td>
			<td>有效期至</td>	
			<td>提交状态</td>
			<!-- <td>审核状态</td>	 --> 
			<!-- <td>修改</td>
			<td>删除</td> -->	  				
	  	</tr>
    	<c:if test="${empty qtList}">
			<tr>
				<td colspan="12">没有查询到数据</td>
			</tr>			
		</c:if> 				
		<c:if test="${qtList!=null }">		
  			<c:forEach items="${qtList }" var="ql">		
				<tr align="center">	
					<td><input type="checkbox"  class="check" name="box"></td> 					
					<td>${ql.quotationid}</td>
					<td>${ql.material.material_name} </td>	
					<td>${ql.cpayment.payment} </td>
					<td>${ql.paycount} </td>
					<td>${ql.q_price} </td>					
					<td>${ql.customer.c_name}</td>
					<td>${ql.customer.c_phone} </td>					
					<td>${ql.customer.c_address}</td>
					
					<td>
						<fmt:formatDate value="${ql.quotation_date}" pattern="yyyy年MM月dd日" />
					 </td>	
					<td>
						<fmt:formatDate value="${ql.ofr_vail}" pattern="yyyy年MM月dd日" />
					</td>
					<td>${ql.state5.statename }</td>
					<%-- <c:if test="${ql.state1.stateid eq '14' }">	 
						<td><input type="button"  value="送审" onclick="tijiao(${ql.state1.stateid})" /></td>
					 </c:if> --%>	
					<%-- <c:if test="${ql.state4.stateid eq '23' }">				
						<td><input type="button" value="审核" onclick="shenhe(${ql.state2.stateid})" />
						<input type="button" value="驳回" onclick="songshen(${ql.state2.stateid})" /></td>
					</c:if>	 --%>
															
					<%-- <td>
						<a href="qa/update?quotationid=${ql.quotationid}">修改</a>
					</td>
					<td>
						<a href="qa/delete?quotationid=${ql.quotationid}">删除</a>
					</td> --%>
				</tr>
			</c:forEach>
		</c:if>  
		
	</table>
	

			 <c:url var="Url" value="qa/gofenye">
			 	<c:param name="query.qcpaymentid" value="${fy.query.qcpaymentid }"></c:param>			
				<c:param name="query.qcpaymentid" value="${fy.query.qcpaymentid }"></c:param>			
					
			</c:url> 

			<a href="${Url }&page=1">首页</a>
			<c:choose>
				<c:when test="${fy.page==1 }">
					上一页
				</c:when>
				<c:otherwise>
					<a href="${Url }&page=${fy.page-1}">上一页</a>
				</c:otherwise>
			</c:choose>
			
			<c:choose>
				<c:when test="${fy.page==fy.pageCount }">
					下一页
				</c:when>
				<c:otherwise>
					<a href="${Url }&page=${fy.page+1}">下一页</a>
				</c:otherwise>
			</c:choose>
			<a href="${Url }&page=${fy.pageCount}">尾页</a> 
  </body>
</html>