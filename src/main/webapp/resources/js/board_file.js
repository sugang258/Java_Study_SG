const addFiles = document.getElementById("addFiles");
const fileAdd = document.getElementById("fileAdd");
const fileDelete = document.querySelectorAll(".fileDelete"); //forEach
const del = document.querySelector("#del");

//update시 file delete
try {
fileDelete.forEach(function(f){
    f.addEventListener("click",function() {

        let check = window.confirm("삭제를 하면 되돌릴 수 없다!!!!");

        if(!check) {
            return;
        }

        let fileNum = f.getAttribute("data-file-num");

        //ajax
        const xhttp = new XMLHttpRequest();

        xhttp.open("POST","./fileDelete");

        xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");

        xhttp.send("fileNum=" + fileNum);

        xhttp.onreadystatechange = function (){
            if(xhttp.readyState == 4 && xhttp.status == 200) {
                let result = xhttp.responseText.trim();
                if(result == 1) {
                    console.log(result);
                    f.parentNode.remove();
                    count--;
                }else {
                    console.log(result);
                }
            }

        }

    })
});
}catch (e) {
    console.log(e);
}

// for(fi of fileDelete) {
//     console.log(fi);
// }

//------------------add시 file add-------------------------------------
let count = 0;
let idx = 0;
    
function setCount(c) {
    if(c>=0) {
        count=c;
    }
}

try {
fileAdd.addEventListener("click",function() {
    
    if(count >4) {

        alert("5회이상 안됨");
        
    }else {
   

    let d = document.createElement("div");
    let c = document.createAttribute("class");
    c.value = "mb-3";
    d.setAttributeNode(c);
    c = document.createAttribute("id");
    c.value = "file"+idx;
    d.setAttributeNode(c);
    
    //let d2 = document.createElement("div");
    let l = document.createElement("label");
    let f = document.createAttribute("for");
    f.value = "files";
    let c1 = document.createAttribute("class");
    c1.value = "form-label";
    let t = document.createTextNode("File");

    l.setAttributeNode(f);
    l.setAttributeNode(c1);
    l.appendChild(t);

    d.appendChild(l);
    
    let i = document.createElement("input");
    let f1 = document.createAttribute("type");
    f1.value = "file";
    let c2 = document.createAttribute("class");
    c2.value="form-control";
    let n = document.createAttribute("name");
    n.value="files";
    let id = document.createAttribute("id");
    id.value="files";

    i.setAttributeNode(f1);
    i.setAttributeNode(c2);
    i.setAttributeNode(n);
    i.setAttributeNode(id);

    d.appendChild(i);
    let i1 = document.createElement("input");
    let b = document.createAttribute("type");
    b.value = "button";
    let c3 = document.createAttribute("class");
    c3.value = "del btn btn-danger";
    let t1 = document.createTextNode("삭제");
    i1.setAttributeNode(b);
    i1.setAttributeNode(c3);
    i1.appendChild(t1);

    buttonAttr = document.createAttribute("title");
    buttonAttr.value = idx;
    i1.setAttributeNode(buttonAttr);


    d.appendChild(i1);


    addFiles.appendChild(d);

    count++;
    idx++;
    }
    
});

addFiles.addEventListener("click",function(event){

    let button = event.target;

    if(button.classList[0] == 'del') {
        document.getElementById("file" + button.title).remove();
        count--;
        }

    /*
    for(let j=0; j<5;j++) {
        if(event.target.title = j ) {
               addFiles.removeChild(event.target.id =="file"+j);
        }
    }

    */
     
});

}catch (e) {

};


