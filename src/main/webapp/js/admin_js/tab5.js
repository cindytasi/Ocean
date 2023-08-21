//未訂閱人數
function userNosubscribeCount() {
    let userNosubscribeCount = document.querySelector("#userNosubscribeCount");
    fetch('/Ocean/userNosubscribeCount')
        .then(response => response.json())
        .then(res => {

            userNosubscribeCount.innerHTML =  res;

        });
}

//已訂閱人數
function userAllSubscribe() {
    let userAllSubscribe = document.querySelector("#userAllSubscribe");
    fetch('/Ocean/selectAllSubscribe')
        .then(response => response.json())
        .then(res => {

            userAllSubscribe.innerHTML = res;

        });
}

//本月到期會員人數&本月加入訂閱數量
function SubscribersAndExpiresThisMonth() {
    let expiresCount = document.querySelector("#expiresCount");
    let subscriberCount = document.querySelector("#subscriberCount");
    fetch('/Ocean/UserSubsIdController')
        .then(response => response.json())
        .then(res => {
            expiresCount.innerHTML = res[0]
            subscriberCount.innerHTML = res[1];
        });
}

//查會員
function userSerch() {
    let user_serch = document.querySelector("#user_serch").value.trim();
    let user_info_table = document.querySelector("#user_info_table");
    document.querySelector("#member_info_table").innerHTML = '';
    let JsonData = {};
    if (isNaN(user_serch)) {
        JsonData = { "userName": user_serch };
    } else {
        JsonData = { "userId": user_serch };
    }

    user_info_table.innerHTML = `
        <tr>
        <th>會員編號</th>
        <th>會員名稱</th>
        <th>地址</th>
        <th>電話</th>
        <th>email</th>
        <th>會員資格</th>

        <th>成就(數量)</th>
        <th>訂單(數量)</th>
        <th>到期日期</th>
        </tr>
    `;

    fetch('/Ocean/userSearchController', {
        method: 'POST',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify(JsonData)
    })
        .then(response => response.json())
        .then(data => {
            for (let i = 0; i < 1; i++) {
                let row = document.createElement('tr');
                row.setAttribute('id', 'user_tr' + i);

                //ID
                let userId = document.createElement('td');
                userId.textContent = data[0]["userId"];
                userId.setAttribute('onclick', `selectMemberByUserId('${data[0]['userId']}')`);
                userId.setAttribute('style', 'color:blue');
                row.appendChild(userId);
                //姓名
                let userName = document.createElement('td');
                userName.textContent = data[0]["userName"];
                row.appendChild(userName);
                // //帳號
                // let account = document.createElement('td');
                // account.textContent = data[0]["account"];
                // account.setAttribute('onclick', `selectMemberByAccount('${data[0]['account']}')`);
                // account.setAttribute('style', 'color:blue');
                // row.appendChild(account);
                //地址
                let address = document.createElement('td');
                address.textContent = data[0]["address"];
                row.appendChild(address);
                //電話
                let telephone = document.createElement('td');
                telephone.textContent = data[0]["telephone"];
                row.appendChild(telephone);
                //EMAIL
                let email = document.createElement('td');
                email.textContent = data[0]["email"];
                row.appendChild(email);
                //會員資格
                let statusCode = document.createElement('td');
                statusCode.textContent = data[0]["statusCode"];
                row.appendChild(statusCode);
                //成就數量
                let achCount = document.createElement('td');
                achCount.textContent = data[1];
                row.appendChild(achCount);
                //訂單數量
                let OrderQuantity = document.createElement('td');
                OrderQuantity.textContent = data[2];
                // OrderQuantity.setAttribute("onclick",`selectOrderById(${data[0]["userId"]})`);
                row.appendChild(OrderQuantity);
                //到期日期
                let expirationDate = document.createElement('td');
                expirationDate.textContent = data[3];
                row.appendChild(expirationDate);

                user_info_table.appendChild(row);
            }
        })
        ;
}

//user帳號查成員
function selectMemberByUserId(userId) {
    document.querySelector("#userOrdersInfo").style.display = "none";
    let member_info_table = document.querySelector("#member_info_table");
    member_info_table.innerHTML = `
        <tr>
            <th>成員編號</th>
            <th>成員名稱</th>
            <th>會員編號</th>
            <th>兒童使用者</th>
        </tr>
    `;
    fetch('/Ocean/MemberController', {
        method: 'POST',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify({ "userId": userId })
    })
        .then(response => response.json())
        .then(data => {
            if (data.length >= 1) {
                for (let i = 0; i < data.length; i++) {
                    let row = document.createElement('tr');
                    row.setAttribute('id', 'mb_tr' + i);

                    //成員編號
                    let memberId = document.createElement('td');
                    memberId.textContent = data[i]["memberId"];
                    row.appendChild(memberId);

                    //成員名稱
                    let memberName = document.createElement('td');
                    memberName.textContent = data[i]["memberName"];
                    row.appendChild(memberName);

                    //會員編號
                    let userId = document.createElement('td');
                    userId.textContent = data[i]["userId"];
                    row.appendChild(userId);

                    //兒童使用者
                    let childMember = document.createElement('td');
                    childMember.textContent = data[i]["childMember"];
                    row.appendChild(childMember);

                    member_info_table.appendChild(row);
                }
            } else {
                let row = document.createElement('tr');
                row.setAttribute('id', 'mb_tr' + i);

                //成員編號
                let memberId = document.createElement('td');
                memberId.textContent = data["memberId"];
                row.appendChild(memberId);

                //成員名稱
                let memberName = document.createElement('td');
                memberName.textContent = data["memberName"];
                row.appendChild(memberName);

                //會員帳號
                let userId = document.createElement('td');
                userId.textContent = data["userId"];
                row.appendChild(userId);

                //兒童使用者
                let childMember = document.createElement('td');
                childMember.textContent = data["childMember"];
                row.appendChild(childMember);

                member_info_table.appendChild(row);
            }

        })
        ;
}

// 成員總數
// function selectAllMembers() {
//     let memberQuantity = document.querySelector("#memberQuantity");
//     fetch('/ocean/MemberController')
//         .then(response => response.json())
//         .then(res => {
//             memberQuantity.innerHTML = `
//         成員人數 : ${res}
//         `;
//         })
// }

//ID查會員訂單明細
function selectOrderById(id){
    document.querySelector("#member_info_table").style.display = "none";
    let userOrdersInfo = document.querySelector("#userOrdersInfo");
    userOrdersInfo.innerHTML = `
        <tr>
            <th>訂單編號</th>
            <th>會員編號</th>
            <th>訂單總金額</th>
            <th>下單日期</th>
            <th>金流狀態</th>
            <th>廠商編號</th>
            <th>訂單狀態</th>
            <th>交易狀態</th>
        </tr>
    `;

}