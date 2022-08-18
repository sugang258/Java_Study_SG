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
 

<H1> BANKBOOK update page</H1>

<form action ="update.gang" method = "post" >
<input type ="hidden" name ="bookNum"  readonly value ="${dto.bookNum}}"> 

<div>
 	Name <input type =" text" name= "bookName" value ="${dto.bookName} }">
</div>

<div>
	 Rate <input type =" text " name="bookRate" value ="${dto.bookRate} }">
</div>

    
   <button type="submit">update</button>
	<a href="../"><input type="button" value="메인으로 이동"></a>
	
	
</form>

</body>
</html>