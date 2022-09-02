<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
	
	<form action="./join.gang" class="align-center" id="join_submit" method="post" enctype="multipart/form-data">
  <div class="mb-3 mt-4">
    <label for="userName" class="form-label">ID</label>
    </div>
    <div>
    <input type="text" class="col-lg-2 join_ele" name="userName" id="userName">
    <div id="div1"></div>
    <div id="idHelp" class="form-text">We'll never share your ID with anyone else.</div>
  </div>
  <div class="mb-3 mt-4">
    <label for="password1" class="form-label">Password</label>
    </div>
    <div>
    <input type="text" class="col-lg-2 join_ele" name="password" id="password1">
    <div id="div2"></div>
  </div>
  <div class="mb-3 mt-4">
    <label for="password2" class="form-label">Name</label>
    </div>
    <div>
      <input type="text" class="col-lg-2 join_ele" name="password" id="password2">
      <div id="div3"></div>
    </div>
    <div class="mb-3 mt-4">
      <label for="name" class="form-label">Name</label>
      </div>
    <div>
    <input type="text" class="col-lg-2 join_ele" name="name" id="name" >
    <div id="div4"></div>
  </div>
  <div class="mb-3 mt-4">
    <label for="email" class="form-label">Email</label>
    </div>
    <div>
    <input type="email" class="col-lg-2 join_ele" name="Email" id="email">
    <div id="div5"></div>
  </div>
  <div class="mb-3 mt-4">
    <label for="phone" class="form-label">Phone</label>
    </div>
    <div>
    <input type="text" class="col-lg-2 join_ele" name="phone" id="phone">
    <div id="div6"></div>
  </div>
  
  <div class="mb-3 mt-4">
    <label for="files" class="form-label">Photo</label>
    </div>
    <div>
    <input type="file" class="col-lg-2 join_ele" name="photo" id="files">
  </div>
  
  <button  class="btn btn-primary mt-4" id="join" >Submit</button>
  <button class="btn btn-primary mt-4" onclick="location.href='login.gang'">뒤로가기</button>
</form>

    	<c:import url="../template/footer.jsp"></c:import>
    
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-A3rJD856KowSb7dwlZdYEkO39Gagi7vIsF0jrRAoQmDKKtQBHUuLZ9AsSv4jD4Xa" crossorigin="anonymous"></script>
  <script src="/resources/js/join.js"></script>
  <script>
    joincheck();
  </script>
</body>
</html>