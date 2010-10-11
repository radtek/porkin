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
</head>
<body>
<div id=dfleft>
<div class=sidebar>
    <div class=blk>
    <h3>用户操作</h3>
        <div class=c>                   
            <div class=blk2>                       
                <ul>
                  <li><b><a href="${ctx}/company/basicInfo" target="mainFrame" title="基本信息">基本信息 </a></b></li>
                  <li><b><A href="${ctx}/company/passwordForm" target="mainFrame" title="密码管理">密码管理</A></b></li>
                  <LI><b><A href="${ctx}/company/emailForm" target="mainFrame" title="电子邮件">电子邮件</A></b></LI>
                  <li><b><a href="${ctx}/person/infoRelease" target="mainFrame" title="二手发布 ">二手发布 </a></b></li>
                  <li><b><a href="${ctx}/person/commodityList" target="mainFrame" title="二手历史 ">二手历史</a></b></li>
                </ul>
            </div>
        </div>
    </div>
</div>
</div>
</body>
</html>