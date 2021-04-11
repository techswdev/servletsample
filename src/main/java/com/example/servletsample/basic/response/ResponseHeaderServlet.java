package com.example.servletsample.basic.response;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "responseHeaderServlet", urlPatterns = "/response-header")
public class ResponseHeaderServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        setContent(resp);
        setCookies(resp);
        redirect(resp);
        resp.getWriter().write("ok");

    }

    private void redirect(HttpServletResponse resp) throws IOException {
        //  resp.setStatus(HttpServletResponse.SC_FOUND);
        // resp.setHeader("Location", "/basic/hello-form.html");
        resp.sendRedirect("/basic/hello-form.html");

    }

    private void setCookies (HttpServletResponse resp) {
        //Set-Cookie : myCookies=good; Max-aged = 600;
        //resp.setHeader("Set-Cookie", "MyCookies=good; Max-Age=600");
        Cookie cookie = new Cookie("myCookies", "good");
        cookie.setMaxAge(600);
        resp.addCookie(cookie);
    }

    private void setContent(HttpServletResponse resp) {
        //response-header
        //resp.setHeader("Content-type", "text/plain;charset=utf-8");
        //resp.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
        //resp.setHeader("Pragma", "no-cache");
        //resp.setHeader("my-header", "hello");

        resp.setContentType("text/plain");
        resp.setCharacterEncoding("utf-8");
    }


}
