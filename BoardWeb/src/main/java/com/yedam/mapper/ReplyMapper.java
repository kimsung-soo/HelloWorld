package com.yedam.mapper;

import java.util.List;

import com.yedam.vo.ReplyVO;

public interface ReplyMapper {
    boolean insertReply(ReplyVO vo);
    List<ReplyVO> selectReplies(int bno);
    ReplyVO selectReply(int rno);
    boolean deleteReply(int rno);
}