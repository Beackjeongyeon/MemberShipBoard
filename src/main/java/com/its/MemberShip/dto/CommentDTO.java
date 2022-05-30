package com.its.MemberShip.dto;

import lombok.Data;

import java.sql.Timestamp;
@Data
public class CommentDTO {
    private Long id;
    private Long boardId;
    private String memberId;
    private String commentContents;
    private Timestamp commentCreatedDate;


}
