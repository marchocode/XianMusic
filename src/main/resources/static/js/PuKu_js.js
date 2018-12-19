var index = 1;
$(function() {

	
	load(index);

})

function load(index) {
	
	$("#inde").text(index);

	$
			.ajax({

				type : "get",

				data : {
					index : index
				},

				url : "findAllPu",

				async : false,

				error : function(request) {
					alert("发送请求失败！");
				},
				success : function(data) {

					for (var i = 0; i < data.length; i++) {
						var html = "<a href='../html/quku.html?id="
								+ data[i].pu_id
								+ "' class='list-group-item'>"
								+ "<span class='glyphicon glyphicon-music' aria-hidden='true'></span> "
								+ data[i].singer.s_name + "—" + data[i].pu_name
								+ "" + "<span class='badge'>" + data[i].pu_drop
								+ "</span></a>";

						$("#yue").append(html);
					}
				}

			});

}

$("#next").click(function() {
	$("#yue").empty();
	load(++index);

});
$("#before").click(function() {
	
	if (index !=1) {
		$("#yue").empty();
		load(--index);
	}

});