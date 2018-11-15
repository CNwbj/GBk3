<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %>
<%
	String path = request.getContextPath();
	String basepath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";

%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<base href="<%=basepath %>" />
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<title>用户添加页面</title>
<link rel="stylesheet" rev="stylesheet" href="css/style.css" type="text/css" media="all" />
<script language="JavaScript" type="text/javascript">
function link(){
		alert('保存成功！');
	   document.getElementById("fom").action="uc/updateuser";
	   document.getElementById("fom").submit();
	}
</script>

<script type="text/javascript" src="js/jquery-1.8.3.js" ></script>
<script type="text/javascript" src="js/uploadPreView.js" ></script>
</head>

<body class="ContentBody">
  <form action="" method="post" name="fom" id="fom">
  <input type="hidden" value="${user.userid }" name="userid" id="userid" />
<div class="MainDiv">
<table width="99%" border="0" cellpadding="0" cellspacing="0" class="CContent">
  <tr>
      <th class="tablestyle_title" >修改用户页面</th>
  </tr>
  <tr>
    <td class="CPanel">
		<table border="0" cellpadding="0" cellspacing="0" style="width:100%">
			<tr>
				<td align="left">
					<input type="button" name="saveuser" value="保存" class="button" onclick="alert('保存成功！');"/>　
					<input type="button" name="goback" value="返回" class="button" onclick="window.history.go(-1);"/>
				</td>
			</tr>
			<tr>
				<td width="100%">
					<fieldset style="height:100%;">
						<legend>修改用户状态</legend>
					  	<table border="0" cellpadding="2" cellspacing="1" style="width:100%">
					  		<tr>
					    		<td nowrap align="right" width="13%">账户名称:</td>
					    		<td width="41%">
					    			<input name="loginname" value="${user.loginname }" readonly class="text" style="width:154px" type="text" size="40" />
				        		</td>
					    	</tr>
					  		<tr>
					    		<td nowrap align="right" width="13%">部门:</td>
					    		<td width="41%">
					    			<select name="deptno">
									    <c:forEach items="${deptlist}" var="dept">								
											<option value="${dept.deptno }" <c:if test="${dept.deptno eq user.deptno}">selected="selected"</c:if>>
											    ${dept.dname }
											</option>
									    </c:forEach> 
									</select>
				        		</td>
					    	</tr>
					  		
					   		<tr>
					    		
					    		<td align="right">用户状态:</td>
					    		<td>
					    			<input type="radio" name="is_dele" <c:if test="${1 eq user.is_dele}">checked</c:if> value="1"/>在职
					    			<input type="radio" name="is_dele" <c:if test="${0 eq user.is_dele}">checked</c:if> value="0"/>休假
					    			<input type="radio" name="is_dele" <c:if test="${3 eq user.is_dele}">checked</c:if> value="3"/>离职
                        		</td>
					  		</tr>
					  		
					  	</table>
			 			<br />
					</fieldset>			
				</td>
			</tr>
		</table>
	 </td>
  </tr>
  <tr>
	<td colspan="2" align="center" height="50px">
		<input type="button" name="Submit" value="保存" class="button" onclick="link();"/>　
		<input type="button" name="Submit2" value="返回" class="button" onclick="window.history.go(-1);"/>
	</td>
  </tr>
</table>
</div>
</form>
</body>
</html>
