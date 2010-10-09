<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page pageEncoding="UTF-8"%>
<%@ page session="true" %>
<%@ include file="/common/taglibs.jsp" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>用户基本信息</title>
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
<div class="companyTitle">用户密码管理</div>
<div id="companyLeft">
<form action="${ctx}/company/chnagepassword" method="post">
  <table width="60%" border="0" align="center" cellpadding="0" cellspacing="0">
<!--    <tr>-->
<!--      <td colspan="2"><strong>用户基本信息</strong></td>-->
<!--    </tr>-->
 	<tr>
      <td></td>
    </tr>
    <tr>
      <td>请输入旧密码</td>
      <td><input type="password" name="oldpassword" id="oldpassword" /></td>
    </tr>
    <tr>
      <td>请输入新密码</td>
      <td><input type="password" name="newpassword1" id="newpassword1" /></td>
    </tr>
    <tr>
      <td>再确认新密码</td>
      <td><input type="password" name="newpassword2" id="newpassword1" /></td>
    </tr>
    <tr>
      <td></td>
    </tr>
    <tr>
      <td colspan="2" align="center"><span class="headCity">
        <input class="btn_login" type="submit" value="提交" />
            </span><span class="headCity">
      <input class="btn_login" type="reset" value="取消" />
                  </span></td>
    </tr>
    <tr>
      <td></td>
    </tr>
  </table>
</form>
  <p class="tagContent">&nbsp;</p>
</div>
</body>
</html>















</body>
</html>
