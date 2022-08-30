const login = document.getElementById("login");
const login_submit = document.getElementById("login_submit");
const userName = document.getElementById("userName");
const password = document.getElementById("password");

login.addEventListener("click",function(){

    /*
    if(userName.value == null) {
        console.log("null");
    }

    console.log(userName.value);
    */
    
    if(userName.value != "" && password.value != "") {
        login_submit.submit();
    }else {
        alert("로그인 안돼");
    }
    
    
});