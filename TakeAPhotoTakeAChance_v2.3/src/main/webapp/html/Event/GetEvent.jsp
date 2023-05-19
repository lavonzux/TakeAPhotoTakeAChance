<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>活動資訊</title>
</head>
<body style = "background-color:#fdf5e5">
<div align="center">
<h2>活動資訊</h2>
<jsp:useBean id="event" scope="request" class="com.ex2.bean.EventBean" />
<table>
<tr><td>活動編號<td><input type="text" disabled value="<%=event.getEventID() %>">
<tr><td>主辦人<td><input type="text" disabled value="<%=event.getMemberID() %>">
<tr><td>活動類型<td><input type="text" disabled value="<%=event.getEventType() %>">
<tr><td>活動主題<td><input type="text" disabled value="<%=event.getEventTopic() %>">
<tr><td>活動內容<td><input type="text" disabled value="<%=event.getEventInfo() %>">
<tr><td>活動日期<td><input type="text" disabled value="<%=event.getEventDate() %>">
</table>
</div>
</body>
</html>
<%System.out.println(event.getEventID()); %>
<% if (event == null) {
       out.println("Failed to get event information.");
   } else {
       out.println("Successfully got event information.");
   }
%>