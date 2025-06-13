/**
 * service.js
 */
//svc객체의 add메소드
const svc = {
	add: function(num1 = 0, num2 = 0) {
		return num1 + num2;
	},
	//목록출력메소드
	replyList(bno,successCallback,errorCallback){
		fetch('replyList.do?bno='+bno)
		.then(data => data.json())
		.then(successCallback)
		.catch(errorCallback)
	},
	//댓글삭제메소드.
	removeReply(rno, successCallback, errorCallback){
		//ajax
		fetch('removeReply.do?rno='+rno)
		.then(data => data.json())
		.then(successCallback)
		.catch(errorCallback)
	},
	
	//댓글등록메소드
	addReply(param={bno,reply,replyer},successCallback, errorCallback) {
		//ajax
				fetch('addReply.do',{
					method:'post',
					headers:{'Content-Type': 'application/x-www-form-urlencoded'},
					body:'bno='+ param.bno +'&reply='+param.reply+'&replyer=' +param.replyer
					
				})
				.then(data => data.json())
				.then(successCallback)
				.catch(errorCallback)
	}
}
//  add함수
const add = (num1, num2) => {
	return num1 + num2;
}

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
	
	