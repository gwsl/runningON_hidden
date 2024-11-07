<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>프로필 및 게시글 목록</title>
    <link href="https://cdn.jsdelivr.net/npm/reset-css@5.0.2/reset.min.css" rel="stylesheet">
    <link href="/resources/KGW/css/thumbs2.css" rel="stylesheet">
    <link href="/resources/KGW/css/thumbs.css" rel="stylesheet">
 
</head>
<body>
	<jsp:include page="/WEB-INF/views/top.jsp" />
	<div id="layout">
		<div id="side_left">
			<jsp:include page="/WEB-INF/views/mypage/mypage_side_left.jsp" />
		</div>
	    <div id="main_page">
    <div class="profile">
    <c:choose>
        <c:when test="${empty my.user_profileImg }">
        	<a href="/my_info">
			<img src="/resources/KGW/images/basic.webp"></a>
        	
        </c:when>
        <c:otherwise>
        	<a href="/my_info">
            <img src="/resources/upload/${my.user_profileImg}" ></a>
        </c:otherwise>
    </c:choose>
   		<div class="profile-info">
           	<h2>${my.user_nickName}</h2>
          		<span>${my.user_id}</span><br>
           	<span>방문 92 · 작성글 3 · 구독멤버 0</span>
       	</div>
    </div>

    <div class="tabs">
        <a href="/my_act">작성글</a>
        <a href="/my_comment">작성댓글</a>
        <a href="#" class="active">스크랩</a>
    </div>

    <table>
        <tr>
            <th class="checkbox"><input type="checkbox"></th>
            <th>번호</th>
            <th>제목</th>
            <th>작성일</th>
            <th>조회</th>
        </tr>
        <c:choose>
			<c:when test="${empty list}">
				<tr><td colspan="5"><h3>게시물이 존재하지 않습니다.</h3></td></tr>
			</c:when>
		<c:otherwise>
			<c:forEach var="k" items="${list}" varStatus="c">
			<tr>
				<td class="checkbox"><input type="checkbox"></td>
				<td>${k.post_idx }</td>
				<td ><a href="/#?post_idx=${k.post_idx}">${k.post_title}</a></td>
				<td>${k.post_created_at}</td>
				<td>${k.post_views}</td>
			</tr>
			</c:forEach>
		</c:otherwise>
		</c:choose>
    </table>

    <!-- 두 버튼 삭제 어떠신지
		<div class="action-buttons">
	        <button>삭제</button>
	        <button class="write-button">글쓰기</button>
	    </div>
    -->
		</div>
	</div>
</body>
</html>