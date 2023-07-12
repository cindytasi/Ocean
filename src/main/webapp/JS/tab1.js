
//上架、修改、下架
let btn_manage = document.querySelectorAll(".btn_manage");

//各頁籤的畫面
let video_manage = document.querySelectorAll(".video_manage");

//判斷是電影1或影集2
let movie_or_drama_1_2 = 0;


btn_manage.forEach((e1, index) => {
	e1.addEventListener("click", (e2) => {
		e2.preventDefault();

		//移除其他按鈕的css
		btn_manage.forEach(e1 => {
			e1.classList.remove("active");
		});
		//加入當前按鈕的css
		e1.classList.add("active");

		//隱藏其他頁籤的內容
		video_manage.forEach(divv => {
			divv.style.display = 'none';
		});
		//顯示當前頁籤的內容
		video_manage[index].style.display = 'block';
	});
});


//修改處理

let video_name_bar = `
<div id="video_name" style="border: white 1px solid; ">
    <label style="color: white;">影片名稱，點擊後彈出資訊</label>
</div><br>
`;

let video_info = `
<div style="border: white 1px solid; ">                            
    <div class="tab">
		<button class="movie_or_drama">電影</button>
		<button class="movie_or_drama">影集</button>
	</div><br>
	<div class="input-section">
		<label for="title" class="info">片名：<input type="text" id="title" value="玩命關頭"></label>
		<div>
			<label for="category" class="label-white">領域：
				<select name="field">
				    <option value="" selected>請選擇</option>
				    <option value="喜劇">喜劇</option>
				    <option value="卡通">卡通</option>
				    <option value="動漫">動漫</option>
				    <option value="驚悚劇">驚悚劇</option>
				    <option value="愛情劇">愛情劇</option>
				    <option value="科幻劇">科幻劇</option>
				    <option value="懸疑劇">懸疑劇</option>
				    <option value="科幻劇">科幻劇</option>
				    <option value="動作劇">動作劇</option>
				    <option value="紀錄片">紀錄片</option>
				</select>
			</label>
		</div>
		<div class="container">
			<div class="row">
			<br><br>
				<div>
					<label for="year" class="label-white">年份：
						<input type="text" id="year" class="input-field" value="2022">
					</label>
		
					<label for="region" class="label-white">地區：
						<input type="text" id="region" class="input-field" value="美國">
					</label>
		
				</div>
				<div>
					<label for="director" class="label-white">導演：
						<input type="text" id="director" class="input-field" value="不知道">
					</label>
		
					<label for="actor" class="label-white">主演：
						<input type="text" id="actor" class="input-field" value="馮迪索">
					</label>
				</div>
				<div>
					<label for="season" class="label-white">季數：
						<input type="text" id="season" class="input-field" value="0">
					</label>
		
					<label for="episode" class="label-white">集數：
						<input type="text" id="episode" class="input-field" value="10">
					</label>
		
				</div>
		
			</div>
		</div>
		<label for="description" class="info">簡介：</label>
		<textarea class="description">一堆大咖雲集的飆車、科技、武打動作片</textarea>
	</div><br>
		
	<div align="center">
		<button class="update_clear">清空</button>
		<button type="submit" id="submit" class="active">上傳</button>
	</div>
</div>
`;

document.querySelector("#video_info_area").innerHTML = video_name_bar + video_info;

//電影或影集的按鈕處理，放後面才能取得每個頁籤的按鈕
let movie_or_drama = document.querySelectorAll(".movie_or_drama");
//電影或影集按鈕
movie_or_drama.forEach((e3, index) => {
	e3.addEventListener("click", (e4) => {
		e4.preventDefault();

		movie_or_drama.forEach(e3 => {
			e3.classList.remove("active");
		});
		e3.classList.add("active");

		movie_or_drama_1_2 = index + 1;
	});
});


//下架處理

let remove_checkbox = `
<div style="border: white 1px solid;">
	<input type="checkbox" name="" id="">
	<label for="" style="color: white;">影片名稱</label>
</div>
`;

document.querySelector("#remove_video_name").innerHTML = remove_checkbox;

var remove_enter = document.querySelector("#remove_enter");
remove_enter.addEventListener("click", function () {
	let checked = document.querySelectorAll('input[type="checkbox"]:checked');
	if (checked.length > 0) {
		if (confirm("確定要刪除嗎?") == true) {

		} else {
			
		}
	}

});

//清空按鈕
var update_clear = document.querySelector(".update_clear");
update_clear.addEventListener("click", function (e) {
	e.preventDefault();
	var info = document.querySelectorAll('input[type="text"]');
	info.forEach(e => {
		if (e.value != "") {
			e.value = ""
		}
	}
	);
	document.querySelectorAll('input[type="file"]').value="";
	document.querySelectorAll(".description").value="";
});