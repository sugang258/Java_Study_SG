<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>BankBook Detail</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx" crossorigin="anonymous">

</head>
<style>
    .align-center {text-align: center;}
</style>
<body>
<c:import url="../template/header.jsp"></c:import>

<h1 class="align-center">!!!detail page!!!</h1>

<table border="1" class="table table-striped">
<!-- border 테두리 적용  -->
<tr>

				<td>BOOKNUM</td>
				<td>BOOKNAME</td>
				<td>BOOKRATE</td>
				<td>BOOKSALE</td>

</tr>

<tr>

			 <td>${dto.bookNum}</td> 
			<td>${dto.bookName} </td>
			<td>${dto.bookRate}</td>
			<td>${dto.bookSale}</td>
 
</td>


</tr>

</table>

<!--  상대경로 -->
<a href = "../member/login.gang" >login</a> 

<!--  절대경로  -->
<a href = "/member/join.gang" >join</a> 

<a href = "./list.gang" >리스트 보기</a> 
<a href ="./update.gang?bookNum=${dto.bookNum}"> 수정 </a>
<a href ="./delete.gang?bookNum=${dto.bookNum}"> 삭제 </a>

  <c:if test="${not empty sessionScope.member}">

<a href ="../bankaccount/add.gang?bookNum=${dto.bookNum}"> 상품 가입하기 </a> 


</c:if>
<c:import url="../template/footer.jsp"></c:import>
    
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-A3rJD856KowSb7dwlZdYEkO39Gagi7vIsF0jrRAoQmDKKtQBHUuLZ9AsSv4jD4Xa" crossorigin="anonymous"></script>


</body>
</html>