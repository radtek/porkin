/**
 * 登录
 * @param username
 * @param password
 * @return
 */
function login(url) {
	var username = $("input[name='username']").val();
	var password = $("input[name='password']").val();
	$.ajax({
		url: "login",
		dataType: "text",
		type: "POST",
		data:{username:username, password:password},
		success: function(data) {
			if(data == "success"){
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
