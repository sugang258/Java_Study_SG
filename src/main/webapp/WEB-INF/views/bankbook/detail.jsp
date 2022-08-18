<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h1>!!!detail page!!!</h1>

<table border="1">
<!-- border 테두리 적용  -->
<tr>

				<td>BOOKNUM</td>
				<td>BOOKNAME</td>
				<td>BOOKRATE</td>
				<td>BOOKSALE</td>

</tr>

<tr>

			 <td>${requestScope.dto.getBookNum()}</td> 
			<td>${requestScope.dto.bookName} </td>
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

<a href ="../account/add.gang?bookNum=${dto.bookNum}"> 상품 가입하기 </a> 


</c:if>

</body>
</html>