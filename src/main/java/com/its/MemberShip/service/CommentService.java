package com.its.MemberShip.service;

import com.its.MemberShip.dto.CommentDTO;
import com.its.MemberShip.dto.MemberDTO;
import com.its.MemberShip.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService {
    @Autowired
    private CommentRepository commentRepository;

    public void save(CommentDTO commentDTO) {
       commentRepository.save(commentDTO);
    }

    public List<CommentDTO> findByBoardId(Long id) {
      return   commentRepository.find(id);
    }
}
