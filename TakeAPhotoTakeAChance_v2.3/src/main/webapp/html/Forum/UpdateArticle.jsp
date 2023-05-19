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
</style>
</head>
<body>
	<div align="center">
		<h2>文章資料</h2>
		<form method="post" action="/TakeAPhotoTakeAChance/UpdateArticle">
			<jsp:useBean id="resultBean" scope="request" class="com.article.bean.ArticleBean" />
			<table>
				<tr>
					<td style="background-color: #fafafa;">文章編號</td>
					<td><input type="text" name="articleID" readonly
						value="<%=resultBean.getArticleID()%>"></td>
				</tr>
				<tr>
					<td style="background-color: #fafafa;">會員編號</td>
					<td><input type="text" name="memberID" readonly
						value="<%=resultBean.getMemberId()%>"></td>
				</tr>
				<tr>
					<td style="background-color: #fafafa;">會員姓名</td>
					<td><input type="text" name="memberName" readonly
						value="<%=resultBean.getMemberName()%>"></td>
				</tr>
				<tr>
					<td style="background-color: #fafafa;">文章標題</td>
					<td><input type="text" name="articleTitle"
						value="<%=resultBean.getArticleTitle()%>"></td>
				</tr>
				<tr>
					<td style="background-color: #fafafa;">文章內容</td>
					<td><textarea name="articleContent"><%=resultBean.getArticleContent()%></textarea></td>
				</tr>
				<tr>
					<td style="background-color: #fafafa;">Hashtag</td>
					<td><input type="text" name="hashtag"
						value="<%=resultBean.getHashtag()%>"></td>
				</tr>
				<tr>
					<td style="background-color: #fafafa;">發布日期</td>
					<td><input type="text" readonly
						value="<%=resultBean.getPostDate()%>"></td>
				</tr>
			</table>
			<button type="submit">更新</button>
		</form>
	</div>
</body>
</html>
