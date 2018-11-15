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
		<meta charset="utf-8">
		<title></title>
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
			
		</script>
	</head>
	<body>
		<div class="container">
	<div class="row clearfix">
		<div class="col-md-12 column">
			<div class="tabbable" id="tabs-543638">
				<ul class="nav nav-tabs">
					<li class="active">
						 <a href="#panel-799147" data-toggle="tab">账户详情</a>
					</li>
					<li>
						 <a href="#panel-284913" data-toggle="tab">修改账户</a>
					</li>
					
				</ul>
				
				<div class="tab-content">
					<div class="tab-pane active" id="panel-799147">
						
						<div class="panel-group" id="panel-356102">
							<div class="panel panel-default">
								<div class="panel-heading">
									<a class="panel-title" data-toggle="collapse" data-parent="#panel-356102" href="#panel-element-943045">基本信息</a>
								</div>
								<div id="panel-element-943045" class="panel-collapse collapse in">
									<div class="panel-body">
										<div class="row">
											<div class="col-md-6">
												<h4>身份证号:${customer.c_idcard_id }</h4><br/>
												<h4>姓名:${customer.c_name }</h4><br/>
												<h4>手机号:${customer.c_phone }</h4><br/>
												<h4>邮箱:${customer.c_mail }</h4><br/>
												<h4>地址:${customer.c_address }</h4><br/>
												<h4>绑定银行卡号:${customer.c_account_num }</h4><br/>
												<h4>余额:${customer.c_money }	￥</h4><br/>	
											</div>
											<div class="col-md-6">
												<img src="img/01.jpg" width="400px">
											</div>
										</div>
																		
									</div>
								</div>
							</div>
							<div class="panel panel-default">
								<div class="panel-heading">
									<a class="panel-title" data-toggle="collapse" data-parent="#panel-356102" href="#panel-element-168657">完善信息</a>
								</div>
								<div id="panel-element-168657" class="panel-collapse collapse">
									<div class="panel-body">
										<div class="alert alert-success alert-dismissable">
											<button type="button" class="close" data-dismiss="alert" aria-hidden="true">×</button>
											<h4>
												注意!
											</h4> <strong>Warning!</strong> Best check yo self, you're not looking too good. <a href="#" class="alert-link">alert link</a>
										</div>
										<form role="form">
											<div class="form-group">
												<label for="exampleInputEmail1">Email address</label><input type="email" class="form-control" id="exampleInputEmail1" />
											</div>
											<div class="form-group">
												<label for="exampleInputPassword1">Password</label><input type="password" class="form-control" id="exampleInputPassword1" />
											</div>
											<div class="form-group">
												<label for="exampleInputFile">File input</label><input type="file" id="exampleInputFile" />
												<p class="help-block">
													Example block-level help text here.
												</p>
											</div>
											<div class="checkbox">
												<label><input type="checkbox" />Check me out</label>
											</div> <button type="submit" class="btn btn-default">Submit</button>
										</form>
									</div>
								</div>
							</div>
						</div>
						
					</div>
					<div class="tab-pane" id="panel-284913">
						<div class="panel-group" id="panel-884221">
						
							<div class="panel panel-default">
								<div class="panel-heading">
									<a class="panel-title collapsed" data-toggle="collapse" data-parent="#panel-884221" href="#panel-element-231776">固定信息</a>
								</div>
								<div id="panel-element-231776" class="panel-collapse collapse">
									<div class="panel-body">
										<h3>身份证号:${customer.c_idcard_id }</h3><br/>
										<h3>姓名:${customer.c_name }</h3><br/>
										<h3>注册时间:<fmt:formatDate value='${customer.c_createdate }' pattern='yyyy-MM-dd'/></h3><br/>										
									</div>
								</div>
							</div>
							
							<div class="panel panel-default">
								<div class="panel-heading">
									<a class="panel-title collapsed" data-toggle="collapse" data-parent="#panel-884221" href="#panel-element-762268">可修改信息</a>
								</div>
								<div id="panel-element-762268" class="panel-collapse collapse">
									<div class="panel-body">
										<form role="form" action=" ca/update.action?c_id=${customer.c_id }" method="post">
											<div class="form-group">
												<label for="exampleInputEmail1">Email</label><input type="email" class="form-control" id="exampleInputEmail1" name="c_mail" value="${customer.c_mail }"/>
											</div>
											<div class="form-group">
												<label for="exampleInputPassword1">Password</label><input type="password" class="form-control" id="exampleInputPassword1" name="c_pwd"/>
											</div>
											<div class="form-group">
												<label for="customerAddress">常用地址</label>
												<input type="address" class="form-control" id="customerAddress" name="c_address" value="${customer.c_address }"/>
											</div>
											<div class="form-group">
												<label for="companyName">公司名称</label>
												<input type="text" class="form-control" id="companyName" name="c_company" value="${customer.c_company }"/>
											</div>
											<div class="form-group">
												<label for="companyName">学历</label>
												<SELECT name="c_eduid"> 		 			    
													    <OPTION value="1">小学 </OPTION>
													    <OPTION value="2">初中 </OPTION>
													    <OPTION value="3">高中 </OPTION>
													    <OPTION value="4">大专 </OPTION>
													    <OPTION value="5">本科 </OPTION>
													    <OPTION value="6">硕士及以上 </OPTION>		    						
												    </SELECT>
											</div>
											<div class="form-group">
												<label for="exampleInputFile">File input</label><input type="file" id="exampleInputFile" />
												<p class="help-block">
													Example block-level help text here.
												</p>
											</div>
											<div class="checkbox">
												<label><input type="checkbox" />Check me out</label>
											</div> <button type="submit" class="btn btn-default">Submit</button>
										</form>
										<div class="alert alert-success alert-dismissable">
											<button type="button" class="close" data-dismiss="alert" aria-hidden="true">×</button>
											<h4>
												注意!
											</h4> <strong>Warning!</strong> Best check yo self, you're not looking too good. <a href="#" class="alert-link">alert link</a>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
	</body>
</html>
