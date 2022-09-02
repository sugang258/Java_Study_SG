const addFiles = document.getElementById("addFiles");
const fileAdd = document.getElementById("fileAdd");

let count = 0;
let idx = 0;
    
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


