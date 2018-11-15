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
<title>岗位添加页面</title>
<link rel="stylesheet" rev="stylesheet" href="css/style.css" type="text/css" media="all" />

<script type="text/javascript" src="js/jquery-1.8.3.js" ></script>
<script type="text/javascript" src="js/uploadPreView.js" ></script>
<script language="javascript">

function link(){
   location.href="rc/preupdateper?roleid=${role.roleid }";
}
</script>
</head>

<body class="ContentBody">
  <form action="" method="post" name="fom" id="fom">
<div class="MainDiv">
<table width="99%" border="0" cellpadding="0" cellspacing="0" class="CContent">
  <tr>
      <th class="tablestyle_title" >查看岗位权限页面</th>
  </tr>
  <tr>
    <td class="CPanel">
		<table border="0" cellpadding="0" cellspacing="0" style="width:100%">
			<tr>
				<td align="left">
					<input type="button" name="goback" value="返回" class="button" onclick="window.history.go(-1);"/>
				</td>
			</tr>
			<tr>
				<td width="100%">
					<fieldset style="height:100%;">
						<legend>查看岗位权限</legend>
					  	<table border="0" cellpadding="2" cellspacing="1" style="width:100%">
					  		<tr>
					    		<td nowrap align="right" width="13%">岗位名称:</td>
					    		<td width="41%">
					    			<input name="rolename" class="text" style="width:154px" type="text" size="40" value="${role.rolename }" readonly />
				        		</td>
					    	</tr>
					  		<tr>
					    		<td nowrap align="right">岗位描述:</td>
					    		<td><input name="roledes" type="text"  class="text" style="width:800px" value="${role.roledes }" /></td>
					  		</tr>
                        	<tr>
					    		<td align="right">岗位权限:</td>
					    		<td>
					    			<c:if test="${empty perlist }">
					    				<span>暂无任何权限</span>
					    			</c:if>
					    			<c:if test="${not empty perlist }">
										<c:forEach items="${perlist }" var="per" varStatus="status">
											<input type="checkbox" checked="checked" readonly="readonly" />${per.pname }&nbsp;&nbsp;&nbsp;&nbsp;
											<c:if test="${status.index%5==0}"><br /></c:if> 
										</c:forEach>
									</c:if>
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
		<c:if test="${role.roleid != 1 }">
			<input type="button" id="btn" name="Submit" value="编辑岗位权限" class="button" onclick="link();"/>　
		</c:if>
		<input type="button" name="Submit2" value="返回" class="button" onclick="window.history.go(-1);"/>
	</td>
  </tr>
</table>
</div>
</form>
</body>
</html>
