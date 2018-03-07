<%--
  Created by IntelliJ IDEA.
  User: yanwenqiang
  Date: 2017/10/29
  Time: 18:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
    <title>Title</title>
</head>
<body>
<center>
    <table cellpadding="10" cellspacing="10">
        <tr>
            <td>文件名</td>
            <td>操作</td>
        </tr>
        <c:forEach items="${uploadFileName}" var="fileName" varStatus="fn">
            <tr>
                <td>${fileName}</td>
                <td>
                    <c:url var="url" value="download.action">
                        <c:param name="filename" value="${fileName}"></c:param>
                    </c:url>
                    <a href="${url}">下载</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</center>
</body>
</html>
