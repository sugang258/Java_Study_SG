function joinCheck() {

const userName = document.getElementById("userName");
const password1 = document.getElementById("password1");
const password2 = document.getElementById("password2");
const name = document.getElementById("name");
const email = document.getElementById("email");
const phone = document.getElementById("phone");
const join = document.getElementById("join");
const join_submit = document.getElementById("join_submit");
const div1 = document.getElementById("div1");
const div2 = document.getElementById("div2");
const div3 = document.getElementById("div3");
const div4 = document.getElementById("div4");
const div5 = document.getElementById("div5");
const div6 = document.getElementById("div6");
const join_ele = document.getElementsByClassName("join_ele");
const phone_regex = /\d{3}-\d{4}-\d{4}/;

 //Check 결과
 let idCheck=false;
 let pwCheck=false;
 let pwEqualCheck=false;
 let nameCheck=false;
 let emailCheck=false;
 let phoneCheck=false;

userName.addEventListener("blur",function(){
    idCheck = false;
    if(userName.value.length > 1) {
        div1.innerHTML="";
        idCheck = true;
    }else{
        div1.value = "2글자 이상 작성해주세요";
        div1.innerHTML = div1.value;
    }
    
});


password1.addEventListener("change",function(){
    if(password1.value.length > 5) {
        pwCheck = true;
        div2.innerHTML="";
        password2.value="";
    }else{
        pwCheck=false;
        div2.value = "6글자 이상 작성해주세요";
        div2.innerHTML = div2.value;
    }
    
});

password2.addEventListener("blur",function(){
    if(password1.value == password2.value) {
        pwEqualCheck=true;
        div3.innerHTML="";
    }else {
        pwEqualCheck=false;
        password2.value="";
        div3.value= "다르다";
    }
});

name.addEventListener("blur",function(){
    if(name.value.length > 0) {
        nameCheck=true;
        div4.innerHTML="";
    }else{
        nameCheck=false;
        div4.value = "1글자 이상 작성해주세요";
        div4.innerHTML = div4.value;
    }
});
email.addEventListener("blur",function(){
    if(email.value.length > 0) {
        emailCheck=true;
        div5.innerHTML="";
    }else{
        emailCheck=false;
        div5.value = "1글자 이상 작성해주세요";
        div5.innerHTML = div5.value;
    }
});
phone.addEventListener("blur",function(){
    if(phone.value.length > 0 ) {
        phoneCheck=true;
        div6.innerHTML="";
    }else{
        phoneCheck=false;
        div6.value = "1글자 이상 작성해주세요";
        div6.innerHTML = div6.value;
    }
    if(phone_regex.test(phone.value) == false) {
        div6.value = "형식 엑스";
        
    }else{
        div6.value="형식 정확";
       
    }
    div6.innerHTML = div6.value;
});

join.addEventListener("click",function(){
    //console.log(join_ele[i]);
    
   if(idCheck && pwCheck && pwEqualCheck && nameCheck && emailCheck && phoneCheck) {
        alert("서버 전송 합니다");
        console.log(idCheck);
        console.log(pwCheck);
        console.log(pwEqualCheck);
        console.log(nameCheck);
        console.log(emailCheck);
        console.log(phoneCheck);

        join_submit.submit();
   }else {
        alert("필수 입력 사항은 다 입력 해야함");
   }
    
})
    
}

