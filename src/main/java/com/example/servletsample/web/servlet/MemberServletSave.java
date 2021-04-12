package com.example.servletsample.web.servlet;

import com.example.servletsample.domain.member.Member;
import com.example.servletsample.domain.member.MemberRepository;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "memberSaveServlet", urlPatterns = "/servlet/members/save")
public class MemberServletSave extends HttpServlet {

    private MemberRepository memberRepository =  MemberRepository.getInstance();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String age = req.getParameter("age");
        String id = req.getParameter("id");

        Member member = new Member(id, Integer.valueOf(age));
        memberRepository.save(member);

        resp.setCharacterEncoding("utf-8");
        resp.setContentType("text/html");

        resp.getWriter().write("<!DOCTYPE html>\n" +
                "<html>\n" +
                "<head>\n" +
                "    <meta charset=\"utf-8\">\n" +
                "    <title>title </title>\n" +
                "</head>\n" +
                "<body>\n" +
                "    <li>id="+member.getId()+"</li>\n" +
                "    <li>age="+member.getAge()+"</li>\n" +
                "\n" +
                "</body>\n" +
                "\n" +
                "</html>");
    }
}
