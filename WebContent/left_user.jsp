<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<div class="sticky">
<div class="row col-xs-2">
	<nav class="row navbar navbar-default">
		<ul class="nav">
			<li>
				<a class="col-xs-offset-1 text-muted" href="${pageContext.servletContext.contextPath}/NewsServlet?method=gotoFirstPage">
					<i class="glyphicon glyphicon-home"></i> 校园资讯首页</a>
			</li>
			<li>
				<a class="col-xs-offset-1" href="${pageContext.servletContext.contextPath}/NewsServlet?method=preAddNews">
				<i class="glyphicon glyphicon-send"></i> 发布新信息</a>
			</li>
			<li>
				<a class="col-xs-offset-1" href="${pageContext.servletContext.contextPath}/NewsServlet?method=searchNews&uid=${user.uid}">
					<i class="glyphicon glyphicon-list-alt"></i> 历史发布记录</a>
			</li>
		</ul>
	</nav>
</div>
</div>