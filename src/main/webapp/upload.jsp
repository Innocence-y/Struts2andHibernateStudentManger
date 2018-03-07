<%--
  Created by IntelliJ IDEA.
  User: yanwenqiang
  Date: 2017/10/29
  Time: 15:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>多文件上传</title>
</head>
<body>

<s:form action="uploadAction" method="POST" enctype="multipart/form-data">
    <s:textfield label="上传文件" name="title"></s:textfield>
    <s:file label="选择文件1" name="upload"></s:file>
    <s:file label="选择文件2" name="upload"></s:file>
    <s:file label="选择文件3" name="upload"></s:file>
    <s:submit value="上传"></s:submit>
</s:form>
</body>
</html>
