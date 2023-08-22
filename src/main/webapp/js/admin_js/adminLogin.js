// document.querySelector("#login_button").addEventListener("click",function(){
//     const account = document.querySelector("#account").textContent;
//     const password = document.querySelector("#password").textContent;

//     if(account=='' || password=='' || account==null || password==null){
//         alert("請輸入帳號或密碼");
//     }else{
//         let data = {
//             "account":account,
//             "password":password
//         }
//         console.log(data);
//         fetch('/Ocean/adminLogin',{
//             method: 'POST',
//             body:JSON.stringify(data)
//         }).then()
//         ;
//     }
// });