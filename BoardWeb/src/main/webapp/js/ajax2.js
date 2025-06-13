/**
 * ajax2.js
 */
console.log(svc.add(10, 20));
//목록메소드 
svc.replyList(221, //게시글번호
	function(result) {
		console.log(result);
		result.forEach(function(item) {
			let tr = makeRow(item);
			document.querySelector('table:nth-of-type(2) tbody')
				.appendChild(tr);
		});
	}, //성공콜백함수

	function(err) {
		console.error(err);
	}) //실패콜백함수
//등록이벤트
document.querySelector('#addReply').addEventListener('click', addReplyFnc);
function addReplyFnc(){
	const bno = document.querySelector('#bno').value;
	const reply = document.querySelector('#reply').value;
	//필수입력
	if (!bno || !reply || !logId) {
				alert('필수값 입력하세요.');
				return;
}
//메소도 호출
svc.addReply({bno , reply , replyer:logId },
	function(result){
		if (result.retCode === 'Success') {
							alert('등록 성공!');
							let tr = makeRow(result.retVal);
							let target = document.querySelector('table:nth-of-type(2) tbody tr')
							document.querySelector('table:nth-of-type(2) tbody')
							.insertBefore(tr, target);
						} else {
							alert('등록실패!');
						}
		
	},
	function(err) {
			console.error(err);
		});

}

//삭제 메소드
function deleteReplyFnc(e) {
	let rno = e.target.parentElement.parentElement.dataset.rno;
	svc.removeReply(rno,
		function(result) {
			if (result.retCode === 'Success') {
				alert('삭제성공!');
				e.target.parentElement.parentElement.remove(); // tr 삭제
			} else {
				alert('삭제실패!');
			}
		},
		function(err) {
			console.error(err);
		}

	)
} //end of deleteReplyFnc
