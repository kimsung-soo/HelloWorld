<%@ page import="com.yedam.vo.BoardVO" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<jsp:include page="../include/header.jsp" />

<h3>수정화면(modifyForm.jsp)</h3>

<%
    BoardVO board = (BoardVO) request.getAttribute("board");
%>

<form action="modifyBoard.do" method="post">
   <input type="hidden" name="bno" value="<%= board.getBoardNo() %>">


    <table class="table table-bordered">
        <tr>
            <th>글번호</th>
            <td><%= board.getBoardNo() %></td>
            <th>조회수</th>
            <td><%= board.getReadCnt() %></td>
        </tr>
        <tr>
            <th>제목</th>
            <td colspan="3">
                <input type="text" name="title" class="form-control" value="<%= board.getTitle() %>">
            </td>
        </tr>
        <tr>
            <th>내용</th>
            <td colspan="3">
                <textarea name="content" class="form-control" rows="5"><%= board.getContent() %></textarea>
            </td>
        </tr>
        <tr>
            <th>작성자</th>
            <td colspan="3"><%= board.getWriter() %></td>
        </tr>
        <tr>
            <th>작성일지</th>
            <td colspan="3"><%= board.getWriteDate() %></td>
        </tr>
        <tr>
            <td colspan="4" class="text-center">
                <input type="submit" value="저장" class="btn btn-warning" />
                <button type="button" class="btn btn-danger">삭제</button>
            </td>
        </tr>
    </table>
</form>
<script>
let bno = "<%=board.getBoardNo() %>"
console.log(bno);
document.querySelector('button.btn-danger').addEventListener('click',function(){
	location.href ='removeBoard.do?bno='+ bno;
})
	
</script>
<jsp:include page="../include/footer.jsp" />
