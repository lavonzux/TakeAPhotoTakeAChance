<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>文章資料</title>
<style>
body {
	background-color: #fff7db;
	font-family: Arial, sans-serif;
	font-size: 14px;
	line-height: 1.5;
}

table {
	margin: auto;
	width: 50%;
	border-collapse: collapse;
	background-color: #fff;
	box-shadow: 0 0 20px rgba(0, 0, 0, 0.15);
}

td {
	padding: 10px;
	border: 1px solid #ddd;
	background-color: #f2f2f2;
}

h2 {
	text-align: center;
}

textarea {
	width: 100%;
	height: 200px;
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
</head>
<body>
	<div align="center">
		<h2>新增文章資料</h2>
		<jsp:useBean id="resultBean" scope="request" class="com.article.bean.ArticleBean" />
		<table>
			
			<tr>
				<td style="background-color: #fafafa;">文章標題</td>
				<td><input type="text" disabled
					value="<%=resultBean.getArticleTitle()%>"></td>
			</tr>
			<tr>
				<td style="background-color: #fafafa;">文章內容</td>
				<td><textarea disabled><%=resultBean.getArticleContent()%></textarea></td>
			</tr>
			<tr>
				<td style="background-color: #fafafa;">Hashtag</td>
				<td><input type="text" disabled
					value="<%=resultBean.getHashtag()%>"></td>
			</tr>

		</table>
		
		<form method="post" action="html/Forum/MainPage.html">
			<button type="submit">回首頁</button>
		</form>
	</div>
</body>
</html>
