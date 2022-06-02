package com.its.MemberShip.contoroller;

import com.its.MemberShip.dto.BoardDTO;
import com.its.MemberShip.dto.MemberDTO;
import com.its.MemberShip.dto.PageDTO;
import com.its.MemberShip.service.BoardService;
import com.its.MemberShip.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/member")
public class MemberController {
    @Autowired
    private MemberService memberService;


    @Autowired
    private BoardService boardService;

    @GetMapping("/save1")
    public String save() {
        return "member/save";
    }

    @GetMapping("/myPage")
    public String mypage(HttpSession session, Model model) {
        // 가져가야되는값이있어야한다.
        Long id = (Long)
                session.getAttribute("Id");
        MemberDTO result = memberService.findById(id);
        model.addAttribute("result", result);
        return "member/myPage";
    }


    @PostMapping("/save1")
    public String save1(@ModelAttribute MemberDTO memberDTO) throws IOException {
        boolean saveresult = memberService.save1(memberDTO);
        if (saveresult == true) {
            return "member/login";
        } else {
            return "member/save";
        }

    }

    @GetMapping("/login")
    public String login() {

        return "member/login";
    }

    @PostMapping("/login1")
    public String login1(@ModelAttribute MemberDTO memberDTO, HttpSession session, Model model) {
        MemberDTO loginresult = memberService.login1(memberDTO);





        if (loginresult != null) {
            String memberId = loginresult.getMemberId();
            Long id = loginresult.getId();
            session.setAttribute("memberId", memberId);
            session.setAttribute("Id", id);
            List<BoardDTO> boardDTOList = boardService.findAll();
            model.addAttribute("boardList", boardDTOList);
            return "redirect:/paging";
        } else {
            return "member/login";
        }
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.removeAttribute("memberId");
        session.removeAttribute("Id");
        return "index";


    }

    @GetMapping("/detail")
    public String findById(@RequestParam("id") Long id, Model model) {
        MemberDTO memberDTO = memberService.findById(id);
        model.addAttribute("member", memberDTO);
        System.out.println("id = " + id + ", model = " + model);
        System.out.println("MemberController.findById");
        return "member/detail";
    }


    @PostMapping("/duplicate-check")
    public String logincheck(@RequestParam("memberId") String memberId) {
        memberService.logincheck1(memberId);

        return null;

    }

    //  @GetMapping ("/myPage")
//    public String result(Model model,HttpSession session){
//        Long id = (Long) session.getAttribute("Id");
//        MemberDTO memberDTO = memberService.findById(id);
//        model.addAttribute("updateMember",memberDTO);
//
//        return "/member/myPage";
//  }
    @GetMapping("/update")
    public String update(@ModelAttribute MemberDTO memberDTO, HttpSession session, Model model) {
        boolean updateResult = memberService.update(memberDTO);

        if (updateResult) {
            return "redirect:/member/myPage";
        } else {
            return "update-fail";
        }
    }

    @GetMapping("/delete")
    public String delete(@RequestParam("id") Long id) {
        int result = memberService.delete(id);
        if (result > 0) {
            return "index";
        } else {
            return "/member/myPage";
        }
    }



}







