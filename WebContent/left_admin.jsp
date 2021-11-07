<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!-- 左侧导航栏 -->
<div class="sticky">
<div class="row col-xs-2">
	<nav class="row navbar navbar-default">
		<ul class="nav">
			<li>
				<a class="col-xs-offset-1 text-muted" href="${pageContext.servletContext.contextPath}/NewsServlet?method=gotoFirstPage" 
					class="text-muted"><i class="glyphicon glyphicon-home"></i> 资讯首页</a>
			</li>
			<li>
				<a class="col-xs-offset-1" href="${pageContext.servletContext.contextPath}/topic_add.jsp">
					<i class="glyphicon glyphicon-menu-hamburger"></i> 新增主题</a>
			</li>
			<li>
				<a class="col-xs-offset-1" href="${pageContext.servletContext.contextPath}/TopicServlet?method=showAllTopics">
					<i class="glyphicon glyphicon-list-alt"></i> 主题列表</a>
			</li>
			<li>
				<a class="col-xs-offset-1" href="${pageContext.servletContext.contextPath}/NewsServlet?method=preAddNews">
					<i class="glyphicon glyphicon-bullhorn"></i> 发布新信息</a>
			</li>
			<li>
				<a class="col-xs-offset-1" href="${pageContext.servletContext.contextPath}/NewsServlet?method=searchNews">
					<i class="glyphicon glyphicon-folder-open"></i> 所有信息列表</a>
			</li>
			<li>
				<a class="col-xs-offset-1" href="${pageContext.servletContext.contextPath}/NewsServlet?method=searchNews&checkStatus=2">
					<i class="glyphicon glyphicon-question-sign"></i> 待审核信息</a>
			</li>
		</ul>
	</nav>
</div>
</div>