package com.its.MemberShip.repository;

import com.its.MemberShip.dto.BoardDTO;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import java.util.List;
import java.util.Map;

@Repository
public class BoardRepository {
    @Autowired
    private SqlSessionTemplate Sql;

    public void saveFile(BoardDTO boardDTO) {
        Sql.insert("board.saveFile", boardDTO); }


    public int writesave(BoardDTO boardDTO) {
       return Sql.insert("board.save",boardDTO);
    }

    public List<BoardDTO> findAll() {
        return Sql.selectList("board.findAll");
    }

    public void updateHits(BoardDTO boardDTO) {
        Sql.update("board.updateHits",boardDTO);
    }

    public BoardDTO findById(BoardDTO boardDTO) {

        return Sql.selectOne("board.findById",boardDTO);

    }


    public List<BoardDTO> search(Map<String, String> search) {
        System.out.println("search = " + search);
        System.out.println("BoardRepository.search");
        return Sql.selectList("board.find",search);

    }
    public int boardCount() {
        return Sql.selectOne("board.count");
    }

    public List<BoardDTO> pagingList(Map<String, Integer> pagingParam) {
        return Sql.selectList("board.pagingList", pagingParam);
    }
}
