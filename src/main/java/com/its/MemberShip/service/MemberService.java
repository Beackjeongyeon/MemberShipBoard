package com.its.MemberShip.service;

import com.its.MemberShip.dto.MemberDTO;
import com.its.MemberShip.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@Service

public class MemberService {
    @Autowired
    private MemberRepository memberRepository;


    public boolean save1(MemberDTO memberDTO) {

        int saveresult = memberRepository.save1(memberDTO);
        if (saveresult > 0) {
            return true;
        } else {
            return false;
        }
    }


    //파일첨부
    public void saveFile(MemberDTO memberDTO) throws IOException {
        /**
         * 1.dto 객체에 담긴 파일을 꺼냄
         * 2.파일의 이름을 가져옴
         *  2-1 .파일 이름 중복을 피하기 위한 조치
         * 3.파일 이름을 dto객체의 boardFileName에 저장
         * 4.파일의 저장위치지정
         * 5.파일저장 처리
         * 6.dto객체 repository로 전달
         */
        MultipartFile boardFile = memberDTO.getMemberProfile();//1번
        String memberFileName = boardFile.getOriginalFilename();//2
        memberFileName = System.currentTimeMillis() + "-" + memberFileName;//2.1
        memberDTO.setMemberFileName(memberFileName);//3
        String savePath = "D:\\spring_img\\" + memberFileName;//4

        if (!boardFile.isEmpty()) {
            boardFile.transferTo(new File(savePath));
            //파일이 비어있지 않다면 그 파일을 세이브 패스 경로에 옮겨라(저장해라)
            //나를 호출한 대로 이 익셉션을 던지겠다(예외처리)
        }//5
        memberRepository.saveFile(memberDTO);//6
    }

    public MemberDTO login1(MemberDTO memberDTO) {
        return memberRepository.login1(memberDTO);


    }


    public boolean logincheck1(String memberId) {
        MemberDTO idresult = memberRepository.logincheck1(memberId);
        if (idresult == null) {
            return true;
        } else {
            return false;
        }

    }
}
