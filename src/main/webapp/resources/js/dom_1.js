console.log('dom_1');

let result = window.confirm("확인??????");
console.log("result : " ,result);

result = window.prompt("이름을 입력하세요");
console.log("result : " ,result);

let d1 = window.document.getElementById("d1");
window.alert(d1);
window.console.log(d1);
d1.innerHTML='<h1>' + result + '</h1>';

let d3 = window.document.getElementById("d3");
let d4 = document.getElementById("d4");

d4.innerHTML = d3.innerHTML;
