package com.its.MemberShip.dto;

import lombok.Data;

import java.security.Timestamp;

@Data
public class CommentDTO {
    private Long id;
    private Long boardId;
    private String commentContents;
    private String commentWriter;
    private Timestamp commentCreatedDate;


}
