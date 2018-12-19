$(function() {

	var title;
	var mess;
	var content;
	var image;

	$("#title").change(function() {
		// 判断文章标题
		if ($(this).val() != "") {

			title = $(this).val();
		} else {
			title = null;
		}

	});

	$("#mess").change(function() {
		// 判断文章的简介
		if ($(this).val() != "") {

			mess = $(this).val();
		} else {
			mess = null;
		}

	});

	$("#content").change(function() {
		// 判断文章的简介
		if ($(this).val() != "") {

			content = $(this).val();
		} else {
			content = null;
		}

	});

	$("#butto").click(function() {

		if (title != null && mess != null && content != null) {
			// 当且仅仅不为空的时候
			// 发送ajax请求到指定的页面
			
			var formdata = new FormData();
			formdata.append("title",title);
			formdata.append("message",mess);
			formdata.append("content",content);
			formdata.append("image",$('#image')[0].files[0]);
			//console.log($('#image')[0].files[0]);
			//console.log($('#image'));
			
			$.ajax({

				cache : false,

				type : "POST",

				data : formdata,

				processData : false,
				
				contentType : false,
				
				url : "/XianMusic/UploadText",

				async : false,

				error : function(request) {

					alert("发送请求失败！");
				},
				success : function(data) {
					alert("提交成功，请等待审核");
				}

			});

		}

	})

})