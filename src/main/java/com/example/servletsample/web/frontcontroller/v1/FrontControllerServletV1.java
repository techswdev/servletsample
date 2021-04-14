package com.example.servletsample.web.frontcontroller.v1;

import com.example.servletsample.web.frontcontroller.v1.controller.MemberFormControllerV1;
import com.example.servletsample.web.frontcontroller.v1.controller.MemberSaveControllerV1;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "frontControllerServletV1", urlPatterns = "/front-controller/v1/*")
public class FrontControllerServletV1 extends HttpServlet {

    private Map<String, ControllerV1> controllerInfo = new HashMap<>();

    public FrontControllerServletV1() {
        controllerInfo.put("/front-controller/v1/members/new-form",new MemberFormControllerV1());
        controllerInfo.put("/front-controller/v1/members/save",new MemberSaveControllerV1());
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String requestURI = req.getRequestURI();
        ControllerV1 controllerV1 = controllerInfo.get(requestURI);
        if(controllerV1 == null){
            resp.setStatus(HttpServletResponse.SC_NOT_FOUND);
            return;
        }
        controllerV1.process(req,resp);

    }
}
