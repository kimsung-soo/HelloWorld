package com.yedam.common;

import java.util.List;

import com.yedam.service.ReplyService;
import com.yedam.service.ReplyServiceImpl;
import com.yedam.vo.ReplyVO;

public class AppTest {
   public static void main(String[] args) {
      ReplyService svc= new ReplyServiceImpl();
      
      
      
      
   
      
      // 목록
      List<ReplyVO> list = svc.replyList(119);
      for(ReplyVO reply : list) {
         System.out.println(reply.toString());
      }
   }
}
