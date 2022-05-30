package com.its.MemberShip.service;

import com.its.MemberShip.dto.BoardDTO;
import com.its.MemberShip.repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class BoardService {
    @Autowired
    private BoardRepository boardRepository;
    public boolean writesave(BoardDTO boardDTO) {
      int boardSave= boardRepository.writesave( boardDTO);
        if(boardSave >0){
            return true;
        }else{
            return false;
        }
    }

    public List<BoardDTO> findAll() {
        return boardRepository.findAll();
    }

    public BoardDTO findById(BoardDTO boardDTO) {
        // 1. 조회수 증가, 2. 상세정보 가져오기
        boardRepository.updateHits(boardDTO);
        return boardRepository.findById(boardDTO);
    }

    public List<BoardDTO> search(String searchType, String q) {
        Map<String, String> searchParam = new HashMap<>();
        searchParam.put("type", searchType);
        searchParam.put("q", q);
        List<BoardDTO> searchList = boardRepository.search(searchParam);
        return searchList;
    }
}
