let lastSearchText = '';
    $(document).ready(function () {
        $("#searchButton").click(function () {
            $("#searchInput").focus();
        });
    });

    const searchInput = document.getElementById("searchInput");
    const sv = document.getElementById('searchVideo');

    searchInput.addEventListener("keypress", function (e) {

        if (e.keyCode === 13) {
            const searchText = searchInput.value.trim();

            if (searchText === '') {
                sv.innerHTML = '';
                return;
            }

            // 清空之前搜尋的結果
            sv.innerHTML = '';

            // 更新上一次的搜尋內容
            lastSearchText = searchText;

            $.ajax({
                url: "/Ocean/web/controller/indexSearchVideoController",
                type: "POST",
                dataType: "json",
                data: JSON.stringify({
                    videoName: searchText
                }),
                success: function (data) {

                    let starRatings = []; // 用來存放每一筆資料的星星數量

                    for (let i in data) {

                        // 將字串轉換為數字
                        const videoReview = parseInt(data[i].VideoReview, 10); // 假設 data[i].VideoReview 是一個範圍為 "1" 到 "5" 的字串

                        // 將星星數量放入陣列
                        starRatings.push(videoReview);

                        // 生成星星 icon
                        let starsHtml = '';
                        for (let j = 1; j <= 5; j++) {
                            const starClass = j <= videoReview ? 'bi bi-star-fill checked' : 'bi bi-star';
                            starsHtml += `<i class="${starClass}" data-rating="${j}" style="color:#81D8D2"></i>`;
                        }

                        let card = document.createElement('div');
                        card.classList.add('card');
                        card.style.backgroundColor = 'rgba(0, 0, 0, 0.5)';
                        card.innerHTML = `
                            <div class="row g-0">
                                <div class="col-md-4">
                                    <img src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSneeWcVqMfMeHC0tLaVFfwcjAgPpRq6jaXYg&usqp=CAU" alt="..." style="width: 150px; height: 100px;">
                                </div>
                                <div class="col-md-8">
                                    <div class="card-body text-left ms-2">
                                        <h4 class="card-text" style="color: white;">${data[i].videoName}</h4>
                                        <div class="stars" style="color: white;">${starsHtml}</div>
                                    </div>
                                </div>
                            </div>
                        `;
                        sv.appendChild(card);
                    }
                }
            })
        }
    });

    // 在搜尋欄失去焦點時檢查是否需要清空搜尋結果
    searchInput.addEventListener("blur", function () {
        const searchText = searchInput.value.trim();
        if (searchText === '') {
            sv.innerHTML = '';
        }
    });

    // 在搜尋欄重新獲得焦點時檢查是否需要重新顯示上一次的搜尋結果
    searchInput.addEventListener("focus", function () {
        const searchText = searchInput.value.trim();
        if (searchText === '' && lastSearchText !== '') {
            searchInput.value = lastSearchText;
            // 觸發 Enter 鍵事件，重新顯示上一次的搜尋結果
            const enterEvent = new KeyboardEvent("keypress", { keyCode: 13 });
            searchInput.dispatchEvent(enterEvent);
        }
    });

    //=================================我的片單======================================//

    $.ajax({
        url: "/Ocean/web/controller/indexVideoListController",
        type: "POST",
        dataType: "json",
        data: JSON.stringify({
            type: "lastOnline"
        }),
        success: function (data) {

            let vidItems = document.getElementById('videoItems');

            for (let i in data) {
                vidItems.innerHTML += `
                    <div class="item mb-2">
                        <img src="/img/1616574201-3511996999-g_n.jpg" alt="" style="width: 100%;">
                        <div class="star-icon">
                            <i class="bi bi-star-fill" id="star"></i>
                        </div>
                    </div>
                `;
            }
        }
    });

    //=================================移除影片======================================//
    const videoitems = document.querySelector('.videoitems');

    videoitems.addEventListener('click', function (event) {
        const target = event.target;
        if (target.classList.contains('bi-star-fill')) {
            const itemId = target.getAttribute('data-item-id');
            const itemToRemove = document.querySelector(`[data-item-id="${itemId}"]`).closest('.item');
            if (itemToRemove) {
                itemToRemove.remove();
            }
        }
    });
