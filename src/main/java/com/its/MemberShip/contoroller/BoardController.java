package com.its.MemberShip.contoroller;

import com.its.MemberShip.dto.BoardDTO;
import com.its.MemberShip.dto.CommentDTO;
import com.its.MemberShip.dto.PageDTO;
import com.its.MemberShip.service.BoardService;
import com.its.MemberShip.service.CommentService;
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
    @Autowired
    CommentService commentService;



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
        List<CommentDTO> save = commentService.findByBoardId(boardDTO.getId());
        model.addAttribute("id",save);
        model.addAttribute("board", board);
        return "board/detail";
    }
    @GetMapping("board/search")
    public String search(@RequestParam("searchType") String searchType,
                         @RequestParam("q") String q, Model model){
       List<BoardDTO>searchList= boardService.search(searchType,q);
        model.addAttribute("boardList",searchList);
        System.out.println("BoardController.search");
        System.out.println(searchList);
        return "board/pagingList";
    }
    @GetMapping("/paging")
//    /board/paging?page=1
//    required=false로 하면 /board/paging 요청도 가능
//    별도의 페이지 값을 요청하지 않으면 첫페이지(pgae=1)를 보여주자.
    public String paging(@RequestParam(value="page", required=false, defaultValue="1") int page,
                         Model model) {
        List<BoardDTO> boardList = boardService.pagingList(page);
        PageDTO paging = boardService.paging(page);
        model.addAttribute("boardList", boardList);
        model.addAttribute("paging", paging);
        return "board/pagingList";
    }


}
