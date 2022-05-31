package com.its.MemberShip.contoroller;

import com.its.MemberShip.dto.BoardDTO;
import com.its.MemberShip.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


import java.io.IOException;
import java.util.List;


@Controller

public class BoardController {


    @Autowired
    private BoardService boardService;



    @GetMapping("/board/save")
    public String write() {
        return "/board/save";
    }
    // 글작성




    @PostMapping("/board/save")
    public String writesave(@ModelAttribute BoardDTO boardDTO) {
        boolean boardresult = boardService.writesave(boardDTO);
        System.out.println("boardDTO = " + boardDTO);
        System.out.println("BoardController.writesave");
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
    @GetMapping("/board/search")
    public String search(@RequestParam("searchType") String searchType,
                         @RequestParam("q") String q, Model model) {
        List<BoardDTO> searchList = boardService.search(searchType, q);
        model.addAttribute("boardList", searchList);
        return "board/list";
    }
    @GetMapping("/board/saveFile")
    public String savefile1(){
        return "board/saveFile";
    }

    // 파일첨부 글작성 처리
    @PostMapping ("/board/saveFile")
    public String saveFile(@ModelAttribute BoardDTO boardDTO) throws IOException {
        boardService.saveFile(boardDTO);
        System.out.println("boardDTO = " + boardDTO);
        System.out.println("BoardController.saveFile");
        return "board/saveFile";
    }
    @GetMapping("/board/detail")
    public String findById(@ModelAttribute BoardDTO boardDTO ,Model model){
        BoardDTO board= boardService.findById(boardDTO);
        model.addAttribute("board", board);
        return "board/detail";
    }


}
