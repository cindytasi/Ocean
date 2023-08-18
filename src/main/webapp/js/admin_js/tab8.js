document.querySelector("#add_admin").addEventListener("click", function () {
    document.querySelector(".add_admin_insert").style.display = "block";
});

var ad_mode = "";

// 確定新增按鈕
function submit_add_admin() {
    let admin_name = document.querySelector("#admin_name").value.trim();
    let admin_account = document.querySelector("#admin_account").value.trim();
    let admin_password = document.querySelector("#admin_password").value.trim();
    ad_mode = "insert";
    let InsertData = {
        "adminName": admin_name,
        "adminAccount": admin_account,
        "adminPassword": admin_password,
        "adMode": ad_mode
    };
    if (admin_name == '' || admin_account == '' || admin_password == '') {
        alert("請輸入完整內容");
    } else {

        fetch("http://localhost:8081/ocean/adminController", {
            // mode: 'no-cors',
            method: 'POST',
            headers: { 'Content-Type': 'application/json' },
            body: JSON.stringify(InsertData)
        })
            .then(response => response.text())
            .then(data => {
                admin_selectAll();
                alert(data);
            })
            .catch(error => {
                console.log('Error:', error);
            })
            .finally(
                admin_selectAll()
            );
    }
}

// 修改密碼
function admin_update_btn(tr_id) {
    var newPassword = prompt('請輸入新密碼');
    var firstTd = document.querySelector('#tr' + tr_id).firstChild;
    var adminId = firstTd.textContent;
    ad_mode = 'update';
    var up_data = {
        "adminId": adminId,
        "adminPassword": newPassword,
        "adMode": ad_mode
    }
    fetch('http://localhost:8081/ocean/adminController', {
        //mode: 'no-cors',
        method: 'POST',
        headers: {
            'Content-Type': 'application/json',
        },
        body: JSON.stringify(up_data)
    })
        .then(response => response.text())
        .then(data => {
            admin_selectAll();
            alert(data);
        }).catch(error => {
            console.error('Error:', error);
        })
        .finally(
            admin_selectAll()
        );
}

// 刪除按鈕
function admin_delete_btn(tr_id) {
    var yes = confirm('你確定嗎？');
    if (!yes) {
        admin_selectAll();
    } else {
        var firstTd = document.querySelector('#tr' + tr_id).firstChild;
        var adminId = firstTd.textContent;
        ad_mode = "delete";
        var data = {
            "adminId": adminId,
            "adMode": ad_mode
        };
        fetch('http://localhost:8081/ocean/adminController', {
            //mode: 'no-cors',
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify(data)
        }).then(response => response.text())
            .then(data => {
                admin_selectAll();
                alert(data);
            }).catch(error => {
                console.error('Error:', error);
            })
            .finally(
                admin_selectAll()
            );
    }

}

// 取消新增，隱藏並清空欄位
document.querySelector("#cancel_add_admin").addEventListener("click", function () {
    document.querySelector("#admin_name").value = '';
    document.querySelector("#admin_account").value = '';
    document.querySelector("#admin_password").value = '';
    document.querySelector(".add_admin_insert").style.display = "none";
});