<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %>
<%@taglib uri="http://shiro.apache.org/tags" prefix="shiro" %>
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
.font051 {font-family: "宋体";
	font-size: 12px;
	color: #333333;
	text-decoration: none;
	line-height: 20px;
}
.font201 {font-family: "宋体";
	font-size: 12px;
	color: #FF0000;
	text-decoration: none;
}
.button {
	font-family: "宋体";
	font-size: 14px;
	height: 37px;
}
#tab tr td{
		text-align: center;
	}
html { overflow-x: auto; overflow-y: auto; border:0;} 
-->
</style>

<link href="css/css.css" rel="stylesheet" type="text/css" />
<script type="text/JavaScript">

</script>
<link href="css/style.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" type="text/css" href="js/easyui/themes/default/easyui.css"/>
<link rel="stylesheet" type="text/css" href="js/easyui/themes/icon.css"/>
<script type="text/javascript" src="js/jquery-1.8.3.js"></script>
<script type="text/javascript" src="js/easyui/jquery.easyui.min.js"></script>
<script language="javascript">

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
		onload = function(){
			var pagination = geld("pagination").value
			if(pagination==""){
				document.location="ml/fy";
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
<body>
<div id="dlg"  ></div>
	<table width="100%" border="0" cellspacing="0" cellpadding="0">
  <tr>
    <td height="30">      
    	<table width="100%" border="0" cellspacing="0" cellpadding="0">
        	<tr>
        		<!-- 搜索部分开始 -->
          		<td height="62" background="images/nav04.gif">
	          		<form name="lookml" id="lookbook" method="get">
	          		<input type="hidden" name="pagination" id="pagination" value="${pagination }" /> 
					<input type="hidden" name="pag" id="pag"value="${allpag }" />
			   			<table width="98%" border="0" align="center" cellpadding="0" cellspacing="0">
			    			<tr>
				  				<td width="21"><img src="images/ico07.gif" width="20" height="18" /></td>
				  				<td width="538">查看内容：
									物资名搜索:<input type="text" size="12" name="linchpin" value="${linchpin }" />
									价格搜索：<input type="text" size="8" name="sprice" value="${sprice }" />-<input type="text" size="8" name="tprice" value="${tprice }" />
									<!-- <input name="Submit4" type="submit" class="right-button02" value="查 询" /> -->
									<input type="submit" value="查询" onclick="a();" />
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
          	 			<%-- <tr>
               				<td height="20">
               					<span class="newfont07">选择：
               						<a href="javascript:void(0);" class="right-font08" onclick="selectAll();">全选</a>
               						---<a href="javascript:void(0);" class="right-font08" onclick="unselectAll();">反选</a>
               					</span>
               					<shiro:hasPermission name="uc/deleteuser">
	              					<input name="deleteuser" type="button" class="right-button08" value="删除所选用户" />
	              				</shiro:hasPermission>
	              				<shiro:hasPermission name="uc/adduser">
	              					<input name="adduser" type="button" class="right-button08" value="添加用户" onclick="link();"/>
	              				</shiro:hasPermission>
	              			</td>
          	 			</tr> --%>
          	 			
          	 			<!-- 表格部分开始 -->
              			<tr>
                			<td height="40" class="font42">
								<table width="100%" border="0" cellpadding="4" cellspacing="1" bgcolor="#464646" class="newfont03" id="tab">
				 					<tr class="CTitle" >
                    					<td height="22" width="" colspan="8" align="center" style="font-size:16px">金蝶物资展示列表</td>
                  					</tr>
                  					<tr bgcolor="#EEEEEE">
                  						<th width="5%">编号</th>
                    					<th width="10%">物品名</th>
                    					<th width="8%">库存数量</th>
										<th width="10%">价格</th>
										<th width="12%">图片</th>
										<th width="9%">仓库地址</th>
										<th width="12%">物资详情</th>
										<th width="9%">仓库状态</th>
                  					</tr>
                  					<c:if test="${!empty mllist}">
					<c:forEach items="${mllist }" var="ml">
				                  <tr bgcolor="#FFFFFF">
										<td >${ml.material_id }</td>
										<td >${ml.material_name }</td>
										<td >${ml.depot.depot_sum}</td>
										<td>￥${ml.material_price}</td>
										<td ><img style="width: 250px;height: 150px;" src="${ml.material_url}"/></td>
										<td >${ml.depot.depot_name}</td>
										<td >${ml.material_details}</td>
										<td >${ml.state.statename}</td>
				                  </tr>
				                  
				                  </c:forEach>
				                  	</c:if>
            					</table>
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
												共 <span class="right-text09">${allpag }</span> 页 | 
												第 <span class="right-text09">${pagination }</span> 页
											</td>
												<td width="49%" align="right">
													[<input type="button" name="firstPage" value="首页" onclick="gotoPage(1);"/> | 
													<input type="button" name="previous" value="上一页" onclick="gotoPage(${pagination}-1);"/> | 
													<input type="button" name="next" value="下一页" onclick="gotoPage(${pagination}+1);"/> | 
													<input type="button" name="last" value="最后一页" onclick="gotoPage(${allpag});"/>]
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
