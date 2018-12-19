$(function() {

	var name;
	var password;
	/**
	 * 登陆按钮被点击后的
	 */

	$("#login").click(function() {

		name = $("#name").val();
		password = $("#password").val();
		if (name != "" && password != "") {

			$.ajax({

				type : "POST",

				url : "userLogin",

				data : {
					'u_name' : name,
					'u_password' : password
				},

				async : false,

				error : function(request) {

					alert("发送请求失败！");
				},

				success : function(data) {

					if (data != "none") {
						setCookie("user", name, 1);
						setCookie("userId", data, 1);
						alert("欢迎回来" + name);
						$(location).attr('href', '/music/index.html');
					} else {
						alert("检查用户名或者密码是否有误");
					}
				}

			});

		} else {
			alert("你还没有填写完整的信息，不能登录");
		}

	});

	function setCookie(cname, cvalue, exdays) {
		var d = new Date();
		d.setTime(d.getTime() + (exdays * 24 * 60 * 60 * 1000));
		var expires = "expires=" + d.toGMTString();

		document.cookie = cname + "=" + cvalue + "; " + expires + ";path=/";
	}

})