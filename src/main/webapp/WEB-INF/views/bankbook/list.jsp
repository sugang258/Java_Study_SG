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


<h1>bankbook list</h1>

<table border ="1"> 

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
</body>
</html>