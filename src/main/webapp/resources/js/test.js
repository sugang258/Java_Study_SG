alert("Welcome");

var num=1;
let num2=1;

console.log(num==num2);
console.log(num === num2);

for(var i=0;i<10;i++) {
    console.log(i);
}

console.log('-------------------');

let ar = [1, '2', 3.12, true];
console.log(ar[0]);
console.log(ar[1]);


ar.push(5);
console.log(ar);

ar.unshift('9');
ar.sort();

console.log(ar);

ar.forEach(function(v,i,ar){
    window.console.log("v : " , v);
    console.log("i : ",i);
    console.log( i +" == " + v);
});