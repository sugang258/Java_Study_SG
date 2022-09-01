const addFiles = document.getElementById("addFiles");
const fileAdd = document.getElementById("fileAdd");
let count = 0;
fileAdd.addEventListener("click",function() {
    
    count = count + 1;
    
    if(count >5) {

        alert("5회이상 안됨");
        
    }else {

    let d = document.createElement("div");
    let c = document.createAttribute("class");
    c.value = "mb-3";
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

    l.appendChild(i);

    addFiles.appendChild(d);

    
    }
    
    
    
});

