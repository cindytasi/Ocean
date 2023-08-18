$(document).ready(function () {

    // console.log(sessionStorage.getItem('userId'));

    // fetch('/Ocean/web/controller/SelectMemberImageController', {
    //     method: 'POST', // 或者 'GET'，'PUT'等，取決於你的API需求
    //     headers: {
    //         'Content-Type': 'application/json', // 根據你的API需求設置合適的Content-Type
    //     },
    //     body: JSON.stringify({
    //         userId: sessionStorage.getItem('userId'),
    //     }),
    // })
    //     .then(resp => {
    //         if (resp.ok) {
    //             return resp.blob(); // 將 response 轉換為二進制數據
    //         } else {
    //             throw new Error('Network response was not ok.');
    //         }
    //     })
    //     .then(blobData => {
    //         // 在這裡處理包含圖片的二進制數據
    //         for (let i in blobData) {
    //             const profilePicture = blobData[i].profilePicture;
    //             const profilePicture_image = URL.createObjectURL(profilePicture);

    //             sessionStorage.setItem('profilePicture{i}', profilePicture_image);
    //         }
    //     })

    fetch('/Ocean/web/controller/SelectMemberController', {
        method: 'POST', // 或者 'GET'，'PUT'等，取決於你的API需求
        headers: {
            'Content-Type': 'application/json', // 根據你的API需求設置合適的Content-Type
        },
        body: JSON.stringify({
            userId: sessionStorage.getItem('userId'),
        }),
    })
        .then(resp => resp.json())
        .then(body => {
            // 在這裡處理fetch請求的回應
            const { memberId, memberName, childMember, profilePicture } = body;
            let list_html = '';
            let profilePicture_URL = [];

            for (let i in body) {
                // const memberId = new Array();
                // sessionStorage.setItem('memberId', body[i].memberId);
                // memberId[i] = sessionStorage.getItem('memberId', body[i].memberId);
                // sessionStorage.setItem('memberName', body[i].memberName);
                // sessionStorage.setItem('childMember', body[i].childMember);
                const memberId = body[i].memberId;
                const memberName = body[i].memberName;
                const childMember = body[i].childMember;
                // const profilePicture = body[i].profilePicture;


                // console.log(memberId[i]);
                // const profilePictureURL = URL.createObjectURL(profilePicture);
                // profilePicture_URL.push(profilePictureURL);


                sessionStorage.setItem('memberId${i}', memberId);
                sessionStorage.setItem('memberName${i}', memberName);
                sessionStorage.setItem('childMember${i}', childMember);
                // sessionStorage.setItem('profilePicture{i}',profilePicture_URL);


                // 遍歷回應的每個項目，動態生成HTML結構
                list_html += '<li class="profile">';
                list_html += '<a href="http://localhost:8080/Ocean/index.html">'
                list_html += '<div class="img_div">';
                list_html += '<img src="http://localhost:8080/Ocean/web/controller/SelectMemberImageController?member_id=' + memberId + '" alt="Member image" class="member_image">';
                // list_html += '<img src="img/images' + sessionStorage.getItem('memberId${i}') + '.jpeg" alt="Member image" class="member_image">';
                list_html += '<i class="memberId_i" data-member-id="' + sessionStorage.getItem('memberId${i}') + ' "></i>';
                list_html += '<span>' + body[i].memberName + sessionStorage.getItem('memberId${i}') + '</span>';
                list_html += '</div>';
                list_html += '</a>';
                list_html += '</li>';

                // console.log(sessionStorage.getItem('memberId${i}'));
            }
            // 將動態生成的HTML插入到<ul>元素中
            $("ul.choose-profile").html(list_html);

        });


    $(document).on('click', '.img_div', function () {
        const memberIdValue = $(this).find('.memberId_i').data('member-id');
        sessionStorage.setItem('memberIdValue', memberIdValue);
        console.log(sessionStorage.getItem('memberIdValue'));
    });


});



