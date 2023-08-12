<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
    
 <!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-F3w7mX95PdgyTmZZMECAngseQB83DfGTowi0iMjiWaeVhAn4FJkqJByhZMI3AhiU" crossorigin="anonymous">

    <style>
        body {
          background-color: #363434;
          color: #fff; /* Optional: Set the text color to white for contrast */
        }
      
        /* Other CSS styles go here */


        #logo {
            position: absolute;
            top: 10px; /* Adjust top position to your liking */
            left: 40px; /* Adjust left position to your liking */
            max-width: 40px; /* Limit the maximum width of the logo */
            /* z-index: 1;  */
            /* Set z-index to bring the logo to the front */
        }

        h3 {
            margin-top: 100px; /* Adjust the value to move the h3 element down */
            margin-left: 50px;
            height: 40px;
            
        }
         
        

        .btn-group-vertical .btn {
            background-color: #363333; /* 將按鈕的底色設置為淺灰色 (#777) */
            color: #fff; /* 設置按鈕文字顏色為白色 */
        }

        .item-container {
            border: 3px solid #fff; /* 白色細線邊框 */
            padding: 10px; /* 內部間距，使白色邊框不會貼得太緊 */
            margin-bottom: 10px; /* 底部間距，使商品之間有些空隙 */
            display: inline-block; /* 讓商品項目水平排列 */
        }

        .name-container {
            border: 3px solid #fff; /* 白色細線邊框 */
            padding: 10px; /* 內部間距，使白色邊框不會貼得太緊 */
            display: inline-block; /* 讓商品名稱水平排列 */
            width: 850px; /* 調整白框寬度 */
        }
        .name-container .right-aligned {
            text-align: right; /* 讓內容向右對齊 */
        }
      </style>

</head>



<body>




<!-- navbar -->
<nav class="navbar navbar-expand-lg navbar-dark bg-dark sticky-top mb-5">
    <div class="container-fluid">
        <div class="collapse navbar-collapse justify-content-between" id="navbarNavDropdown">
            <!-- logo -->
            <div class="logo d-flex">
                <a class="navbar-brand" href="/oceanIndex.html">
                    <img src="https://cdn.discordapp.com/attachments/1111587335419740274/1129318479376429158/logo_-_.png" alt="Ocean Logo" style="width: 50px;height: 50px;">
                </a>
                <!-- search -->
                <div class="input-group my-auto w-50">
                    <input type="text" class="form-control" id="searchInput" placeholder="Search"
                        aria-label="Search" aria-describedby="basic-addon2">
                    <button class="btn btn-outline-secondary" type="button" id="searchButton">
                        <i class="bi bi-search"></i>
                    </button>
                </div>
            </div>
            <!-- 導覽列 -->
            <div class="list">
                <ul class="navbar-nav align-items-center">
                    <!-- 首頁 -->
                    <li class="nav-item">
                        <a class="nav-link active" href="/oceanIndex.html">首頁</a>
                    </li>
                    <!-- 電影 -->
                    <li class="nav-item">
                        <a class="nav-link" href="/movieIndex.html">電影</a>
                    </li>
                    <!-- 影集 -->
                    <li class="nav-item">
                        <a class="nav-link" href="/seriesIndex.html">影集</a>
                    </li>
                    <!-- 藝人商品 -->
                    <li class="nav-item">
                        <a class="nav-link" href="/productIndex.html">藝人商品</a>
                    </li>
                    <!-- 收藏地圖 -->
                    <li class="nav-item">
                        <a class="nav-link" href="/favoriteMapIndex.html">收藏地圖</a>
                    </li>
                    <!--user  -->
                    <div class="nav-item dropdown">
                        <button type="button" class="btn dropdown-toggle" id="navbarDropdownUserLink"
                            data-bs-toggle="dropdown" aria-expanded="false">
                            <img src="/img/user.webp" alt="" style="width: 40px; height: 40px;">
                        </button>
                        <!-- user下拉選單 -->
                        <ul class="dropdown-menu dropdown-menu-end mt-2" style="opacity: 80%;"
                            aria-labelledby="navbarDropdownUserLink">
                            <li><a class="dropdown-item" href="/aacountIndex.html">帳戶</a></li>
                            <li><a class="dropdown-item" href="/accountDetail.html">基本資料</a></li>
                            <li><a class="dropdown-item" href="/myAchieve.html">我的成就</a></li>
                            <li><a class="dropdown-item" href="/myOrder.html">我的訂單</a></li>
                            <li><a class="dropdown-item" href="/myList.html">我的片單</a></li>
                            <li><a class="dropdown-item" href="/watchHistory.html">觀看紀錄</a></li>
                            <li>
                                <hr class="dropdown-divider">
                            </li>
                            <li><a class="dropdown-item" href="/signOut.html">登出</a></li>
                        </ul>
                    </div>
                </ul>
            </div>
        </div>
    </div>
</nav>


<div class="foamtitle container">
    <h3>廠商後台</h3>
</div>  
<!-- <div class="check container" style="margin-left: 20%;">
    <button type="button" class="btn btn-outline-secondary"><a href="test.html">已上架</a></button>
    <button type="button" class="btn btn-outline-secondary">待審核</button>
</div> -->

    <div class="foamlist container">
        <div class="mainfoam  left d-flex">
            <div class="bts">
            
                <button type="button" class="btn btn-dark "><a href="<c:url value="/jsp/test2.html"/>">商品列表</a></button>
                <button type="button" class="btn btn-dark"><a href="<c:url value="/jsp/test.html"/>">>上架商品</a></button>
                <br>
                <button type="button" class="btn btn-dark">商品置入</button>
                <button type="button" class="btn btn-dark">審核明細</button>
            </div>
            




    <div class="foamdetail"style ="margin-bottom:10px;">
       
        <div class="item-container"> <!-- 新增的 div 包裹商品圖片 -->
            <img src="..." class="text-start" alt="商品圖片">
            <input type="file" id="p_file">
        </div>

        <div class="item-container"> <!-- 新增的 div 包裹商品圖片 -->
            <img src="..." class="text-start" alt="商品圖片">
            <input type="file" id="p_file">
        </div>
<!--     
   圖片先不做------------------------------------------------------------------------        -->
          <div class="name-container"> <!-- 新增的 div 包裹商品名稱 -->
            <label for="productName" class="col-sm-2 col-form-label">商品名稱</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" id="productName">
            </div>



            <label for="specType" class="col-sm-2 col-form-label">商品分類</label>
            <div class="col-sm-10">
                <!-- <input type="text" class="form-control" id="specType"> -->
            

                <select class="form-select" aria-label="Default select example"id="specType">
                <option selected>開啟選擇類別</option>
                <option value="1">衣服</option>
                <option value="2">庫子</option>
                <option value="3">帽子</option>
              </select>
            </div>

            <label for="sizeType" class="col-sm-2 col-form-label">商品尺寸</label>
            <div class="col-sm-10">
                <input type="商品名稱" class="form-control" id="sizeType">
            </div>
            <label for="price" class="col-sm-2 col-form-label">商品價錢</label>
            <div class="col-sm-10">
                <input type="商品名稱" class="form-control" id="price">
            </div>
            <label for="inStock" class="col-sm-2 col-form-label">商品庫存</label>
            <div class="col-sm-10">
                <input type="商品名稱" class="form-control" id="inStock">
            </div>
            <div class="right-aligned">
            <button type="button" class="btn btn-warning"id="keepBtn">上架</button>
            <!-- <button type="button" class="btn btn-info"id="publishBtn">上架</button> -->

                </div>
          </div>
        </div>
        <!-- <button id="click-btn">點擊</button> -->
          <!-- " padding-left: 700px; " -->
     


        </div>
      </div>        
      
    
      <script>
        window.onload = function(){
            // document.getElementById("click-btn").addEventListener("click", function(){
            //     const product_name_input = document.getElementById("inputPassword");
            //     const product_name = product_name_input.value;
            const keepBtn = document.getElementById("keepBtn");
        // const publishBtn = document.getElementById("publishBtn");
        const productName = document.getElementById("productName");
        const specType = document.getElementById("specType");
        const sizeType = document.getElementById("sizeType");
        const price = document.getElementById("price");
        const inStock = document.getElementById("inStock");

    
                keepBtn.addEventListener("click", function() {
     
            const nameValue = productName.value;
            const categoryValue = specType.value;
            const sizeValue = sizeType.value;
            const priceValue = price.value;
            const stockValue = inStock.value;

                    console.log(nameValue);


            fetch("ProductsOnShelvesServlet", {
                method: "POST",
                headers: {
                    "Content-Type": "application/json",
                },
                body: JSON.stringify({
                    productName: nameValue,
                    specType: categoryValue,
                    sizeType: sizeValue,
                    price: priceValue,
                    inStock: stockValue
                }),
            })
            .then(response => response.json())
            .then(data => {
                if(data.successful ){
                    location.href = "http://127.0.0.1:5501/test2.html";
                }
            })
            .catch(error => {
                console.log("Error:", error);
            });
        });

        // 其他事件監聽和程式碼
    };














        // var preview_img = function(file){
        
        // var reader = new FileReader(); // 用來讀取檔案
        // reader.readAsDataURL(file); // 讀取檔案
        // reader.addEventListener("load", function () {
        //   //console.log(reader.result);
        //   /*
        //   let img_node = document.createElement("img"); // <img>
        //   img_node.setAttribute("src", reader.result); // <img src="base64">
        //   img_node.setAttribute("class", "preview_img"); // <img src="base64" class="preview_img">
        //   preview_el.innerHTML = '';
        //   preview_el.append(img_node);
        //   */
        
        //   let img_str = '<img src="' + reader.result + '" class="preview_img">';
        //   preview_el.innerHTML = img_str;
        // });
        // };
        
        
        // p_file_el.addEventListener("change", function(e){
        // if(this.files.length > 0){
        //   preview_img(this.files[0]);
        // }else{
        //   preview_el.innerHTML = '<span class="text">預覽圖</span>';
        // }
        // });
        
        
        
              </script>
      
      <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.10.1/dist/umd/popper.min.js" integrity="sha384-W8fXfP3gkOKtndU4JGtKDvXbO53Wy8SZCQHczT5FMiiqmQfUpWbYdTil/SxwZgAN" crossorigin="anonymous"></script>
      <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/js/bootstrap.min.js" integrity="sha384-skAcpIdS7UcVUC05LJ9Dxay8AXcDYfBJqt1CJ85S/CFujBsIzCIv+l9liuYLaMQ/" crossorigin="anonymous"></script>
</body>
</html>
 