/*
 * covid.js
 */
import { makeRow, url } from './covid_module.js';

//변수 선언
let centerAry;

// DOM이 모두 로드된 후 실행
document.addEventListener('DOMContentLoaded', function() {

	fetch(url)
		.then(data => data.json())
		.then(result => {
			console.log(result.data);
			centerAry = result.data; // (284) [{…},{…}, {…}, {…}, ....{…},]
			//시도정보 배열
			let sidoAry = [];
			//tr>td*2
			//#centerList
			//[].forEach(function(elem, idx, ary ))				
			centerAry.forEach((center, idx) => {
				//sidoAry에 중복하지 않고 담기.
				if (sidoAry.indexOf(center.sido) == -1) {
					sidoAry.push(center.sido); //추가

				}
				if (idx < 10) {
					//tr 생성하기.
					let tr = makeRow(center); // makeRow에서 tr을 리턴함
					document.querySelector('#centerList').appendChild(tr);
				} //end of if
			}) //end of for
			console.log(sidoAry);
			//sidoAry의 갯수만큼 <option value = "sido정보"> </option>
			sidoAry.forEach(sido => {
				let opt = document.createElement('option');
				opt.value = sido;
				opt.innerText = sido;
				document.getElementById('sido').appendChild(opt);
			})


		})
		.catch(err => console.log(err));

	//event
	document.querySelector('button.btn-primary').addEventListener('click', function(e) {

		//목록 지우고 
		document.querySelector('#centerList').innerHTML = "";//clear
		let keyword = document.getElementById('centerName').value; // 검색값.

		centerAry //배열
			//.filter(center =>  center.centerName.indexOf(keyword) != -1)
			.filter(center => center.centerName.includes(keyword)) //배열
			.forEach(center => {
				let tr = makeRow(center);
				document.querySelector('#centerList').appendChild(tr);
			})
	});

	//select태그의 change이벤트
	document.querySelector('#sido').addEventListener('change', function(e) {
		//목록지우기
		document.querySelector('#centerList').innerHTML = "";//clear	
		let keyword = document.getElementById('sido').value; // 선택한 시도 값
		centerAry
			.reduce((acc, center) => {
				if (center.sido == keyword) {
					let tr = makeRow(center);
					acc.appendChild(tr);
				}
				return acc;
			}, document.querySelector('#centerList'));
		//.filter(center =>  center.centerName.indexOf(keyword) != -1)
		//	.filter(center => center.sido == keyword)
		//	.forEach(center => {
		//		let tr = makeRow(center);
		//		document.querySelector('#centerList').appendChild(tr);
		//	})
	});

	//[].push(), [].unshift(), [].pop(), [].shift() => [].splice()
	//reduce();

	let result = [1, 3, 5, 7].reduce(function(acc, elem, idx, ary) {
		console.log(acc, elem);
		if (elem > 4) {
			let li = document.createElement('li');
			li.innerHTML = elem;
			acc.appendChild(li);
		}

		return acc //1\ <ul><li>5</li></ul>
	}, document.querySelector('#target'));
	console.log('결과: ', result);
});

