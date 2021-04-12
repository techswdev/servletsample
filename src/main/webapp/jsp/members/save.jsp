<%@ page import="com.example.servletsample.domain.member.Member" %>
<%@ page import="com.example.servletsample.domain.member.MemberRepository" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    MemberRepository memberRepository = MemberRepository.getInstance();

    String age = request.getParameter("age");
    String id = request.getParameter("id");

    Member member = new Member(id, Integer.valueOf(age));
    memberRepository.save(member);
%>
<html>
<head>
    <li>id=<%=member.getId()%></li>
    <li>age=<%=member.getAge()%></li>
</head>
<body>
</body>
</html>