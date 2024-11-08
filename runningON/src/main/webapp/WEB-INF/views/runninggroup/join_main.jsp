<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link href="https://cdn.jsdelivr.net/npm/reset-css@5.0.2/reset.min.css"
	rel="stylesheet">
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="/resources/LHN/css/join_main.css" rel="stylesheet">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>모임 페이지</title>
<link rel="stylesheet" href="layout.css">
<!-- 외부 CSS 파일 링크 -->
</head>
<body>
	<div class="g_name">
		<h1>우리 러닝은 영원히! 포에버런!</h1>
	</div>
	<br>
	<hr>
	<br>
	<div class="g_gong">
		<p>러닝할때 노래 소리를 크게 틀어놓지 않도록 주의해 주시길 바랍니다.</p>
	</div>
	<hr>
	<div class="content_box">
		<!-- 모임 수다 -->
		<div class="content_sd">
			<h2>모임 수다</h2>
			<table class="content_table">
				<thead>
					<tr>
						<th>제목</th>
						<th>작성자</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td>1회 러닝</td>
						<td>사용자1</td>
					</tr>
					<tr>
						<td>2회 러닝</td>
						<td>사용자2</td>
					</tr>
					<tr>
						<td>3회 러닝</td>
						<td>관리자</td>
					</tr>
					<tr>
						<td>다음 모임 언제하나요?</td>
						<td>참여자1</td>
					</tr>
					<tr>
						<td>즐거운 시간이었어요!</td>
						<td>참여자2</td>
					</tr>
					<tr>
						<td>즐거운 시간이었어요!</td>
						<td>참여자2</td>
					</tr>
				</tbody>
			</table>
			<div id="t_foot">
					<b>이전</b>
					<b>현재페이지</b>
					<b>다음</b>
			</div>
		</div>
		<!-- 모임 사진 -->
		<div class="photo_section">
			<h2 style="text-align: center; margin: 20px;">모임 사진</h2>
			<hr>
			<div class="photo_table">
				<img alt="그림1" src="/resources/LHN/images/cat01.png" class="photo1">
				<img alt="그림2" src="/resources/LHN/images/cat01.png" class="photo2">
				<img alt="그림3" src="/resources/LHN/images/cat01.png" class="photo3">
				<img alt="그림4" src="/resources/LHN/images/cat01.png" class="photo4">
				<img alt="그림5" src="/resources/LHN/images/cat01.png" class="photo5">
				<img alt="그림6" src="/resources/LHN/images/cat01.png" class="photo6">
				<img alt="그림7" src="/resources/LHN/images/cat01.png" class="photo7">
				<img alt="그림8" src="/resources/LHN/images/cat01.png" class="photo8">
				<img alt="그림9" src="/resources/LHN/images/cat01.png" class="photo9">
			</div>
			
			<div id="p_foot">
					<b>이전</b>
					<b>현재페이지</b>
					<b>다음</b>
			</div>
		</div>

		<div class="member">
			<h2>모임 멤버</h2>
			<ul>
				<li>관리자</li>
				<li>러너1</li>
				<li>러너2</li>
				<li>러너3</li>
				<li>러너4</li>
				<li>러너5</li>
				<li>러너6</li>
				<li>러너7</li>
				<li>러너8</li>
				<li>러너9</li>
			</ul>
			
			<div id="m_foot">
					<b>이전</b>
					<b>다음</b>
			</div>
		</div>
	</div>
	<!-- 06. 하단 버튼 -->
	<footer class="footer">
		<button class="action_button" id="j_writer">글쓰기</button>
	</footer>
</body>
</html>
