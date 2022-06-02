package com.its.MemberShip.contoroller;

import com.its.MemberShip.dto.BoardDTO;
import com.its.MemberShip.dto.MemberDTO;
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

    @GetMapping("/save")
    public String save(){
        return "member/save";
    }

    @GetMapping("/myPage")
    public String mypage(){
        return "member/myPage";
    }


    @PostMapping ("/save1")
    public String save1(@ModelAttribute MemberDTO memberDTO)throws IOException {
       boolean saveresult = memberService.save1(memberDTO);
        if(saveresult == true){
            return "member/login";
        }else{
            return "member/save";
        }

    }
    @GetMapping("/login")
    public String login(){

        return "member/login";
    }
    @PostMapping("/login1")
    public  String login1(@ModelAttribute MemberDTO memberDTO, HttpSession session, Model model){
        MemberDTO loginresult = memberService.login1(memberDTO);
        List<BoardDTO> boardDTOList = boardService.findAll();
        model.addAttribute("boardList",boardDTOList);
        String memberId = loginresult.getMemberId();
        Long id = loginresult.getId();
        session.setAttribute("memberId",memberId);
        session.setAttribute("Id",id);



        if(loginresult != null){
            return "board/pagingList";
        }else{
            return "member/login";
        }
    }
    @GetMapping("/logout")
    public String logout(HttpSession session){
        session.removeAttribute("memberId");
        session.removeAttribute("Id");
        return "index";


    }


    @PostMapping("/duplicate-check")
    public  String logincheck(@RequestParam("memberId")String memberId ){
        memberService.logincheck1(memberId);

        return null;

    }
  @PostMapping("/myPage")
    public String result(Model model,HttpSession session){
        Long id = (Long) session.getAttribute("Id");
        MemberDTO memberDTO = memberService.findById(id);
        model.addAttribute("updateMember",memberDTO);
      System.out.println("MemberController.result");
      System.out.println(id);
        return "/member/myPage";
  }
    @PostMapping("/update")
    public String update(@ModelAttribute MemberDTO memberDTO){
        System.out.println("memberDTO = " + memberDTO);
        boolean updateResult = memberService.update(memberDTO);
        if(updateResult){
            // 해당 회원의 상세정보
            return "redirect:/detail?id=" + memberDTO.getId();
        }else{
            return "update-fail";
        }
    }
  }







