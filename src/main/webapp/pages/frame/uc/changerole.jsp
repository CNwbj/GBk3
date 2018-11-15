<%@ page language="java" contentType="text/html; charset=utf-8"  pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
	String path = request.getContextPath();
	String basepath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basepath %>" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>变更用户角色</title>
<script type="text/javascript" src="js/jquery-1.8.3.js"></script>
<script type="text/javascript" src="js/lhgdialog/lhgdialog.js"></script>
<script type="text/javascript">
	function link(){
		alert('保存成功！');
		document.getElementById("fom").action="uc/updaterole";
		document.getElementById("fom").submit();
	}
</script>
</head>
<body >
<h2>修改用户职位</h2>
<form id="fom" action="" method="post">
	<input type="hidden" value="${user.userid }" name="userid" id="userid" />
	用户名：${user.loginname }<br/><br />
	岗位：
	<select name="roleid">
		<c:forEach items="${rolelist }" var="rl">
		<option value="${rl.roleid }" <c:if test="${user.sysrole.roleid eq rl.roleid}">selected="selected"</c:if>>${rl.rolename }</option>
		</c:forEach>
	</select>
</form><br/><br />
	<input type="button" name="Submit" value="确认更改" class="button" onclick="link();"/>　
	<input type="button" name="Submit2" value="返回" class="button" onclick="window.history.go(-1);"/>
</body>
</html>