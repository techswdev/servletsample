package com.example.servletsample.basic.request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.stream.Stream;

@WebServlet(name="requestParamServlet", urlPatterns = "/request-param")
public class RequestParamServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        System.out.println("getParameterNames Test");
        req.getParameterNames()
                .asIterator()
                .forEachRemaining(
                        parameters -> System.out.println(parameters)
                );
        System.out.println();

        System.out.println("getParameter Test");
        String id = req.getParameter("id");
        System.out.println("id : "+id);
        System.out.println();

        System.out.println("getParameterValues Test");
        String[] hobbies = req.getParameterValues("hobby");
        Stream<String> stream = Arrays.stream(hobbies);
        stream.forEach(System.out::println);
        System.out.println();

    }
}
