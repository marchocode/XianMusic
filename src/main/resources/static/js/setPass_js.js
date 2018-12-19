$(function() {

	var password = null;
	var email = getParamer(email);// 取道地址栏的email
	/**
	 * 从地址栏参数里面取得email 保存在变量里面
	 */

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

	$("#one").click(function() {

		/**
		 * 发送请求修改密码 带参数邮箱地址；
		 * 
		 */

		if (email != "" && password != null) {

			$.ajax({

				cache : false,

				type : "GET",

				dataType : "json",

				data : {
					email : email,
					password : password
				},

				url : "/XianMusic/UpdatePass",

				async : false,

				error : function(request) {
					alert("发送请求失败！");
				},
				success : function(data) {
					if (data) {
						alert("修改成功");
						$(location).attr('href', '/XianMusic/html/login.html');
					} else {
						alert("修改失败");
					}
				}

			});
		} else {
			alert("请先填写完整");
		}

	});
})