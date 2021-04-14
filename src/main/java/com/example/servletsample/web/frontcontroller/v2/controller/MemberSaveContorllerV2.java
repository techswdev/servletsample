package com.example.servletsample.web.frontcontroller.v2.controller;

import com.example.servletsample.domain.member.Member;
import com.example.servletsample.domain.member.MemberRepository;
import com.example.servletsample.web.frontcontroller.MyView;
import com.example.servletsample.web.frontcontroller.v2.ControllerV2;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class MemberSaveContorllerV2 implements ControllerV2 {

    private MemberRepository memberRepository =  MemberRepository.getInstance();

    @Override
    public MyView process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String age = request.getParameter("age");
        String id = request.getParameter("id");

        Member member = new Member(id, Integer.valueOf(age));
        memberRepository.save(member);

        //Model 데이터 보관
        request.setAttribute("member", member);

        return new MyView("/WEB-INF/views/save-results.jsp");


    }
}
