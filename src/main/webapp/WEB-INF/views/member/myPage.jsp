<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>myPage</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx" crossorigin="anonymous">

</head>
<style>
    .align-center {text-align: center;}
</style>
<body>
	<c:import url="../template/header.jsp"></c:import>

	<h1>myPage</h1>
	<!-- 
	<table border = "1" class="table table-striped" >
		<thead>
		<tr>
			<th>ID</th>
			<th>NAME</th>
			<th>EMAIL</th>
			<th>PHONE</th>
		</tr>
		</thead>
	
		<tbody>
			
				<tr>
					<td>${map.dto.userName}</td>
					<td>${map.dto.name}</td>
					<td>${map.dto.Email}</td>
					<td>${map.dto.phone}</td>
				</tr>
		 
		
		
		</tbody>
	
	
	</table>
	
	<table border = "1" class="table table-striped" >
		<thead>
		<tr>
			<th>ACCOUNTNUM</th>
			<th>BOOKNAME</th>
			<th>ACCOUNTDATE</th>
		</tr>
		</thead>
	
		<tbody>
		<c:forEach items="${map.list}" var="dto">
			
				<tr>
					<td>${dto.accountNum}</td>
					<td>${dto.bankBookDTO.bookname}</td>
					<td>${dto.accountDate}</td>
				</tr>
		 
		
		</c:forEach>
		</tbody>
	
	
	</table>
	 -->
	  
	<table border = "1" class="table table-striped" >
      <thead>
      <tr>
         <th>ID</th>
         <th>NAME</th>
         <th>EMAIL</th>
         <th>PHONE</th>
      </tr>
      </thead>
   
      <tbody>
         
            <tr>
               <td>${dto.userName}</td>
               <td>${dto.name}</td>
               <td>${dto.email}</td>
               <td>${dto.phone}</td>
            </tr>
       
      </tbody>
   
   </table>
   
   <table border = "1" class="table table-striped" >
      <thead>
      <tr>
         <th>ACCOUNTNUM</th>
         <th>BOOKNAME</th>
         <th>ACCOUNTDATE</th>
      </tr>
      </thead>
   
      <tbody>
      <c:forEach items="${dto.bankAccountDTOs}" var="dto1">
         
            <tr>
               <td>${dto1.accountNum}</td>
               <td>${dto1.bankBookDTO.bookName}</td>
               <td>${dto1.accountDate}</td>
            </tr>
       
      
      </c:forEach>
      </tbody>
   </table>
	
	
	<c:import url="../template/footer.jsp"></c:import>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-A3rJD856KowSb7dwlZdYEkO39Gagi7vIsF0jrRAoQmDKKtQBHUuLZ9AsSv4jD4Xa" crossorigin="anonymous"></script>
	

</body>
</html>