package com.yedam.vo;

import lombok.Data;

@Data
public class ReplyVO {
    private int replyNo;         // 댓글 번호
    private int boardNo;         // 게시글 번호
    private String reply;    // 댓글 내용
    private String replyer;  // 작성자
    private String replyDate; // 작성일자

  
    
}