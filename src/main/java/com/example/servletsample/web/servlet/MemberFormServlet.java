package com.example.servletsample.web.servlet;

import com.example.servletsample.domain.member.MemberRepository;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name="memberFormServlet", urlPatterns = "/servlet/members/new-form")
public class MemberFormServlet extends HttpServlet {

    private MemberRepository memberRepository = MemberRepository.getInstance();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        resp.setCharacterEncoding("utf-8");
        resp.getWriter().write("<!DOCTYPE html>\n" +
                "<html>\n" +
                "<head>\n" +
                "    <meta charset=\"utf-8\">\n" +
                "    <title>title </title>\n" +
                "</head>\n" +
                "<body>\n" +
                "\n" +
                "<form action=\"/servlet/members/save\" method=\"post\">\n" +
                "    id : <input type=\"text\" name=\"id\">\n" +
                "    age      : <input type=\"text\" name=\"age\">\n" +
                "    <button type=\"submit\"> 전송 </button>\n" +
                "\n" +
                "</form>\n" +
                "</body>\n" +
                "\n" +
                "</html>");
    }
}
