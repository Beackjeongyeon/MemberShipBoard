package com.its.MemberShip.repository;

import com.its.MemberShip.dto.MemberDTO;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MemberRepository {
    @Autowired
    private SqlSessionTemplate sql;

    public int save1(MemberDTO memberDTO) {
        return sql.insert("member.save2", memberDTO);


    }

    public void saveFile(MemberDTO memberDTO) {
        sql.insert("member.save2", memberDTO);
    }

    public MemberDTO login1(MemberDTO memberDTO) {
        return sql.selectOne("member.login2", memberDTO);

    }


    public MemberDTO logincheck1(String memberId) {
        return sql.selectOne("member.idcheck1",memberId);
    }
}
