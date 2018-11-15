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
		/* 二级审核,和控制器交互,传递数据(订单编号) */
		function shenhe(id){
			sale.action="sea/updatestateid?states="+id;
			sale.submit();
		}
		function bohui(id){
			sale.action="sea/updatestateid1?states="+id;
			sale.submit();
		}
		/* 三级审核呢 */
	 	function shenhe1(id){
			sale.action="sea/updatestateid2?states="+id;
			sale.submit();
		}
		function bohui1(id){
			sale.action="sea/updatestateid3?states="+id;
			sale.submit();
		} 
		/* 四级审核 */
	 	function shenhe2(id){
			sale.action="sea/updatestateid4?states="+id;
			sale.submit();
		}
		function bohui2(id){
			sale.action="sea/updatestateid5?states="+id;
			sale.submit();
		} 
	</script>
	<script type="text/javascript">
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
	          		<form action="pc/gopage" method="post">
			   			<table width="98%" border="0" align="center" cellpadding="0" cellspacing="0">
			    			<tr>
				  				<td width="21"><img src="images/ico07.gif" width="20" height="18" /></td>
				  				<td width="538">查看内容：
									销售订单编号：<input size="5" type="text" name="saleid" value="${l.sale.saleid}" >
									客户名查询：<input type="text" size="5" name="c_name" value="${l.customer.c_name }" />
									客户编号：<input type="text"  size="5"name="c_id" value="${l.customer.c_id }" >
									商品编号：<input size="5" type="text" name="material_id" value="${l.material.material_id }" >
									地址查询：<input type="text" size="5" name="sendaddr" value="${l.customer.c_address }" />
									添加日期开始:<input size="5" type="date" onclick="WdatePicker()" value="<fmt:formatDate value='${qStartAddDate }' pattern='yyyy-MM-dd'/>">
	  								添加日期结束: <input size="5" type="date" value="<fmt:formatDate value='${qEndAddDate }' pattern='yyyy-MM-dd'/>">
									<input type="submit" value="搜索">
									
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
                  						<c:forEach items="${lss }" var="l">
										<tr bgcolor="#FFFFFF">
										<td class="noExl"><input type="checkbox" value="${l.sale.saleid}" class="check" name="box"></td> 
										<td>${l.sale.saleid}</td>
										<td>${l.customer.c_id }</td>
										<td>${l.customer.c_name }</td>
										<td>${l.customer.c_phone }</td>
										<td>${l.customer.c_address }</td>
										<td>${l.sale.goodscount }</td>
										<td>${l.material.material_id }</td>
										<td>${l.material.material_name }</td>
										<td>${l.material.material_price }</td>
										<td>${l.payment.payment }</td>
										<td><fmt:formatDate value="${l.sale.need_date }" pattern="yyyy-MM-dd"/></td>
										<td><fmt:formatDate value="${l.sale.last_date }" pattern="yyyy-MM-dd"/></td>
										<td><fmt:formatDate value="${l.sale.first_date }" pattern="yyyy-MM-dd"/></td>
										<td><fmt:formatDate value="${l.sale.create_date }" pattern="yyyy-MM-dd"/></td>
										<td>${l.state.statename }</td><!-- 提交过来的审核状态 -->
										<td>${l.state1.statename  }</td><!-- 仓库经理的审核状态 -->
										<td>${l.state2.statename }</td><!-- 财务经理的审核状态 -->
										<td>${l.state3.statename  }</td><!-- 总经理审批 --> 
										<td>
											<shiro:hasPermission name="sea/updatestateid">
												<input type="button" value="仓管审核" onclick="shenhe(${l.sale.saleid})" /><!--${l.sale.saleid}指明要操作的是哪条订单  -->
											</shiro:hasPermission>
											<shiro:hasPermission name="sea/updatestateid1">
												<input type="button" value="仓管驳回" onclick="bohui(${l.sale.saleid})" />
											</shiro:hasPermission>
											<shiro:hasPermission name="sea/updatestateid2">
												<input type="button" value="财务审核" onclick="shenhe1(${l.sale.saleid})" />
											</shiro:hasPermission>
											<shiro:hasPermission name="sea/updatestateid3">	
												<input type="button" value="财务驳回" onclick="bohui1(${l.sale.saleid})" />
											</shiro:hasPermission>
											<shiro:hasPermission name="sea/updatestateid4">	
												<input type="button" value="老总审核" onclick="shenhe2(${l.sale.saleid})" />
											</shiro:hasPermission>
											<shiro:hasPermission name="sea/updatestateid5">
												<input type="button" value="老总驳回" onclick="bohui2(${l.sale.saleid})" />
											</shiro:hasPermission>
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
													<a href="javascript:gotoPage(${cp}-1)" >上一页</a>| 
													<a href="javascript:gotoPage(${cp}+1)" >下一页</a> | 
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























































<%-- 
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://shiro.apache.org/tags" prefix="shiro" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
    <title>销售订单审核页面</title>
	<!-- <meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page"> -->
	<style type="text/css">
	</style>
	<link href="css/css.css" rel="stylesheet" type="text/css" />
	<link rel="stylesheet" type="text/css" href="js/easyui/themes/default/easyui.css"/>
	<link rel="stylesheet" type="text/css" href="js/easyui/themes/icon.css"/>
	<script type="text/JavaScript"></script>
	<script type="text/javascript" src="js/easyui/jquery.easyui.min.js"></script>
	<script src="js/jquery.table2excel.js"></script>
	<!-- <link rel="stylesheet" href="css/bootstrap.css" />
	<link rel="stylesheet" href="css/bootstrap-theme.css" />
	<script src="js/jquery.js"></script>
	<script src="js/bootstrap.js"></script>
	<script src="jquery.table2excel.js"></script>-->
	<script> 
		/* 二级审核,和控制器交互,传递数据(订单编号) */
		function shenhe(id){
			sale.action="sea/updatestateid?states="+id;
			sale.submit();
		}
		function bohui(id){
			sale.action="sea/updatestateid1?states="+id;
			sale.submit();
		}
		/* 三级审核呢 */
	 	function shenhe1(id){
			sale.action="sea/updatestateid2?states="+id;
			sale.submit();
		}
		function bohui1(id){
			sale.action="sea/updatestateid3?states="+id;
			sale.submit();
		} 
		/* 四级审核 */
	 	function shenhe2(id){
			sale.action="sea/updatestateid4?states="+id;
			sale.submit();
		}
		function bohui2(id){
			sale.action="sea/updatestateid5?states="+id;
			sale.submit();
		} 
	</script>
	<script type="text/javascript">
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
  <div id="dlg" ></div>
  	<table width="100%" border="0" cellspacing="0" cellpadding="0">
  		<tr>
  			<td height="30">
  				<table width="100%" border="0" cellspacing="0" cellpadding="0">
        	<tr>
        		<!-- 搜索部分开始 -->
          		<td height="62" background="images/nav04.gif">
		   			<table width="98%" border="0" align="center" cellpadding="0" cellspacing="0">
		    			<tr>
			  				<td width="21"><img src="images/ico07.gif" width="20" height="18" /></td>
			  				<td width="538">查看内容：
								搜索 ：销售订单编号：<input size="5" type="text" name="saleid" value="" >
								客户名查询：<input type="text" size="5" name="c_name" value="" />
								客户编号：<input type="text"  size="5"name="c_id" value="" >
								商品编号编号：<input size="5" type="text" name="material_id" value="" >
								地址查询：<input type="text" size="5" name="sendaddr" value="" />
								添加日期开始:<input size="5" type="date" onclick="WdatePicker()" value="<fmt:formatDate value='${qStartAddDate }' pattern='yyyy-MM-dd'/>">
  								添加日期结束: <input size="5" type="date" value="<fmt:formatDate value='${qEndAddDate }' pattern='yyyy-MM-dd'/>">
								<input type="submit" value="搜索">
								<input type="button" id="ExportExcel" name="ExportExcel" value="导出数据"  /> 
							</td>
		    			</tr>
          			</table>
	          	</td>
	         </tr>
          	</table>	
          		<!-- 搜索部分结束 -->
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
                    					<td height="22" width="" colspan="23" align="center" style="font-size:16px">金蝶出货列表</td>
                  					</tr>
                  					<tr bgcolor="#EEEEEE">
										<td class="noExl" style="width: 50px;"><input id="all" type="checkbox" /></td>	
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
								<c:forEach items="${lss }" var="l">
									<tr bgcolor="#FFFFFF">
										
										<td class="noExl"><input type="checkbox"  class="check" name="box"></td> 
										<td>${l.sale.saleid}</td>
										<td>${l.customer.c_id }</td>
										<td>${l.customer.c_name }</td>
										<td>${l.customer.c_phone }</td>
										<td>${l.customer.c_address }</td>
										<td>${l.sale.goodscount }</td>
										<td>${l.material.material_id }</td>
										<td>${l.material.material_name }</td>
										<td>${l.material.material_price }</td>
										<td>${l.payment.payment }</td>
										<td><fmt:formatDate value="${l.sale.need_date }" pattern="yyyy-MM-dd"/></td>
										<td><fmt:formatDate value="${l.sale.last_date }" pattern="yyyy-MM-dd"/></td>
										<td><fmt:formatDate value="${l.sale.first_date }" pattern="yyyy-MM-dd"/></td>
										<td><fmt:formatDate value="${l.sale.create_date }" pattern="yyyy-MM-dd"/></td>
										<td>${l.state.statename }</td><!-- 提交过来的审核状态 -->
										<td>${l.state1.statename  }</td><!-- 仓库经理的审核状态 -->
										<td>${l.state2.statename }</td><!-- 财务经理的审核状态 -->
										<td>${l.state3.statename  }</td><!-- 总经理审批 --> 
										<td>
											<shiro:hasPermission name="sea/updatestateid">
												<input type="button" value="仓管审核" onclick="shenhe(${l.sale.saleid})" /><!--${l.sale.saleid}指明要操作的是哪条订单  -->
											</shiro:hasPermission>
											<shiro:hasPermission name="sea/updatestateid1">
												<input type="button" value="仓管驳回" onclick="bohui(${l.sale.saleid})" />
											</shiro:hasPermission>
											<shiro:hasPermission name="sea/updatestateid2">
												<input type="button" value="财务审核" onclick="shenhe1(${l.sale.saleid})" />
											</shiro:hasPermission>
											<shiro:hasPermission name="sea/updatestateid3">	
												<input type="button" value="财务驳回" onclick="bohui1(${l.sale.saleid})" />
											</shiro:hasPermission>
											<shiro:hasPermission name="sea/updatestateid4">	
												<input type="button" value="老总审核" onclick="shenhe2(${l.sale.saleid})" />
											</shiro:hasPermission>
											<shiro:hasPermission name="sea/updatestateid5">
												<input type="button" value="老总驳回" onclick="bohui2(${l.sale.saleid})" />
											</shiro:hasPermission>
										</td>
										
									</tr>
								</c:forEach>
							</table>
            			</form>
            		</td>
        		</tr>
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
													<a href="javascript:gotoPage(${cp}-1)" >上一页</a>| 
													<a href="javascript:gotoPage(${cp}+1)" >下一页</a> | 
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
</body> --%>
<!-- </html> -->