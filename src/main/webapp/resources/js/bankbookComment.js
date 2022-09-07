const b_comment = document.querySelector("#b_comment");
const writer = document.querySelector("#writer");
const contents = document.querySelector("#contents");
const commentList = document.querySelector("#commentList");
const more = document.querySelector("#more");


//page번호 담는 변수
let page=1;
//bookNum을 담을 변수
const bookNum = b_comment.getAttribute("data-booknum");

getCommentList(page,bookNum);

b_comment.addEventListener("click",function(){

    let wv = writer.value;
    let cv = contents.value;
   // let bookNum = b_comment.getAttribute("data-booknum");


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
                
                for(let i=0;i<commentList.children.length;) {
                    commentList.children[i].remove();
                }
                
                // if(commentList.children.length != 0) {
                //     commentList.children[0].remove();
                // }

                page = 1;

                getCommentList(page ,bookNum);
            }else {

            } 
          
        }
    }
});

function getCommentList(p, bn) {
    //1.XMLHTTPRequest 생성
    const xhttp = new XMLHttpRequest();

    //2. Method, URL
    xhttp.open("GET","./getReply?page="+p+"&bookNum="+bn);

    //3. 요청 전송
    xhttp.send();
    
    //4. 응답 처리
    xhttp.addEventListener("readystatechange",function(){
        if(xhttp.readyState == 4 && xhttp.status == 200) {
            console.log(xhttp.responseText);
            //1. jsp 사용한 결과물
            //commentList.innerHTML = xhttp.responseText.trim();

            //2. JSON 결과물
            let result = JSON.parse(xhttp.responseText.trim());

            let pager = result.pager;  //CommentPager
            let ar = result.list;    //댓글리스트


            for(let i=0;i<ar.length;i++){
                let tr = document.createElement("tr");
                let td = document.createElement("td");

                let num = document.createTextNode(ar[i].num);
                let contents =document.createTextNode(ar[i].contents);
                let writer= document.createTextNode(ar[i].writer);
                let date = document.createTextNode(ar[i].regDate);
                let update = document.createTextNode("수정");
                let del = document.createTextNode("삭제");

                td.appendChild(num);
                tr.appendChild(td);
                commentList.append(tr);

                td = document.createElement("td");
                td.appendChild(contents);
                tr.appendChild(td);
                commentList.append(tr);

                td = document.createElement("td");
                td.appendChild(writer);
                tr.appendChild(td);
                commentList.append(tr);

                td = document.createElement("td");
                td.appendChild(date);
                tr.appendChild(td);

                td = document.createElement("td");
                let tdAttr = document.createAttribute("class");
                tdAttr.value = "update";
                td.setAttributeNode(tdAttr);
                td.appendChild(update);
                tr.appendChild(td);

                td = document.createElement("td");
                tdAttr = document.createAttribute("class");
                tdAttr.value = "delete";
                td.setAttributeNode(tdAttr);
                td.appendChild(del);
                tr.appendChild(td);

                commentList.append(tr);

                if(page >= pager.totalPage) {
                    more.classList.add('disabled');
                }else {
                    more.classList.remove('disabled');
                }

            }
            // console.log(table);
            // console.log(commentList.children);

            // let t = commentList.children;

            // if(t.length != 0) {
            //     commentList.children[0].remove();
            // }
            // try {
                
                //     console.log(commentList.removeChild(commentList.firstChild));
                //     throw new Error("에러메세지");
                
                // }catch(exeception){
                    
                    // }finally {
                        
                        // }
                        
            
            

        }
    })



}

//-----------------------더보기-----------------------

more.addEventListener("click",function(){
    page++;
   // const bookNum = b_comment.getAttribute("data-booknum");
    console.log(page);
    console.log(bookNum);

    getCommentList(page,bookNum);

})

//----------------------Delete----------------------

commentList.addEventListener("click",function(event){


    if(event.target.className == "delete") {
        let check = window.confirm("삭제하시겠습니까?");

        console.log(event.target.previousSibling.previousSibling.previousSibling.previousSibling.previousSibling.innerHTML);
    }
    // let d = event.target;
    // if(d.className == 'del') {

    // }

})
