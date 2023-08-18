const tabLinks = document.querySelectorAll('.tab-link');
const tabContents = document.querySelectorAll('.tab-content');

// lulu修改
window.addEventListener("load", function () {
    tabContents.forEach(content => {
        content.style.display = 'none';

    });
    document.querySelector("#tab1").style.display = 'block';
    document.querySelector("#m_upload").classList.add("active");
})

tabLinks.forEach(link => {
    link.addEventListener('click', (e) => {
        e.preventDefault();

        const selectedTab = link.getAttribute('data-tab');

        // 移除所有 li 元素的 active 
        tabLinks.forEach(link => {
            link.parentNode.classList.remove('bordered');
        });

        // 添加當前點擊的li區域的css
        link.parentNode.classList.add('bordered');

        // 隱藏所有內容區域
        tabContents.forEach(content => {
            content.style.display = 'none';

        });

        // 顯示選到的內容區域
        document.getElementById(selectedTab).style.display = 'block';

        //預設第一個按鈕click
        switch (selectedTab) {
            case 'tab1':
                document.querySelector("#m_upload").click();
                break;
            case 'tab2':
                break;
            case 'tab3':
                break;
            case 'tab4':
                break;
            case 'tab5':
                break;
            case 'tab8':
                admin_selectAll();
                break;
            default:
                document.querySelector("#m_upload").click();
                break;
        }
    });
});

// 按下管理員帳號標籤載入清單
function admin_selectAll() {
    document.querySelector(".add_admin_insert").style.display = "none";
    const table = document.querySelector("#admin_info");
    table.innerHTML = `
                <tr>
                    <th>管理員編號</th>
                    <th>管理員名稱</th>
                    <th>管理員帳號</th>
                    
                    <th></th>
                    <th></th>
                </tr>
                `;
    ad_mode='select';
    //let select = {"adMode":ad_mode};
    fetch('http://localhost:8081/ocean/adminController')
    .then(response => response.json())
        .then(data => {

            for (let i = 0; i < data.length; i++) {

                let row = document.createElement('tr');
                row.setAttribute('id', 'tr' + i);

                //編號
                let adminId = document.createElement('td');
                adminId.textContent = data[i]["adminId"];
                row.appendChild(adminId);

                //名稱
                let adminName = document.createElement('td');
                adminName.textContent = data[i]["adminName"];
                row.appendChild(adminName);

                //帳號
                let adminAccount = document.createElement('td');
                adminAccount.textContent = data[i]["adminAccount"];
                row.appendChild(adminAccount);

                //修改密碼欄位，預設隱藏
                // let password_update = document.createElement('td');
                // password_update.innerHTML = '<input type="text" id="up_tx_pwd'+i+'">';
                // password_update.classList.add("password_update");
                // row.appendChild(password_update);
                
                //修改按鈕
                let ad_upd_btn = document.createElement('td');
					ad_upd_btn.innerHTML = '<button id="admin_update_btn' +i+ '" style="width:auto;" onclick="admin_update_btn(' + `${i}` + ')">修改密碼</button>';
					row.appendChild(ad_upd_btn);
				
                // 刪除按鈕
                let ad_delete_btn = document.createElement('td');

                // 將btn加上自動編號鎖定欄位
                // 紀錄該欄位tr的ID
                ad_delete_btn.innerHTML = '<button id="admin_delete_btn' +i+ '" onclick="admin_delete_btn(' + `${i}` + ')">刪除</button>';
                row.appendChild(ad_delete_btn);

                table.appendChild(row);
                ad_mode='';
            }
        })
        .catch(error => {
            console.error('Error:', error);
        });
}