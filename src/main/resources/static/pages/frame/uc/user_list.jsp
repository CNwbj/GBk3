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

function link(){
    document.getElementById("fom").action="uc/adduser";
   	document.getElementById("fom").submit();
}

</script>
<script>
$(function(){
	//单击首页
	$("#firstpage").click(function(){
		splitform.cp.value = 1;
		splitform.submit();
	});
	
	//上一页
	$("#prepage").click(function(){
		var cp = parseInt(splitform.cp.value);
		if(cp>1){
			splitform.cp.value = cp-1;
			splitform.submit();
		}else{
			alert("已经是第一页了");
		}
	});
	
	//下一页
	$("#nextpage").click(function(){
		var allpage = parseInt(splitform.allpage.value);
		var cp = parseInt(splitform.cp.value);
		if(cp<allpage){
			splitform.cp.value = cp+1;
			splitform.submit();
		}else{
			alert("已经是最后一页了");
		}
	});
	
	//尾页
	$("#lastpage").click(function(){
		var allpage = parseInt(splitform.allpage.value);
		splitform.cp.value = allpage;
		splitform.submit();
	});
	
	
	//go提交
	$("#sbt").click(function(){
		
		var allpage = parseInt(splitform.allpage.value);
		var mypage = splitform.mypage.value;
		
		var reg = /^\d+$/;
		if(reg.test(mypage)&&parseInt(mypage)>0&&parseInt(mypage)<=allpage){
			splitform.cp.value = mypage;
			splitform.submit();
		}else{
			$("#mypage").val("");
			alert("页码输入不合法");
			$("#mypage").focus();
		}
	});
});
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
	          		<form action="uc/findusersplitbySc" method="post">
			   			<table width="98%" border="0" align="center" cellpadding="0" cellspacing="0">
			    			<tr>
				  				<td width="21"><img src="images/ico07.gif" width="20" height="18" /></td>
				  				<td width="538">查看内容：
									按账号：<input name="loginname" type="text" size="12" value="${usersc.loginname }"/>
									按状态：<select name="is_dele">
											<option value="">-不限-</option>
								 			<option value="1" <c:if test="${usersc.is_dele eq 1}">selected="selected"</c:if>> 在职</option>
								 			<option value="0" <c:if test="${usersc.is_dele eq 1}">selected="selected"</c:if>> 离职</option>
									 	</select>
									按部门: <select name="deptno">
											<option value="">-来源方式不限-</option>
										    <c:forEach items="${deptlist}" var="dept">								
												<option value="${dept.deptno }" <c:if test="${dept.deptno eq usersc.deptno}">selected="selected"</c:if>>
												    ${dept.dname }
												</option>
										    </c:forEach> 
										</select>
									<input name="Submit4" type="submit" class="right-button02" value="查 询" />
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
          			<form name="fom" id="fom" method="post">
          			<table width="95%" border="0" align="center" cellpadding="0" cellspacing="0">
          	 			<tr>
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
          	 			</tr>
          	 			<!-- 表格部分开始 -->
              			<tr>
                			<td height="40" class="font42">
								<table width="100%" border="0" cellpadding="4" cellspacing="1" bgcolor="#464646" class="newfont03" id="tab">
				 					<tr class="CTitle" >
                    					<td height="22" colspan="5" align="center" style="font-size:16px">用户详细列表</td>
                  					</tr>
                  					<tr bgcolor="#EEEEEE">
				    					<th width="4%" align="center" height="30">选择</th>
                    					<th width="10%">账户</th>
                    					<th width="10%">部门</th>
										<th width="5%">状态</th>
										<th width="12%">操作</th>
                  					</tr>
                  					<c:forEach items="${userlist }" var="ul">
				                  <tr bgcolor="#FFFFFF">
								    <td height="20"><input type="checkbox" value="${ul.userid }" name="delid"/></td>
				                    <td>${ul.loginname }</td>
				                    <td>${ul.dept.dname }</td>
				                    <td>${ul.is_dele=="1"?"在职":"离职" }</td>
				                    <td>
				                    	<a href="#">编辑|</a>
				                    	<a href="#;">变更岗位|</a>
										<a href="#">删除</a>
									</td>
				                  </tr>
				                  </c:forEach>
            					</table>
            				</td>
        				</tr>
        				<!-- 表格部分结束 -->
      				</table>
      				</form>
      				<table width="95%" border="0" align="center" cellpadding="0" cellspacing="0">
        				<tr>
          					<td height="6"><img src="images/spacer.gif" width="1" height="1" /></td>
        				</tr>
        				<tr>
          					<td height="33">
          						<!-- 分页部分开始 -->
          						<form name="splitform" id="splitform" action="uc/findusersplitbySc" method="post" >
								    <input type="hidden" value="${usersc.loginname }" name="loginname" />
								    <input type="hidden" value="${usersc.is_dele }" name="is_dele" />
								    <input type="hidden" value="${usersc.deptno }" name="deptno" />
								    <input type="hidden" value="${cp }" name="cp" id="cp" />
									<input type="hidden" value="${ps }" name="ps" id="ps" />
									<input type="hidden" value="${count }" name="count" id="count" />
									<input type="hidden" value="${allpage }" name="allpage" id="allpage" />
									<table width="100%" border="0" align="center" cellpadding="0" cellspacing="0" class="right-font08">
										<tr>
											<td width="50%">
												共 <span class="right-text09">${allpage }</span> 页 | 
												第 <span class="right-text09">${cp }</span> 页
											</td>
											<td width="49%" align="right">
												[<a href="javascript:void(0);" id="firstpage" class="right-font08">首页</a> | 
												<a href="javascript:void(0);" id="prepage" class="right-font08">上一页</a> | 
												<a href="javascript:void(0);" id="nextpage" class="right-font08">下一页</a> | 
												<a href="javascript:void(0);" id="lastpage" class="right-font08">末页</a>] 转至：
											</td>
											<td width="1%">
												<table width="20" border="0" cellspacing="0" cellpadding="0">
								 							<tr>
								 								<td width="1%">
								 									<input name="mypage" id="mypage" type="text" class="right-textfield03" size="1" />
								 								</td>
								 								<td width="87%">
								 									<input name="Submit23222" id="sbt" type="button" class="right-button06" value=" " />
								 								</td>
								 							</tr>
												</table>
											</td>
										</tr>
									</table>
								</form>
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
