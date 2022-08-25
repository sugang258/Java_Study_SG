<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>List </title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx" crossorigin="anonymous">

</head>
<style>
    .align-center {text-align: center;}
</style>

<body>
<c:import url="../template/header.jsp"></c:import>
<h2 class="align-center">${board}  List</h2>
<table border = "1" class="table table-striped align-center ">

	<thead>
	<tr>
		<th> num </th> <th> title </th> <th> writer </th> <th>regDate</th> <th> hit </th>
	</tr>
	</thead>
	
	<tbody>
 
	<c:forEach items="${list}" var="dto">
	<tr>
	<td><a href="./detail.gang?num=${dto.num}">${dto.num}</a></td>
	<td>${dto.title }</td>
	<td>${dto.writer }</td>
	<td>${dto.regDate }</td>
	<td>${dto.hit }</td>
	</tr>
	</c:forEach>
	
	

	</tbody>
</table>
<nav aria-label="Page navigation example">
  <ul class="pagination">
  <c:if test="${pager.pre}">
    <li class="page-item"><a class="page-link" href="./list.gang?page=${pager.startNum-1}">Previous</a></li>
    </c:if>
    <c:forEach begin="${pager.startNum}" end="${pager.lastNum}" var="i">
    	<li class="page-item"><a class="page-link" href="./list.gang?page=${i}">${i}</a></li>
   </c:forEach>
   <!-- 
   <c:choose>
   		<c:when test="${pager.next}">
   			<li class="page-item">
   		</c:when>
   		<c:otherwise>
   			<li class="page-item disabled">
   		</c:otherwise>
   </c:choose>
    -->
   <li class="page-item ${pager.next?'':'disabled'}">
    <a class="page-link" href="./list.gang?page=${pager.lastNum+1}">Next</a></li>
  </ul>
</nav>
	
<c:if test="${not empty sessionScope.member}">
<a href="./add.gang">글 작성하기</a>
</c:if>
	<c:import url="../template/footer.jsp"></c:import>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-A3rJD856KowSb7dwlZdYEkO39Gagi7vIsF0jrRAoQmDKKtQBHUuLZ9AsSv4jD4Xa" crossorigin="anonymous"></script>


</body>
</html>