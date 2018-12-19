$(function() {

	/**
	 * 开始写曲库的相关js
	 */
	
	var id ;
	var name;

	function getParamer(paramer) {

		var url = window.location.href.split("?")[1]; /* 获取url里"?"后面的值 */
		if (url.indexOf("&") > 0) { /* 判断是否是一个参数还是多个参数 */
			urlParamArry = url.split("&"); /* 分开每个参数，并放到数组里 */
			for (var i = 0; i < urlParamArry.length; i++) {
				var paramerName = urlParamArry[i].split("="); /* 把每个参数名和值分开，并放到数组里 */
				if (paramer == paramerName[0]) { /* 匹配输入的参数和数组循环出来的参数是否一样 */
					return paramerName[1]; /* 返回想要的参数值 */
				}
			}
		} else { /* 判断只有个参数 */
			var paramerValue = url.split("=")[1];
			return paramerValue;
		}

	}

	id = getParamer(id);
	
	$.ajax({

		cache : false,

		type : "POST",

		url : "loadPuById", // 把表单数据发送到ajax.jsp

		data : {
			puId : id
		}, // 要发送的是ajaxFrm表单中的数据

		async : false,

		error : function(request) {

			alert("发送请求失败！");

		},

		success : function(data) {

			 $("#singer").text(data.singer.s_name);
			 $("#title").text(data.singer.s_title);
			 $("#author").text(data.pu_author);
			 $("#dian").text(data.pu_drop);
			 $("#img").attr("src", "../img/singer/" + data.singer.s_img)
			 $("#video").attr("src", "http://player.youku.com/player.php/sid/" + data.pu_video+"/v.swf")
			
			/**
			 * singName, singTitle, singImg, puAuthor, video, pushang, img_id,
			 * dian
			 */
			var img = data.pictures;
			 
			for (var i = 0; i < img.length; i++) {
				
				var html = "<img src='../quku/"+img[i].i_imgaddress+"' class='img-responsive center-block img_padd'>";
				
				$("#pu_img").append(html);
			}

		}

	});
	
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
	
	name = getCookie("userId");
	
	$("#butt").click(function(){
		
		/**
		 * 先判断用户是否已经登陆 没有登陆则不能点赞 跳转至登陆主页；
		 */
		
		if (name == "") {
			alert("你还没有登陆 请至主页面登陆！");
			$(location).attr('href', '/html/login.html');
			
		} else {
			
			
			$.ajax({

				type : "get",
				url : "dropPu",
				data : {
					'dp_puid': id,
					'dp_uid' : name
				}, // 要发送的是ajaxFrm表单中的数据

				async : false,

				error : function(request) {

					alert("发送请求失败！");

				},

				success : function(data) {
					$("#dian").text(data);
				}

			});
		}
		
		
		
		
		
	});
	
	if (name != "") {
		
		$.ajax({

			type : "get",
			url : "collectionExist", // 把表单数据发送到ajax.jsp
			data : {
				cp_puid : id,
				cp_userid : name
			}, // 要发送的是ajaxFrm表单中的数据
			async : false,
			error : function(request) {
				alert("发送请求失败！");
			},

			success : function(data) {
				if(data == false) {
					
					$("#collecticon").removeClass("glyphicon glyphicon-heart");
					$("#collecticon").addClass("glyphicon glyphicon-heart-empty");
					
				} else {
					
					$("#collecticon").removeClass("glyphicon glyphicon-heart-empty");
					$("#collecticon").addClass("glyphicon glyphicon-heart");
					
				}
			}

		});
	}
	
	
	
	$("#collect").click(function(){
		
		/**
		 * 先判断用户是否已经登陆 没有登陆则不能点赞 跳转至登陆主页；
		 */
		
		
		if (name == "") {
			alert("你还没有登陆 请至主页面登陆！");
			$(location).attr('href', '/html/index.html');
			
		} else {
			
			
			$.ajax({
				type : "get",
				url : "collectionPu", // 把表单数据发送到ajax.jsp
				data : {
					cp_userid : name,
					cp_puid : id
				}, // 要发送的是ajaxFrm表单中的数据

				error : function(request) {
					alert("发送请求失败！");
				},
				success : function(data) {
					if(data == false) {
						alert("你取消了收藏");
						$("#collecticon").removeClass("glyphicon glyphicon-heart");
						$("#collecticon").addClass("glyphicon glyphicon-heart-empty");
					} else {
						alert("收藏成功");
						$("#collecticon").removeClass("glyphicon glyphicon-heart-empty");
						$("#collecticon").addClass("glyphicon glyphicon-heart");
					}
				}

			});
		}
		
	})
})