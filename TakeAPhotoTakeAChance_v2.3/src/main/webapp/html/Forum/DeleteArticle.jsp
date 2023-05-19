<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>刪除文章</title>
</head>
<style>
.delete-btn {
	padding: 10px 20px;
	background: linear-gradient(to bottom, #1b93b4, #137e94);
	color: #fff;
	border: none;
	border-radius: 5px;
	cursor: pointer;
	transition: background 0.3s ease, box-shadow 0.3s ease;
	box-shadow: 2px 2px 5px rgba(0, 0, 0, 0.3);
	margin:20px
}

.delete-btn:hover {
	background: linear-gradient(to bottom, #ae8c84, #8a6860);
	box-shadow: 2px 2px 10px rgba(0, 0, 0, 0.5);
}

button[type="submit"] {
	padding: 10px 20px;
	background-color: rgb(27, 147, 180);
	color: #fff;
	border: none;
	border-radius: 5px;
	cursor: pointer;
	transition: background-color 0.3s ease;
}

button[type="submit"]:hover {
	background-color: rgb(174, 164, 132);
}
</style>

<body style="background-color: #fdf5e6">
	<div align="center">
		<h2>刪除文章</h2>
		<jsp:useBean id="deleteResult" scope="request"
			class="com.article.bean.ArticleBean" />
		<button onclick="deleteArticle()" class="delete-btn">確認刪除</button>
	</div>

	<script>
		function deleteArticle() {
			if (confirm("確認要刪除嗎？")) {
				// 在此加上刪除文章的程式碼
				alert("刪除成功");
			}
		}
	</script>

	<div style="text-align: center">
		<form method="post" action="html/Forum/MainPage.html">
			<button type="submit">回首頁</button>
		</form>
	</div>

</body>
</html>