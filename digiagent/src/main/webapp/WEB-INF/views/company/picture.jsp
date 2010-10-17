<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page pageEncoding="UTF-8"%>
<%@ page session="true"%>
<%@ include file="/common/taglibs.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>资质认证</title>
<link href="${ctx}/styles/main.css" rel="stylesheet" type="text/css" />
<script src="${ctx}/scripts/common/common.js"></script>
<script src="${ctx}/scripts/Calendar.js"></script>
<script src="${ctx}/scripts/menu.js"></script>
<script type="text/javascript" src="${ctx}/scripts/jquery-1.4.2.min.js"></script>
<script type="text/javascript" src="${ctx}/scripts/jquery.form.js"></script>
<script>
function PreviewImg(imgFile, targetImage){  
	var targetId = "#"+targetImage;
	$(targetId).empty();
	var targetImage = document.getElementById(targetImage);
    var imgDiv = document.createElement("div");
    document.body.appendChild(imgDiv);
    imgDiv.style.width = "80px";    imgDiv.style.height = "80px";
    imgDiv.style.filter="progid:DXImageTransform.Microsoft.AlphaImageLoader(sizingMethod = scale)";   
    imgDiv.filters.item("DXImageTransform.Microsoft.AlphaImageLoader").src = imgFile.value;
    targetImage.appendChild(imgDiv);    
    targetImage.style.width = "80px";
    targetImage.style.height = "60px";
}

$(document).ready(function() {
	var url = "../supplier/getImage1?id=${supplierId}&uuid=" + createUUID();
	$('#image1').empty().append('<img id="pic" width="100" height="100" src="'+url+'"/>');
	var url = "../supplier/getImage2?id=${supplierId}&uuid=" + createUUID();
	$('#image2').empty().append('<img id="pic" width="100" height="100" src="'+url+'"/>');
	formSubmit();
});

//edit event
function formSubmit() {
	$('#supplierForm').ajaxForm({ 
		url: '../supplier/updatePicture',
		beforeSubmit: validate, 
		dataType:  'html', 
      success:   processJson,
      error:   function(err){
	    	alert('更新操作失败！');
		} 
	});
}

function validate(formData, jqForm, options) {
	var form = jqForm[0];
	if (form.file1.value != "") {
		var ext = form.file1.value.split('.').pop().toLowerCase(); 
		var allow = new Array('gif','png','jpg','jpeg'); 
		if(form.file1.value.length > 0 && jQuery.inArray(ext, allow) == -1) {
		
		   alert('请选择图片格式为：gif,png,jpg,jpeg！');
		   return false;
		} 
	}
	if (form.file2.value != "") {
		var ext = form.file2.value.split('.').pop().toLowerCase(); 
		var allow = new Array('gif','png','jpg','jpeg'); 
		if(form.file2.value.length > 0 && jQuery.inArray(ext, allow) == -1) {
		
		   alert('请选择图片格式为：gif,png,jpg,jpeg！');
		   return false;
		} 
	}
	$('#image1').append('<image id="loader" src="../images/datagrid/tree_loading.gif"/> ');
	$('#image2').append('<image id="loader" src="../images/datagrid/tree_loading.gif"/> ');
}
/**
* 字符串转JSON对象
* @param strData
* @return
*/
function parseObj(strData){
	return (new Function( "return " + strData ))();
}

function processJson(data) {
	data = parseObj($(data).text().replace(/=/g,":"));
  if (data.supplierId == -2) {
  	$('#loader').remove();
		alert('商品图片大小应小于65K，请重新操作！');
  	return;
  }
  alert('更新成功！');
  window.location.href = '${ctx}/company/picture';
}
</script>
</head>
<body>
<div class="companyTitle">资质认证</div>
<div id="companyLeft">
<form id="supplierForm" action="supplier/updatePicture" method="post" enctype="multipart/form-data">
<table width="80%" border="0" align="center" cellpadding="0"
	cellspacing="0">
	<tr>
		<td colspan="2"><strong> <c:if
			test="${not empty message}">
			<fmt:message key="${message.text}" />
		</c:if> </strong></td>
	</tr>
	<tr>
		<td>实名认证</td>
	</tr>
	<tr>
		<td>
			<input type="file" name="file1" id="file1" onchange="javascript:PreviewImg(this, 'image1')"/> 
	          <div id="image1"/>
		</td>
	</tr>
	<tr>
		<td>资质认证</td>
	</tr>
	<tr>
		<td>
			<input type="file" name="file2" id="file2" onchange="javascript:PreviewImg(this, 'image2')"/> 
	          <div id="image2"/>
		</td>
	</tr>
	<tr>
		<td></td>
	</tr>
	<tr>
		<td colspan="8" align="center">
			<span class="headCity">
					<input type="hidden" name="supplierId" value="${supplierId }"/>
					<input class="btn_login" type="submit" value="确认" />
			</span>
		</td>
		<td>
		</td>
		
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