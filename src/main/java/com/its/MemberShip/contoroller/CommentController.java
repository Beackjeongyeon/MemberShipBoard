package com.its.MemberShip.contoroller;

import com.its.MemberShip.dto.CommentDTO;
import com.its.MemberShip.dto.MemberDTO;
import com.its.MemberShip.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class CommentController {
    @Autowired
    private CommentService commentService;

    @GetMapping("/comment/save")
    public @ResponseBody List<CommentDTO> save(@ModelAttribute CommentDTO commentDTO, @RequestParam("boardId") Long id){
        commentService.save(commentDTO);
        List<CommentDTO> commentDTOList = commentService.findByBoardId(id);
        return  commentDTOList;


    }


}
