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
			url : "findUserById",

			async : false,

			error : function(request) {
				alert("发送请求失败！");
			},
			success : function(data) {
				$("#name").attr("value", data.u_name);
				$("#ni").attr("value", data.u_nick);
				$("#qian").attr("value", data.u_autograph);
				$("#email").attr("value", data.u_email);
				$("#tou").attr("src", '../../img/usertoux/' + data.u_img);
				$("#id").text("ID:"+data.u_id);
			}

		});
		
		
	}
	

	$("#update").click(function() {

		var ni = $("#ni").val();
		var email = $("#email").val();
		var qian = $("#qian").val();
		
		if (ni != '' && email != '' && qian != '') {

			$.ajax({

				cache : false,

				type : "POST",

				dataType : "json",

				data : {
					ni : ni,
					email : email,
					qian : qian,
					id : id
				},

				url : "../jsp/ajax_User_update.jsp",

				async : false,

				error : function(request) {

					alert("发送请求失败！");

				},

				success : function(data) {
					alert(data);
				}

			});

		} else {

		}

	})
})