<%@page import="com.gang.start.board.BoardDTO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
     <%ArrayList<BoardDTO> ar = (ArrayList<BoardDTO>) request.getAttribute("board"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx" crossorigin="anonymous">

</head>
<style>
    .align-center {text-align: center;}
</style>

<body>
<c:import url="../template/header.jsp"></c:import>
<h2 class="align-center">게시판 목록</h2>
<table border = "1" class="table table-striped align-center ">

	<thead>
	<tr>
		<th> num </th> <th> title </th> <th> username </th> <th>textDate</th> <th> views </th>
	</tr>
	</thead>
	
	<tbody>
<!--  
	<c:forEach items="${requestScope.board }" var="board">
	<tr>
	<td>${pageScope.board.num }</td>
	<td>${pageScope.board.title }</td>
	<td>${pageScope.board.userName }</td>
	<td>${pageScope.board.textDate }</td>
	<td>${pageScope.board.views }</td>
	</tr>
	</c:forEach> -->
	<% for (BoardDTO boardDTO : ar) { %>
	<tr>
	<td><a href ="./detail.gang?num=<%= boardDTO.getNum() %>"><%= boardDTO.getNum() %></a></td>
	<td><%= boardDTO.getTitle() %></td>
	<td><%= boardDTO.getUserName() %></td>
	<td><%= boardDTO.getTextDate() %></td>
	<td><%= boardDTO.getViews() %></td>
	</tr>
	<%} %>
	
	</tbody>
</table>
<c:if test="${not empty sessionScope.member}">
<a href="./add.gang">글 작성하기</a>
</c:if>
	<c:import url="../template/footer.jsp"></c:import>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-A3rJD856KowSb7dwlZdYEkO39Gagi7vIsF0jrRAoQmDKKtQBHUuLZ9AsSv4jD4Xa" crossorigin="anonymous"></script>


</body>
</html>