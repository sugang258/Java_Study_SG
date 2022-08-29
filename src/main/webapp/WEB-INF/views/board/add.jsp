<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ADD Page</title>
<!-- jquery -->
 <script type="text/javascript" src="//code.jquery.com/jquery-3.6.0.min.js"></script>
 <!-- bootstrap -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx" crossorigin="anonymous">
<!-- intclude summernote css/js -->
 <link href="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote-lite.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote-lite.min.js"></script>
</head>
<style>
    .align-center {text-align: center;}
</style>
<body>
<c:import url="../template/header.jsp"></c:import>

<form action ="./add.gang" class="align-center" method="post" enctype="multipart/form-data">
  	<h1 class="align-center">${board } ADD</h1>
  
  <div class="mb-3 mt-4">
    <label class="form-label">Title</label>
    </div>
    <div>
    <input type ="text" name ="title"> 
    </div>
  <div class="mb-3 mt-4">
    <label  class="form-label">Contents</label>
    </div>
    <div>
    <textarea class="col-lg-2" name="contents" id="contents"></textarea>
  </div>
  
  <div class="mb-3 mt-4">
    <label for="files" class="form-label">File</label>
    </div>
    <div>
    <input type="file" class="col-lg-2" name="files" id="files1">
  </div>
  
  <div class="mb-3 mt-4">
    <label for="files" class="form-label">File</label>
    </div>
    <div>
    <input type="file" class="col-lg-2" name="files" id="files2">
  </div>
  
  <div class="mb-3 mt-4">
    <label for="files" class="form-label">File</label>
    </div>
    <div>
    <input type="file" class="col-lg-2" name="files" id="files3">
  </div>
 
  
  <button type="submit" class="btn btn-primary mt-4">글 게시하기</button>
</form>

	
	<c:import url="../template/footer.jsp"></c:import>
    
    <!-- bootstrap -->
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-A3rJD856KowSb7dwlZdYEkO39Gagi7vIsF0jrRAoQmDKKtQBHUuLZ9AsSv4jD4Xa" crossorigin="anonymous"></script>
	<script type="text/javascript">
		$("#contents").summernote();
	</script>

</body>
</html>