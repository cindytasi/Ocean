
//上傳影片
function uploadVideo_btn() {
	//取得全部資訊
	let imgFile = document.querySelector("#imgFile").files[0];						//影片檔
	let picFile = document.querySelector("#picFile").files[0];						//圖片檔
	let movie_or_drama = document.querySelector('input[name="movie_or_drama"]:checked').value;//電影或影集
	let videoName = document.querySelector("#titleName").value.trim();		//片名
	let doaminName = document.querySelector("#doaminName").value.trim();	//領域名稱
	let videoYear = document.querySelector("#upyear").value.trim();			//年份
	let videoArea = document.querySelector("#region").value.trim();			//地區
	let videoDirector = document.querySelector("#director").value.trim();	//導演
	let videoActor = document.querySelector("#actor").value.trim();			//主演
	let videoSeason = document.querySelector("#season").value.trim();		//季數
	let videoEpisode = document.querySelector("#episode").value.trim();		//集數
	let Introduction = document.querySelector("#infoArea").value.trim();	//簡介

	if (imgFile == null || imgFile == '') { alert("請選擇影片") }
	if (picFile == null || picFile == '') { alert("請選擇圖片") }
	if (movie_or_drama == null || movie_or_drama == '') { alert("請選擇片類型") }
	if (videoName == null || videoName == '') { alert("請輸入片名") }
	if (doaminName == null || doaminName == '') { alert("請選擇領域名") }
	if (videoYear == null || videoYear == '') { alert("請輸入年份") }
	if (videoArea == null || videoArea == '') { alert("請輸入地區") }
	if (videoDirector == null || videoDirector == '') { alert("請輸入導演") }
	if (videoActor == null || videoActor == '') { alert("請輸入主演員") }
	if (videoSeason == null || videoSeason == '') { alert("請輸入季數") }
	if (videoEpisode == null || videoEpisode == '') { alert("請輸入集數") }
	if (Introduction == null || Introduction == '') { alert("請輸入簡介") }
	if (isNaN(videoYear) || isNaN(videoSeason) || isNaN(videoEpisode)) {
		alert("請輸入正確的數字(年份、季數、集數)");
	}

	let domainId = DomainNameToDomainId(doaminName);

	const formdata = new FormData();
	//將全部資訊放入formData
	formdata.append("videoType", movie_or_drama);
	formdata.append("videoName", videoName);
	formdata.append("domainId", domainId);
	formdata.append("videoYear", videoYear);
	formdata.append("videoArea", videoArea);
	formdata.append("videoDirector", videoDirector);
	formdata.append("videoActor", videoActor);
	formdata.append("videoSeason", videoSeason);
	formdata.append("videoEpisode", videoEpisode);
	formdata.append("Introduction", Introduction);
	formdata.append("imgFile", imgFile);
	formdata.append("picFile", picFile);

	alert("影片上傳中...");

	fetch('/Ocean/videoUpload', {
		method: 'POST',
		body: formdata
	}).then(response => response.text())
		.then(res => {
			console.log(res);
			alert(res);
			location.reload();
		});

}


//上架、修改、下架
let btn_manage = document.querySelectorAll(".btn_manage");
//各頁籤的畫面
let video_manage = document.querySelectorAll(".video_manage");
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


//搜尋要修改的影片列表
function serchToUpdate() {
	let toUpdateSerchText = document.querySelector("#toUpdateSerchText").value.trim();
	if (toUpdateSerchText == null || toUpdateSerchText == '') {
		alert("請輸入片名");
	}
	document.querySelector("#videoList").innerHTML = '';
	document.querySelector("#videoInfo").innerHTML = '';
	fetch('/Ocean/videoSerch', {
		method: 'POST',
		body: JSON.stringify({ "toUpdateSerchText": toUpdateSerchText })
	}).then(response => response.json())
		.then(data => {
			for (let i = 0; i < data.length; i++) {
				document.querySelector("#videoList").innerHTML += `<label style="color: white;" onclick="showVideoInfo(info${data[i]["videoId"]})" id="${data[i]["videoName"]}">${data[i]["videoName"]}</label>`;
				document.querySelector("#videoInfo").innerHTML += `
					<div id="info${data[i]["videoId"]}" style="display:none">
						<div style="border: white 1px solid; ">                            
							<div class="tab">
								<input type="radio" value="電影" name="up_movie_or_drama" id="movie"><label for="movie">電影</label>
								<input type="radio" value="影集" name="up_movie_or_drama" id="drama"><label for="drama">影集</label>
							</div><br>
							<div class="input-section">
								<label for="title" class="info">片名：<input type="text" id="up_title" value="${data[i]["videoName"]}"></label>
								<div>
									<label for="category" class="label-white">領域：
										<select name="field" id="up_domainName">
											<option value="" >請選擇</option>
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
												<input type="text" id="up_year" class="input-field" value="${data[i]["videoYear"]}">
											</label>
						
											<label for="region" class="label-white">地區：
												<input type="text" id="up_region" class="input-field" value="${data[i]["videoArea"]}">
											</label>
						
										</div>
										<div>
											<label for="director" class="label-white">導演：
												<input type="text" id="up_director" class="input-field" value="${data[i]["videoDirector"]}">
											</label>
								
											<label for="actor" class="label-white">主演：
												<input type="text" id="up_actor" class="input-field" value="${data[i]["videoActor"]}">
											</label>
										</div>
										<div>
											<label for="season" class="label-white">季數：
												<input type="text" id="up_season" class="input-field" value="${data[i]["videoSeason"]}">
											</label>
								
											<label for="episode" class="label-white">集數：
												<input type="text" id="up_episode" class="input-field" value="${data[i]["videoEpisode"]}">
											</label>
										</div>
									</div>
								</div>
								<label for="description" class="info">簡介：</label>
								<textarea class="description" id="up_infoArea">${data[i]["Introduction"]}</textarea>
							</div><br>
							<div align="center">
								<button class="update_clear">清空</button>
								<button type="button" id="update_btn" class="active" onclick="update_btn(${data[i]["videoId"]})">上傳</button>
							</div>
						</div>
					</div>
					`;
				let domainname = DomainIdToDomainName(data[i]["domainId"]);
				document.querySelector("#up_domainName").value = domainname;

				let movie_or_drama = document.querySelectorAll('input[type="radio"][name="up_movie_or_drama"]');
				for (let j = 0; j < movie_or_drama.length; j++) {
					if (movie_or_drama[0].value === data[i]["videoType"]) {
						movie_or_drama[0].checked = true;
						break;
					} else {
						movie_or_drama[1].checked = true;
						break;
					}
				}
			}
		})
		;
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
}

//顯示要修改的影片資訊
function showVideoInfo(video_Name) {
	video_Name.style.display = "block";
}

//修改上傳按鈕
function update_btn(vId) {
	//取得全部資訊
	let movie_or_drama = document.querySelector('input[name="up_movie_or_drama"]:checked').value;//電影或影集
	let videoName = document.querySelector("#up_title").value.trim();			//片名
	let doaminName = document.querySelector("#up_domainName").value;			//領域名稱
	let videoYear = document.querySelector("#up_year").value.trim();			//年份
	let videoArea = document.querySelector("#up_region").value.trim();			//地區
	let videoDirector = document.querySelector("#up_director").value.trim();	//導演
	let videoActor = document.querySelector("#up_actor").value.trim();			//主演
	let videoSeason = document.querySelector("#up_season").value.trim();		//季數
	let videoEpisode = document.querySelector("#up_episode").value.trim();		//集數
	let Introduction = document.querySelector("#up_infoArea").value.trim();		//簡介


	if (movie_or_drama == null || movie_or_drama == '') { alert("請選擇片類型") }
	if (videoName == null || videoName == '') { alert("請輸入片名") }
	if (doaminName == null || doaminName == '') { alert("請選擇領域名") }
	if (videoYear == null || videoYear == '') { alert("請輸入年份") }
	if (videoArea == null || videoArea == '') { alert("請輸入地區") }
	if (videoDirector == null || videoDirector == '') { alert("請輸入導演") }
	if (videoActor == null || videoActor == '') { alert("請輸入主演員") }
	if (videoSeason == null || videoSeason == '') { alert("請輸入季數") }
	if (videoEpisode == null || videoEpisode == '') { alert("請輸入集數") }
	if (Introduction == null || Introduction == '') { alert("請輸入簡介") }
	if (isNaN(videoYear) || isNaN(videoSeason) || isNaN(videoEpisode)) {
		alert("請輸入正確的數字(年份、季數、集數)");
	}

	let domainId = DomainNameToDomainId(doaminName);

	let data = {
		"videoId": vId,
		"videoType": movie_or_drama,
		"videoName": videoName,
		"domainId": domainId,
		"videoYear": videoYear,
		"videoArea": videoArea,
		"videoDirector": videoDirector,
		"videoActor": videoActor,
		"videoSeason": videoSeason,
		"videoEpisode": videoEpisode,
		"Introduction": Introduction
	}
	alert("影片資訊更新中...");

	fetch('/Ocean/videoUpdate', {
		method: 'POST',
		body: JSON.stringify(data)
	}).then(response => response.text())
		.then(res => {
			console.log(res);
			alert(res);
			location.reload();
		});
}

//搜尋要刪除的影片
function serchToDelete() {
	let serchToDeleteText = document.querySelector("#serchToDeleteText").value.trim();
	if (serchToDeleteText == null || serchToDeleteText == '') {
		alert("請輸入片名");
	}
	fetch('/Ocean/videoSerch', {
		method: 'POST',
		body: JSON.stringify({ "serchToDeleteText": serchToDeleteText })
	}).then(response => response.json())
		.then(data => {
			console.log(data);
			for (let i = 0; i < data.length; i++) {
				document.querySelector("#remove_video_name").innerHTML += `
			<label style="color: white;" id="${data[i]["videoId"]}">${data[i]["videoName"]}</label>
			<button type="button" style="background-color: yellow;" onclick="remove_enter(${data[i]["videoId"]})">刪除</button><br>
			`;
			}
		});
}

//下架處理
function remove_enter(vi_id) {
	if (confirm("確定要刪除嗎?")) {
		fetch('/Ocean/deleteVideo',{
			method: 'POST',
			body: JSON.stringify({vi_id})
		}).then(response => response.text())
		.then(res => {
			console.log(res);
			alert(res);
			location.reload();
		})
		;
	}
}

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