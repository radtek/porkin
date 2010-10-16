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
<DIV id=dfleft>
<DIV class=sidebar>
    <DIV class=blk>
    <H3>用户操作</H3>
        <DIV class=c>                   
        <DIV class=blk2>                       
        <UL>
          <LI><b><A href="${ctx}/company/basicInfo" target="mainFrame" title="基本信息">基本信息 </A></b>                 
          <LI><b><A href="${ctx}/company/passwordForm" target="mainFrame" title="密码管理">密码管理</A></b></LI>                  
          <LI><b><A href="${ctx}/company/emailForm" target="mainFrame" title="电子邮件">电子邮件</A></b></LI>
          <LI><b><A href="${ctx}/company/introductionForm" target="mainFrame" title="公司简介">公司简介</A></b></LI>
          <LI><b><A href="${ctx}/company/contact/list" target="mainFrame" title="联系方式">联系方式</A></b></LI>
          <LI><b><A href="${ctx}/company/agent?page=1" target="mainFrame" title="代理申请">代理申请</A></b></LI>
          <LI><b><A href="right.html" target="mainFrame">资质认证</A></b></LI>
          <LI><b><A href="${ctx}/company/infoRelease" target="mainFrame" title="促销发布">促销发布</A></b></LI>
          <LI><b><A href="${ctx}/company/commodityList" target="mainFrame" title="促销历史">促销历史</A></b></LI>
        </UL>
        </DIV>
        </DIV>
    </DIV>
   
</DIV>
</DIV>
</body>
</html>