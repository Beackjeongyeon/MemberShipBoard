package com.its.MemberShip.repository;

import com.its.MemberShip.dto.CommentDTO;
import com.its.MemberShip.dto.MemberDTO;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CommentRepository {
    @Autowired
    private SqlSessionTemplate Sql;

    public void save(CommentDTO commentDTO) {
       Sql.insert("Comment.save", commentDTO);

    }

    public List<CommentDTO> find(Long id) {
       return Sql.selectList("Comment.findAll",id);

    }
}
