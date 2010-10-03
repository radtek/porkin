<%@page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<script type="text/javascript" src="scripts/jquery-1.4.2.min.js"></script>
<script>
$(document).ready(function() {
	$(".blk2 li").bind("click", tabChange);
});

var tabChange = function(event) {
	var index = $("li").index(this);
	switch (index) {
	case 0:
		$("#myframe").attr('src','personInfo');
		break;
	case 1:
		alert("暂未开通此功能！");
		break;
	case 2:
		alert("暂未开通此功能！");
		break;
	case 3:
		$("#myframe").attr('src','infoRelease');
		break;
	default:
		alert("暂未开通此功能！");
		break;
	}
};
</script>
<title>个人会员</title>
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
<div id=dfleft>
<div class=sidebar>
    <div class=blk>
    <h3>用户操作</h3>
        <div class=c>                   
            <div class=blk2>                       
                <ul>
                  <li><b><a href="javascript:void(0)">基本信息 </a></b></li>
                  <li><b><a href="javascript:void(0)">密码管理 </a></b></li>
                  <li><b><a href="javascript:void(0)">电子邮件 </a></b></li>
                  <li><b><a href="javascript:void(0)">二手发布 </a></b></li>
                  <li><b><a href="javascript:void(0)">二手历史</a></b></li>
                </ul>
            </div>
        </div>
    </div>
</div>
</div>
    <iframe name="framename" id="myframe" src="personInfo" width="70%" onload="parent.document.all('myframe').style.height=document.body.scrollHeight;"></iframe>
	</body>
</html>
