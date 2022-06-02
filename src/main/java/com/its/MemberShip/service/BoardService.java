package com.its.MemberShip.service;

import com.its.MemberShip.dto.BoardDTO;
import com.its.MemberShip.repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
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
    public void saveFile(BoardDTO boardDTO) throws IOException {
        /**
         1. DTO 객체에 담긴 파일을 꺼냄.
         2. 파일의 이름을 가져옴.
         2.1. 파일 이름 중복을 피하기 위한 조치
         3. 파일 이름을 DTO 객체의 boardFileName에 저장
         4. 파일의 저장 위치 지정.
         5. 파일 저장처리
         6. DTO 객체 repository로 전달
         */
        MultipartFile boardFile = boardDTO.getBoardFile(); // 1.
        String boardFileName = boardFile.getOriginalFilename(); // 2.
        boardFileName = System.currentTimeMillis() + "-" + boardFileName; // 2.1.
        boardDTO.setBoardFileName(boardFileName); // 3.
        String savePath = "D:\\spring_img\\" + boardFileName; // 4.
        // 5.
        if (!boardFile.isEmpty()) {
            boardFile.transferTo(new File(savePath));
        }
        boardRepository.saveFile(boardDTO); // 6.
    }
    private static final int PAGE_LIMIT = 5; // 한 페이지에 보여줄 글 갯수

    public List<BoardDTO> findAll() {
        return boardRepository.findAll();
    }

    public BoardDTO findById(BoardDTO boardDTO) {
        // 1. 조회수 증가, 2. 상세정보 가져오기
        boardRepository.updateHits(boardDTO);
        return boardRepository.findById(boardDTO);
    }


    public List<BoardDTO> search(String searchType, String q) {
        Map<String, String> search = new HashMap<>();
        search.put("type",searchType);
        search.put("q",q);
        List<BoardDTO>searchList =boardRepository.search(search);
        System.out.println("BoardService.search");
        System.out.println("searchType = " + searchType + ", q = " + q);
        return searchList;


    }
}


