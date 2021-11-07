<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<nav class="navbar navbar-default navbar-fixed-top">
	<div class="container">
		<div class="navbar-header">
			<!-- 隐藏admin，防止移动端显示效果不佳 -->
			<button class="navbar-toggle" data-toggle="collapse"
				data-target="#info">
				<span class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="index.html"></a>
		</div>
		<div id="info" class="collapse navbar-collapse">
			<ul class="nav navbar-nav">
				<li class="active"><a href="#">校园那些事 </a></li>
				<li><a href="index.jsp">返回主站 </a></li>
				<li><a href="index.jsp">实习招聘 </a></li>
				<li><a href="index.jsp">资源天地 </a></li>
			</ul>
			<ul class="nav navbar-nav navbar-right">
			<c:choose>
				<c:when test="${empty user}">
					<li><a href="login.jsp">登录</a></li>
				</c:when>
				<c:otherwise>
					<li class="dropdown"><a href="#" class="dropdown-toggle" data-toggle="dropdown">Welcome，${user.uname} <span class="caret"></span></a>
						<ul class="dropdown-menu">
							<li><a href="${pageContext.servletContext.contextPath}/UserServlet?method=gotoMyCenter"><span class="glyphicon glyphicon-user"> 个人中心 </span></a></li>
							<li class="divider"></li>
							<li><a href="${pageContext.servletContext.contextPath}/UserServlet?method=logout"><span class="glyphicon glyphicon-log-out"> 退出登录 </span></a></li>
						</ul>
					</li>
				</c:otherwise>
			</c:choose>
			</ul>
		</div>
	</div>
</nav>