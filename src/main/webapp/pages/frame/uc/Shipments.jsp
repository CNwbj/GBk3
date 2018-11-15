<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://shiro.apache.org/tags" prefix="shiro"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%
	String path = request.getContextPath();
	String basepath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<base href="<%=basepath%>" />
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<title>用户列表页面</title>
<style type="text/css">
<!--
body {
	margin-left: 0px;
	margin-top: 0px;
	margin-right: 0px;
	margin-bottom: 0px;
}

.tabfont01 {
	font-family: "宋体";
	font-size: 9px;
	color: #555555;
	text-decoration: none;
	text-align: center;
}

.font051 {
	font-family: "宋体";
	font-size: 12px;
	color: #333333;
	text-decoration: none;
	line-height: 20px;
}

.font201 {
	font-family: "宋体";
	font-size: 12px;
	color: #FF0000;
	text-decoration: none;
}

.button {
	font-family: "宋体";
	font-size: 14px;
	height: 37px;
}

#tab tr td {
	text-align: center;
}

.aclass {
	pointer-events: none;
	cursor: not-allowed;
}

html {
	overflow-x: auto;
	overflow-y: auto;
	border: 0;
}
-->
</style>

<link href="css/css.css" rel="stylesheet" type="text/css" />
<script type="text/JavaScript">

</script>
<link href="css/style.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" type="text/css"
	href="js/easyui/themes/default/easyui.css" />
<link rel="stylesheet" type="text/css" href="js/easyui/themes/icon.css" />
<script type="text/javascript" src="js/jquery-1.8.3.js"></script>
<script type="text/javascript" src="js/easyui/jquery.easyui.min.js"></script>
<script language="javascript">
onload = function(){
	var pagination = geld("pagination").value
	if(pagination==""){
		document.location="ml/ch";
	} 

} 

function selectAll(){
	var obj = document.fom.elements;
	for (var i=0;i<obj.length;i++){
		if (obj[i].name == "delid"){
			obj[i].checked = true;
		}
	}
}

function unselectAll(){
	var obj = document.fom.elements;
	for (var i=0;i<obj.length;i++){
		if (obj[i].name == "delid"){
			if (obj[i].checked==true){ 
				obj[i].checked = false;
				}else{ 
					obj[i].checked = true;
				}
		}
	}
}
/* 		onload = function(){
			var pagination = geld("pagination").value
			if(pagination==""){
				document.location="ml/ch";
			} 
		
	} */
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
	sh.submit();
}

</script>

</head>
<body>
	<div id="dlg"></div>
	<table width="100%" border="0" cellspacing="0" cellpadding="0">
		<tr>
			<td height="30">
				<table width="100%" border="0" cellspacing="0" cellpadding="0">
					<tr>
						<!-- 搜索部分开始 -->
						<td height="62" background="images/nav04.gif">
							<form name="lookml" id="lookbook" method="get">
								<input type="hidden" name="pagination" id="pagination"
									value="${pagination }" /> <input type="hidden" name="pag"
									id="pag" value="${allpag }" />
								<table width="98%" border="0" align="center" cellpadding="0"
									cellspacing="0">
									<tr>
										<td width="21"><img src="images/ico07.gif" width="20"
											height="18" /></td>
										<td width="538">查看内容： 物资名搜索:<input type="text" size="12"
											name="linchpin" value="${linchpin }" /> 订单结束时间搜索：<input
											size="10" type="date" name="startTime" value="${startTime }" />-<input
											type="date" size="10" name="stopTime" value="${stopTime }" />
											<select name="statename">
												<option>---请选择---</option>
												<c:if test="${!empty statename }">
													<option value="${statename }" selected>${statename }</option>
												</c:if>
												<option value="已发货">已发货</option>
												<option value="未发货">未发货</option>
										</select> <input type="submit" value="查询" name="sh" id="sh" " />
										</td>
									</tr>
								</table>
							</form>
						</td>
						<!-- 搜索部分结束 -->
					</tr>
				</table>
			</td>
		</tr>
		<tr>
			<td>
				<table id="subtree1" style="DISPLAY:" width="100%" border="0"
					cellspacing="0" cellpadding="0">
					<tr>
						<td>
							<table width="95%" border="0" align="center" cellpadding="0"
								cellspacing="0">
								<!-- 表格部分开始 -->
								<tr>
									<td height="40" class="font42">
										<table width="100%" border="0" cellpadding="4" cellspacing="1"
											bgcolor="#464646" class="newfont03" id="tab">
											<tr class="CTitle">
												<td height="22" width="" colspan="13" align="center"
													style="font-size: 16px">金蝶出货列表</td>
											</tr>
											<tr bgcolor="#EEEEEE">
												<!-- <th width="4%" align="center" height="30">选择</th> -->
												<th width="5%">编号</th>
												<th width="5%">物资名</th>
												<th width="12%">图片</th>
												<th width="5%">价格</th>
												<th width="8">销售数量</th>
												<th width="6%">下单时间</th>
												<th width="6%">发货时间</th>
												<th width="4%">客户名</th>
												<th width="9%">收货地址</th>
												<th width="4%">金额</th>
												<th width="5%">订单状态</th>
												<th width="12%">物资详情</th>
												<th width="8%">操作</th>
											</tr>
											<c:if test="${!empty shlist}">
												<c:forEach items="${shlist }" var="sh">
													<tr bgcolor="#FFFFFF">
														<!-- <th width="4%" align="center" height="30">选择</th> -->
														<td>${sh.sale.saleid }</td>
														<td>${sh.material.material_name }</td>
														<td ><img style="width: 250px;height: 150px;" src="${sh.material.material_url}"/></td>
														<td>￥${sh.material.material_price}</td>
														<td>${sh.sale.goodscount}</td>
														<td><fmt:formatDate value="${sh.sale.create_date }"
																pattern="yyyy-MM-dd" /></td>
														<td><fmt:formatDate value="${sh.sale.first_date }"
																pattern="yyyy-MM-dd" /></td>
														<td>${sh.customer.c_name}</td>
														<td>${sh.customer.c_address}</td>
														<td>￥${sh.material.material_price*sh.sale.goodscount}</td>
														<td id="${sh.sale.saleid }">${sh.sendGoodState.statename}</td>
														<td>${sh.material.material_details}</td>
														<td>
															<c:if test="${sh.sendGoodState.stateid==9 }">
																<a class="showdate" href="ml/mend?saleid=${sh.sale.saleid }" id="${sh.sale.saleid }">发货</a>
															</c:if>
															<c:if test="${sh.sendGoodState.stateid==8 }">
																<span>已发货</span>
															</c:if> 
														</td>
													</tr>
												</c:forEach>
											</c:if>
										</table>
									</td>
								</tr>
								<!-- 表格部分结束 -->
							</table>
							<table width="95%" border="0" align="center" cellpadding="0"
								cellspacing="0">
								<tr>
									<td height="6"><img src="images/spacer.gif" width="1"
										height="1" /></td>
								</tr>
								<tr>
									<td height="33">
										<table width="100%" border="0" align="center" cellpadding="0"
											cellspacing="0" class="right-font08">
											<tr>
												<td width="50%">共 <span class="right-text09">${allpag }</span>
													页 | 第 <span class="right-text09">${pagination }</span> 页
												</td>
												<td width="49%" align="right">[<input type="button"
													name="firstPage" value="首页" onclick="gotoPage(1);" /> | <input
													type="button" name="previous" value="上一页"
													onclick="gotoPage(${pagination}-1);" /> | <input
													type="button" name="next" value="下一页"
													onclick="gotoPage(${pagination}+1);" /> | <input
													type="button" name="last" value="最后一页"
													onclick="gotoPage(${allpag});" />]
												</td>
											</tr>
										</table> <!-- 分页部分结束 -->
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
