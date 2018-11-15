<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
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
function tishi()
{
  var a=confirm('数据库中保存有该人员基本信息，您可以修改或保留该信息。');
  if(a!=true)return false;
  window.open("冲突页.htm","","depended=0,alwaysRaised=1,width=800,height=400,location=0,menubar=0,resizable=0,scrollbars=0,status=0,toolbar=0");
}

function check()
{
document.getElementById("aa").style.display="";
}


function link(){
alert('保存成功！');
    document.getElementById("fom").action="xuqiumingxi.htm";
   document.getElementById("fom").submit();
}



</script>
<style type="text/css">
<!--
.atten {font-size:12px;font-weight:normal;color:#F00;}
-->
</style>

<script type="text/javascript" src="js/jquery-1.8.3.js" ></script>
<script type="text/javascript" src="js/uploadPreView.js" ></script>
<script type="text/javascript">
$(function(){
	
	//原生js实现ajax:
	//1.创建核心对象 new XMLHttpRequest()
	//2.设置提交方式和提交路径 open("post","路径?参数=xxx");
	//3.设置回调函数  onreadystatechange = 回调函数的名字 
	//4.发送请求 send();
	
	//单独定义回调函数
	//回调函数中，要想拿到ajax请求的结果,需要做两个判断：
	//1.readyState : 请求处理的状态(0-4)
		// 0 : 开始创建核心对象
		// 1 : 客户端开始发送请求
		// 2 : 客户端发送请求结束
		// 3 : 服务器开始响应
		// 4 : 服务器响应结束
	//2.status : 浏览器的状态码
		//200 : 表示一切正常
	//拿到ajax结果：responseText
	
	//jquery的ajax的实现：
	// $.ajax({..});
	// $.post("路径",{传递的参数(可以是字符串或者json)},function(data){回调函数},"数据返回格式");
	
	//字符串转换为json:
	// eval("("+json字符串+")") -- eval本身的含义：表示把一个字符串当成是一条js语句来执行
	//jquery中也提供了转变的函数：$.parseJSON("json字符串");--这种方式对json字符串的格式要求更严格
	//  '{"名字":"值"}'
	
	//加载部门信息
	$.post("dc/findalldept",{},function(data){
		$.each(data,function(i,n){
			$("#deptno").append("<option value='"+n.deptno+"'>"+n.dname+"</option>");
		});
	},"json");
	
	//这里，还需要通过ajax来查询所有角色信息
		
	
	//图片上传预览
	new uploadPreview({ UpBtn: "pic", DivShow: "imgdiv", ImgShow: "imgShow" });
	
	
	
});
</script>




</head>

<body class="ContentBody">
  <form action="" method="post" enctype="multipart/form-data" name="fom" id="fom" target="sypost" >
<div class="MainDiv">
<table width="99%" border="0" cellpadding="0" cellspacing="0" class="CContent">
  <tr>
      <th class="tablestyle_title" >用户添加页面</th>
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
						<legend>添加用户</legend>
					  	<table border="0" cellpadding="2" cellspacing="1" style="width:100%">
					  		<tr>
					    		<td nowrap align="right" width="13%">账户名称:</td>
					    		<td width="41%">
					    			<input name="loginname" class="text" style="width:154px" type="text" size="40" />
				        			<span class="red"> *</span>
				        		</td>
					    		<td align="right" width="19%">真实姓名:</td>
					    		<td width="27%">
					    			<input name="realname" id="realname" class="text" style="width:154px" />
					    		</td>
					    	</tr>
					  		<tr>
					    		<td nowrap align="right">密码:</td>
					    		<td><input name="loginpwd" type="password" id="loginpwd" class="text" style="width:154px" /></td>
					    		<td align="right">邮箱:</td>
					    		<td><input name="email" id="email" class="text" style="width:154px" /></td>
					  		</tr>
					   		<tr>
					    		<td nowrap align="right">确认密码:</td>
					    		<td>
					    			<input name="repwd" type="password" id="repwd" class="text" style="width:154px" />
                        		</td>
					    		<td align="right">用户状态:</td>
					    		<td><select name="userStatus" >
			                          <!-- <option  selected="selected">==请选择==</option> -->
			                          <option value="1" selected="selected">在职</option>
			                          <option value="0">离职</option>
                        			</select>
                        		</td>
					  		</tr>
					  		<tr>
					    		<td nowrap align="right">部门:</td>
					    		<td>
					    			<select id="deptno" name="dept.deptno" >
			                          <option  selected="selected">==请选择==</option>
                        			</select>
                        		</td>
					    		<td align="right">用户岗位:</td>
					    		<td><select name="role.roleid" >
			                          <!--<option  selected="selected">==请选择==</option> -->
			                          <option value="0" selected="selected">在职</option>
			                          <option value="1">休假</option>
			                          <option value="2">离职</option>
                        			</select>
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
