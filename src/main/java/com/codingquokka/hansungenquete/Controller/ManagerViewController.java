package com.codingquokka.hansungenquete.Controller;

import com.codingquokka.hansungenquete.domain.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@RequestMapping("/manager")
@Controller
public class ManagerViewController {

    @Inject
    private CandidateDAO cDao;

    @Inject
    private ElectionDAO eDao;

    @Inject
    private ElectionvotedDAO evDao;

    @Inject
    private UserDAO uDao;

    @RequestMapping(value = "/main", method = RequestMethod.GET)
    public String MgrLogin(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession();
        UserVO uVo = (UserVO) session.getAttribute("UserVO");
        if (uVo != null) {
            return "Mgr001_Main";
        }
        else {
            response.setContentType("text/html; charset=euc-kr");
            PrintWriter out = null;
            out = response.getWriter();
            out.println("<script>alert('비정상적인 접근입니다 :('); </script>");
            out.flush();
            return "redirect:/login";
        }
    }
    @RequestMapping(value = "/vote", method = RequestMethod.GET)
    public String MgrMain(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession();
        UserVO uVo = (UserVO) session.getAttribute("UserVO");
        if (uVo != null) {
            return "Mgr002_Main2";
        }
        else {
            response.setContentType("text/html; charset=euc-kr");
            PrintWriter out = null;
            out = response.getWriter();
            out.println("<script>alert('비정상적인 접근입니다 :('); </script>");
            out.flush();
            return "redirect:/login";
        }
    }
}