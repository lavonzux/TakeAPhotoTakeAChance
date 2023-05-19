<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>更新完成</title>
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

button {
	margin: 10px;
	padding: 5px;
	font-size: 16px;
	background-color: #4CAF50;
	color: white;
	border: none;
	border-radius: 4px;
	cursor: pointer;
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
		<h2>更新完成</h2>
		<jsp:useBean id="updateBean" scope="request" class="com.article.bean.ArticleBean" />
		<table>
			<tr>
				<td style="background-color: #fafafa;">文章編號</td>
				<td><input type="text" 　name="articleID" disabled
					value="<%=updateBean.getArticleID()%>"></td>
			</tr>
			<tr>
				<td style="background-color: #fafafa;">會員編號</td>
				<td><input type="text" name="memberID" disabled
					value="<%=updateBean.getMemberId()%>"></td>
			</tr>
			<tr>
				<td style="background-color: #fafafa;">會員姓名</td>
				<td><input type="text" name="memberName" disabled
					value="<%=updateBean.getMemberName()%>"></td>
			</tr>
			<tr>
				<td style="background-color: #fafafa;">文章標題</td>
				<td><input type="text" name="articleTitle" disabled
					value="<%=updateBean.getArticleTitle()%>"></td>
			</tr>
			<tr>
				<td style="background-color: #fafafa;">文章內容</td>
				<td><textarea name="articleContent" disabled><%=updateBean.getArticleContent()%></textarea></td>
			</tr>
			<tr>
				<td style="background-color: #fafafa;">Hashtag</td>
				<td><input type="text" name="hashtag" disabled
					value="<%=updateBean.getHashtag()%>"></td>
			</tr>
			<tr>
				<td style="background-color: #fafafa;">發布日期</td>
				<td><input type="text" disabled
					value="<%=updateBean.getPostDate()%>"></td>
			</tr>
		</table>

			
		<form method="post" action="html/Forum/MainPage.html">
			<button type="submit">回首頁</button>
		</form>
	</div>
</body>
</html>
