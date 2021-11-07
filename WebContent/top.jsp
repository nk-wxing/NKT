<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<nav class="navbar navbar-inverse navbar-fixed-top">
	<div class="container-fluid">
		<div class="navbar-header">
			<!-- 隐藏admin，防止移动端显示效果不佳 -->
			<button class="navbar-toggle" data-toggle="collapse" data-target="#info">
				<span class="icon-bar"></span>
				<span class="icon-bar"></span>
				<span class="icon-bar"></span>
			</button>
			<a class="navbar-brand">
				<img alt="NKT后台" src="img/logo1.png" style="width: 20px;">
			</a>
			<a class="navbar-brand">NKT个人中心</a>
		</div>
		<div id="info" class="collapse navbar-collapse">
			<!-- 导航栏右侧 -->
			<ul class="nav navbar-nav navbar-right">
				<li class="dropdown">
					<a href="#" class="dropdown-toggle" data-toggle="dropdown">Welcome，${user.uname} <span class="caret"></span></a>
					<ul class="dropdown-menu">
						<li><a href="personal_info.jsp"><span class="glyphicon glyphicon-user"> 个人资料 </span></a></li>
						<li><a href="authentication.jsp"><span class="glyphicon glyphicon-check"> 校园认证 </span></a></li>
						<li class="divider"></li>
						<li><a href="${pageContext.servletContext.contextPath}/UserServlet?method=logout"><span class="glyphicon glyphicon-log-out"> 退出登录 </span></a></li>
					</ul>
				</li>	
			</ul>
		</div>			
	</div>		
</nav>