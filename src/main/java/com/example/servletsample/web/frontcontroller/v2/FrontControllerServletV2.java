package com.example.servletsample.web.frontcontroller.v2;

import com.example.servletsample.web.frontcontroller.MyView;
import com.example.servletsample.web.frontcontroller.v1.ControllerV1;
import com.example.servletsample.web.frontcontroller.v1.controller.MemberFormControllerV1;
import com.example.servletsample.web.frontcontroller.v1.controller.MemberSaveControllerV1;
import com.example.servletsample.web.frontcontroller.v2.controller.MemberFormContorllerV2;
import com.example.servletsample.web.frontcontroller.v2.controller.MemberSaveContorllerV2;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "frontControllerServletV2", urlPatterns ="/front-controller/v2/*")
public class FrontControllerServletV2 extends HttpServlet {


    private Map<String, ControllerV2> controllerInfo = new HashMap<>();

    public FrontControllerServletV2() {
        controllerInfo.put("/front-controller/v1/members/new-form",new MemberFormContorllerV2());
        controllerInfo.put("/front-controller/v1/members/save",new MemberSaveContorllerV2());
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String requestURI = req.getRequestURI();
        ControllerV2 controllerV2 = controllerInfo.get(requestURI);
        if(controllerV2 == null){
            resp.setStatus(HttpServletResponse.SC_NOT_FOUND);
            return;
        }
        MyView view = controllerV2.process(req, resp);
        view.render(req, resp);

    }
}
