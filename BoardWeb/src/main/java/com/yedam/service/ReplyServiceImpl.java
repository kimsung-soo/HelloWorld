package com.yedam.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.yedam.common.DataSource;
import com.yedam.mapper.ReplyMapper;
import com.yedam.vo.ReplyVO;

public class ReplyServiceImpl implements ReplyService {

	SqlSession sqlSession = DataSource.getInstance().openSession(true);
	ReplyMapper mapper = sqlSession.getMapper(ReplyMapper.class);

    @Override
    public boolean addReply(ReplyVO rvo) {
        // 댓글 추가 (INSERT)
        return mapper.insertReply(rvo);
    }

    @Override
    public List<ReplyVO> replyList(int bno) {
        // 특정 글 번호(bno)에 대한 댓글 목록 반환 (SELECT)
        return mapper.selectReplies(bno);
    }

    @Override
    public ReplyVO getReply(int rno) {
        // 특정 댓글 번호(rno)에 대한 단건 조회 (SELECT)
        return mapper.selectReply(rno);
    }

    @Override
    public boolean removeReply(int rno) {
        // 특정 댓글 번호(rno)에 대한 삭제 (DELETE)
        return mapper.deleteReply(rno);
    }
}