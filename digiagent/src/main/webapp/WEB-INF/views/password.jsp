<%@page contentType="text/html;charset=UTF-8"%>
<%@page pageEncoding="UTF-8"%>
<%@ page session="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Untitled Document</title>
<link href="../styles/main.css" rel="stylesheet" type="text/css" />
<script src="../scripts/Calendar.js"></script>
<script src="../scripts/menu.js"></script>
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
<div class="headTop">
    <div class="headCity">切换城市           
      <select name="select3" style="width:60px;">
        <option>大连</option>
        <option>上海</option>
        </select>
      您好,用户姓名
      <select name="select4" style="width:80px;">
        <option>个人中心</option>
        </select> 
        <input class="btn_login" type="submit" value="登录" />
    </div>
	<div class="logo"></div>
    <div class="rightLink">登录 | 注册 | 帮助</div>
    <div class="redLine"></div>
</div>

<DIV style="CLEAR: both"></DIV>
</DIV>
</DIV>
<div class="dfcenterTitle">用户找回密码</div>
<div id="loginCenter">
  <table width="60%" border="0" align="center" cellpadding="0" cellspacing="0">
    <tr>
      <td colspan="2"><strong>用户类型</strong></td>
    </tr>
    <tr>
      <td>输入帐号</td>
      <td><input type="text" name="textfield" id="textfield" /></td>
    </tr>
    <tr>
      <td>随机验证</td>
      <td><input type="text" name="textfield3" id="textfield3" /></td>
    </tr>
    <tr>
      <td colspan="2" align="center"><span class="headCity">
        <input class="btn_login" type="submit" value="注册" />
            </span><span class="headCity">
      <input class="btn_login" type="submit" value="取消" />
                  </span></td>
    </tr>
  </table>
  <p class="tagContent">&nbsp;</p>
</div>

</body>
</html>
