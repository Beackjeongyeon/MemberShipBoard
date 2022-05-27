package com.its.MemberShip.contoroller;

import com.its.MemberShip.dto.MemberDTO;
import com.its.MemberShip.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/member")
public class MemberController {
    @Autowired
    private MemberService memberService;


    @GetMapping("/save")
    public String save(){
        return "member/save";
    }


    @PostMapping ("/save1")
    public String save1(@ModelAttribute MemberDTO memberDTO){
       boolean saveresult = memberService.save1(memberDTO);
        System.out.println("MemberController.save1");
        System.out.println("memberDTO = " + memberDTO);
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
    public  String login1(@ModelAttribute MemberDTO memberDTO){
        MemberDTO loginresult = memberService.login1(memberDTO);
        if(loginresult != null){
            return "member/findAll";
        }else{
            return "member/login";
        }
    }
    }



