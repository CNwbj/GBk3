<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
	<base href="<%=basePath%>" />
		<meta charset="utf-8">
		<title>历史订单页面</title>
		<link rel="stylesheet" href="css/bootstrap.css" />
		<link rel="stylesheet" href="css/bootstrap-theme.css" />
		<script src="js/jquery.js"></script>
		<script src="js/bootstrap.js"></script>
		<script src="<%=basePath%>My97DatePicker/WdatePicker.js"></script>
		<script>
		$(function(){
			//$(parent.document.getElementById("registerFrame")).attr("height",0);
			let sailid = $("#saleid").val();
			console.log(sailid);
			if(sailid==null){
				
				location = "ca/sale_manage.action?c_id="+$("#c_id").val();
			}
			var height = document.body.scrollHeight;
			//console.log(height);
			$(parent.document.getElementById("registerFrame")).attr("height",1600);
		}); 
		
		function geld(id){
			return document.getElementById(id);
		}
		/* 退货 */
		function tuihuo(c_id,saleid,goodscount,material_id){
			
			//var saleid = geld("saleid").value;
			/* var c_id = geld("c_id").value;			
			var material_id = geld("material_id").value;									
			var goodscount = geld("m_count").value;
			var sendaddr = geld("c_address").value;	
			var material_price = geld("material_price").value;
			var realprice = parseInt(goodscount)*parseFloat(material_price);
			var c_paymentid= geld("payMethod").value;
			document.location="pc/returngoods?c_id="+c_id+"&material_id="+material_id+"&goodscount="+goodscount+"&sendaddr="+sendaddr+"&realprice="+realprice+"&c_paymentid="+c_paymentid+"&saleid"+saleid;  */
			document.location="pc/returngoods?saleid="+saleid+"&c_id="+c_id+"&goodscount="+goodscount+"&material_id="+material_id;
		}
		/* 收货 */
		function shouhuo(c_id,saleid,goodscount,material_price){
			
			//var c_id = geld("c_id").value;
			//var saleid = geld("saleid").value;
			//var goodscount = geld("m_count").value;			
			//var material_price = geld("material_price").value;			
			var realprice = parseInt(goodscount)*parseFloat(material_price);						
			document.location="pc/confirm?money="+realprice+"&c_id="+c_id+"&saleid="+saleid;
		}
		</script>
	</head>
	<body>
		<div class="container">
			<div class="row clearfix">
				<div class="col-md-12 column">
					
					<!-- 开始 -->
					<form action="ca/sale_manage.action" method="get">
						购买日期:&nbsp;<input type="text" name="query.qStartAddDate" readonly="readonly" class="Wdate" onclick="WdatePicker()"  value="<fmt:formatDate value='${fy.query.qStartAddDate }' pattern='yyyy-MM-dd'/>">&nbsp;至&nbsp;
				  		<input type="text" name="query.qEndAddDate" readonly="readonly" class="Wdate" onclick="WdatePicker()"  value="<fmt:formatDate value='${fy.query.qEndAddDate }' pattern='yyyy-MM-dd'/>">&nbsp;&nbsp;
						<input type="hidden" name="query.qc_id" id="c_id" value="${customer.c_id }" />
						<input type="submit" value="搜索"><br/>
					</form>
					<c:forEach items="${slist }" var="slist">
					<div class="panel panel-default">
						<div class="panel-heading">
							<h3 class="panel-title">
								${slist.material.material_name }
							</h3>
						</div>
						
						<div class="panel-body">
							<div class="row">
								<div class="col-md-3"><img class="img-rounded img-responsive" src="${slist.material.material_url }"/></div>
								<div class="col-md-9">
									<dl>
										<dt>详情</dt>
										<dd>${slist.material.material_details }</dd>
										<dd>商品价格：${slist.material.material_price } <input type="hidden" name="material_price" id="material_price" value="${slist.material.material_price }" /></dd>
										<dd>购买数量：${slist.goodscount } <input type="hidden" name="m_count" id="m_count" value="${slist.goodscount }" /></dd>
										<dd>总价：${slist.pay }</dd>
									</dl>
								</div>
							</div>
						</div>
						<div class="panel-footer">
							<div class="row">
								<div class="col-md-8">
									购买日期：<fmt:formatDate value="${slist.create_date }" pattern="yyyy-MM-dd"/>
									支付方式：${slist.c_payment.payment }
									订单状态：
									<c:if test="${slist.column6!=25 }">
										<c:if test="${slist.column5!=8 }">商家处理订单中</c:if>
										<c:if test="${slist.column5==8 }">已发货，待验收</c:if>
									</c:if>
									<c:if test="${slist.column6==25 }">已确认收货</c:if>
									
									<input type="hidden" name="saleid" id="saleid" value="${slist.saleid }" />
								</div>
								<div class="col-md-4">
								<!-- 
									<div class="col-md-6 connect">
										<button><span class="glyphicon glyphicon-headphones" >联系客服</span></button>
									</div>
									 -->
									<c:if test="${slist.column6!=25 }">
										<div class="col-md-6 returngood">
											<button  onclick="tuihuo(${customer.c_id },${slist.saleid },${slist.goodscount },${slist.material.material_id });"><span class="glyphicon glyphicon-headphones">申请退货</span></button>
										</div>
										<div class="col-md-6 confirmgood">
											<button  onclick="shouhuo(${customer.c_id },${slist.saleid },${slist.goodscount },${slist.material.material_price });"><span class="glyphicon glyphicon-shopping-cart">确认收货</span></button>
										</div>
									</c:if>
									<c:if test="${slist.column6==25 }">
									<div class="col-md-6 confirmgood disabled">
										<span class="glyphicon glyphicon-shopping-cart">已确认收货</span>
									</div>
									</c:if>
									<!-- <div class="col-md-6 commitorder">
										<button><span class="glyphicon glyphicon-shopping-cart">提交订单<span></button>
									</div> -->
								</div>
							</div>
						</div>
					</div>
					</c:forEach>
					<!-- 结束 -->
					
					<!--下一页  -->
		  <font size="2">共${fy.pageCount}  页</font>&nbsp;&nbsp;
          <c:url var="cUrl" value="ca/sale_manage.action">
				<c:param name="query.qc_id" value="${fy.query.qc_id }"></c:param>
				<c:param name="query.qStartAddDate">
					<fmt:formatDate value='${fy.query.qStartAddDate }' pattern='yyyy-MM-dd'/>
				</c:param>
				<c:param name="query.qEndAddDate">
					<fmt:formatDate value='${fy.query.qEndAddDate }' pattern='yyyy-MM-dd'/>
				</c:param>
				
			</c:url>
           <a href="${cUrl }&page=1">首页</a>
			<c:choose>
				<c:when test="${fy.page==1 }">
					上一页
				</c:when>
				<c:otherwise>
					<a href="${cUrl }&page=${fy.page-1}">上一页</a>
				</c:otherwise>
			</c:choose>
			&nbsp;&nbsp;<font size="2">第 ${fy.page}   页</font>&nbsp;&nbsp;
			<c:choose>
				<c:when test="${fy.page==fy.pageCount }">
					下一页
				</c:when>
				<c:otherwise>
					<a href="${cUrl }&page=${fy.page+1}">下一页</a>
				</c:otherwise>
			</c:choose>
			<a href="${cUrl }&page=${fy.pageCount}">尾页</a>
					
				</div>
			</div>
		</div>
	</body>
</html>
