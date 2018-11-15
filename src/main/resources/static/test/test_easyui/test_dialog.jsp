<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basepath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";

%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basepath %>" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="js/easyui/themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="js/easyui/themes/icon.css">
<script type="text/javascript" src="js/jquery-1.8.3.js"></script>
<script type="text/javascript" src="js/easyui/jquery.easyui.min.js"></script>
<script>
	$(function(){
		$("#dlg").dialog({
			width:"400",
			height:"200",
			title : "修改角色窗口",
			buttons:[{
				text:'保存',
				handler:function(){alert("save");}
			},{
				text:'关闭',
				handler:function(){alert("close");}
			}]
		});
	});
</script>
</head>
<body>
<div id="dlg"  ></div>
</body>
</html>