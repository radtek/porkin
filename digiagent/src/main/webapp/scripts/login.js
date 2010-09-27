/**
 * 登录
 * @param username
 * @param password
 * @return
 */
function login(username,password) {
	$.ajax({
		url: "security/login",
		dataType: "text",
		type: "POST",
		data:{username:username, password:password},
		success: function(data) {
			if(data==null){
				alert("用户名或密码错误！");
			}
			else{
				alert(22);
				//window.location.href("/");
			}		
		},
		error: function(xhr, ajaxOptions, thrownError){
			 alert("数据读取失败！");
        }
	});
}
/**
 * 验证
 * @return
 */
function validate() {
	var username = $("input[name='username']").val();
	var password = $("input[name='password']").val();
	login(username, password);
}