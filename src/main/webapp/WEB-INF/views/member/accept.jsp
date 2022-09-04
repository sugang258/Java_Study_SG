<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<style>
    .align-center {text-align: center;}
</style>
<body>
    <form action="./accept.gang" id="accept_submit" method="post" class="align-center">
        <h1>약관 동의</h1>
    <div><input type="checkbox" name="box" id="all" >전체 동의<br>
        <input type="checkbox" name="box" id="" class="cb req">이용 약관 동의(필수)<br>
        <input type="checkbox" name="box" id="" class="cb req">개인정보 수집 및 이용 동의(필수)<br>
        <input type="checkbox" name="box" id="" class="cb">위치기반서비스 이용약관 동의(선택)<br>
        <input type="checkbox" name="box" id="" class="cb">프로모션 정보 수신 동의(선택)<br>

    </div>
    

    <button type="button" class="btn btn-primary mt-4" onclick="location.href='join.gang'" >취소</button>
    <button type="button" class="btn btn-primary mt-4" id="accept" >확인</button>

</form>

    <script src="/resources/js/board.js"></script>
    <script>
        check();
    </script>

</body>
</html>