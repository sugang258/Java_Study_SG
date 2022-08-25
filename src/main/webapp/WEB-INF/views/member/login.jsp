6<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>YG</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx" crossorigin="anonymous">
</head>
<style>
    .align-center {text-align: center;}
    .text-center{text-align : center!important;}
    .m-auto {margin:500!important;}
    .w-100 {width:100%!important;}
    .form-signin {max-width:330px; padding:15px}
    .wrapper{
    	display:flex;
    	justify-content:center;
    	align-items:center;
    	min-height:50vh;
    }
</style>

<body class="text-center">
	<c:import url="../template/header.jsp"></c:import>
	
	<main class="wrapper">
	<form action ="login.gang"  method="post">
	<img src="/resources/images/chunsik.png" width =100px height=100px>
  <div class="mb-3 mt-4">
    <label for="exampleInputEmail1" class="form-label">ID</label>
    </div>
    <div>
    <input type="text"  name="userName">
    <div id="emailHelp" class="form-text">We'll never share your ID with anyone else.</div>
  </div>
  <div class="mb-3 mt-4">
    <label for="exampleInputPassword1" class="form-label">Password</label>
    </div>
    <div>
    <input type="text" name="password">
  </div>
  
  <button type="submit" class="btn btn-primary mt-4">Submit</button>
</form>
</main>
	<c:import url="../template/footer.jsp"></c:import>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-A3rJD856KowSb7dwlZdYEkO39Gagi7vIsF0jrRAoQmDKKtQBHUuLZ9AsSv4jD4Xa" crossorigin="anonymous"></script>
	
</body>
</html>