<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %>
<%@taglib uri="http://shiro.apache.org/tags" prefix="shiro" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%
	String path = request.getContextPath();
	String basepath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";

%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<base href="<%=basepath %>" />
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<title>用户列表页面</title>
<style type="text/css">
</style>

<link href="css/css.css" rel="stylesheet" type="text/css" />
<script type="text/JavaScript">

</script>
<link href="css/style.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" type="text/css" href="js/easyui/themes/default/easyui.css"/>
<link rel="stylesheet" type="text/css" href="js/easyui/themes/icon.css"/>
<script type="text/javascript" src="js/jquery-1.8.3.js"></script>
<script type="text/javascript" src="js/easyui/jquery.easyui.min.js"></script>
<script type="text/javascript" src="My97DatePicker/WdatePicker.js"></script>
<script src="js/jquery.table2excel.js"></script>
<script> 
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
<div id="dlg"  >
	
</div>
	<table width="100%" border="0" cellspacing="0" cellpadding="0">
		  <tr>
		    <td>
		    	<table id="subtree1" style="DISPLAY: " width="100%" border="0" cellspacing="0" cellpadding="0">
		        	<tr>
		          		<td>
		          			<table width="95%" border="0" align="center" cellpadding="0" cellspacing="0">
		          	 			<!-- 表格部分开始 -->
		              			<tr>
		                			<td height="40" class="font42">
		                			<form id="sale" method="post" name="sale" action="" enctype="multipart/form-data">
			                			<input type="hidden" name="cp" id = "cp" value="1"/>
										<input type="hidden" name="allpage" id= "allpage" value="${allpage }"/>
										<table width="100%" border="0" cellpadding="4" cellspacing="1" bgcolor="#464646" class="newfont03" id="tab">
						 					<tr class="CTitle" >
		                    					<td height="22" width="" colspan="23" align="center" style="font-size:16px">金蝶销售单审核表</td>
		                  					</tr>
		                  					<tr bgcolor="#EEEEEE">
												<!-- <td class="noExl" style="width: 50px;"><input id="all" type="checkbox" /></td> -->
												<td>选项</td>
												<td>订单编号</td>
												<td>客户 编号</td>
												<td>客户 姓名</td>
												<td>客户 电话</td>
												<td>客户 地址</td>
												<td>客户购买数量</td>
												<td>商品编号</td>
												<td>商品名</td>
												<td>商品单价</td>						
												<td>支付方式</td>
												<td>客户需求日期</td>
												<td>最后编制日期</td>
												<td>开始编制日期</td>
												<td>订单生成日期</td>
												<td>营销主管意见</td>
												<td>仓库主管意见</td>
												<td>财务主管意见</td>
												<td>总经理意见</td>				
												<td>操作</td>
		                  					</tr>
		                  						<c:forEach items="${fulist }" var="fu">
												<tr bgcolor="#FFFFFF">
												<td class="noExl"><input type="checkbox" value="${fu.sale.saleid}" class="check" name="box"></td> 
												<td>${fu.sale.saleid}</td>
												<td>${fu.customer.c_id }</td>
												<td>${fu.customer.c_name }</td>
												<td>${fu.customer.c_phone }</td>
												<td>$fu.customer.c_address }</td>
												<td>${fu.sale.goodscount }</td>
												<td>${fu.material.material_id }</td>
												<td>${fu.material.material_name }</td>
												<td>${fu.material.material_price }</td>
												<td>${fu.payment.payment }</td>
												<td><fmt:formatDate value="${fu.sale.need_date }" pattern="yyyy-MM-dd"/></td>
												<td><fmt:formatDate value="${fu.sale.last_date }" pattern="yyyy-MM-dd"/></td>
												<td><fmt:formatDate value="${fu.sale.first_date }" pattern="yyyy-MM-dd"/></td>
												<td><fmt:formatDate value="${fu.sale.create_date }" pattern="yyyy-MM-dd"/></td>
												<c:forEach items="${stalist }" var="sta" >
													<c:if test="${fu.sale.column2==sta.stateid }"><td>${sta.statename }</td></c:if>
												</c:forEach>
												<c:forEach items="${stalist }" var="sta" >
													<c:if test="${fu.sale.column3==sta.stateid }"><td>${sta.statename }</td></c:if>
												</c:forEach>
												<c:forEach items="${stalist }" var="sta" >
													<c:if test="${fu.sale.column4==sta.stateid }"><td>${sta.statename }</td></c:if>
												</c:forEach>
												<c:forEach items="${stalist }" var="sta" >
													<c:if test="${fu.sale.column1==sta.stateid }"><td>${sta.statename }</td></c:if>
												</c:forEach>
												<td>
													<c:if test="${fu.sale.column1==6}">
													<input type="button" value="审核" onclick="jump(7,${fu.sale.saleid });"/>
													<input type="button" value="驳回" onclick="jump(22,${fu.sale.saleid });"/>
													</c:if>
												</td>
											</tr>
										</c:forEach>
		            					</table>
		            				</form>
		            				</td>
		        				</tr>
		        				<!-- 表格部分结束 -->
		      				</table>
		      				<table width="95%" border="0" align="center" cellpadding="0" cellspacing="0">
		        				<tr>
		          					<td height="6"><img src="images/spacer.gif" width="1" height="1" /></td>
		        				</tr>
		        				<tr>
		          					<td height="33">
											<table width="100%" border="0" align="center" cellpadding="0" cellspacing="0" class="right-font08">
												<tr>
													<td width="50%">
														共 <span class="right-text09">${allpage }</span> 页 | 
														第 <span class="right-text09">${cp }</span> 页
													</td>
														<td width="49%" align="right">
															<form action="fc/showSale" id="flowsale">
																<input type="hidden" value="${cp }" id="cp" name="cp" />
																<input type="hidden" value="${allpage}" id="allpage" name="allpage" />
																<input type="button" value="首页" onclick="gopage(1)"/>
																<input type="button" value="上一页" onclick="gopage(${cp-1})"/>
																<input type="button" value="下一页" onclick="gopage(${cp+1})"/>
																<input type="button" value="尾页" onclick="gopage(${allpage})"/>
															</form>
														</td>
												</tr>
											</table>
												
		          						<!-- 分页部分结束 -->
		          					</td>
		        				</tr>
		      				</table>
		      			</td>
		  			</tr>
				</table>
			</td>
		</tr>
	</table>
</body>
</html>
