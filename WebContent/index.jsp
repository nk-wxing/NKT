<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<meta http-equiv="X-UA-Compatible" content="ie=edge">
	<title>南开通校园综合信息服务平台</title>
	<!-- Bootstrap -->
	<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css"/>
	
	<style>
	
		body {
			padding-top: 50px;
			padding-bottom: 40px;
			color: #5a5a5a;
		}

		/* 轮播广告 */

		.carousel {
			height: 500px;
			margin-bottom: 60px;
		}

		.carousel .item {
			height: 500px;
			background-color: #000;
		}

		.carousel .item img {
			width: 100%;
		}

		.carousel-caption {
			z-index: 10;
		}

		.carousel-caption p {
			margin-bottom: 20px;
			font-size: 20px;
			line-height: 1.8;
		}

		/* 简介 */

		.summary {
			padding-right: 15px;
			padding-left: 15px;
		}

		.summary .col-md-4 {
			margin-bottom: 20px;
			text-align: center;
		}
		

		/* 特性 */

		.feature-divider {
			margin: 40px 0;
		}

		.feature {
			padding: 30px 0;
		}

		.feature-heading {
			font-size: 50px;
			color: #2a6496;
		}

		.feature-heading .text-muted {
			font-size: 28px;
		}

		/* 响应式布局 */

		@media (max-width: 768px) {

			.summary {
				padding-right: 3px;
				padding-left: 3px;
			}

			.carousel {
				height: 300px;
				margin-bottom: 30px;
			}

			.carousel .item {
				height: 300px;
			}

			.carousel img {
				min-height: 300px;
			}

			.carousel-caption p {
				font-size: 16px;
				line-height: 1.4;
			}

			.feature-heading {
				font-size: 34px;
			}

			.feature-heading .text-muted {
				font-size: 22px;
			}
		}

		@media (min-width: 992px) {
			.feature-heading {
				margin-top: 120px;
			}
		}
	</style>
</head>
<body>
	<!-- 导航栏 -->
	<div class="navbar navbar-inverse navbar-fixed-top" role="navigation" id="menu-nav">
		<div class="container">
		  <!-- Brand and toggle get grouped for better mobile display -->
		  <div class="navbar-header">
		    <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target=".navbar-collapse">
		      <span class="sr-only">切换导航</span>
		      <span class="icon-bar"></span>
		      <span class="icon-bar"></span>
		      <span class="icon-bar"></span>
		    </button>
		    <a class="navbar-brand" href="index.html">
					<img alt="NKT" src="img/logo1.png" style="width: 20px;">
			</a>
		  </div>
			
		  <!-- Collect the nav links, forms, and other content for toggling -->
		  <div class="collapse navbar-collapse">
		    <ul class="nav navbar-nav">
		      <li class="active"><a href="#">首页 </a></li>
		      <li><a href="#summary-container">传送门 </a></li>
		      <li class="dropdown">
		        <a href="#" class="dropdown-toggle" data-toggle="dropdown">内容介绍 <span class="caret"></span></a>
		        <ul class="dropdown-menu" role="menu">
		          <li><a href="#feature-tab" data-tab="tab-news">校园资讯</a></li>
		          <li role="separator" class="divider"></li>
				  <li><a href="#feature-tab" data-tab="tab-job">实习招聘</a></li>
				  <li role="separator" class="divider"></li>
		          <li><a href="#feature-tab" data-tab="tab-study">学习资源</a></li>
		          <li role="separator" class="divider"></li>
		          <li><a href="#feature-tab" data-tab="tab-film">影音天地</a></li>
		        </ul>
		      </li>
		    </ul>
		    <!-- <form class="navbar-form navbar-left">
		      <div class="form-group">
		        <input type="text" class="form-control" placeholder="Search">
		      </div>
		      <button type="submit" class="btn btn-default">Submit</button>
		    </form> -->
		    <!-- 导航栏右侧 -->
		    <!-- 
		    <ul class="nav navbar-nav navbar-right">
		      <li><a href="login_admin.jsp">登录</a></li>
		      <li class="dropdown">
		        <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">
					登录 <span class="caret"></span></a>
		        <ul class="dropdown-menu">
		          <li><a href="login_user.jsp">用户登录</a></li>
		          <li role="separator" class="divider"></li>
		          <li><a href="login_admin.jsp">管理员登录</a></li>
		        </ul>
		      </li>
		    </ul>
		     -->
		    
		  </div><!-- /.navbar-collapse -->
		</div><!-- /.container-fluid -->
	</div>
	
	<!-- 轮播广告 -->
	<div id="LBbox" class="carousel slide" data-ride="carousel">
		<!-- 圆点按钮 -->
		<ol class="carousel-indicators">
			<li data-target="#LBbox" data-slide-to="0" class="active"></li>
			<li data-target="#LBbox" data-slide-to="1"></li>
			<li data-target="#LBbox" data-slide-to="2"></li>
		</ol>
		<!-- 轮播内容 -->
		<div class="carousel-inner">
			<div class="item active">
				<img src="img/img1.jpeg" alt="1">
				<div class="carousel-caption">
					<h1>校园资讯</h1>
				</div>
			</div>
			<div class="item">
				<img src="img/img2.jpg" alt="2">
				<div class="carousel-caption">
					<h1>实习招聘</h1>
				</div>
			</div>
			<div class="item">
				<img src="img/img3.jpg" alt="3">
				<div class="carousel-caption">
					<h1>资源天地</h1>
				</div>
			</div>
		</div>
		<a class="left carousel-control" href="#LBbox" data-slide="prev">
			<span class="glyphicon glyphicon-chevron-left"></span>
		</a>
		<a class="right carousel-control" href="#LBbox"data-slide="next">
			<span class="glyphicon glyphicon-chevron-right"></span>
		</a>
	</div>
	
	<!-- 主要内容 -->
	<div class="container summary">
	
	    <!-- 简介 -->
	    <div class="row" id="summary-container">
			<div class="col-md-4">
				<img class="img-circle" src="img/news.png" alt="">
	
	            <h2>校园资讯</h2>
	
				<p>网罗最新的校园新鲜事！</p>
	
				<p><a class="btn btn-default" href="${pageContext.servletContext.contextPath}/NewsServlet?method=gotoFirstPage" role="button">点我进入</a></p>
			</div>
			<div class="col-md-4">
				<img class="img-circle" src="img/job.png" alt="">
				
			    <h2>实习招聘</h2>
				
				<p>全方位的实习招聘信息，毕业季不用愁！</p>
				
				<p><a class="btn btn-default" href="login_user.jsp" role="button">点我进入</a></p>
			</div>
			<div class="col-md-4">
				<img class="img-circle" src="img/film.png" alt="">
				
				<h2>资源天地</h2>
				
				<p>学习资料，电影音乐，拿走不谢！</p>
				
				<p><a class="btn btn-default" href="#" role="button">点我进入</a></p>
			</div>
		</div>
		<!-- 分割线 -->
		<hr class="feature-divider">
		
		<!-- 标签页 -->
		<ul class="nav nav-tabs" role="tablist" id="feature-tab">
			<li class="active"><a href="#tab-news" role="tab" data-toggle="tab">校园资讯</a></li>
			<li><a href="#tab-job" role="tab" data-toggle="tab">实习招聘</a></li>
			<li><a href="#tab-study" role="tab" data-toggle="tab">学习资源</a></li>
			<li><a href="#tab-film" role="tab" data-toggle="tab">娱乐影音</a></li>
		</ul>
		
		<div class="tab-content">
			<div class="tab-pane active" id="tab-news">
				<div class="row feature">
					<div class="col-md-7">
	
						<h2 class="feature-heading">校园资讯 <span class="text-muted">校园百事通</span></h2>
	
						<p class="lead">通过抓取各校园公众号上的最新内容，实时发布最新的校园资讯。</p>
					</div>
					<div class="col-md-5">
						<img class="feature-image img-responsive" src="img/p1.jpg" alt="msg">
					</div>
				</div>
			</div>
			<div class="tab-pane" id="tab-job">
				<div class="row feature">
					<div class="col-md-5">
						<img class="feature-image img-responsive" src="img/p2.jpeg" alt="job">
					</div>
					<div class="col-md-7">
	
						<h2 class="feature-heading">实习招聘 <span class="text-muted">找工作，找实习，来这就对了</span>
						</h2>
	
						<p class="lead">与公司和企业进行对接，将实习信息发布在本平台上，为用户提供实习信息。
						与校外企业合作，发布真实、有效、免费的兼职信息。</p>
					</div>
				</div>
			</div>
			<div class="tab-pane" id="tab-study">
				<div class="row feature">
					<div class="col-md-7">
				
						<h2 class="feature-heading">学习天地 <span class="text-muted">妈妈再也不用担心我的学习了</span></h2>
				
						<p class="lead">用户可以在此板块下分享复习资料。</p>
					</div>
					<div class="col-md-5">
						<img class="feature-image img-responsive" src="img/p3.jpg" alt="study">
					</div>
				</div>
			</div>
			<div class="tab-pane" id="tab-film">
				<div class="row feature">
					<div class="col-md-5">
						<img class="feature-image img-responsive" src="img/p4.png" alt="film">
					</div>
					<div class="col-md-7">
				
						<h2 class="feature-heading">娱乐影音 <span class="text-muted">学累了，来放松一下</span></h2>
				
						<p class="lead">汇集最全的音乐，影视资源，让你轻松嗨翻天！</p>
					</div>
				</div>
			</div>
		</div>
		
		<footer>
			<p class="pull-right"><a href="#top">回到顶部</a></p>
			<p>&copy; 2020 南开通校园综合信息平台 </p>
		</footer>
	</div>

	<!-- 引用js文件，写在底部目的是提高网页响应速度 -->
	<script src="js/jquery.min.js" type="text/javascript" charset="utf-8"></script>
	<script src="js/bootstrap.min.js" type="text/javascript" charset="utf-8"></script>
	
	<!-- 导航点击事件 -->
	<script>
		$(function () {
	        $('#menu-nav .navbar-collapse a').click(function (e) {
	            var href = $(this).attr('href');
	            var tabId = $(this).attr('data-tab');
	            if ('#' !== href) {
	                e.preventDefault();
	                $(document).scrollTop($(href).offset().top - 70);
	                if (tabId) {
	                    $('#feature-tab a[href="#' + tabId + '"]').tab('show');
	                }
				}
	        });
	    });
	</script>
</body>
</html>