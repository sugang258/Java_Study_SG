<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
         <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>BOARD DETAIL</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx" crossorigin="anonymous">

</head>
<style>
    .align-center {text-align: center;}
</style>
<body>
<c:import url="../template/header.jsp"></c:import>

	<h1 class="align-center">Board Detail</h1>
	
	<table border = "1" class="table table-striped">
	
	<tr>
	<th>num</th>
	<th>title</th>
	<th>contexts</th>
	<th>username</th>
	<th>textDate</th>
	<th>views</th>
	
	</tr>
	<tr>
	<td>${board.num }</td>
	<td>${board.title }</td>
	<td>${board.contexts }</td>
	<td>${board.userName }</td>
	<td>${board.textDate }</td>
	<td>${board.views }</td>
	</tr>
	</table>
	
	<a href="./update.gang?num=${board.num}">글 수정하기</a>
	<a href="./delete.gang?num=${board.num}">글 삭제하기</a>
	<a href="./list.gang">공지사항 목록가기</a>
	
	<c:import url="../template/footer.jsp"></c:import>
    
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-A3rJD856KowSb7dwlZdYEkO39Gagi7vIsF0jrRAoQmDKKtQBHUuLZ9AsSv4jD4Xa" crossorigin="anonymous"></script>
	

</body>
</html>