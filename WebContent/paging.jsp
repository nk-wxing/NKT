<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- 设置分页 -->
<nav class="text-center">
	<ul class="pagination">
		<li><a href="${pageBean.url }"><span>&laquo;</span></a></li>
		<li><a>•••</a></li>
		<c:choose>
			<c:when test="${pageBean.currentPage > 1}">
				<li><a href="${pageBean.url }&currentPage=${pageBean.currentPage-1 }">‹</a></li>
			</c:when>
			<c:otherwise><li class="disabled"><a>‹</a></li></c:otherwise>
		</c:choose>
				
		<li class="active"><a>${pageBean.currentPage }</a></li>
		
		<c:choose>
			<c:when test="${pageBean.currentPage < pageBean.totalPages }">
				<li><a href="${pageBean.url }&currentPage=${pageBean.currentPage+1 }">›</a></li>
			</c:when>
			<c:otherwise><li class="disabled"><a>›</a></li></c:otherwise>
		</c:choose>
		
		<li><a>•••</a></li>
		<li><a href="${pageBean.url }&currentPage=${pageBean.totalPages }"><span>&raquo;</span></a></li>
	</ul>
</nav>