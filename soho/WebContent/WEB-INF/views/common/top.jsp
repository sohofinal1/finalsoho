<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<fmt:requestEncoding value="utf-8"/>

<%-- request.setCharacterEncoding("utf-8"); --%>
<jsp:useBean id="nows" class="java.util.Date"/>

<nav class="navbar navbar-expand-lg navbar-light bg-light">
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNavDropdown" aria-controls="navbarNavDropdown" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>
    <ul class="navbar-nav">
    <li class="nav-item dropdown">
        <a class="nav-link dropdown-toggle" href="main.tiles" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
          Mypage
        </a>
        <div class="dropdown-menu" aria-labelledby="navbarDropdown">
          <a class="dropdown-item" href="main.do">홈으로</a>
          <a class="dropdown-item" href="#">마이페이지</a>
          <a class="dropdown-item" href="#">비번변경</a>
          <a class="dropdown-item" href="#">정보수정</a>
          <a class="dropdown-item" href="#">일정관리</a>
          <div class="dropdown-divider"></div>
          <a class="dropdown-item" href="#">회원탈퇴</a>
        </div>
      </li>
       <li class="nav-item dropdown">
        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" data-toggle="dropdown">
         	 펜션소개
        </a>
        <div class="dropdown-menu" >
          <a class="dropdown-item" href="#">펜션소개</a>
          <a class="dropdown-item" href="#">펜션전경</a>
        </div>
      </li>
      <li class="nav-item dropdown">
        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdownMenuLink" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
     	     객실상세
        </a>
        <div class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
          <a class="dropdown-item" href="rbbslist.do">전체보기</a>
          <a class="dropdown-item" href="rbbsOne.do">베를린[101]</a>
          <a class="dropdown-item" href="rbbsTwo.do">런던[102]</a>
          <a class="dropdown-item" href="rbbsThree.do">파리[103]</a>
          <a class="dropdown-item" href="rbbsFour.do">로마[201]</a>
          <a class="dropdown-item" href="rbbsFive.do">프라하[202]</a>
          <a class="dropdown-item" href="rbbsSix.do">아테네[203]</a>
        </div>
      </li>
       <li class="nav-item dropdown">
        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdownMenuLink" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
     	    부대시설
        </a>
        <div class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
          <a class="dropdown-item" href="#">수영장</a>
          <a class="dropdown-item" href="#">바베큐장</a>
          <a class="dropdown-item" href="#">산책로</a>
        </div>
      </li>
       <li class="nav-item dropdown">
        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdownMenuLink" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
     	     여행지
        </a>
        <div class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
          <a class="dropdown-item" href="#">쁘띠프랑스</a>
          <a class="dropdown-item" href="#">아침고요수목원</a>
          <a class="dropdown-item" href="#">남이섬</a>
          <a class="dropdown-item" href="#">자라섬</a>
        </div>
      </li>
       <li class="nav-item dropdown">
        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdownMenuLink" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
     	     교통안내
        </a>
        <div class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
          <a class="dropdown-item" href="#">오시는길</a>
        </div>
      </li>
       <li class="nav-item dropdown">
        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdownMenuLink" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
     	     예약안내
        </a>
        <div class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
          <a class="dropdown-item" href="#">예약하기</a>
        </div>
      </li>
       <li class="nav-item dropdown">
        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdownMenuLink" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
     	     커뮤니티
        </a>
        <div class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
          <a class="dropdown-item" href="#">공지사항</a>
          <a class="dropdown-item" href="pdslist.do">추억남기기</a>
          <a class="dropdown-item" href="#">이벤트게시판</a>
          <a class="dropdown-item" href="#">자주하는질문</a>
          <a class="dropdown-item" href="#">고객만족도</a>
        </div>
      </li>
    </ul>

	<div id="_title_today" style="width: 70%; float: left; text-align: right;">
		<div style="position: relative; top: 27px">
		
		<c:if test="${login.id ne null}">
			<a href="logout.do" title="로그아웃">[로그아웃]</a>&nbsp;&nbsp;&nbsp;
		</c:if>
		<c:if test="${login.id eq null}">
			<a href="login.do" title="로그인">[로그인]</a>&nbsp;&nbsp;&nbsp;
		</c:if>
		
		<c:if test="${login.name ne null }">
			${login.name }님 환영합니다 
		</c:if>
		<c:if test="${login.name eq null }">
			<a href="regi.do" title="회원가입">[회원가입]</a>
		</c:if>
		
		
		</div>	
	</div>
</nav>
	<div align="center" id="_title_image" style="width: 100%; float: left; display: inline;  background-color: #b0dbd2 ">
		<img alt="이미지" src="image/shtop.jpg" style="height: 100px">	
	</div>


