$("#btnUpdate").click(function() {
	var dataParam = {
		"id": $("#id").val(),
		"name": $("#name").val(),
		"email": $("#email").val(),
		"addr": $("#addr").val(),
		"memo": $("#memo").val(),
		}
		$.ajax({
			type: "put",
			url: "/update/",
			data: JSON.stringify(dataParam),
			contentType:"application/json;charset=utf-8"
			})
			.done(function(){
				alert("수정 성공")
				location.href="/list"
			})
			.fail(function(){
				alert("수정 실패")
			})
			})