
//置頂、熱門、最新、推薦
let home_lab = document.querySelectorAll(".home_lab");
//按鈕處理
home_lab.forEach((e, index) => {
    e.addEventListener("click", (e2) => {
        e2.preventDefault();

        home_lab.forEach(e => {
            e.classList.remove("active");
        });
        e.classList.add("active");

        //movie_or_drama_1_2 = index + 1;
    });
});

// const imageFileInput = document.getElementById('image-file');
// const previewImage = document.getElementById('preview-image');

// imageFileInput.addEventListener('change', function (event) {
//     const file = event.target.files[0];
//     const reader = new FileReader();

//     reader.onload = function (e) {
//         previewImage.src = e.target.result;
//     }

//     reader.readAsDataURL(file);
// });
