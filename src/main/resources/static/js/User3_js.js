$(function() {

	function getCookie(cname) {
		var name = cname + "=";
		var ca = document.cookie.split(';');
		for (var i = 0; i < ca.length; i++) {
			var c = ca[i].trim();
			if (c.indexOf(name) == 0)
				return c.substring(name.length, c.length);
		}
		return "";
	}
	

	var userId = getCookie("userId");
	
	if (userId != "") {
		
		$.ajax({

			type : "GET",
			data : {
				userId : userId
			},
			url : "findUserCollectionText",

			error : function(request) {
				alert("发送请求失败！");
			},
			success : function(data) {
				
				if (data.length == 0) {
					$("#text").append("<h1>先收藏几个再来吧</h1>");
					
					return ;
				}
				
				for (var i = 0; i < data.length; i++) {
					
					
					
					
					var html = "<div class='media'>"
							+ "<div class='media-left'><a href='#'>"
							+ "<img class='media-object' style='width:64px;' src='../img/TextImg/"
							+ data[i].t_img + "' alt='...'></a></div>"
							+ "<div class='media-body'>"
							+ "<h4 class='media-heading'>"
							+ data[i].t_title
							+ "</h4><a href='../html/showText.html?id="
							+ data[i].t_id + "'>" + data[i].t_bref
							+ "<a/></div></div>";
					
					$("#text").append(html);

				}
				
				
				
			}

		});
		
		
	} else {
		$("#text").append("<h1>请登陆后查看！</h1>");
	}
	

	
})