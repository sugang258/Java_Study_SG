const b_comment = document.querySelector("#b_comment");
const writer = document.querySelector("#writer");
const contents = document.querySelector("#contents");
const commentList = document.querySelector("#commentList");



getCommentList();

b_comment.addEventListener("click",function(){

    let wv = writer.value;
    let cv = contents.value;
    let bookNum = b_comment.getAttribute("data-booknum");


    const xhttp = new XMLHttpRequest();

    xhttp.open("POST","./setReply");

    xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");

    xhttp.send("bookNum=" + bookNum + "&writer="+wv+"&contents="+cv);

    xhttp.onreadystatechange = function(){
        if(this.readyState == 4 && this.status == 200) {
            let result = xhttp.responseText.trim();

            console.log(result);
            result = JSON.parse(result);
            writer.value= "";
            contents.value = "";

            if(result.result == 1) {
                alert("댓글 달기 성공");
                getCommentList();
            }else {

            } 
          
        }
    }
});

function getCommentList() {
    //1.XMLHTTPRequest 생성
    const xhttp = new XMLHttpRequest();

    //2. Method, URL
    xhttp.open("GET","./getReply?page=1&bookNum=1660703931506");

    //3. 요청 전송
    xhttp.send();
    
    //4. 응답 처리
    xhttp.addEventListener("readystatechange",function(){
        if(xhttp.readyState == 4 && xhttp.status == 200) {
            console.log(xhttp.responseText);
            //1. jsp 사용한 결과물
            //commentList.innerHTML = xhttp.responseText.trim();

            //2. JSON 결과물
            let ar = JSON.parse(xhttp.responseText.trim());

            let table = document.createElement("table");
            let c = document.createAttribute("class");
            c.value = "table table-striped";
            table.setAttributeNode(c);



            for(let i=0;i<ar.length;i++){
                let tr = document.createElement("tr");
                let td = document.createElement("td");

                let contents =document.createTextNode(ar[i].contents);
                let writer= document.createTextNode(ar[i].writer);
                let date = document.createTextNode(ar[i].regDate);
                
                td.appendChild(contents);
                tr.appendChild(td);
                table.appendChild(tr);

                td = document.createElement("td");
                td.appendChild(writer);
                tr.appendChild(td);
                table.appendChild(tr);

                td = document.createElement("td");
                td.appendChild(date);
                tr.appendChild(td);
                table.appendChild(tr);


            }
            commentList.appendChild(table);


        }
    })



}