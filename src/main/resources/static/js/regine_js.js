$(function() {

	var name = null;
	var email = null;
	var password = null;
	var code = null;
	var status = false;

	var yue = false;

	$("#username")
			.change(
					function() {
						// 账号验证
						var nam = /^[a-zA-Z][a-zA-Z0-9_]{4,15}$/;
						var tes = nam.test(this.value);
						if (tes) {
							name = this.value;
							$("#username").parent().removeClass("has-error")
									.addClass("has-success");

							$("#username").nextAll().remove();
							$("#username")
									.parent()
									.append(
											'<span class="glyphicon glyphicon-ok form-control-feedback" aria-hidden="true"></span><span id="inputSuccess2Status" class="sr-only">(success)</span>');
						} else {
							$("#username").parent().removeClass("has-success")
									.addClass("has-error");
							name = null;
							$("#username").nextAll().remove();
							$("#username")
									.parent()
									.append(
											'<span class="glyphicon glyphicon-remove form-control-feedback" aria-hidden="true"></span><span id="inputError2Status" class="sr-only">(error)</span>');

						}
					});
	$("#useremail")
			.change(
					function() {
						// email验证
						var pattern = /^([a-zA-Z0-9]+[_|\_|\.]?)*[a-zA-Z0-9]+@([a-zA-Z0-9]+[_|\_|\.]?)*[a-zA-Z0-9]+\.[a-zA-Z]{2,3}$/;
						var strEmail = pattern.test(this.value);

						if (strEmail) {
							email = this.value
							$("#useremail").parent().removeClass("has-error")
									.addClass("has-success");
							$("#useremail").nextAll().remove();
							$("#useremail")
									.parent()
									.append(
											'<span class="glyphicon glyphicon-ok form-control-feedback" aria-hidden="true"></span><span id="inputSuccess2Status" class="sr-only">(success)</span>');

						} else {
							$("#useremail").parent().removeClass("has-success")
									.addClass("has-error");
							email = null;
							$("#useremail").nextAll().remove();
							$("#useremail")
									.parent()
									.append(
											'<span class="glyphicon glyphicon-remove form-control-feedback" aria-hidden="true"></span><span id="inputError2Status" class="sr-only">(error)</span>');

						}
					});

	$("#userpassword1")
			.change(
					// 第一次密码键入
					function() {
						var pass = /^[a-zA-Z]\w{5,17}$/;
						var pas1 = this.value;
						if (pass.test(pas1)) {
							$("#userpassword1").parent().removeClass(
									"has-error").addClass("has-success");
							$("#userpassword1").nextAll().remove();
							$("#userpassword1")
									.parent()
									.append(
											'<span class="glyphicon glyphicon-ok form-control-feedback" aria-hidden="true"></span><span id="inputSuccess2Status" class="sr-only">(success)</span>');

						} else {
							$("#userpassword1").parent().removeClass(
									"has-success").addClass("has-error");
							$("#userpassword1").nextAll().remove();
							$("#userpassword1")
									.parent()
									.append(
											'<span class="glyphicon glyphicon-remove form-control-feedback" aria-hidden="true"></span><span id="inputError2Status" class="sr-only">(error)</span>');

						}

					})
	$("#userpassword2")
			.change(
					function() {
						// 密码(以字母开头，长度在6~18之间，只能包含字母、数字和下划线)
						var passw2 = this.value;
						var passw1 = $("#userpassword1").val();
						if (passw1 == passw2) {

							password = passw2;
							$("#userpassword2").parent().removeClass(
									"has-error").addClass("has-success");
							$("#userpassword2").nextAll().remove();
							$("#userpassword2")
									.parent()
									.append(
											'<span class="glyphicon glyphicon-ok form-control-feedback" aria-hidden="true"></span><span id="inputSuccess2Status" class="sr-only">(success)</span>');

						} else {
							$("#userpassword2").parent().removeClass(
									"has-success").addClass("has-error");
							$("#userpassword2").nextAll().remove();
							$("#userpassword2")
									.parent()
									.append(
											'<span class="glyphicon glyphicon-remove form-control-feedback" aria-hidden="true"></span><span id="inputError2Status" class="sr-only">(error)</span>');

						}

					})

	$("#remail")
			.change(
					function() {

						/**
						 * 这里写向邮箱发送验证码 ，
						 * 
						 */

						var userInputCode = this.value;
						if (code != null && userInputCode != null) {

							if (code == userInputCode) {
								/**
								 * 验证码与用户输入相等
								 */
								status = true;

								$("#remail").parent().removeClass("has-error")
										.addClass("has-success");
								$("#remail").nextAll().remove();
								$("#remail")
										.parent()
										.append(
												'<span class="glyphicon glyphicon-ok form-control-feedback" aria-hidden="true"></span><span id="inputSuccess2Status" class="sr-only">(success)</span>');

							} else {
								$("#remail").parent()
										.removeClass("has-success").addClass(
												"has-error");
								$("#remail").nextAll().remove();
								$("#remail")
										.parent()
										.append(
												'<span class="glyphicon glyphicon-remove form-control-feedback" aria-hidden="true"></span><span id="inputError2Status" class="sr-only">(error)</span>');

							}

						}

					});

	$("#sendCode").click(function() {

		var time = 60;
		$(this).attr("disabled", "disabled");
		var timDemo = setInterval(function() {

			$("#sendCode").text((time--) + "秒后重试");

			if (time < 0) {
				// 六十秒走完 移除disabled属性
				$("#sendCode").removeAttr("disabled");
				time = 60;
				$("#sendCode").text("发送");
				clearInterval(timDemo);// 停止计时事件
			}

		}, 1000);

		/**
		 * 发送验证码按钮被单击
		 */
		if (email != null) {

			/**
			 * 调用后台程序发送验证码
			 */

			$.ajax({

				cache : false,

				type : "post",

				url : "sendEmail",// 请求发送验证码邮件

				data : {
					email : email
				},// 要发送的数据

				async : false,

				error : function(request) {

					alert("发送请求失败！");

				},

				success : function(data) {
					var tmp = data.trim();
					if (tmp.length == 4) {
						code = tmp
					} else {
						alert("错误");
					}

				}

			});

		}

	});

	/**
	 * AJAX提交数据
	 * 
	 */

	$("#one").click(function() {

		/**
		 * 此处当且用户名密码邮箱地址不为空的情况下才进行提交
		 */

		yue = $("#yue").prop("checked");

		if (name == null) {
			alert("请检查用户名格式");
		} else if (password == null) {
			alert("请检查密码格式");
		} else if (email == null) {
			alert("请检查邮箱格式");
		} else if (status == false) {
			alert("请检查验证码");
		} else if (!yue) {
			alert("请同意网站相关约束");
		} else {

			$.ajax({

				cache : false,

				type : "POST",

				url : "userRegister",

				data : {
					'u_name' : name,
					'u_password' : password,
					'u_email' : email
				},// 要发送的数据

				async : false,

				error : function(request) {
					alert("发送请求失败！");
				},
				success : function(data) {
					
					if (data !="") {
						alert("恭喜你注册成功");
						/**
						 * 跳转页面，保存cookie
						 */
						// cookie保存到路径为index.html页面
						setCookie("user", name, 1);
						setCookie("userId", data.u_id, 1);
						$(location).attr('href', '/music/index.html');
					} else {
						alert("注册失败，用户名重复");
					}

				}

			});

		}

	});

	function setCookie(cname, cvalue, exdays) {
		var d = new Date();
		d.setTime(d.getTime() + (exdays * 24 * 60 * 60 * 1000));
		var expires = "expires=" + d.toGMTString();
		document.cookie = cname + "=" + cvalue + "; " + expires + ";path=/";
	}

})