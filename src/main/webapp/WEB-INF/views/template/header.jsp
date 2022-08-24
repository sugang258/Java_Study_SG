<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<header class="container-fluid">
        <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
            <!-- Navbar content -->
            <div class="container-fluid">
                <a class="navbar-brand" href="#">Navbar</a>
                <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNavAltMarkup" aria-controls="navbarNavAltMarkup" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
                </button>
                <div class="collapse navbar-collapse" id="navbarNavAltMarkup">
                <div class="navbar-nav">
                    <a class="nav-link active" aria-current="page" href="../../../../../../">Home</a>
                    <a class="nav-link active" href="/bankbook/list.gang">상품리스트</a>
                    <a class="nav-link active" href="/notice/list.gang">공지사항</a>
                    <a class="nav-link active" href="/qna/list.gang">Q&A</a>
                    <a class="nav-link active" href="/member/search.gang">회원검색</a>
                    
                    <c:choose>
                    	<c:when test="${not empty member}">
		                    <a class="nav-link active" href="/member/myPage.gang">마이페이지</a>
		                    <a class="nav-link active" href="/member/logout.gang">로그아웃</a>
                    	</c:when>
                    	<c:otherwise>
		                    <a class="nav-link active" href="/member/login.gang">로그인</a>
		                    <a class="nav-link active" href="/member/join.gang">회원가입</a>
		                </c:otherwise>
                    </c:choose>
                </div>
                </div>
            </div>
        </nav>
    </header>