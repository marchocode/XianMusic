var banner="../img/banner/"

$(function() {

	/**
	 * 获取浏览器里面存在的cookie;
	 * 
	 */

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

	function setCookie(cname, cvalue, exdays) {
		var d = new Date();
		d.setTime(d.getTime() + (exdays * 24 * 60 * 60 * 1000));
		var expires = "expires=" + d.toGMTString();

		document.cookie = cname + "=" + cvalue + "; " + expires + ";path=/";
	}

	var name = getCookie("user");
	var userId = getCookie("userId");
	if (name != "") {
		var html = "<li><a href='html/User.html?userId="
				+ userId
				+ "' target='_blank'><span class='glyphicon glyphicon-user' aria-hidden='true'></span> "
				+ name + "</a>";
		$("#show").prepend(html);
	}

	/**
	 * ajax获取最新吉他谱内容；
	 */

	$
			.ajax({

				cache : false,

				type : "GET",

				data: {type:"pu_date"},
				
				url : "loadPuOrderBy",

				async : false,

				error : function(request) {

					alert("发送请求失败！");

				},

				success : function(data) {

					for (var i = 0; i < data.length; i++) {

						var html = "<a href='html/quku.html?id="
								+ data[i].pu_id
								+ "' target='_blank' class='list-group-item'>"
								+ "<span class='glyphicon glyphicon-music' aria-hidden='true'></span> "
								+ data[i].singer.s_name + "—" + data[i].pu_name + ""
								+ "<span class='badge'>" + data[i].pu_drop
								+ "</span></a>";
						$("#yue").append(html);
					}
				}

			});
	/**
	 * 加载点击量最高的曲谱
	 */

	$
			.ajax({

				cache : false,

				type : "get",
				
				data: {type:"pu_drop"},
				
				url : "loadPuOrderBy",

				async : false,

				error : function(request) {

					alert("发送请求失败！");

				},

				success : function(data) {
					
					for (var i = 0; i < data.length; i++) {

						var html = "<a href='html/quku.html?id="
								+ data[i].pu_id
								+ "' target='_blank' class='list-group-item'>"
								+ "<span class='glyphicon glyphicon-music' aria-hidden='true'></span> "
								+ data[i].singer.s_name + "—" + data[i].pu_name + ""
								+ "<span class='badge'>" + data[i].pu_drop
								+ "</span></a>";

						$("#dian").append(html);

					}

				}

			});

	/**
	 * json返回一个banner图；
	 */

	$.ajax({

		cache : false,

		type : "GET",

		url : "loadBanner", 

		async : false,

		error : function(request) {

			alert("发送请求失败！");

		},

		success : function(data) {
			
			
			for (var i = 0; i < data.length; i++) {

				var html = "<div class='item'>" + "<img src='img/banner/"
						+ data[i].b_imgaddress + "' alt='...'>"
						+ "<div class='carousel-caption'><h3>" + data[i].b_title
						+ "</h3></div></div>";

				$("#banner").append(html);
			}
			$("#banner").children().first().addClass("active");
		}
	});

	/**
	 * json请求一个文章地址；
	 */

	$
			.ajax({

				cache : false,

				type : "GET",

				url : "loadTextByOrder",

				async : false,

				error : function(request) {

					alert("发送请求失败！");

				},

				success : function(data) {

					for (var i = 0; i < data.length; i++) {
				
						var html = "<a><a href='html/showText.html?id="+data[i].t_id+"' class='list-group-item'>"+
					"<h4 class='list-group-item-heading'>"+data[i].t_title+"</h4>"+
					"<p class='list-group-item-text'>"+data[i].t_bref+"</p>"+
				"</a></a>";
						
						
						var html1 = "<div class='col-sm-6 col-md-3'>"
								+
								"<div class='thumbnail' style='border:none'>"
								+ "<img src='img/TextImg/"
								+ data[i].t_img
								+ "' alt='...' class='img-responsive img-rounded' >"
								+ "<div class='caption'>"
								+ "<h3>"
								+ data[i].t_title
								+ "</h3>"
								+ "<p>"
								+ data[i].t_bref
								+ "</p>"
								+ "<p><a href='html/showText.html?id="
								+ data[i].t_id
								+ "' target='_blank' class='btn btn-primary' role='button'>查看更多</a></p></div></div></div>";
						
						if (i<=5) {
							$("#ttext").append(html);
						}
						$("#text").append(html1);
					}
				}

			});

	/**
	 * 返回商品列表
	 */
	$
			.ajax({

				cache : false,

				type : "GET",

				url : "loadCommodity",

				async : false,

				error : function(request) {

					alert("发送请求失败！");

				},

				success : function(data) {
					for (var i = 0; i < data.length; i++) {

						var html = "<div class='col-md-3'>"
								+ "<div class='thumbnail'>"
								+ "<img src='img/吉他商城/"
								+ data[i].c_img
								+ "' alt='...'>"
								+ "<div class='caption'>"
								+ "<h4 style='color:red'>￥"
								+ data[i].c_price
								+ "</h4>"
								+ "<p>"
								+ data[i].c_content
								+ "</p>"
								+ "<p><a href='"
								+ data[i].c_url
								+ "' target='_blank' class='btn btn-danger' role='button'>立即购买</a></p></div></div></div>";
//						$("#commoidty").append(html); v1.2版本下线
					}
				}

			});
});


$("#find").click(function(){
	
	var value = $("#content").val();
	
	if (value !="") {
		//发送请求 ，歌手/歌曲名模糊查找
		
		$.ajax({
			
			url:"html/findPuByLikeName",
			type:"get",
			data:{
				content:value
			},
			async:false,
			success:function(data){
				
				if (data.length == 0) {
					//没有查找到数据 直接停止
					$("#findout").append("<h4>未查找到相关内容，请检查输入是否有误！</h4>");
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
					$("#findout").append(html);
				}
				//打开模态框
				$('#myModal').modal('show');//打开模态框
			},
			error:function(){
				alert("请求发送失败");
			}
			
		})
		
	}
	
})

$('#myModal').on('hidden.bs.modal', function (e) {
  //模态框隐藏 删除数据
	$("#findout").empty();
})