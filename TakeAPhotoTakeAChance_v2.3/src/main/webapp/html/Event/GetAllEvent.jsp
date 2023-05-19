<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List, java.util.ArrayList,com.ex2.bean.EventBean" %>
<%! @SuppressWarnings("unchecked") %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>活動資訊</title>
</head>
<body style = "background-color:#fdf5e5">
<div align="center">
<h2>活動資訊</h2>
<table border = "1">
<th>活動編號<th>主辦人<th>活動類型<th>活動主題<th>活動內容<th>活動日期
<% List<EventBean> events = (ArrayList<EventBean>)request.getAttribute("events");
	for(EventBean event: events){ %>
	<tr><td><%=event.getEventID() %>
	<td><%=event.getMemberID() %>
	<td><%=event.getEventType() %>
	<td><%=event.getEventTopic() %>
	<td><%=event.getEventInfo() %>
	<td><%=event.getEventDate() %>
<% } %>
</table>
<h3>共<%= events.size() %>筆活動資訊</h3>
</div>
</body>
</html>