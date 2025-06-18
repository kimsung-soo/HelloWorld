/**
 * covid_module.js
 * 
 */

const defaultNum = 10;
let url = `https://api.odcloud.kr/api/15077586/v1/centers?page=1&perPage=284&serviceKey=lHt2WFAx%2B%2FnA22S2j8BE2qcQuitfeXRH57lIXthQ5dm5VVzBClWB4ecpxeU7Lm9%2FlXZH59MuDE0MYm8QWQ5G%2Bw%3D%3D`;

function makeRow(center) {
	let tr = document.createElement('tr');
	for (const prop of ['id', 'centerName', 'phoneNumber']) {
		let td = document.createElement('td'); //<td></td>
		td.innerHTML = center[prop]; //<td>1</td>
		tr.appendChild(td);
	}
	return tr;
}

export {makeRow,url}