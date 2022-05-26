package com.its.MemberShip.service;

import com.its.MemberShip.dto.MemberDTO;
import com.its.MemberShip.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service

public class MemberService {
    @Autowired
    private MemberRepository memberRepository;
    public boolean save1(MemberDTO memberDTO) {
        int saveresult = memberRepository.save1(memberDTO);
        if(saveresult >0){
            return true;
        }else{
            return false;
        }
    }
}
