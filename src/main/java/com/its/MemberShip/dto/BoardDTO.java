package com.its.MemberShip.dto;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import java.sql.Timestamp;

@Data
public class BoardDTO {

    private Long id;
    private String boardTitle;
    private String boardWriter;
    private String boardContents;
    private int boardHits;
    private Timestamp boardCreateDate;
    private MultipartFile boardFile;
    private String boardFileName;

}
