var index = 1;

$(function() {

	/**
	 * 请求所有的文章信息，这里涉及到分页问题
	 */

	
	load(index);

})

$("#next").click(function() {
	$("#text").empty();
	load(++index);

});
$("#before").click(function() {
	
	if (index !=1) {
		$("#text").empty();
		load(--index);
	}

});

function load(index) {
	
	$("#inde").text(index);
			$
			.ajax({

				type : "get",

				data : {
					pageIndex : index
				},

				url : "findTextByPageIndex",

				async : false,

				error : function(request) {

					alert("发送请求失败！");

				},

				success : function(data) {

					for (var i = 0; i < data.length; i++) {

						var html = "<div class='media'>"
								+ "<div class='media-left'><a href='#'>"
								+ "<img class='media-object' style='width:64px;' src='../img/TextImg/"
								+ data[i].t_img + "' alt='...'></a></div>"
								+ "<div class='media-body'>"
								+ "<h4 class='media-heading'>"
								+ data[i].t_title
								+ "</h4><a href='../html/showText.html?id="
								+ data[i].t_id + "'>" + data[i].t_bref
								+ "<a/></div></div>";
						$("#text").append(html);

					}

				}

			});

}