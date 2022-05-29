<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<base href="/ASM_Java4/">
<!DOCTYPE html>
<html lang="en">
<head>
	<title>
		${page.title}
	</title>
	<meta charset="utf-8">
	
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/navbar.css">
	
	<c:if test="${not empty page.resource }">
		<jsp:include page="${page.resource }"></jsp:include>
	</c:if>
</head>

<body>
	<jsp:include page="/navbar/navbar.jsp"></jsp:include>
	
	<jsp:include page="${page.contentUrl}"></jsp:include>
	
	<jsp:include page="/footer/footer.jsp"></jsp:include>
	
	<c:if test="${not empty page.scriptUrl }">
		<jsp:include page="${page.scriptUrl }"></jsp:include>
	</c:if>
	
</body>
</html>    
