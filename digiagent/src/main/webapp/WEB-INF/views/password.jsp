<%@page contentType="text/html;charset=UTF-8"%>
<%@page pageEncoding="UTF-8"%>
<%@ page session="true" %>
<%@ include file="/common/taglibs.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>商讯网--用户注册</title>
<link href="${ctx}/styles/main2.css" rel="stylesheet" type="text/css">
</head>

<body>

<!-- head -->
<table border="0" cellspacing="0" cellpadding="0" width="1000" align="center">
  <tr>
    <td height="74" rowspan="2" width="420"><img src="images/head_pic01.gif" /></td>
    <td height="36" valign="top" colspan="2"><table border="0" cellspacing="0" cellpadding="0" align="right">
	  <tr valign="bottom">
		<td><a href="#" class="Ahead">首页</a></td>
		<td><img src="images/head_line.gif" /></td>
		<td><a href="#" class="Ahead">关于我们</a></td>
		<td><img src="images/head_line.gif" /></td>
		<td><a href="#" class="Ahead">设为首页</a></td>
		<td><img src="images/head_line.gif" /></td>
	  </tr>
    </table></td>
  </tr>
  <tr>
    <td bgcolor="#ffffff" height="38"><table border="0" cellspacing="0" cellpadding="0">
	  <tr>
		<td class="head_landing_text">切换城市 </td>
		<td width="90"><select name="select" class="head_landing_select">
		</select>
		</td>
		<td class="head_landing_text">用户名 </td>
		<td width="80"><label>
		  <input type="text" name="textfield" class="head_landing_input" />
		</label></td>
		<td class="head_landing_text">密码 </td>
		<td width="80"><label>
		  <input value="" type="password" name="textfield2" class="head_landing_input"  />
		</label></td>
		<td><label>
		  <input value="登录" type="submit" name="Submit" class="btn_02"  />
		</label></td>
		<td width="15"></td>
		<td><a href="#" class="Aorange"><img src="images/dot01.gif" /> 注册</a> &nbsp; <a href="${ctx}/passwordForm" class="Aorange"><img src="images/dot01.gif" /> 忘记密码</a></td>
	  </tr>
    </table></td>
    <td width="25"><img src="images/head_pic02.gif" /></td>
  </tr>
</table>
<!-- head end -->

<table border="0" cellspacing="0" cellpadding="0" width="100%" align="center">
  <tr><td height="25"></td></tr>
</table>

<!-- center -->
<table width="950" border="0" align="center" cellpadding="0" cellspacing="0">
  <tr>
    <td height="10" width="10"><img src="images/bg_pic00a.gif" /></td>
    <td background="images/bg_pic00e.gif"></td>
    <td width="10"><img src="images/bg_pic00b.gif" /></td>
  </tr>
  <tr>
    <td valign="top" background="images/bg_pic00f.gif" style="padding-top:194px">&nbsp;</td>
    <td bgcolor="#ffffff" valign="top"><table width="800" border="0" align="center" cellpadding="0" cellspacing="0">
	  <tr valign="top">
		<td width="240" rowspan="2"><img src="images/icon_registered.jpg" width="240" height="320" /></td>
		<td class="title_color07"><img src="images/dot03.gif" />&nbsp;&nbsp; 用户注册</td>
	  </tr>
	  <tr valign="top">
	    <td>
		<!-- 注册 -->
		<table width="100%" border="0" cellspacing="0" cellpadding="5" class="text_13size">
          <tr>
            <td width="5" class="text_red">*</td>
            <td width="70"> 用户类型：</td>
            <td width="180"><input type="radio" name="radiobutton" value="radiobutton" />
              个人会员 &nbsp;&nbsp;&nbsp;&nbsp;
              <input type="radio" name="radiobutton" value="radiobutton" />
              企业会员</td>
            <td>&nbsp;</td>
          </tr>
          <tr>
            <td class="text_red">*</td>
            <td>用户账号：</td>
            <td><input type="text" name="textfield3" class="registered_input" /></td>
            <td class="text_gray">请输入6-20位字母数字下划线的组合</td>
          </tr>
          <tr>
            <td class="text_red">*</td>
            <td>输入密码：</td>
            <td><input type="password" name="textfield32" class="registered_input" /></td>
            <td class="text_gray">请输入6-32位字符，不允许空格</td>
          </tr>
          <tr>
            <td class="text_red"></td>
            <td>&nbsp;</td>
            <td><img src="images/icon_password1.gif" /><img src="images/icon_password2.gif" /><img src="images/icon_password3.gif" /></td>
            <td>&nbsp;</td>
          </tr>
          <tr>
            <td class="text_red">*</td>
            <td>确认密码：</td>
            <td><input type="password" name="textfield322" class="registered_input" /></td>
            <td class="text_gray">请重复输入上面的密码</td>
          </tr>
          <tr>
            <td class="text_red">*</td>
            <td>电子邮箱：</td>
            <td><input type="text" name="textfield33" class="registered_input" /></td>
            <td>&nbsp;</td>
          </tr>
          <tr>
            <td class="text_red">*</td>
            <td>验 证 码：</td>
            <td><input type="text" name="textfield34" class="registered_input" /></td>
            <td><img src="images/xx01.jpg" width="100" height="25" align="absbottom" /> <a href="#">换一张</a></td>
          </tr>
          <tr>
            <td></td>
            <td>&nbsp;</td>
            <td colspan="2"><input type="checkbox" name="checkbox" value="checkbox" />
              已阅读并接受<a href="#">商讯网服务协议</a></td>
            </tr>
          <tr>
            <td>&nbsp;</td>
            <td>&nbsp;</td>
            <td height="40" colspan="2"><input type="submit" name="Submit2" value="提 交" class="btn_01" style="width:80px" />
              &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			  <input type="submit" name="Submit22" value="提 交" class="btn_01" style="width:80px" /></td>
            </tr>
        </table>
		<!-- 注册 end -->
		</td>
	    </tr>
	</table>
	<br />
    </td>
	<td background="images/bg_pic00g.gif"></td>
  </tr>
  <tr>
    <td height="10"><img src="images/bg_pic00c.gif" /></td>
    <td background="images/bg_pic00h.gif"></td>
    <td><img src="images/bg_pic00d.gif" /></td>
  </tr>
</table>
<!-- center end -->
<br />

<!-- foot -->
<table border="0" cellspacing="0" cellpadding="0" width="100%">
	<tr><td bgcolor="#cccccc" height="1"></td></tr>
	<tr><td height="30" class="text_foot">&copy; 2011年 商讯网版权所有</td></tr>
</table>
<!-- foot end -->

</body>
</html>
