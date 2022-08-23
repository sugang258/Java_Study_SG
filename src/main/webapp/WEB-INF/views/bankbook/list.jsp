<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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



<h1>bankbook list</h1>

<table border ="1" class="table table-striped"> 

		</thead>
		
		<tr>
		
			
			   <th>BOOKNAME</th> 
			   <th>BOOKRATE</th> 
			 
		
		</tr>
		
		</thead>
		
		<tbody>
			
				
				<c:forEach items="${list}" var="dto">
				
				<tr>
					<td> <a href="./detail.gang?bookNum=${dto.bookNum}">
					${dto.bookName}</a> </td>
					
					<td> ${dto.bookRate} </td>
				</tr>
			</c:forEach>	
				
				
				
		</tbody>
		 
</table>
<br>
<a href = "add.gang"> 상품등록 </a>
<c:import url="../template/footer.jsp"></c:import>
    
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-A3rJD856KowSb7dwlZdYEkO39Gagi7vIsF0jrRAoQmDKKtQBHUuLZ9AsSv4jD4Xa" crossorigin="anonymous"></script>

</body>
</html>