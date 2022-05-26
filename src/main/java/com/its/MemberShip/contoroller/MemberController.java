package com.its.MemberShip.contoroller;

import com.its.MemberShip.dto.MemberDTO;
import com.its.MemberShip.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MemberController {
    @Autowired
    private MemberService memberService;


    @GetMapping("/member/save")
    public String save(){
        return "/member/save";
    }


    @PostMapping ("save1")
    public String save1(@ModelAttribute MemberDTO memberDTO){
       boolean saveresult = memberService.save1(memberDTO);
        if(saveresult == true){
            return "/member/login";
        }else{
            return "/member/save";
        }

    }
}
