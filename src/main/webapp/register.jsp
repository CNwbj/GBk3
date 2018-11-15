<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
	<head>
	<base href="<%=basePath%>" />
		<meta charset="utf-8" />
		<title>华夏文具</title>
		<link rel="stylesheet" href="css/bootstrap.css" />
		<link rel="stylesheet" href="css/bootstrap-theme.css" />
		<script src="js/jquery.js"></script>
		<script src="js/bootstrap.js"></script>
		<script>
			$(function(){
				//$(parent.document.getElementById("registerFrame")).attr("height",0);
				
				var height = document.body.scrollHeight;
				console.log(height);
				$(parent.document.getElementById("registerFrame")).attr("height",1600);
			}); 
			
			function geld(id){
				return document.getElementById(id);
			}
			function zhuce(){
				var pwd1 = geld("exampleInputPassword1").value;
				var pwd2 = geld("exampleInputPassword2").value;
				if (pwd1==pwd2) {
					location="ca/register.action";
				}else{
					slert("两次输入密码不一致！请重新输入");
				}
			}
			/* function yanzheng(){
				var pwd1 = geld("exampleInputPassword1").value;
				var pwd2 = geld("exampleInputPassword2").value;
				if (pwd1!=pwd2) {
					$("#errorFont").html("两次输入密码不一致，请重新输入!!!");
				}else{
					$("#errorFont").html("两次输入密码一致!!!");
				}
			} */
		</script>
	</head>
	<body>
		<div class="container">
			<div class="row clearfix">
				<div class="col-md-12 column">
					<div class="jumbotron">
						<h1>
							欢迎您加入华夏大家庭!
						</h1>
						<p>
							滚滚长江东逝水，浪花淘尽英雄。
							是非成败转头空。
							青山依旧在，几度夕阳红。
							白发渔樵江渚上，惯看秋月春风。
							一壶浊酒喜相逢。
							古今多少事，都付笑谈中。
						</p>
						<p>
							<a class="btn btn-primary btn-large" href="https://baike.baidu.com/item/%E4%B8%B4%E6%B1%9F%E4%BB%99%C2%B7%E6%BB%9A%E6%BB%9A%E9%95%BF%E6%B1%9F%E4%B8%9C%E9%80%9D%E6%B0%B4/7597615?fr=aladdin">Learn more</a>
						</p>
						
					</div>
					<ul class="breadcrumb" style="margin-top:-30px;">
						<li>
							<a href="#">华夏文具</a>
						</li>
						<li>
							<a href="#home">注册</a>
						</li>
					</ul>
					<form role="form" action="ca/register.action" method="post">
						<div class="form-group">
							<label for="customerName">用户名</label>
							<input type="text" class="form-control" id="customerName" name="c_name"/>
						</div>
						<div class="form-group">
							<label for="companyName">公司名称</label>
							<input type="text" class="form-control" id="companyName" name="c_company"/>
						</div>
						<div class="form-group">
							<!--此处应该增加AJAX判断-->
							<label for="customerEmail1">邮箱地址</label>
							<input type="email" class="form-control" id="customerEmail1" name="c_mail"/>
						</div>
						<div class="form-group">
							<!--此处应该增加AJAX判断-->
							<label for="customerTel">手机号码</label>
							<input type="text" class="form-control" id="customerTel" name="c_phone"/>
						</div>
						<div class="form-group">
							<label for="customerID">身份证号</label>
							<input type="text" class="form-control" id="customerID" name="c_idcard_id"/>
						</div>
						<div class="form-group">
							<label for="customerAddress">常用地址</label>
							<input type="address" class="form-control" id="customerAddress" name="c_address"/>
						</div>
						<div class="form-group">
							<label for="bankType">开户银行</label> 
							<select class="form-control" id="bankType" name="c_accountid">
								<option value="1">中国银行</option>
								<option value="2">建设银行</option>
								<option value="3">招商银行</option>
								<option value="4">平安银行</option>
								<option value="5">花旗银行</option>
							</select>
						</div>
						<div class="form-group">
							<label for="creditCardNum">银行卡账号</label>
							<input type="text" class="form-control" id="creditCardNum" name="c_account_num"/>
						</div>
						<div>
							<label>学历</label><br />
						<!-- 	<label class="checkbox-inline">
								<input type="checkbox" id="inlineCheckbox1" value="option1"> 选项 1
							</label>
							<label class="checkbox-inline">
								<input type="checkbox" id="inlineCheckbox2" value="option2"> 选项 2
							</label>
							<label class="checkbox-inline">
								<input type="checkbox" id="inlineCheckbox3" value="option3"> 选项 3
							</label> -->
							<label class="radio-inline">
								<input type="radio"  id="optionsRadios1" value="1" name="c_eduid"> 小学
							</label>
							<label class="radio-inline">
								<input type="radio"  id="optionsRadios2" value="2" name="c_eduid"> 初中
							</label>
							<label class="radio-inline">
								<input type="radio"  id="optionsRadios3" value="3" name="c_eduid"> 高中
							</label>
							
							<label class="radio-inline">
								<input type="radio"  id="optionsRadios4" value="4" checked="checked" name="c_eduid"> 大专
							</label>
							<label class="radio-inline">
								<input type="radio"  id="optionsRadios5" value="5" name="c_eduid"> 本科
							</label>
							<label class="radio-inline">
								<input type="radio"  id="optionsRadios6" value="6" name="c_eduid"> 硕士及硕士以上
							</label>
						</div>
						<div>
							<label>性别：</label>
							<label class="radio-inline">
								<input type="radio"  id="optionsRadios6" value="男" name="c_sex" checked="checked" > 男
							</label>
							<label class="radio-inline">
								<input type="radio"  id="optionsRadios7" value="女" name="c_sex"> 女
							</label>
						</div>
						<br />
						<div class="form-group">
							<label for="exampleInputPassword1">Password</label><input type="password" class="form-control" id="exampleInputPassword1" name="c_pwd"/>
						</div>
						<!--判断两次密码是否一致,使用AJAX-->
						<div class="form-group">
							<label for="exampleInputPassword1">Password</label><input type="password" class="form-control" id="exampleInputPassword2" onkeydown ="yanzheng();" />
							<font size="1" color="red" id="errorFont"></font>
						</div>
						<!--上传照片-->
						<!-- <div class="form-group">
							<label for="exampleInputFile">File input</label>
							<input type="file" id="example
								Example block-level help text here.
							</p>
						</div>
						<div class="
							 checkbox">
							<label><input type="checkbox" />Check me out
								<InputFile" />
								<p class="help-block">
							</label>
						</div>  -->
						<button type="submit"   class="btn btn-default col-lg-2 col-lg-offset-5">提交</button>
					</form>
				</div>
			</div>
		</div>
	</body>
</html>
