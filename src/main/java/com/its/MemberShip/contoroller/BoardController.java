package com.its.MemberShip.contoroller;

import com.its.MemberShip.dto.MemberDTO;
import com.its.MemberShip.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;


@Controller

public class BoardController {


    @Autowired
    private BoardService boardService;
    @GetMapping("/board/list")
    public String list(){
        return "/board/list";
    }

    @PostMapping("/board/logout")
    public String logout(){
        return "/index";

    }




}
