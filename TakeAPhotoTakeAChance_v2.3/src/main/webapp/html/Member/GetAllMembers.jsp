<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.*,com.taptac.bean.MemberBean"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<title>會員資料</title>
</head>
<body>
	<div align="center">
		<h2>會 員 資 料</h2>
		<table border="1">
			<tr style="background-color: #a8fefa">
				<th>會員編號
				<th>會員名稱
				<th>會員帳號
				<th>會員密碼
				<th>會員信箱
				<th>會員性別 
				<c:forEach items="${members}" var="member">
						<tr>
							<td>${member.memberID}
							<td>
							
							<a href="GetMemberByIDServlet?memberID=${member.memberID}">
								${member.memberName} 
							</a>
									
							<td>${member.memberAccount}
							<td>${member.memberPassword}
							<td>${member.memberEmail}
							<td>${member.memberGender}
							<td>
								<form method="post" action="GetMemberByIDServletForUpdata">
									<input type="hidden" name="memberID" value="${member.memberID}" />
									<input type="submit" value="修改" />
								</form>
							</td>
							<td>
								<form method="post" action="DeleteMember/ConfirmDelete.jsp">
									<input type="hidden" name="memberID" value="${member.memberID}" />
									<input type="submit" value="刪除" />
								</form>
							</td>
					</c:forEach>
		</table>
	</div>
</body>
</html>