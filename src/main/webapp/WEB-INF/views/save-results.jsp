<%@ page import="com.example.servletsample.domain.member.Member" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <li>id=<%=((Member)request.getAttribute("member")).getId()%></li>
    <li>age=<%=((Member)request.getAttribute("member")).getAge()%></li>
</body>
</html>
