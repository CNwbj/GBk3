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
<script language="JavaScript" type="text/javascript">
function link(){
	var dname = $("#dname").val();
	if(dname.length>0){
		alert('保存成功！');
	   document.getElementById("fom").action="dc/adddept";
	   document.getElementById("fom").submit();
	}else{
			 $("#msg").html("内容不能为空!!");
			 $("#btn").hide();
			 $("#bt").hide();
		}
	}
</script>

<script type="text/javascript" src="js/jquery-1.8.3.js" ></script>
<script type="text/javascript" src="js/uploadPreView.js" ></script>
<script type="text/javascript">

	$(function () {
		 $("#dname").focus();
		$("#dname").blur(function(){
			var dname = $("#dname").val();
			if(dname.length>0){
				$.post("dc/checkre",{"dname":dname},function(data){
						if(data!="0"){
							 $("#msg").html("部门名称已存在,请换一个!!");
							 $("#btn").hide();
							 $("#bt").hide();
						}else{
							$("#msg").html("可以使用!");
							$("#btn").show();
							$("#bt").show();
						}
				},"json");
			}else{
				 $("#msg").html("内容不能为空!!");
				 $("#btn").hide();
				 $("#bt").hide();
			}
		});
	})

</script>
</head>

<body class="ContentBody">
  <form action="" method="post" name="fom" id="fom">
<div class="MainDiv">
<table width="99%" border="0" cellpadding="0" cellspacing="0" class="CContent">
  <tr>
      <th class="tablestyle_title" >部门添加页面</th>
  </tr>
  <tr>
    <td class="CPanel">
		<table border="0" cellpadding="0" cellspacing="0" style="width:100%">
			<tr>
				<td align="left">
					<input type="button" id="bt" name="saveuser" value="保存" class="button" onclick="link();"/>　
					<input type="button" name="goback" value="返回" class="button" onclick="window.history.go(-1);"/>
				</td>
			</tr>
			<tr>
				<td width="100%">
					<fieldset style="height:100%;">
						<legend>添加部门</legend>
					  	<table border="0" cellpadding="2" cellspacing="1" style="width:100%">
					  		<tr>
					    		<td nowrap align="right" width="13%">部门名称:</td>
					    		<td width="41%">
					    			<input name="dname" id="dname" class="text" style="width:154px" type="text" size="40" />
				        			<span id="msg" class="red"> *</span>
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
		<input type="button" id="btn" name="Submit" value="保存" class="button" onclick="link();"/>　
		<input type="button" name="Submit2" value="返回" class="button" onclick="window.history.go(-1);"/>
	</td>
  </tr>
</table>
</div>
</form>
</body>
</html>
