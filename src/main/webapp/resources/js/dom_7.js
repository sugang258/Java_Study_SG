const remove1 = document.getElementById("remove1");
const remove2 = document.getElementById("remove2");

const d1 = document.getElementById("d1");
const d2 = document.getElementById("d2");
const d2_1 = document.getElementById("d2_1");

const d2_ele = document.getElementsByClassName("d2_ele");



remove1.addEventListener("click",function(){
    //삭제
    d1.remove();
})

remove2.addEventListener("click",function(){
    
    const ar =[];
    for(let i=0;i<d2_ele.length;i++) {
        ar.push(d2_ele[i].id);
    }

    for(i of ar) {
        let d = document.getElementById(i);
        d2.removeChild(d);
    }

});