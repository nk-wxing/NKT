<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="zh-CN">
	<head>
		<meta charset="UTF-8">
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<meta http-equiv="X-UA-Compatible" content="ie=edge">
		<title>NKT用户个人中心</title>
		<!-- Bootstrap -->
		<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css" />

		<script src="js/jquery.min.js" type="text/javascript" charset="utf-8"></script>
		<script src="js/bootstrap.min.js" type="text/javascript" charset="utf-8"></script>

		<script type=text/javascript src=js/table.js></script>
		
		<style type="text/css">
			.sticky { 
				position: -webkit-sticky; 
				position: sticky; 
				top: 50px; 
			}
			.table>thead>tr>th { text-align: center;}
		</style>
	</head> 
	<body>
	<!-- 顶部导航栏 -->
	<%@include file="top.jsp"%>
	
	<div class="container-fluid" style="margin-top: 50px;">
		<!-- 左侧导航栏 -->
		<%@include file="left_user.jsp"%>
		
		<!-- 右侧列表 -->
		<div class="sticky">
		<div class="col-xs-10">
			<div class="container-fluid">
				<ol class="breadcrumb">
					<li><a herf="${pageContext.servletContext.contextPath}/UserServlet?method=gotoMyCenter">首页</a></li>				
					<li><a herf="javascript:history.go(-1);">返回上一级</a></li>				
					<li class="active">当前页面</li>	
				</ol>
				
				<form class="form-inline col-xs-10" action="${pageContext.servletContext.contextPath}/NewsServlet" method="get">
					<input name="method" type="hidden" value="searchNews"/>
					<div class="form-group">
						<label>标题关键词：</label>
						<input name="keywords" type="text" class="form-control" placeholder="请输入关键词" />
						<input name="uid" type="hidden" value="${user.uid}"/>
						<label>主题：</label>
						<select class="form-control" name="tid">
							<option value="">请选择...</option>
							<c:forEach items="${topics}" var="topic">
							<option value="${topic.tid}">${topic.tname}</option>
							</c:forEach>
						</select>
						<label>审核状态：</label>
						<select class="form-control" name="checkStatus">
							<option value="0">请选择...</option>
							<option value="1">未通过</option>
							<option value="2">待审核</option>
							<option value="3">通过</option>
						</select>
						<button class="btn btn-primary" type="submit">搜索</button>
					</div>
				</form>
				<div class="clearfix"></div>
				
				<c:choose>
					<c:when test="${empty pageBean.beanList}">
						<h3>${msg}</h3>
					</c:when>
					<c:otherwise>
					<div style="padding-top:20px">
            			<div class="panel panel-default">  
		                <div class="panel-heading">
		                	<h4 class="panel-title"><strong>历史发布记录</strong></h4>
		                </div>  
		                <div class="panel-body">  
		                    <div class="list-op" id="list_op">  
		                        <button type="button" class="btn btn-default btn-sm">  
		                            <span class="glyphicon glyphicon-plus" aria-hidden="true"></span>新增  
		                        </button>  
		                        <button type="button" class="btn btn-default btn-sm">  
		                            <span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>修改  
		                        </button>  
		                        <button type="button" class="btn btn-default btn-sm">  
		                            <span class="glyphicon glyphicon-remove" aria-hidden="true"></span>删除  
		                        </button>  
		                    </div>  
		                </div>
						<table class="table table-striped table-bordered" style="text-align:center;">					
							<thead>
								<tr>
									<th>序号</th>
									<th>标题</th>
									<th>发布时间</th>
									<th>审核状态</th>
									<th>主题</th>
									<th>操作</th>
								</tr>
							</thead>
							<tbody>
							<c:forEach items = "${pageBean.beanList}" var="news" varStatus="status">							
								<tr>
									<td>${(pageBean.currentPage-1)*pageBean.pageSize + status.index+1}</td>
									<td style="text-align:left;">${news.ntitle}</td>
									<td><fmt:formatDate value="${news.createDate}" pattern="yyyy-MM-dd HH:mm"/></td>
									<c:choose>
										<c:when test="${news.checkStatus==3}"><td><span class="label label-success">通过</span></td></c:when>
										<c:when test="${news.checkStatus==2}"><td><span class="label label-primary">待审核</span></td></c:when>
										<c:otherwise><td><span class="label label-danger">未通过</span></td></c:otherwise>
									</c:choose>
									<td>${news.tname}</td>
									<td>
										<button class="btn btn-success btn-xs" onclick="{javascrtpt:window.location.href =
											'${pageContext.servletContext.contextPath}/NewsServlet?method=findNewsByNid&nid=${news.nid}'}">查看</button>
										<button class="btn btn-warning btn-xs" onclick="{javascrtpt:window.location.href =
											'${pageContext.servletContext.contextPath}/NewsServlet?method=preEditNews&nid=${news.nid}'}">修改</button>
										<button class="btn btn-danger btn-xs"
										onclick="{if(confirm('确认删除?'))
										{javascrtpt:window.location.href = 
											'${pageContext.servletContext.contextPath}/NewsServlet?method=removeNews&nid=${news.nid}'}}">删除</button>
									</td>
								</tr>						
							</c:forEach>
							</tbody>
						</table>
						<div class="panel-footer" style="background-color:#FFF">
							<!-- 设置分页 -->
							<%@include file="paging.jsp"%>
						</div>
						</div>
					</div>
					</c:otherwise>
				</c:choose>	
			</div>				
		</div>
		</div>
	</div>
	<%
	Object mess=session.getAttribute("message");
	if(!"".equals(mess)  && mess!=null){
	%>
	<script type="text/javascript">
		window.onload=function(){
			alert("<%=mess%>");
		};
	</script>
	<%  session.setAttribute("message", ""); %>	
 	<% 
	}
	%>
</body>
</html>
