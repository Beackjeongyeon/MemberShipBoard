package com.its.MemberShip.contoroller;

import com.its.MemberShip.dto.BoardDTO;
import com.its.MemberShip.dto.MemberDTO;
import com.its.MemberShip.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


import java.util.List;


@Controller

public class BoardController {


    @Autowired
    private BoardService boardService;

//    @GetMapping("/board/list")
//    public String list() {
//        return "/board/list";
//    }


    @GetMapping("/board/save")
    public String write() {
        return "/board/save";
    }
    // 글작성


    @PostMapping("/board/save")
    public String writesave(@ModelAttribute BoardDTO boardDTO) {
        boolean boardresult = boardService.writesave(boardDTO);
        if (boardresult == true) {
            return "/board/pagingList";
        } else {
            return "/board/save";
        }

    }

    @GetMapping("/board/pagingList")
    public String findAll(Model model) {
        List<BoardDTO> boardDTOList = boardService.findAll();
        model.addAttribute("boardList", boardDTOList);
        System.out.println("BoardController.findAll");
        System.out.println("model = " + boardDTOList);
        return "board/pagingList";
    }

    @GetMapping("/board/list")
    public String findById(@ModelAttribute BoardDTO boardDTO,Model model) {
         boardService.findById(boardDTO);
        model.addAttribute("board", boardDTO);
        return "board/detail";

    }
    @GetMapping("/board/search")
    public String search(@RequestParam("searchType") String searchType,
                         @RequestParam("q") String q, Model model) {
        List<BoardDTO> searchList = boardService.search(searchType, q);
        model.addAttribute("boardList", searchList);
        return "board/list";
    }

}



