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
<link href="css/style.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" type="text/css" href="js/easyui/themes/default/easyui.css"/>
<link rel="stylesheet" type="text/css" href="js/easyui/themes/icon.css"/>
<script type="text/javascript" src="js/jquery-1.8.3.js"></script>
<script type="text/javascript" src="js/easyui/jquery.easyui.min.js"></script>
<script src="js/jquery.table2excel.js"></script>
<script >
	function songshen(id){
		//alert(id);
		/* var page = parseInt(pageNum);
		var allp = document.getElementById("allpage").value;
		var cp = document.getElementById("cp");
		var allpage = parseInt(allp);

		if(page<=0){
			cp.value = 1;
		}else if(page>allpage){
			cp.value = allpage;
		}else{
			cp.value = page;
		} */
		sale.action="pc/updatestate?status="+id;
		sale.submit();
	}
</script>
<script type="text/javascript">
	$(function () {
		   $("#ExportExcel").click(function(){
	  	  
	  	  $("#tab").table2excel({
	  		  exclude:$(".noExl"),
	  		  name:"Excel Document Name",
	  		  filename:generateRandowNumber(),
	  		  exclude_img:true,
	  	  	  exclude_links:true,
	  	  	  exclude_inputs:true
	  	  });
	  	  
	  	  
	    });
	    
	})
	
	function generateRandowNumber(){
		  var numbers = [0,1,2,3,4,5,6,7,8,9];
		  var chars = ["a","b","c","d","e","f","g","h","i","j"]
		  var index1 = parseInt(Math.random()*10);var index2 = parseInt(Math.random()*10);var index3 = parseInt(Math.random()*10);
		  var index4 = parseInt(Math.random()*10);var index5 = parseInt(Math.random()*10);var index6 = parseInt(Math.random()*10);
		  var index7 = parseInt(Math.random()*10);var index8 = parseInt(Math.random()*10);var index9 = parseInt(Math.random()*10);
		  var number = ""+numbers[index1]+chars[index2]+numbers[index3]+numbers[index4]+chars[index5]+numbers[index6]+numbers[index7]+chars[index8]+numbers[index9];
		  console.log(number);
		  return number;
	}
	function getPage(obj){
		var node = document.getElementById("getforPage");
		var page = parseInt(node.value);
		if(page!=null||page!=""){
			gotoPage(page);
		}
	}
	
function gotoPage(pageNum){
		
		//console.log(forSplitView);
		
		var page = parseInt(pageNum);
		var allp = document.getElementById("allpage").value;
		var cp = document.getElementById("cp");
		var allpage = parseInt(allp);

		if(page<=0){
			cp.value = 1;
		}else if(page>allpage){
			cp.value = allpage;
		}else{
			cp.value = page;
		}
		
		sale.submit();
	}
</script>
</head>
<body>
<div id="dlg"  >
	
</div>
	<table width="100%" border="0" cellspacing="0" cellpadding="0">
  <tr>
    <td height="30">      
    	<table width="100%" border="0" cellspacing="0" cellpadding="0">
        	<tr>
        		<!-- 搜索部分开始 -->
          		<td height="62" background="images/nav04.gif">
	          		<form action="pc/gogoods" method="post">
			   			<table width="98%" border="0" align="center" cellpadding="0" cellspacing="0">
			    			<tr>
				  				<td width="21"><img src="images/ico07.gif" width="20" height="18" /></td>
				  				<td width="538">查看内容：
									搜索 ：退货订单编号：<input type="text" name="orderid" value="" >
									客户编号：<input type="text" name="c_id" value="" >
									客户名查询：<input type="text" name="c_name" value="" />
									商品编号编号：<input type="text" name="material_id" value="" >
									添加日期开始:<input type="date" value="<fmt:formatDate value='${qStartAddDate }' pattern='yyyy-MM-dd'/>">
							  		添加日期结束: <input type="date" value="<fmt:formatDate value='${qEndAddDate }' pattern='yyyy-MM-dd'/>">
									<input type="submit" value="搜索">
									<input type="button" id="ExportExcel" name="ExportExcel" value="导出数据"  /> 
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
    	<table id="subtree1" style="DISPLAY: " width="100%" border="0" cellspacing="0" cellpadding="0">
        	<tr>
          		<td>
          			<table width="95%" border="0" align="center" cellpadding="0" cellspacing="0">
          	 			<!-- 表格部分开始 -->
              			<tr>
                			<td height="40" class="font42">
                			<form id="sale" method="post" name="sale" action="" >
	                			<input type="hidden" name="cp" id = "cp" value="1"/>
								<input type="hidden" name="allpage" id= "allpage" value="${allpage }"/>
								<table width="100%" border="0" cellpadding="4" cellspacing="1" bgcolor="#464646" class="newfont03" id="tab">
				 					<tr class="CTitle" >
                    					<td height="22" width="" colspan="18" align="center" style="font-size:16px">金蝶退货列表</td>
                  					</tr>
                  					<tr bgcolor="#EEEEEE">
												<th class="noExl" style="width: 50px;"><input id="all" type="checkbox" /></td>
												<th>订单编号</th>
												<th>客户 编号</th>
												<th>客户 姓名</th>
												<th>客户 电话</th>
												<th>客户 地址</th>
												<th>客户购买数量</th>
												<th>商品编号</th>
												<th>商品名</th>
												<th>商品单价</th> 
												<th>商品图片</th>
												<th>库存数量</th>
												<th>订单生成日期</th>
												<th>退货原因</th>
												<th>操作</th>
                  					</tr>
                  						<c:forEach items="${lf }" var="l">
										<tr bgcolor="#FFFFFF">
												<td class="noExl"><input name="product" type="checkbox" value="${cus.userid } "/></td>
												<td>${l.returngoods.orderid}</td>
												<td>${l.returngoods.c_id }</td>
												<td>${l.customer.c_name }</td>
												<td>${l.customer.c_phone }</td>
												<td>${l.customer.c_address }</td>
												<td>${l.returngoods.goodscount }</td>
												<td>${l.material.material_id }</td>
												<td>${l.material.material_name }</td>
												<td>${l.material.material_price }</td>
												<%-- <td><img width="50px" height="40px" src="${l.material.material_url" } /></td> --%>
												<td><img width="50px" height="40px" src="${l.material.material_url }" /></td>
												<td>${l.material.material_sum }</td>
												<td><fmt:formatDate value="${l.returngoods.orderdate }" pattern="yyyy-MM-dd"/></td>
												<td>${l.returngoods.returnreason }</td>
												<td>${l.state.statename }</td>
												<td>
												<c:if test="${l.returngoods.stateid eq '0' }">
												<input type="button" value="退货" onclick="songshen(${l.returngoods.orderid})" />
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
      				<jsp:include page="${pageUrl }"></jsp:include>
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
													[<a href="javascript:gotoPage(1)" >首页</a> | 
													<c:if test="${cp-1==0}">
														上一页|
													</c:if>
													<c:if test="${cp-1>0}">
														<a href="javascript:gotoPage(${cp}-1)" >上一页</a>| 
													</c:if>
													<c:if test="${cp == allpage}">
														下一页|
													</c:if>
													<c:if test="${cp<allpage}">
														<a href="javascript:gotoPage(${cp}+1)" >下一页</a>| 
													</c:if>
													 <a href="javascript:gotoPage(${allpage })" >末页</a>]转至
												</td>
													<td width="1%">
												<table width="20" border="0" cellspacing="0" cellpadding="0">
						 							<tr>
						 								<td width="1%">
       														<input id="getforPage" name="textfield3" type="text"  size="1" />
						 								</td>
						 								<td width="87%">
       													<input name="Submit23222" type="button" value="Go" onclick="getPage();"/>
						 								</td>
						 							</tr>
												</table>
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
