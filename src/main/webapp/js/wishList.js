$(document).ready(function() {
    $(".delete-wishlist").click(function(e) {
        e.preventDefault(); // 阻止默认链接行为

        var wishlistId = $(this).data("wishlistid");

        $.ajax({
            url: "/Ocean/DelWishListServlet",
            type: "GET",
            data: {
                wishlistId: wishlistId
            },
            success: function(response) {
                // 删除成功后的处理，可以根据需要更新页面内容
                console.log("删除成功:", response);

                
                location.reload();
            },
            error: function(xhr, status, error) {
                // 请求失败的处理
                console.error("删除失败:", error);
            }
        });
    });
});