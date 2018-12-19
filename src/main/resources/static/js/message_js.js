$(function() {

	var email;
	var text;

	$("#exampleInputEmail1")
			.change(
					function() {

						var pattern = /^([a-zA-Z0-9]+[_|\_|\.]?)*[a-zA-Z0-9]+@([a-zA-Z0-9]+[_|\_|\.]?)*[a-zA-Z0-9]+\.[a-zA-Z]{2,3}$/;
						var strEmail = pattern.test(this.value);

						if (strEmail) {

							email = this.value;

							$("#exampleInputEmail1").parent().removeClass(
									"has-error").addClass("has-success");
							$("#exampleInputEmail1").nextAll().remove();
							$("#exampleInputEmail1")
									.parent()
									.append(
											'<span class="glyphicon glyphicon-ok form-control-feedback" aria-hidden="true"></span><span id="inputSuccess2Status" class="sr-only">(success)</span>');

						} else {
							$("#exampleInputEmail1").parent().removeClass(
									"has-success").addClass("has-error");
							$("#exampleInputEmail1").nextAll().remove();
							$("#exampleInputEmail1")
									.parent()
									.append(
											'<span class="glyphicon glyphicon-remove form-control-feedback" aria-hidden="true"></span><span id="inputError2Status" class="sr-only">(error)</span>');

						}

					});

	$("#text").change(function() {

		var te = this.value;

		if (te.length >= 6) {

			text = this.value;

		} else {
			alert("留言字符必须大于6个");
		}

	});
	
	$("#butto").click(function() {
		
		if (email != null && text != null) {
			
			
			/**
			 * ajax提交
			 */
			
			$.ajax({

				cache : false,

				type : "POST",

				url : "../jsp/ajax_message.jsp", // 把表单数据发送到ajax.jsp

				data : {em:email,te:text},// 要发送的数据
				
				dataType:"text",
				
				async : false,

				error : function(request) {

					alert("发送请求失败！");

				},

				success : function(data) {
					var tmp = data.trim();
					alert(tmp);

				}

			});
			
			
			
		} else {
			
			
			alert("请填写完整或者存在错误");
			
			
		}
		
		

	})

})