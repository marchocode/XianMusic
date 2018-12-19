$(function() {

	var email = null;
	var code = null;
	var status = false;// 验证码通过

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

	$("#remail")
			.change(
					function() {
						/**
						 * 验证邮箱验证码
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
		/**
		 * 发送验证码按钮被单击
		 */

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

		if (email != null) {

			/**
			 * 调用后台程序发送验证码
			 */

			$.ajax({

				cache : false,

				type : "GET",

				url : "../jsp/ajax_regine_email.jsp",

				data : {
					em : email
				},// 要发送的数据

				dataType : "text",

				async : false,

				error : function(request) {

					alert("发送请求失败！");

				},

				success : function(data) {
					var tmp = data.trim();

					if (tmp.length == 4) {
						code = tmp
					} else {
						alert(tmp);
					}

				}

			});

		}

	});

	$("#one").click(function() {
		/**
		 * 下一步已经被单击
		 */

		if (status) {
			// 跳转到修改密码的页面
			// 参数：?email=.....
			$(location).attr('href', '/XianMusic/html/setPass.html?email='+email);
			
		} else {
			alert("请先通过邮箱验证");
		}

	});

})