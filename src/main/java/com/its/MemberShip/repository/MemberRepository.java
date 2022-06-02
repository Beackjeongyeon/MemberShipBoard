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

    public MemberDTO findById(Long id) {
        return sql.selectOne("member.findById", id);
    }
    public  int update(MemberDTO memberDTO){
        return  sql.update("member.update", memberDTO);}

    public int delete(Long id) {
            return sql.delete("member.delete",id);
    }
}
