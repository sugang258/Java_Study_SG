<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
             <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- summernote jquery -->
<script type="text/javascript" src="//code.jquery.com/jquery-3.6.0.min.js"></script>
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

<form action ="update.gang" class="align-center" method="post" enctype="multipart/form-data">
<h2 class="align-center">${board}  List</h2>

  <div class="mb-3 mt-4">
    <label class="form-label">Num </label>
    </div>
    <div>
    <input type ="text" name ="num"  readonly value ="${boardDTO.num}"> 
    </div>
  <div class="mb-3 mt-4">
    <label  class="form-label">Title</label>
    </div>
    <div>
    <input type="text" class="col-lg-2" name="title" value="${boardDTO.title}">
  </div>
  <div class="mb-3 mt-4">
    <label  class="form-label">Contents</label>
    </div>
    <div>
    <input type="text" class="col-lg-2" name="contents" value="${boardDTO.contents}">
  </div>
  
  <c:forEach items="${boardDTO.boardFileDTOs}" var="fileDTO">
  	<div class="mb-3">
  		<span class="form-control">${fileDTO.oriName }</span>
  		<button type="button" id="del" class="fileDelete" data-file-num="${fileDTO.fileNum}">삭제</button> 
  	</div>
  
  </c:forEach>

  <div id="addFiles" class="mt-3">
    <button type="button" class="btn btn-danger" id="fileAdd">파일 추가</button>
  </div>
  
  <button type="submit" class="btn btn-primary mt-4">Update</button>
</form>

<c:import url="../template/footer.jsp"></c:import>
    
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-A3rJD856KowSb7dwlZdYEkO39Gagi7vIsF0jrRAoQmDKKtQBHUuLZ9AsSv4jD4Xa" crossorigin="anonymous"></script>
	<script src="/resources/js/board_file.js"></script>
  <script>
    setCount(${boardDTO.boardFileDTOs.size()});
  </script>
  <script type="text/javascript">
		$("#contents").summernote();
	</script>


</body>
</html>