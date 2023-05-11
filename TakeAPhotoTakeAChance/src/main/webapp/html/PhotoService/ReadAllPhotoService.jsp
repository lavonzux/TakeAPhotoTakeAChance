<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>PhotoService Information</title>
</head>


<body style="background-color: #fdf5e6">

    <div align="center">

        <table>

            <thead>
                <tr>
                    <th>攝影服務ID</th>
                    <th>攝影服務名稱</th>
                    <th>攝影服務類型</th>
                    <th>攝影服務價格</th>
                    <th>攝影服務時長</th>
                    <th>攝影服務地點</th>
                    <th>攝影服務創建者</th>
                    <th>修改/刪除</th>
                </tr>
            </thead>

            <tbody>

                <c:set var="sum"></c:set>
                <c:forEach items="${resultList}" var="resultBean" varStatus="s">
                    <tr>
                        <td><a href="ReadPhotoServiceServlet?serviceID=${resultBean.serviceID}">${resultBean.serviceID}</a></td>
                        <td>${resultBean.serviceName}</td>
                        <td>${resultBean.serviceType}</td>
                        <td>${resultBean.servicePrice}</td>
                        <td>${resultBean.serviceDuration}</td>
                        <td>${resultBean.serviceLocation}</td>
                        <td>${resultBean.serviceCreator}</td>
                        <td>
                            <a href="UpdatePhotoServiceServlet?serviceID=${resultBean.serviceID}">修改</a>
                            <a href="DeletePhotoServiceServlet?serviceID=${resultBean.serviceID}">刪除</a>
                        </td>
                    </tr>

                    <c:if test="${s.last}">
                        <c:set var="sum" value="${s.count}"></c:set>
                    </c:if>
                </c:forEach>
            </tbody>
        </table>

        <h3>Total:
            <c:out value="${sum}" /> entries of data.
        </h3>
    </div>
</body>
</html>