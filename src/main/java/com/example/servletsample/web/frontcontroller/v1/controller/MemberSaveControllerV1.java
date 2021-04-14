package com.example.servletsample.web.frontcontroller.v1.controller;

import com.example.servletsample.domain.member.Member;
import com.example.servletsample.domain.member.MemberRepository;
import com.example.servletsample.web.frontcontroller.v1.ControllerV1;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class MemberSaveControllerV1 implements ControllerV1 {

    private MemberRepository memberRepository =  MemberRepository.getInstance();

    @Override
    public void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String age = request.getParameter("age");
        String id = request.getParameter("id");

        Member member = new Member(id, Integer.valueOf(age));
        memberRepository.save(member);

        //Model 데이터 보관
        request.setAttribute("member", member);

        String viewPath = "/WEB-INF/views/save-results.jsp";
        RequestDispatcher requestDispatcher = request.getRequestDispatcher(viewPath);
        requestDispatcher.forward(request, response);
    }
}
