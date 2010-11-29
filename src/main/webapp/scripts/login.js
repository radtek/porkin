/**
 * 登录
 * @param username
 * @param password
 * @return
 */
function login(url) {
	var username = $("input[name='username']").val();
	var password = $("input[name='password']").val();
	var type = $("select[name='type']").val();
	if (type == "") {
		alert("请选择通行证!");
		return;
	}
	$.ajax({
		url: "/digiagent/login",
		dataType: "text",
		type: "POST",
		data:{username:username, password:password, type:type},
		success: function(data) {

			if(data == "success"){
				//window.location.reload();
				window.parent.location.href= url;
			}
			else{
				alert("用户名或密码错误！");
			}		
		},
		error: function(xhr, ajaxOptions, thrownError){
			 alert("数据读取失败！");
        }
	});
}
