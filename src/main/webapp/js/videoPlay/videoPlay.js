

// 獲取當前頁面的 URL
const url = new URL(window.location.href);

// 獲取URL 中的查詢參數
const searchParams = new URLSearchParams(url.search);

// 通過參數名獲取參數值
const id = searchParams.get('videoId');

//取得影片來源
fetch(`/Ocean/VideoOutput?videoId=${id}`);


let videoName = '';
let reviewScore = 0;
let domainId = '';
let videoInfo = '';
//取得影片所有資訊
fetch(`/Ocean/videoInfo?videoId=${id}`)
    .then(response => response.json())
    .then(Info => {
        videoInfo = Info;
        videoName = videoInfo.videoName;
        review = videoInfo.VideoReview;
        domainId = videoInfo.domainId;
        reviewScore = parseInt(review);
        document.querySelector("#title").innerHTML = videoName;
        document.querySelector("#videoName").innerHTML += videoName;
        document.querySelector("#videoType").innerHTML += videoInfo.videoType;
        document.querySelector("#videoYear").innerHTML += videoInfo.videoYear;
        document.querySelector("#videoArea").innerHTML += videoInfo.videoArea;
        document.querySelector("#director").innerHTML += videoInfo.videoDirector;
        document.querySelector("#actor").innerHTML += videoInfo.videoActor;
        document.querySelector("#videoLength").innerHTML += videoLengthFormate(videoInfo.videoLength);
        document.querySelector("#videoSeason").innerHTML += videoInfo.videoSeason;
        document.querySelector("#videoEpisode").innerHTML += videoInfo.videoEpisode;
        document.querySelector("#domainName").innerHTML += domainIdToDomainName(videoInfo.domainId);
        document.querySelector("#introduction").innerHTML += videoInfo.Introduction;
        document.querySelector("#review").innerHTML += parseInt(review);
        document.querySelector("#viewCount").innerHTML += videoInfo.views;
    })
    ;

const memberId = document.querySelector("#memberId").innerHTML;
const userId = document.querySelector("#userId").innerHTML;



rateMovie(reviewScore);//顯示評分

// 獲取頁籤按鈕和頁籤內容的元素
const tabButtons = document.querySelectorAll('.tab-button');
const tabContents = document.querySelectorAll('.tab-content');

// // 顯示初始的頁籤內容
tabContents[0].classList.add('active');

//顯示各個頁籤
function showTab(tabName) {
    const tabContents = document.querySelectorAll('.tab-content');
    tabContents.forEach(content => {
        if (content.id === tabName) {
            content.style.display = 'block';
        } else {
            content.style.display = 'none';
        }
    });
}

// const addToCartButtons = document.querySelectorAll('.tab-content button');
let cartList = document.getElementById('cartList');
let cart = []; // 購物車陣列，用於存儲選定的商品和數量

//加入購物車
function addToCart(productId) {
    const cartQuantity = parseInt(document.getElementById('quantity_' + productId).value);
    const productName = document.querySelector('#productName_' + productId).textContent;
    const productType = document.querySelector("#productType_" + productId).textContent;
    const priductInfo = document.querySelector("#priductInfo_" + productId).textContent;
    const price = parseInt(document.getElementById('price_' + productId).textContent);
    // const productId = parseInt(document.getElementById('productId_'+productId).textContent);
    const comId = parseInt(document.getElementById('comId_' + productId).textContent);
    // console.log(comId,productId);
    if (!productName == '') {
        if (cartQuantity >= 1) {
            // 檢查是否已經將相同商品加入購物車
            const existingCartItem = cart.find(item => item.productName === productName);
            document.querySelector("#checkoutButton").style.display = "block";
            if (existingCartItem) {
                // 若商品已存在購物車中，增加數量
                existingCartItem.quantity += 1;
            } else {
                // 若商品尚未加入購物車，創建新的購物車項目
                const newCartItem = {
                    productName: productName,
                    quantity: cartQuantity,
                    productType: productType,
                    priductInfo: priductInfo,
                    price: price,
                    productId: productId,
                    comId: comId,
                    orderTotal: price
                };
                cart.push(newCartItem);
            }

            // 清空數量輸入框，以準備加入下一個商品
            document.getElementById('quantity_' + productId).value = '1';

            // 更新購物車內容顯示
            updateCartDisplay();
        } else {
            document.querySelector("#checkoutButton").style.display = "none";
        }
    }

}
//更新購物車
function updateCartDisplay() {
    // 清空購物車內容
    cartList.innerHTML = '';

    // 將購物車內容顯示在 cartList 元素中
    cart.forEach((item, index) => {
        const cartItemElement = document.createElement('div');
        const tmpPrice = item.price * item.quantity;
        // console.log(item.price, item.quantity);
        cartItemElement.innerHTML = `
                                        <div id = "cartInfo${item.productId}">
                                            <span id='c_productName${item.productId}'>${item.productName}</span>,
                                            <span id='c_colorType${item.productId}'>${item.productType}</span>,
                                            <span id='c_sizeType${item.productId}'>${item.priductInfo}</span><br>
                                            數量 : <span id='c_quantity${item.productId}'>${item.quantity}</span><br>
                                            NT$<span id='c_orderTotal${item.productId}'>${tmpPrice}</span>
                                        </div>
                                     `;
        // 創建刪除按鈕
        const deleteButton = document.createElement('button');
        deleteButton.textContent = '刪除';
        deleteButton.addEventListener('click', () => {
            deleteCartItem(index);
        });
        cartItemElement.appendChild(deleteButton);
        cartList.appendChild(cartItemElement);
        cart[index].orderTotal = tmpPrice
        // console.log(cart[index]);
    });
    if (cart.length == 0) {
        document.querySelector("#checkoutButton").style.display = "none";
        document.querySelector(".right-sidebar").style.width = "15px";
    } else {
        document.querySelector(".right-sidebar").style.width = "150px";
    }
    // 輸出目前的購物車內容
    // console.log('目前的購物車內容：', cart);
}
//更改數量
function adjustQuantity(change) {
    const quantityInput = document.getElementById('quantity');
    let quantity = parseInt(quantityInput.value) + change;

    if (quantity >= 1) {
        quantityInput.value = quantity;
    }
}

//美食加入購物車
// function foodAddToCart() {
//     const cartQuantity = parseInt(document.getElementById('foodQuantity').value);
//     const productName = document.querySelector('#foodName').textContent;
//     const productType = document.querySelector("#foodType").textContent;
//     const priductInfo = document.querySelector("#foodInfo").textContent;
//     const foodprice = parseInt(document.getElementById('foodPrice').textContent);
//     const foodProductId = parseInt(document.getElementById('foodProductId').textContent);
//     const foodcomid = parseInt(document.getElementById('foodComId').textContent);

//     if (!productName == '') {
//         if (cartQuantity >= 1) {
//             // 檢查是否已經將相同商品加入購物車
//             const existingCartItem = cart.find(item => item.productName === productName);
//             document.querySelector("#checkoutButton").style.display = "block";
//             if (existingCartItem) {
//                 // 若商品已存在購物車中，增加數量
//                 existingCartItem.quantity += 1;
//             } else {
//                 // 若商品尚未加入購物車，創建新的購物車項目
//                 const newCartItem = {
//                     productName: productName,
//                     quantity: cartQuantity,
//                     productType: productType,
//                     priductInfo: priductInfo,
//                     price: foodprice,
//                     productId: foodProductId,
//                     comId: foodcomid,
//                     orderTotal: foodprice
//                 };
//                 cart.push(newCartItem);
//             }

//             // 清空數量輸入框，以準備加入下一個商品
//             document.getElementById('foodQuantity').value = '1';

//             // 更新購物車內容顯示
//             foodUpdateCartDisplay();
//         } else {
//             document.querySelector("#checkoutButton").style.display = "none";
//         }
//     }
// }

// //美食更新購物車
// function foodUpdateCartDisplay() {
//     // 清空購物車內容
//     cartList.innerHTML = '';

//     // 將購物車內容顯示在 cartList 元素中
//     cart.forEach((item, index) => {
//         const cartItemElement = document.createElement('div');
//         const tmpPrice = item.price * item.quantity;
//         // console.log(item.price, item.quantity);
//         cartItemElement.innerHTML = `
//                                         <div id = "cartInfo${item.productId}">
//                                             <span id='c_productName${item.productId}'>${item.productName}</span>,
//                                             <span id='c_colorType${item.productId}'>${item.productType}</span>,
//                                             <span id='c_sizeType${item.productId}'>${item.priductInfo}</span><br>
//                                             數量 : <span id='c_quantity${item.productId}'>${item.quantity}</span><br>
//                                             NT$<span id='c_orderTotal${item.productId}'>${tmpPrice}</span>
//                                         </div>
//                                      `;
//         // 創建刪除按鈕
//         const deleteButton = document.createElement('button');
//         deleteButton.textContent = '刪除';
//         deleteButton.addEventListener('click', () => {
//             deleteCartItem(index);
//         });
//         cart[index].orderTotal = tmpPrice
//         cartItemElement.appendChild(deleteButton);
//         cartList.appendChild(cartItemElement);
//         console.log(cart[index]);
//     });
//     if (cart.length == 0) {
//         document.querySelector("#checkoutButton").style.display = "none";
//         document.querySelector(".right-sidebar").style.width = "15px";
//     } else {
//         document.querySelector(".right-sidebar").style.width = "150px";
//     }
//     // 輸出目前的購物車內容
//     // console.log('目前的購物車內容：', cart);
// }

// //美食更改數量
// function foodAdjustQuantity(change) {
//     const quantityInput = document.getElementById('foodQuantity');
//     let quantity = parseInt(quantityInput.value) + change;

//     if (quantity >= 1) {
//         quantityInput.value = quantity;
//     }
// }

//按下購物車中的刪除後更新購物車
function deleteCartItem(index) {
    cart.splice(index, 1);
    updateCartDisplay();
}

//按標籤後顯示該標籤的內容，隱藏其他內容
tabButtons.forEach((button) => {
    button.addEventListener('click', () => {
        // 移除所有頁籤的 active 類別
        tabContents.forEach((content) => {
            content.classList.remove('active');
        });

        // 獲取被點擊的頁籤的目標內容區塊的 ID
        const targetId = button.getAttribute('onclick').match(/'(.*?)'/)[1];
        const targetContent = document.getElementById(targetId);

        // 將目標內容區塊加入 active 類別，以顯示該頁籤的內容
        targetContent.classList.add('active');

        // 移除所有頁籤按鈕的 active 類別
        tabButtons.forEach((btn) => {
            btn.classList.remove('active');
        });

        // 將被點擊的頁籤按鈕加入 active 類別，以顯示它為當前選中頁籤
        button.classList.add('active');
    });
});


let isFavorite = false; // 初始時未收藏

//切換景點愛心狀態
function favouriteMap(_attractionId) {
    // _attractionId.preventDefault();
    isFavorite = !isFavorite; // 切換收藏狀態
    let heartIcon = document.querySelector("#attractionId" + _attractionId)
    // 切換景點愛心圖案的顏色
    if (isFavorite) {
        heartIcon.classList.add("active");
    } else {
        heartIcon.classList.remove("active");
    }
    updateAttractionFavoriteStatus(isFavorite, _attractionId);
}
//加入或刪除收藏地圖
function updateAttractionFavoriteStatus(bool, _attractionId) {
    let data = {
        "memberId": memberId,
        "attractionId": _attractionId
    }
    if (bool) {
        fetch('/Ocean/AddFavoriteMap', {
            method: "POST",
            body: JSON.stringify(data)
        }).then(response => response.text())
            .then(res => console.log(res))
            ;
    } else {
        fetch('/Ocean/DeleteFavouriteMap', {
            method: "POST",
            body: JSON.stringify(data)
        }).then(response => response.text())
            .then(res => console.log(res))
            ;
    }
}

////////////////////////////////////////////////////////////////////////

const heartvideo = document.querySelector('.heart-video');
let isFavoriteVideo = false;
// 監聽影片愛心圖案的點擊事件
heartvideo.addEventListener('click', function (e) {
    e.preventDefault();
    isFavoriteVideo = !isFavoriteVideo; // 切換收藏狀態
    // 切換影片愛心圖案的顏色
    if (isFavoriteVideo) {
        heartvideo.classList.add("active");
    } else {
        heartvideo.classList.remove("active");
    }
    updateVideoFavoriteStatus(isFavoriteVideo);
});
function updateVideoFavoriteStatus(bool) {
    let data = {
        "memberId": memberId,
        "videoId": id
    }
    if (bool) {
        fetch('/Ocean/AddFavorite', {
            method: "POST",
            body: JSON.stringify(data)
        }).then(response => response.text())
            .then(res => console.log(res))
            ;
    } else {
        fetch('/Ocean/DeleteFavourite', {
            method: "POST",
            body: JSON.stringify(data)
        }).then(response => response.text())
            .then(res => console.log(res))
            ;
    }
}

///////////////////////////////////////////////////////////////////////
//影片評分更新
function rateMovie(stars) {
    let newscore = 0;

    const allStars = document.querySelectorAll(".stars");
    allStars.forEach((star, index) => {
        if (index < stars) {
            star.style.color = "gold";
            newscore = index;
            // console.log(newscore + 1);
        } else {
            star.style.color = "gray";
        }
    });
    if (newscore != 0) {
        let data = {
            "videoId": id,
            "userId": userId,
            "score": newscore + 1
        }
        // console.log(data);
        fetch('/Ocean/UpdateReviews', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(data)
        }).then(response => response.text())
            .then(res => {
                document.querySelector("#review").innerHTML = '';
                document.querySelector("#review").innerHTML = res;
            })
    }
}

//ID改領域名
function domainIdToDomainName(domainId) {
    let name;
    switch (domainId) {
        case 1:
            name = '喜劇';
            break;
        case 2:
            name = '卡通';
            break;
        case 3:
            name = '動漫';
            break;
        case 4:
            name = '驚悚劇';
            break;
        case 5:
            name = '愛情劇';
            break;
        case 6:
            name = '奇幻劇';
            break;
        case 7:
            name = '懸疑劇';
            break;
        case 8:
            name = '科幻劇';
            break;
        case 9:
            name = '動作劇';
            break;
        case 10:
            name = '紀錄片';
            break;
    }
    return name;
}

//影片長度換算時分秒
function videoLengthFormate(Seconds) {
    let hr = Math.floor(Seconds / 3600);
    let min = Math.floor((Seconds - (hr * 3600)) / 60);
    let sec = parseInt(Seconds - (hr * 3600) - (min * 60));
    while (min.length < 2) { min = '0' + min; }
    while (sec.length < 2) { sec = '0' + sec; }
    return hr + " 小時 " + min + " 分 " + sec + " 秒"
}



//設定影片來源
const player = document.querySelector('#videoPlayer');

player.src = window.location.origin + "/Ocean/VideoOutput?videoId=" + id;

let productId = [];         //id
let productInfo = [];       //商品資訊
//取得商品資訊
fetch(`/Ocean/selectProductByVideoId?videoId=${id}`)
    .then(response => response.json())
    .then(res => {
        console.log(res)
        res.forEach(i => {
            productId.push(i.productId);
            GetProductImg(i.productImgId);
        })
       
        productInfo = res;
    })
    ;
let productImgId = [];
//取得商品圖片
function GetProductImg(imgid) {
    console.log(imgid);
    fetch(`/Ocean/GetProductImg?productImgId=${imgid}`)
        .then(response => response.json())
        .then(img => {
            const binary = img.img1;
            productImgId.push()
            getProductImgURL(binary);

        })
}

let timeInfo = [];          //商品時間戳
//取得商品時間戳
fetch(`SelectProductTimeByVideoId?videoId=${id}`)
    .then(response => response.json())
    .then(res => {
        console.log(res)
        timeInfo = res;
    })
    ;

//儲存轉換成src路徑的圖片
let imgURL = [];
function getProductImgURL(binary) {
    const imageData = new Uint8Array(binary);
    const blob = new Blob([imageData], { type: 'image/jpeg' });
    const productimg = document.createElement('img');
    let url = URL.createObjectURL(blob);
    imgURL.push(url);
    productimg.src = url;
    console.log(productimg.src);
}

let AttractionSec = [];     //景點時間戳
//取得景點時間戳
fetch(`/Ocean/selectAttractionTimeByVideoId?videoId=${id}`)
    .then(response => response.json())
    .then(res => {
        console.log(res)
        AttractionSec = res;
    })
    ;


let AttractionImg = [];
let AttractionImgBinary = []
let imgId = [];

let AttractionInfo = [];    //景點資訊
//取得景點資訊
fetch(`/Ocean/selectAttractionByVideoId?videoId=${id}`)
    .then(response => response.json())
    .then(res => {
        console.log(res)
        for (let i = 0; i < res.length; i++) {
            GetAttractionImg(res[i].attractionId);
        }
        AttractionInfo = res;
    })
    ;

//取得景點圖片
function GetAttractionImg(aid) {
    fetch(`/Ocean/GetAttractionImg?attractionId=${aid}`)
        .then(response => response.json())
        .then(img => {
            imgId.push(img.attractionId);
            console.log(imgId);
            AttractionImgBinary.push(img.attractionPic);     //將圖片json放到陣列中
        }).catch(error => { console.log(error) })
}



const productinfo = document.querySelector("#productinfo");
const attractionInfo = document.querySelector("#attractionInfo");
// const foodinfo = document.querySelector("#foodinfo");
productinfo.style.display = "none";
// foodinfo.style.display = "none";

let passAttractionTime = 0;
let passProductTime = 0;

//偵測時間，取得商品、景點
player.addEventListener("timeupdate", function () {
    const currentTime = Math.floor(player.currentTime);
    for (let i = 0; i < timeInfo.length; i++) {
        if (currentTime == timeInfo[i] && currentTime > passProductTime) {
            const thisProductId = productId[i];
            const thisProductInfo = productInfo.find(product => product.productId === thisProductId);

            // if (productImgId[i] == thisProductInfo.productImgId) {

            let product = `
                <div class="product-img-container">
                    <img class="product-img" id="productImg" src="${imgURL[i]}" alt="">
                    <div class="product-details">
                        <span class="product-title" id="productName_${thisProductInfo["productId"]}">${thisProductInfo["productName"]}</span>
                        <span class="product-style" id="productType_${thisProductInfo["productId"]}">${thisProductInfo["colorType"]}</span>
                        <span class="product-spec" id="priductInfo_${thisProductInfo["productId"]}">${thisProductInfo["sizeType"]}</span>
                        $<span id="price_${thisProductInfo["productId"]}">${thisProductInfo["price"]}</span>
                        <div style="display: none;">
                            <span id="comId_${thisProductInfo["productId"]}">${thisProductInfo["comId"]}</span>
                            <span id="review"></span>
                        </div>
                        <span class="right">
                            <button class="minus-btn" type="button" onclick="adjustQuantity(-1)">-</button>
                            <input type="text" id="quantity_${thisProductInfo["productId"]}" value="1" style="max-width: 20px;">
                            <button class="add-btn" type="button" onclick="adjustQuantity(1)">+</button>
                            <button class="add-to-cart-btn" onclick="addToCart(${thisProductInfo["productId"]})">加入購物車</button>
                        </span>
                    </div>
                </div>                
                
                `;
            document.querySelector("#productinfo").innerHTML += product;
            // }

            passProductTime = currentTime + 1;

            productinfo.style.display = "block";
            document.querySelector("#noProduct").style.display = "none";
            document.querySelector("#productButton").classList.add('flashing');
            setTimeout(() => {
                document.querySelector("#productButton").classList.remove('flashing');
            }, 10000); // 這裡的時間可以自行調整
        }
    }

    let thisAttractionId = 0;
    let src = '';
    AttractionInfo.forEach((thisAttractionInfo, index) => {
        // console.log(thisAttractionInfo);
        thisAttractionId = thisAttractionInfo.attractionId;
        const AttractionTime = AttractionSec[index];
        // console.log(AttractionTime);
        if (currentTime == AttractionTime && currentTime > passAttractionTime) {
            passAttractionTime = currentTime + 1;
            // console.log(thisAttractionId, imgId[index]);
            if (thisAttractionId == imgId[index]) {
                const imageData = new Uint8Array(AttractionImgBinary[index]);
                const blob = new Blob([imageData], { type: 'image/jpeg' });
                // let blobUrl = URL.createObjectURL(blob);
                // const productimg = document.querySelector("#productImg");
                src = URL.createObjectURL(blob);
                // productimg.onload = () => {
                //     URL.revokeObjectURL(productimg.src);
                // };
            }

            attractionInfo.innerHTML += `
            <div class="attraction-img-container" style="border: 1px white solid;">
                <img class="attraction-img" src="${src}" alt="${thisAttractionInfo["attractionName"]}" id="attractionimg${thisAttractionInfo["attractionId"]}">
                <div class="attraction-details">
                    <span class="attraction-title" id="attractionName">${thisAttractionInfo["attractionName"]}</span>
                    <span class="atthearticon" id="attractionId${thisAttractionInfo["attractionId"]}" onclick="favouriteMap(${thisAttractionInfo["attractionId"]})">&#10084;</span><br>
                    <span class="attraction-description" id="attractionIntroduce">${thisAttractionInfo["attractionIntroduce"]}</span>
                </div>
            </div>
        `;
        document.querySelector("#attractionTab").classList.add('flashing');
            setTimeout(() => {
                document.querySelector("#attractionTab").classList.remove('flashing');
            }, 10000); // 這裡的時間可以自行調整
        }
    });
});

//結帳按鈕
document.querySelector("#checkoutButton").addEventListener("click", function () {
    const userId = document.querySelector("#userId").innerHTML;
    for (let i = 0; i < cart.length; i++) {
        const data = {
            productId: cart[i].productId,
            comId: cart[i].comId,
            colorType: cart[i].colorType,
            sizeType: cart[i].sizeType,
            productQuantity: cart[i].quantity,
            orderTotal: cart[i].orderTotal,
            userId: userId,
            productPrice: cart[i].price
        }
        fetch('/Ocean/insertToOrder', {
            method: "POST",
            body: JSON.stringify(data)
        }).then(response => {
            cartList.innerHTML = '';
            cart.innerHTML = ''; // 清空購物車內容
            return response.text();
        }).then(res => {

            console.log(res);
            cartList.textContent = res
        })

    }
    setTimeout(() => {
        cartList.innerHTML = '';
        cart = [];
        document.querySelector("#checkoutButton").style.display = "none";
        document.querySelector(".right-sidebar").style.width = "15px";

    }, 5000); // 10000毫秒等於10秒

});

//增加觀看次數、觀看記錄、累計觀看時數
let hasTriggered = false;
let oldTime = 0;
let oldDomainTime = 0;
player.addEventListener('timeupdate', () => {
    const currentTime = player.currentTime;
    const intCurrentTime = Math.floor(currentTime);

    if (currentTime >= 5 && !hasTriggered) {

        hasTriggered = true; // 避免重複觸發

        fetch(`/Ocean/UpdateViews?videoId=${id}`)
            .then(res => res.text())
            .then(views => {
                // let views = parseInt(restext);
                console.log(views);
                document.querySelector("#viewCount").innerHTML = '';
                document.querySelector("#viewCount").innerHTML = views;
            })
            ;
    }

    if ((intCurrentTime % 5) == 0 && intCurrentTime > oldTime) {
        let data = {
            "memberId": memberId,
            "videoId": id,
            "watchTimePoint": intCurrentTime
        }
        fetch('/Ocean/UpdateDuration', {
            method: "POST",
            body: JSON.stringify(data)
        }).then(response => response.text())
            .then(res => console.log(res))
            ;
        oldTime = intCurrentTime + 1;
        // console.log(intCurrentTime, oldTime);
    }

    //每分鐘累計一次領域觀看時間
    if ((intCurrentTime % 60) == 0 && intCurrentTime > oldDomainTime) {

        // let watchDuration = intCurrentTime / 60;
        let data = {
            "userId": userId,
            "domainId": domainId
        }
        fetch('/Ocean/AddDomainTime', {
            method: "POST",
            body: JSON.stringify(data)
        }).then(response => response.text())
            .then(res => console.log(res));
        oldDomainTime = intCurrentTime + 1;

    }

});

