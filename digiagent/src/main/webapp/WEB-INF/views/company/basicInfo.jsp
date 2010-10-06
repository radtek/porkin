<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page pageEncoding="UTF-8"%>
<%@ page session="true" %>
<%@ include file="/common/taglibs.jsp" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Untitled Document</title>
<link href="${ctx}/styles/main.css" rel="stylesheet" type="text/css" />
<script src="${ctx}/scripts/Calendar.js"></script>
<script src="${ctx}/scripts/menu.js"></script>
<script language="javascript">

function whenDelete() {
	var isDelete=true;
	if (!confirm("sure to delete")) {
		isDelete=false;
	}
	window.location = 'contractSearch.html'; 
	return isDelete;
}
</script>
</head>
<body>
<div id="dfright">
	<ul class="userInfo">
    	<li onmousemove=splash(this); ><span class="userInfoBlue">ç¨æ·æµç§°</span><span class="userInfoYellow">Porkin</span></li>
        <li onmousemove=splash(this); ><span class="userInfoBlue">ç¨æ·ç±»å</span><span class="userInfoYellow">é«çº§VIPç¨æ·</span></li>
        <li onmousemove=splash(this); ><span class="userInfoBlue">ä¸æ¬¡ç»å½æ¶é´</span><span class="userInfoYellow">2010-08-25  19:45</span></li>
		<li onmousemove=splash(this); ><span class="userInfoBlue">æ³¨åæ¶é´</span><span class="userInfoYellow">06-05-06   19:45</span></li>
		<li onmousemove=splash(this); ><span class="userInfoBlue">ç»å½æ¬¡æ°</span><span class="userInfoYellow">12</span></li>
    </ul>
</div>

















</body>
</html>
