<%@page contentType="text/html;charset=UTF-8"%>
<%@page pageEncoding="UTF-8"%>
<%@ page session="true" %>
<%@ include file="/common/taglibs.jsp" %>

<script language="javascript">
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
		url: "/digiagent/login",
		dataType: "text",
		type: "POST",
		data:{username:username, password:password},
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

function setHomepage()
{
 if (document.all)
    {
        document.body.style.behavior='url(#default#homepage)';
        document.body.setHomePage('http://www.crazymusic.com');
    }
    else if (window.sidebar)
    {
    	if(window.netscape)
    	{
         	try
   			{ 
            	netscape.security.PrivilegeManager.enablePrivilege("UniversalXPConnect"); 
         	} 
         	catch (e) 
         	{ 
    			alert( "该操作被浏览器拒绝，如果想启用该功能，请在地址栏内输入 about:config,然后将项 signed.applets.codebase_principal_support 值该为true" ); 
         	}
    	}
    	var prefs = Components.classes['@mozilla.org/preferences-service;1'].getService(Components. interfaces.nsIPrefBranch);
   	 	prefs.setCharPref('browser.startup.homepage','http://www.carzymusic.com');
 	}
}




function logout() {
	var url = "${ctx}/logout";
	//document.location.href = "${ctx}/logout";
	window.parent.location.href= url;
	//window.location.href=url;
	//window.location.reload();

}

function homepage() {
	var url = "${ctx}/";
	//document.location.href = "${ctx}/logout";
	window.parent.location.href= url;

}

function about() {
	var url = "${ctx}/about";
	//document.location.href = "${ctx}/logout";
	window.parent.location.href= url;

}

function member() {
	window.parent.location.href= "${ctx}/member";
}
</script>
<table border="0" cellspacing="0" cellpadding="0" width="98%" align="center">
  <tr>
    <td height="74" rowspan="2" width="420"><img src="${ctx}/images/head_pic01.gif" /></td>
    <td height="36" valign="top" colspan="2"><table border="0" cellspacing="0" cellpadding="0" align="right">
	  <tr valign="bottom">
		<td><a href="${ctx}/" class="Ahead">首页</a></td>
		<td><img src="${ctx}/images/head_line.gif" /></td>
		<td><a href="${ctx}/about" class="Ahead">关于我们</a></td>
		<td><img src="${ctx}/images/head_line.gif" /></td>
		<td><a onclick="setHomepage();" href="#" class="Ahead">设为首页</a></td>
		<td><img src="${ctx}/images/head_line.gif" /></td>
	  </tr>
    </table></td>
  </tr>
  <tr>
    <td bgcolor="#ffffff" height="38"><table border="0" cellspacing="0" cellpadding="0">
	  <tr>
	  <c:choose>
      	<c:when test="${empty sessionScope.userName}">
		<td class="head_landing_text">切换城市 </td>
		<td width="90">
			<select name="select" class="head_landing_select">
				<option selected>大连</option>
			</select>
		</td>
		
		<form name="loginForm" action="${ctx}/login" method="POST">
		<td class="head_landing_text">用户名 </td>
		<td width="80"><label>
		  <input type="text" name="username" class="head_landing_input" />
		</label></td>
		<td class="head_landing_text">密码 </td>
		<td width="80"><label>
		  <input value="" type="password" name="password" class="head_landing_input"  />
		</label></td>
		<td><label>
		  <input type="button" value="登录" onclick="login(${ctx}/)" class="btn_02"  />
		</label></td>
		<td width="15"></td>
		</form>
		<td><a href="${ctx}/registerForm" class="Aorange"><img src="${ctx}/images/dot01.gif" /> 注册</a> &nbsp; <a href="${ctx}/passwordForm" class="Aorange"><img src="${ctx}/images/dot01.gif" /> 忘记密码</a></td>
		</c:when>
		<c:otherwise>
		<td class="head_landing_text">欢迎您 ，<c:out value="${sessionScope.userName}" /> | <a href="javascript:void(0);" onclick="homepage()"><fmt:message key="label.common.homepage"/></a> | <a href="javascript:void(0);" onclick="member();">会员</a> | <a href="javascript:void(0);" onclick="logout()" ></><fmt:message key="label.common.logout"/></a></td>
		<td width="80"><label>
		  
		</label></td>
		</c:otherwise>
		
		</c:choose>
	  </tr>
    </table></td>
    <td width="25"><img src="${ctx}/images/head_pic02.gif" /></td>
  </tr>
</table>
