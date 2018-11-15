<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basepath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
	//System.out.println("basepath:"+basepath);
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basepath %>" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<script type="text/javascript" src="js/jquery-1.8.3.js"></script>
<script type="text/javascript" src="js/lhgdialog/lhgdialog.js?s=default,chrome"></script>
<script type="text/javascript">
$(function(){
	var dglg = new window.$.dialog({
		id:"changerole",//窗口唯一标示,自定义
		title: '变更角色',
		page:'test/lhgdialog/child.jsp',//子窗口中显示的内容
		skin:'chrome',//窗口风格，需要在样式中有这个，并且在页面上引用js时问号传参传递
		drag:true,//是否允许拖拽
		resize:false,//是否允许改变窗口大小
		cover: true,//打开子窗口时是否遮盖父窗口
		maxBtn:false,//是否显示最大化子窗口按钮
		minBtn:false,//是否显示最小化子窗口按钮
		xButton:true,//是否显示子窗口关闭按钮
		width:240, 
		height:170
		//cancelBtn:false
	});
	dglg.ShowDialog();
});
</script>
</head>
<body>

</body>
</html>