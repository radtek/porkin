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
<script type="text/javascript" src="${ctx}/scripts/common/upload.preview.js"></script>
<script type="text/javascript" src="${ctx}/scripts/infoRelease.js"></script>
</head>
<body>
	<div class="companyTitle">二手发布 </div>	
	<div id="companyLeft">
	<form id="commodityForm" name="commodityForm" action="commodity/release" method="post" enctype="multipart/form-data">
	<ul style="list-style:none; line-height:30px;">
		<li>类别<select id="categoryId" name="categoryId"></select></li>
		<li>产品<select id="productId" name="productId"></select></li>
    	<li>商品名称<input type="hidden" name="commodityId" id="commodityId" size="30"/><input type="text" name="commodityName" id="commodityName" size="30"/></li>
        <li>商品单价<input type="text" name="commodityPrice" id="commodityPrice" size="30"/></li>
        <li>开始时间<input type="text" name="startDate" id="startDate" size="30" readonly="readonly" onclick="SelectDate(this,'yyyy/MM/dd');"/></li>
		<li>结束时间<input type="text" name="endDate" id="endDate" size="30" readonly="readonly" onclick="SelectDate(this,'yyyy/MM/dd');"/></li>
		<li>商品描述<textarea name="commodityDescription" id="commodityDescription" cols="50" rows="5"></textarea></li>
		<li><input type="submit" value="发布" onclick="releaseInfo()"/><input type="reset" name="reset" value="取消"/>
					<input type="hidden" name="MAX_FILE_SIZE" value="100000" /> 
					<input type="hidden" name="commodityType" value="S" /></li>
    </ul>
    <ul style="list-style:none; line-height:30px;">
    	<li>图片1
    		<div id="image1_wrapper">  
		        <div id="image1_fake">  
		            <img id="image1" onload="onPreviewLoad(this)"/>  
		        </div>  
		    </div> 
    		<input type="file" name="file1" id="file1" onchange="onUploadImgChange(this, 'image1');"/>
        </li>
        <li>图片2
        	<div id="image2_wrapper">  
		        <div id="image2_fake">  
		            <img id="image2" onload="onPreviewLoad(this)"/>  
		        </div>  
		    </div> 
    		<input type="file" name="file2" id="file2" onchange="onUploadImgChange(this, 'image2');"/>
        </li>
        <li>图片3
        	<div id="image3_wrapper">  
		        <div id="image3_fake">  
		            <img id="image3" onload="onPreviewLoad(this)"/>  
		        </div>  
		    </div> 
    		<input type="file" name="file3" id="file3" onchange="onUploadImgChange(this, 'image3');"/>
        </li>
        <li>图片4
        	<div id="image4_wrapper">  
		        <div id="image4_fake">  
		            <img id="image4" onload="onPreviewLoad(this)"/>  
		        </div>  
		    </div> 
    		<input type="file" name="file4" id="file4" onchange="onUploadImgChange(this, 'image4');"/>
        </li>
        <li>图片5
        	<div id="image5_wrapper">  
		        <div id="image5_fake">  
		            <img id="image5" onload="onPreviewLoad(this)"/>  
		        </div>  
		    </div> 
    		<input type="file" name="file5" id="file5" onchange="onUploadImgChange(this, 'image5');"/>
        </li>
    </ul>
    </form>
</div>
</body>
</html>