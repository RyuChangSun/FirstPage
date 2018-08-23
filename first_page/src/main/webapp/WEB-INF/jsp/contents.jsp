<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"></meta>
<title>Hello Millky</title>

    <style type="text/css">
    	a {text-decoration:none;}
		a:link { color: black;}
		a:visited { color: gray;}
		a:hover { color: blue;}
    </style>
    
	<script src="/js/jquery-3.3.1.js"></script>
	<script src="/js/bootstrap.js"></script>
	
	<link href="/css/bootstrap.css" rel="stylesheet">        
</head>
<body>

	<!--/* <xmp> */-->	
	<table class="table table-hover">
		<tbody>
			<c:forEach items="${multiMap}" var="info" varStatus="stat">
				<tr>
					<!--td scope="row" onClick="location.href='${info.href}'" style="cursor:pointer;"-->
					<td>
						<a href="${info.href}">
							<div style="width:100%;height:100%;cursor:pointer;">

								<c:choose>
									<c:when test="${siteGubun == 'slrclub'}">
										<span class="badge badge-pill badge-primary" style="font-weight: bold">${siteGubun}</span>
									</c:when>
									<c:when test="${siteGubun == 'bobae'}">
										<span class="badge badge-pill badge-warning" style="font-weight: bold">${siteGubun}</span>
									</c:when>
									<c:when test="${siteGubun == 'ppomppu'}">
										<span class="badge badge-pill badge-success" style="font-weight: bold">${siteGubun}</span>
									</c:when>
								</c:choose>
								${info.text}
								<span style="float:right;padding:0px 0px 0px 5px;font-size:10px;">${info.metainfo}</span>
							</div>
						</a>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table> 

</body>
</html>