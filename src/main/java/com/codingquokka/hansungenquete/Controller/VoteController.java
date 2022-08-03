package com.codingquokka.hansungenquete.Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalTime;
import java.util.*;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.codingquokka.hansungenquete.domain.*;

@RequestMapping("/vote")
@Controller
public class VoteController {

    @Inject
    private CandidateDAO cDao;

    @Inject
    private ElectionDAO eDao;

    @Inject
    private ElectionvotedDAO evDao;

    @Inject
    private UserDAO uDao;


    @RequestMapping(value = "/votehome", method = RequestMethod.GET)
    public String VoteHome(Locale locale, HttpServletRequest request, HttpServletResponse response) throws Exception {
        HttpSession session = request.getSession();

        UserVO user = (UserVO) session.getAttribute("UserVO");
        if (user == null) {
            sessionIsNull(response);
        }
        String department = user.getDepartment();


        ElectionVO evVo = new ElectionVO();
        evVo.setDepartment(department);
        List<ElectionVO> electionList = eDao.selectElection(evVo);
        List<Float> votePercentageList = new ArrayList<Float>();
        List<Integer> voteRightCountList = new ArrayList<Integer>();
        for(ElectionVO e : electionList) {
            int voteRightCount = uDao.totalVoters(e.getDepartment());
            int votePercentage = evDao.turnout(e.getElectionName());
            votePercentageList.add((float)votePercentage/voteRightCount);
            voteRightCountList.add(voteRightCount);
        }

        request.setAttribute("username", user.getName() + " (" + user.getStuid() + ")");
        request.setAttribute("electionList",electionList);

        request.setAttribute("votePercentageList",votePercentageList);
        request.setAttribute("voteRightCountList",voteRightCountList);
        return "003_Vote1";
    }


    @RequestMapping(value = "/voteDetail", method = RequestMethod.GET)
    public String VoteDetail(Locale locale, HttpServletRequest request, HttpServletResponse response) throws Exception {
        HttpSession session = request.getSession();
        UserVO user = (UserVO)session.getAttribute("UserVO");
        if (user == null) {
            sessionIsNull(response);
        }
        if (LocalTime.now().getHour() < 9 || LocalTime.now().getHour() >  23) {
            response.setContentType("text/html; charset=euc-kr");
            PrintWriter out = null;
            out = response.getWriter();
            out.println("<script>alert('투표가능시간이 아닙니다');" +
                    "location.href = \"/vote/votehome\";" +
                    "</script>");
            out.flush();
        }

        String election = request.getParameter("electionName");
        ElectionvotedVO evVo = new ElectionvotedVO();
        evVo.setStuId(user.getStuid());
        evVo.setName(user.getName());
        evVo.setDepartment(user.getDepartment());
        evVo.setElectionName(election);
        ElectionvotedVO wasVoted = evDao.wasVoted(evVo);


        if (wasVoted != null) {
            response.setContentType("text/html; charset=euc-kr");
            PrintWriter out = null;
            out = response.getWriter();
            out.println("<script>alert('중복투표는 불가합니다');" +
                    "location.href = \"/vote/votehome\";" +
                    "</script>");
            out.flush();
        }

        List<CandidateVO> candiList = cDao.selectList(election);
        request.setAttribute("candiList", candiList);


        return "004_Vote2";
    }

    @RequestMapping(value = "/doVote", method = RequestMethod.POST)
    public void DoVote(Locale locale, HttpServletRequest request, HttpServletResponse response, @RequestParam("CandidateName") String CandidateName, @RequestParam("ElectionName") String ElectionName) throws Exception {
        HttpSession session = request.getSession();
        UserVO user = (UserVO)session.getAttribute("UserVO");
        if (user == null) {
            sessionIsNull(response);
        }

        ElectionvotedVO evVo = new ElectionvotedVO();
        evVo.setElectionName(ElectionName);
        evVo.setVotename(CandidateName);
        evVo.setStuId(user.getStuid());
        evVo.setName(user.getName());

        evDao.insertVote(evVo);

        response.setContentType("text/html; charset=euc-kr");
        PrintWriter out = null;
        out = response.getWriter();
        out.println("<script>alert('투표가 완료되었습니다. 감사합니다 :)');" +
                "location.href = \"/vote/votehome\";" +
                "</script>");
        out.flush();
    }
    //----------------------------------Method------------------------------------------------------------------------//
    void sessionIsNull(HttpServletResponse response) throws IOException {
        response.setContentType("text/html; charset=euc-kr");
        PrintWriter out = null;
        out = response.getWriter();
        out.println("<script>alert('세션이 만료되었습니다. 다시 로그인해 주세요 :(');" +
                "location.href = \"/login\";" +
                "</script>");
        out.flush();
    }

}
