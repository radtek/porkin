<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page pageEncoding="UTF-8"%>
<%@ page session="true" %>
<%@ include file="/common/taglibs.jsp" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href="${ctx}/styles/main.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="${ctx}/scripts/jquery-1.4.2.min.js"></script>
<script type="text/javascript" src="${ctx}/scripts/jquery.form.js"></script>
<script type="text/javascript" src="${ctx}/scripts/Calendar.js"></script>
<script type="text/javascript" src="${ctx}/scripts/infoRelease.js"></script>
</head>
<body>
	<div class="companyTitle">促销发布 </div>
	<div id="companyLeft">
	<form id="commodityForm" name="commodityForm" action="commodity/release" method="post" enctype="multipart/form-data">
	<ul style="list-style:none; line-height:30px;">
    	<li>商品名称<input type="hidden" name="commodityId" id="commodityId" size="30"/><input type="text" name="commodityName" id="commodityName" size="30"/></li>
        <li>商品单价<input type="text" name="commodityPrice" id="commodityPrice" size="30"/></li>
        <li>开始时间<input type="text" name="startDate" id="startDate" size="30" readonly="readonly" onclick="SelectDate(this,'yyyy/MM/dd');"/></li>
		<li>结束时间<input type="text" name="endDate" id="endDate" size="30" readonly="readonly" onclick="SelectDate(this,'yyyy/MM/dd');"/></li>
		<li>商品描述<textarea name="commodityDescription" id="commodityDescription" cols="50" rows="5"></textarea></li>
		<li><input type="submit" value="发布" onclick="releaseInfo()"/><input type="reset" name="reset" value="取消"/>
					<input type="hidden" name="MAX_FILE_SIZE" value="100000" /> 
					<input type="hidden" name="commodityType" value="P" /></li>
    </ul>
    <ul style="list-style:none; line-height:30px;">
    	<li>图片1
    		<input type="file" name="file1" id="file1" onchange="javascript:PreviewImg(this, 'image1');"/>
            <div id="image1"></div>
        </li>
        <li>图片2
    		<input type="file" name="file2" id="file2" onchange="javascript:PreviewImg(this, 'image2');"/>
            <div id="image2"></div>
        </li>
        <li>图片3
    		<input type="file" name="file3" id="file3" onchange="javascript:PreviewImg(this, 'image3');"/>
            <div id="image3"></div>
        </li>
        <li>图片4
    		<input type="file" name="file4" id="file4" onchange="javascript:PreviewImg(this, 'image4');"/>
            <div id="image4"></div>
        </li>
        <li>图片5
    		<input type="file" name="file5" id="file5" onchange="javascript:PreviewImg(this, 'image5');"/>
            <div id="image5"></div>
        </li>
    </ul>
    </form>
</div>
</body>
</html>