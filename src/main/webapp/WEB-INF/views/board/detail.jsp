<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
         <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>DETAIL</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx" crossorigin="anonymous">

</head>
<style>
    .align-center {text-align: center;}
</style>
<body>
<c:import url="../template/header.jsp"></c:import>

	<h1 class="align-center">${board} Detail</h1>
	
	<table border = "1" class="table table-striped">
	
	<tr>
	<th>num</th>
	<th>title</th>
	<th>contents</th>
	<th>writer</th>
	<th>regDate</th>
	<th>hit</th>
	
	</tr>
	<tr>
	<td>${boardDTO.num }</td>
	<td>${boardDTO.title }</td>
	<td>${boardDTO.contents }</td>
	<td>${boardDTO.writer }</td>
	<td>${boardDTO.regDate }</td>
	<td>${boardDTO.hit }</td>
	</tr>
	</table>
	
	 <div class="row">
   		<c:forEach items="${boardDTO.boardFileDTOs}" var="fileDTO">
   			<p>
   			<a href="../resources/upload/${board}/${fileDTO.fileName}">${fileDTO.oriName}</a>
   			</p>
   		</c:forEach>
  	  </div>
	
	<div class="row">
		<a href ="./reply.gang?num=${boardDTO.num }" class="btn btn-danger">Reply</a>
	</div>
	<a href="./delete.gang?num=${boardDTO.num}">글 삭제하기</a>
	<a href="./update.gang?num=${boardDTO.num}">글 수정하기</a>
	<a href="./list.gang">공지사항 목록가기</a>
	
	<c:import url="../template/footer.jsp"></c:import>
    
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-A3rJD856KowSb7dwlZdYEkO39Gagi7vIsF0jrRAoQmDKKtQBHUuLZ9AsSv4jD4Xa" crossorigin="anonymous"></script>
	

</body>
</html>