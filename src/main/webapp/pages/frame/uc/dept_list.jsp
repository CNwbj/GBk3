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
<title>岗位列表页面</title>
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

function link(){
   location.href="dc/preadddept";
}
</script>
</head>
<body>
<div id="dlg"  ></div>
<table width="100%" border="0" cellspacing="0" cellpadding="0">
  <tr><td height="30"></td></tr>
  <tr>
    <td>
    	<table id="subtree1" style="DISPLAY: " width="100%" border="0" cellspacing="0" cellpadding="0">
        	<tr>
          		<td>
          			<table width="95%" border="0" align="center" cellpadding="0" cellspacing="0">
          	 			<tr>
               				<td height="20">
	              				<shiro:hasPermission name="dc/adddept">
	              					<input name="adddept" type="button" class="right-button08" value="添加部门" onclick="link();"/>
	              				</shiro:hasPermission>
	              			</td>
          	 			</tr>
          	 			<tr>
               				<td height="20">
	              			</td>
          	 			</tr>
          	 			<!-- 表格部分开始 -->
              			<tr>
                			<td height="40" class="font42">
								<table width="100%" border="0" cellpadding="4" cellspacing="1" bgcolor="#464646" class="newfont03" id="tab">
				 					<tr class="CTitle" >
                    					<td height="40" colspan="4" align="center" style="font-size:16px">部门列表</td>
                  					</tr>
                  					<tr bgcolor="#EEEEEE">
                    					<th width="5%">编号</th>
                    					<th width="10%">部门名称</th>
                    					<th width="10%">部门人数</th>
                    					<td width="10%">操作</td>
                  					</tr>
                  					<c:forEach items="${deptlist }" var="dept">
				                  <tr bgcolor="#FFFFFF">
				                    <td>${dept.deptno }</td>
				                    <td>${dept.dname }</td>
				                    <td>${dept.usercount }</td>
				                    <td><form action="uc/findusersplitBySc?deptno=${dept.deptno }" method="post"><input type="submit" value="查看本部员工"/></form></td>
				                  </tr>
				                  </c:forEach>
            					</table>
            				</td>
        				</tr>
        				<!-- 表格部分结束 -->
      				</table>
      			</td>
  			</tr>
		</table>
	</td>
</tr>
</table>
</body>
</html>
