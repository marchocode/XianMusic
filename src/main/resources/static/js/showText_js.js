$(function() {

	var id;
	var user;
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

	/**
	 * ajax请求
	 */

	$.ajax({

		cache : false,

		type : "GET",

		data : {
			textId : id
		},

		url : "findTextById",

		async : false,

		error : function(request) {

			alert("发送请求失败！");

		},

		success : function(data) {

			$("#toux").attr("src", "../img/usertoux/" + data.user.u_img);
			$("#name").text("作者：" + data.user.u_nick);
			$("#qian").html("<strong>签名：</strong>" + data.user.u_autograph);
			$("#time").text("上传时间: " + data.t_time);
			$("#dian").text(data.t_drop);
			$("#pict").attr("src", "../img/TextImg/" + data.t_img);
			$("#title").text(data.t_title);
			$("#content").html(data.t_content);
		}

	});

	/**
	 * 此处请求的是评论内容；
	 */
	$
			.ajax({

				type : "get",

				data : {
					tc_textid : id
				},

				url : "findAllCommentById",

				async : false,

				error : function(request) {

					alert("发送请求失败！");

				},

				success : function(data) {
					for (var i = 0; i < data.length; i++) {

						var html = "<ul class='media-list'>"
								+ "<li class='media'>"
								+ "<div class='media-left'>"
								+ "<a href='#'> <img class='media-object tou_img'"
								+ "src='../img/usertoux/"
								+ data[i].user.u_img
								+ "' style='width:64px;height:64px' alt='...'>"
								+ "</a>"
								+ "</div>"
								+ "<div class='media-body'>"
								+ "<h4 class='media-heading'>"
								+ data[i].user.u_nick
								+ "</h4>"
								+ data[i].tc_content
								+ "<p>"
								+ "<button type='button' class='btn btn-danger btn-xs'>"
								+ "<span class='glyphicon glyphicon-heart' aria-hidden='true'></span>"
								+ "点赞" + "</button>" + "<span class='badge'>"
								+ data[i].tc_drop + "</span>" + "</p>" + "</div>"
								+ "</li>" + "</ul>";
						$("#ping").append(html);

					}
				}

			});
	user = getCookie("userId");

	$("#button").click(function() {

		if (user != "") {

			$.ajax({

				cache : false,
				type : "get",
				data : {
					td_userid : user,
					td_textid : id
				},

				url : "textDrop",

				async : false,

				error : function(request) {
					alert("发送请求失败！");
				},
				success : function(data) {
					$("#dian").text(data);
				}

			});

		} else {
			alert("请登陆后再点赞 跳转至主页面登陆");
			$(location).attr('href', '/index.html');
		}

	});

	// 提前请求是否已经存在记录了

	if (user != "") {

		$.ajax({

			cache : false,

			type : "get",

			data : {
				ct_userid : user,
				ct_textid : id
			},

			url : "collectionIsExits",

			async : false,

			error : function(request) {
				alert("发送请求失败！");
			},
			success : function(data) {
				if (data == false) {
					$("#collecticon").removeClass("glyphicon glyphicon-heart");
					$("#collecticon").addClass(
							"glyphicon glyphicon-heart-empty");
				} else {
					$("#collecticon").removeClass(
							"glyphicon glyphicon-heart-empty");
					$("#collecticon").addClass("glyphicon glyphicon-heart");

				}
			}

		});

	}

	/**
	 * 收藏按钮被点击
	 */

	$("#collect").click(
			function() {

				if (user != "") {

					$.ajax({
						type : "get",
						data : {
							ct_userid : user,
							ct_textid : id
						},
						url : "collectionText",
						async : false,

						error : function(request) {

							alert("发送请求失败！");

						},

						success : function(data) {
							if (data == false) {
								alert("你取消了收藏");
								$("#collecticon").removeClass(
										"glyphicon glyphicon-heart");
								$("#collecticon").addClass(
										"glyphicon glyphicon-heart-empty");

							} else {
								alert("收藏成功");
								$("#collecticon").removeClass(
										"glyphicon glyphicon-heart-empty");
								$("#collecticon").addClass(
										"glyphicon glyphicon-heart");
							}
						}

					});

				} else {
					alert("请登陆后再继续收藏  跳转至主页面登陆");
					$(location).attr('href', '/XianMusic/index.html');
				}

			});
	
	
	$("#publish").click(function(){
		var comment = $("#comment").val();
		if (user !="" && comment !="") {
			/**
			 * ajax 请求操作
			 */
			$.ajax({

				type : "POST",
				data : {
					tc_userid : user,
					tc_textid : id,
					tc_content : comment
				},
				url : "saveComment",
				async : false,
				error : function(request) {
					alert("发送请求失败！");
				},
				success : function(data) {
					if (data == "success") {
						//刷新页面
						window.location.reload()
					}else {
						
					}
				}

			});
			
			
			
		}else {
			alert("请先进行登陆 或者键入内容后再提交");
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
	
	


})
