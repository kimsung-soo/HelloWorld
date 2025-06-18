<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<h3>회원가입(signup.jsp)</h3>
<form  name="signForm"  action="signUp.do" method="post" enctype="multipart/form-data">
  <table class="table">
    <tr>
      <th>아이디</th>
      <td><input class="form-control" type="text" name="userId"></td>
    </tr>
    <tr>
      <th>비밀번호</th>
      <td><input class="form-control" type="password" name="userPw"></td>
    </tr>
    <tr>
      <th>이름</th>
      <td><input class="form-control" type="text" name="userName"></td>
    </tr>
    <tr>
      <th>이미지</th>
      <td><input class="form-control" type="file" name="userImg"></td>
    </tr>
    <tr>
      <td colspan="2" align="center">
        <input type="submit" class="btn btn-primary" value="회원가입">
        <input type="reset" class="btn btn-secondary" value="초기화">
      </td>
  </table>
</form>
<script>
document.addEventListener('DOMContentLoaded', function () {
    let check = false;

    const form = document.forms.signForm;
    const userIdInput = document.querySelector('input[name="userId"]');
    const passwordInput = document.querySelector('input[name="userPw"]');


    form.addEventListener('submit', function (e) {
        // 비밀번호 유효성 검사
        if (!passwordInput.value || passwordInput.value.length < 5) {
        	 e.preventDefault();
             alert('비밀번호는 5글자 이상 입력해주세요!');
             passwordInput.focus();
             return;
        }
		
        
        
        if (!check) {
            e.preventDefault();
            alert('입력값을 확인...');
            userIdInput.focus();
            return;
        }
    });

    // 아이디 입력 시 중복 체크 초기화
    userIdInput.addEventListener('input', function () {
        check = false;
    });

    // 아이디 변경 완료 후 중복 확인
    userIdInput.addEventListener('change', function () {
        const user = this.value.trim();
        if (!user) {
            alert("아이디를 입력하세요.");
            return;
        }

        fetch('checkId.do?id=' + user)
            .then(data => data.json())
            .then(result => {
                if (result.retCode === "Exist") {
                    alert("존재하는 아이디입니다.");
                    check = false;
                } else {
                    alert("사용 가능한 아이디입니다.");
                    check = true;
                }
            })
            .catch(err => {
                console.log(err);
                alert("서버 오류가 발생했습니다.");
            });
    });
});
</script>

