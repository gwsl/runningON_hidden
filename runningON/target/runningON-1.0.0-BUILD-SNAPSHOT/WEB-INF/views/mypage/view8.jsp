<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>view8</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>


<link href="/resources/kgw/css/thumbs8.css" rel="stylesheet">

</head>
<body>
		<form method="get" action="">
			<label for="recipients">받는 사람</label> <input type="text"
				id="recipients" name="recipients"
				placeholder="여러 명은 쉼표(,) 또는 세미콜론(;)구분(최대10명)" maxlength="100">

			<textarea id="message" name="message" placeholder="쪽지 내용을 입력하세요..."
				maxlength="1000"></textarea>

			<div class="char-count" id="char-count">0 / 1000자</div>

			<div class="submit-button">
				<input type="submit" value="보내기" data-url="/view9">
			</div>
		</form>

	<script>
		const messageInput = document.getElementById('message');
		const charCount = document.getElementById('char-count');

		messageInput.addEventListener('input', function() {
			const currentLength = messageInput.value.length;
			charCount.textContent = `${currentLength} / 1000자`;
		});
	</script>


</body>
</html>