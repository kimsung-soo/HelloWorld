/**
 * promise.js
 */

//Promise 객체역할
//비동기방식의 처리를 동기방식으로 순서로 처리 .
//화살표함수.
//function add(num1, num2) {
//	return num1 + num2;
//}
//const add = function add(num1, num2) {
//	return num1 + num2;
//}	


fetch('replyList.do?bno=221')
	.then(function(data) {
		//console.log(data);// Response결과
		return data.json(); //json -> object
	})
	.then(function(result) {
		console.log(result);
		result.forEach(function(item) {
			let tr = makeRow(item);
			document.querySelector('table:nth-of-type(2) tbody').appendChild(tr);
		});// 댓글수만큼 tr 생성 
	})
	.catch(function(err) {
		console.log(err);

	})//목록출력

	document.querySelector('#addReply').addEventListener('click', addReplyFnc);
	//등록이벤트
	function addReplyFnc(e) {
		const bno = document.querySelector('#bno').value;
		const reply = document.querySelector('#reply').value;

		if (!bno || !reply || !logId) {
			alert('필수값 입력하세요.');
			return;
		}
		//ajax 호풀
		//fetch(url) =>get 방식요청
		//fetch(url, option) => post방식
		fetch('addReply.do',{
			method:'post',
			headers: {'Content-Type':'application/x-www-form-urlencoded'},
			body: 'bno=' + bno +'&reply=' + reply + '&replyer=' + logId
		})		
			.then(json => json.json()) // JSON 파싱
			.then(result => {
				if (result.retCode === 'Success') {
					alert('등록 성공!');
					let tr = makeRow(result.retVal);
					let target = document.querySelector('table:nth-of-type(2) tbody tr')
					document.querySelector('table:nth-of-type(2) tbody')
					.insertBefore(tr, target);
				} else {
					alert('등록실패!');
				}
			})
			.catch(err => console.log(err));
}	
	
function deleteReplyFnc(e) {
	if (!confirm("정말 삭제하시겠습니까?")) return;

	let rno = e.target.parentElement.parentElement.dataset.rno;

	fetch('removeReply.do?rno=' + rno)
		.then(json => json.json()) // JSON 파싱
		.then(data => {
			if (data.retCode === 'Success') {
				alert('삭제성공!');
				e.target.parentElement.parentElement.remove(); // tr 삭제
			} else {
				alert('삭제실패!');
			}
		})
		.catch(err => console.error(err));

}//end of deleteReplyFnc



	function makeRow(item) {
		let tr = document.createElement('tr');//<tr> </tr>
		tr.setAttribute('data-rno', item.replyNo); // <tr data-rno="8"></tr>
		// 글번호, 내용, 작성자
		for (let prop of ['replyNo', 'reply', 'replyer']) {
			let td = document.createElement('td');//<td> </td>
			td.innerHTML = item[prop]; //item['replyNo']
			tr.appendChild(td); //<tr><td> </td> </tr>
		}
		//삭제버튼
		let td = document.createElement('td');
		let btn = document.createElement('button');
		btn.addEventListener('click', deleteReplyFnc);
		btn.innerHTML = '삭제';
		btn.className = 'btn btn-danger';
		td.appendChild(btn);
		tr.appendChild(td);
		return tr; //makeRow를 호출한 영역으로 tr 반환.
	}//end makeRow
	
