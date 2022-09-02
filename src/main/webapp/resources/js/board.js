//let kind = '${param.kind}';
//alert(kind);
function check() {
const all = document.getElementById("all");
//const cb = document.getElementsByClassName("cb");
const cb = document.querySelectorAll(".cb");
const accept = document.getElementById("accept");
const accept_submit = document.getElementById("accept_submit");
const req = document.getElementsByClassName("req");

cb.forEach(function(v,i,ar){
    console.log(v);
})
all.addEventListener("click",function(){
        
    for(let j=0;j<cb.length;j++) {
            cb[j].checked = all.checked;
    }     
});

for(let i=0;i<cb.length;i++) {
    //cb[i].addEventListener("click", function(){
    //    check(1);
    //});
    cb[i].addEventListener("click",check);
}

function check() {
    let result = true;
    for(let i=0;i<cb.length;i++) {
        if(!cb[i].checked) {
            result = false;
            break;
        }
    }
    all.checked = result
}

accept.addEventListener("click", function(){
    let result =true;

    for(let i=0;i<req.length;i++) {
        if(!req[i].checked) {
            result = false;
            break;
        }
    }
    if(result) {
        accept_submit.submit();
    }else {
        alert("필수 약관에 동의해야 합니다.");
    }
    
});
}
