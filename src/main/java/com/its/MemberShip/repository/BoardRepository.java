package com.its.MemberShip.repository;

import com.its.MemberShip.dto.BoardDTO;
import org.apache.ibatis.jdbc.SQL;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Map;

@Repository
public class BoardRepository {
    @Autowired
    private SqlSessionTemplate Sql;


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

    public List<BoardDTO> search(Map<String, String> searchParam) {
        return Sql.selectList("Board.search", searchParam);
    }
}
