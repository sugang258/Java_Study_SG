function loginCheck() {
    const login = document.getElementById("login");
const login_submit = document.getElementById("login_submit");
const userName = document.getElementById("userName");
const password = document.getElementById("password");

login.addEventListener("click",function(){

    let u = userName.value;
    let p = password.value;

    if(u=="") {
        alert("ID는 필수 입니다");
        return;
    }

    if(p =="") {
        alert("PW는 필수 입니다.");
        return;
    }
    
    login_submit();
   
});
}