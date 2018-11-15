<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
	<base href="<%=basePath%>" />
		<meta charset="utf-8">
		<title>商品分类</title>
		<link rel="stylesheet" href="css/bootstrap.css" />
		<link rel="stylesheet" href="css/bootstrap-theme.css" />
		<script src="js/jquery.js"></script>
		<script src="js/bootstrap.js"></script>
		<script>
			$(function(){
				$(parent.document.getElementById("cate_pencilFrame")).attr("height",0);
				
				var height = document.documentElement.scrollHeight;
				console.log(height);
				$(parent.document.getElementById("cate_pencilFrame")).attr("height",1600);
			}); 
		</script>
	</head>
	<body>
		<div class="container">
			<div class="row clearfix">
				<div class="col-md-12 column">
					<div class="carousel slide" id="carousel-664798">
						<ol class="carousel-indicators">
							<li class="active" data-slide-to="0" data-target="#carousel-664798"></li>
							<li data-slide-to="1" data-target="#carousel-664798"></li>
							<li data-slide-to="2" data-target="#carousel-664798"></li>
							<li data-slide-to="3" data-target="#carousel-664798"></li>
						</ol>
						<div class="carousel-inner">
							<div class="item active">
								<img alt="见贤思齐" src="img/书法作品01.jpg" style="margin:0 auto;"/>
								<div class="carousel-caption">
									<h4>
										见贤思齐
									</h4>
									<p>
										子曰：“见贤思齐焉，见不贤而内自省也。”
									</p>
								</div>
							</div>
							<div class="item">
								<img alt="苏轼书法" src="img/书法作品02.jpg" style="margin:0 auto;" />
								<div class="carousel-caption">
									<h4>
										苏轼书法
									</h4>
									<p>
										归去,也无风雨也无晴.
									</p>
								</div>
							</div>
							<div class="item">
								<img alt="传道" src="img/书法作品03.jpg" style="margin:0 auto;" />
								<div class="carousel-caption">
									<h4>
										传道受业解惑
									</h4>
									<p>
										三人行,必有我师焉.
									</p>
								</div>
							</div>
							<div class="item">
								<img alt="沁园春 雪" src="img/书法作品04.jpg" style="margin:0 auto;" />
								<div class="carousel-caption">
									<h4>
										沁园春·雪
									</h4>
									<p>
										俱往矣,数风流人物还看今朝!
									</p>
								</div>
							</div>
						</div>
						<a class="left carousel-control" href="#carousel-664798" data-slide="prev"><span class="glyphicon glyphicon-chevron-left"></span></a>
						<a class="right carousel-control" href="#carousel-664798" data-slide="next"><span class="glyphicon glyphicon-chevron-right"></span></a>
					</div>
					<ul class="breadcrumb">
						<li>
							<a href="#">华夏文具</a>
						</li>
						<li>
							<a href="#home">商品分类</a>
						</li>
						<li class="active">
							毛笔
						</li>
					</ul>
					
					<div class="row">
						<div class="col-md-4">
							<div class="thumbnail">
								<img alt="300x200" src="img/兼毫毛笔.jpg" />
								<div class="caption">
									<h3>
										兼毫毛笔
									</h3>
									<p>
										毛笔的一种。用两种以上之毫制笔，称兼毫。一般以狼毫或紫毫（紫色兔毛）与羊毫合制而成的为主。有直称兼毫者，如紫兼毫。有表明配合成分多寡者，如三紫七羊，七紫三羊，五紫五羊各种
									</p>
									<p>
										<a class="btn btn-primary" href="purchase.jsp#xxxxxx">购买</a> <a class="btn" href="https://baike.baidu.com/item/%E5%85%BC%E6%AF%AB">百科详情</a>
									</p>
								</div>
							</div>
						</div>
						<div class="col-md-4">
							<div class="thumbnail">
								<img alt="300x200" src="img/狼毫毛笔.jpg" />
								<div class="caption">
									<h3>
										狼毫毛笔
									</h3>
									<p>
										狼毫，是指用黄鼠狼的尾毛做成的毛笔。如：小楷狼毫。毛笔的一种，用黄鼠狼（鼬鼠）尾部的毛制成，故名。以我国东北产的“关东辽毫”品质最佳。特点是润滑而富有弹性，宜书宜画，以画为主。
									</p>
									<p>
										<a class="btn btn-primary" href="#">购买</a> <a class="btn" href="https://baike.baidu.com/item/%E7%8B%BC%E6%AF%AB/6815999?fr=aladdin">百科详情</a>
									</p>
								</div>
							</div>
						</div>
						<div class="col-md-4">
							<div class="thumbnail">
								<img alt="300x200" src="img/硬毫.jpg" />
								<div class="caption">
									<h3>
										硬毫毛笔
									</h3>
									<p>
										毛笔一种。用鼠须、猪鬃制成。这种笔弹性强，容易上手，写字锐利，点画瘦劲。宜书写小楷和国画的线条勾、描等。
硬毫包括紫毫、狼毫、鼠毫。
									</p>
									<p>
										<a class="btn btn-primary" href="#">购买</a> <a class="btn" href="https://baike.baidu.com/item/%E7%A1%AC%E6%AF%AB">百科详情</a>
									</p>
								</div>
							</div>
						</div>
					</div>
					
					<div class="row">
						<div class="col-md-4">
							<div class="thumbnail">
								<img alt="300x200" src="img/紫毫毛笔.jpg" />
								<div class="caption">
									<h3>
										紫毫毛笔
									</h3>
									<p>
										毛笔的一种。用紫色兔毛制成的笔，故名。亦名“紫毫笔”、“紫霜毫”。有紫和花白之分。取白兔脊及
尾。纯用紫毫，软而圆健，若兼花白，则坚强劲利。
									</p>
									<p>
										<a class="btn btn-primary" href="#">购买</a> <a class="btn" href="https://baike.baidu.com/item/%E7%B4%AB%E6%AF%AB">百科详情</a>
									</p>
								</div>
							</div>
						</div>
						<div class="col-md-4">
							<div class="thumbnail">
								<img alt="300x200" src="img/羊毫毛笔.jpg" />
								<div class="caption">
									<h3>
										羊毫毛笔
									</h3>
									<p>
										毛笔的一种，用山羊毛制作，属大众化用品。其中宿羊毫存放多年，脂肪已干化，容易着墨；陈羊毫有些刚性；颖羊毫精细，尖端透明；净羊毫无杂质，羊毫性均柔软，笔头肥厚滋润，适宜书写行书。一般是采用长江下游、太湖沿岸的山羊毛制成的毛笔。
									</p>
									<p>
										<a class="btn btn-primary" href="#">购买</a> <a class="btn" href="https://baike.baidu.com/item/%E7%BE%8A%E6%AF%AB">百科详情</a>
									</p>
								</div>
							</div>
						</div>
						<div class="col-md-4">
							<div class="thumbnail">
								<img alt="300x200" src="img/软毫毛笔.jpg" />
								<div class="caption">
									<h3>
										软毫毛笔
									</h3>
									<p>
										毛笔的一种，用山羊毛等制作。软毫笔柔软圆润，毫端柔软，弹性较差，不易控制，价格低，笔画圆润丰满。写的字体比较丰满，故适宜写较大的字和作国画的点叶、渲染等用
									</p>
									<p>
										<a class="btn btn-primary" href="#">购买</a> <a class="btn" href="https://baike.baidu.com/item/%E8%BD%AF%E6%AF%AB">百科详情</a>
									</p>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
			
		</div>
	</body>
</html>
