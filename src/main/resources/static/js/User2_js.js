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
			url : "findUserConnectionPu",

			error : function(request) {
				alert("发送请求失败！");
			},
			success : function(data) {
				
				if (data.length == 0) {
					//没有查找到数据 直接停止
					$("#collection").append("<h4>先去收藏几个曲谱再来吧！</h4>");
					return;
				}
				
				//填充数据
				for (var i = 0; i < data.length; i++) {

					var html = "<a href='html/quku.html?id="
							+ data[i].pu_id
							+ "' target='_blank' class='list-group-item'>"
							+ "<span class='glyphicon glyphicon-music' aria-hidden='true'></span> "
							+ data[i].singer.s_name + "—" + data[i].pu_name + ""
							+ "<span class='badge'>" + data[i].pu_drop
							+ "</span></a>";
					$("#collection").append(html);
				}
				
				
			}

		});
		
		
	} else {
		$("#collection").append("<h4>请先登陆！</h4>");
	}
	

	
})