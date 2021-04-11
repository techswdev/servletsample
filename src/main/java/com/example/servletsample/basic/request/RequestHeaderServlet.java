package com.example.servletsample.basic.request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "reqeustHeaderServlet", urlPatterns = "/request-header")
public class RequestHeaderServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        getStartLine(req);
        getHeaderInfo(req);
        printHeaderUtils(req);
        printEtc(req);

    }

    private void printEtc(HttpServletRequest req) {
        System.out.println("Remote 정보");
        System.out.println("req.getRemoteHost() = " + req.getRemoteHost());
        System.out.println("req.getRemoteAddr() = " + req.getRemoteAddr());
        System.out.println("req.getRemotePort() = " + req.getRemotePort());

        System.out.println("local 정보<서버 정보>");
        System.out.println("req.getLocalName() = " + req.getLocalName());
        System.out.println("req.getLocalAddr() = " + req.getLocalAddr());
        System.out.println("req.getLocalPort() = " + req.getLocalPort());
    }

    private void printHeaderUtils(HttpServletRequest req) {
        System.out.println("header 조회");
        System.out.println("req.getServerName() = " + req.getServerName());
        System.out.println("req.getServerPort() = " + req.getServerPort());

        System.out.println("Accept-Language 조회");
        req.getLocales().asIterator().forEachRemaining(locale -> System.out.println("locale = "+locale));
        System.out.println("req.getLocale() = " + req.getLocale());

        if(req.getCookies() != null){
            for(Cookie cookie : req.getCookies()){
                System.out.println(cookie.getName() + " : " + cookie.getValue());
            }
        }

        System.out.println("Content  조회");
        System.out.println("req.getContentType() = " + req.getContentType());
        System.out.println("req.getContentLength() = " + req.getContentLength());
        System.out.println("req.getCharacterEncoding() = " + req.getCharacterEncoding());
    }

    private void getHeaderInfo(HttpServletRequest req) {
        System.out.println();
        req.getHeaderNames().asIterator().forEachRemaining(headerName-> System.out.println("headerName = " + headerName));
        System.out.println();

    }

    private void getStartLine(HttpServletRequest req) {

        System.out.println();
        System.out.println("req.getMethod() = " + req.getMethod());
        System.out.println("req.getProtocol() = " + req.getProtocol());
        System.out.println("req.getScheme() = " + req.getScheme());
        System.out.println("req.getRequestURI() = " + req.getRequestURI());
        System.out.println("req.getRequestURL() = " + req.getRequestURL());
        System.out.println("req.getQueryString() = " + req.getQueryString());
        System.out.println("req.isSecure() = " + req.isSecure());
        System.out.println();

    }

}
