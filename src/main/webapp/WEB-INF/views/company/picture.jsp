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
<script type="text/javascript" src="${ctx}/scripts/common/upload.preview.js"></script>
<script>

$(document).ready(function() {
	var url = "../supplier/getImage1?id=${supplierId}&uuid=" + createUUID();
	$('#image1').attr('src', url);
	var url = "../supplier/getImage2?id=${supplierId}&uuid=" + createUUID();
	$('#image2').attr('src', url);
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
	$('#image1_fake').append('<image id="loader" src="../images/datagrid/tree_loading.gif"/> ');
	$('#image2_fake').append('<image id="loader" src="../images/datagrid/tree_loading.gif"/> ');
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
<style>
#image1_wrapper, #image2_wrapper, #image3_wrapper, #image4_wrapper, #image5_wrapper{   
    display:inline-block;   
    width:300px;   
    height:300px;   
    background-color:#CCC;   
}   
#image1_fake, #image2_fake, #image3_fake, #image4_fake, #image5_fake{ /* 该对象用于在IE下显示预览图片 */   
    filter:progid:DXImageTransform.Microsoft.AlphaImageLoader(sizingMethod=scale);   
}   
#image1_size_fake, #image2_size_fake, #image3_size_fake, #image4_size_fake, #image5_size_fake{ /* 该对象只用来在IE下获得图片的原始尺寸，无其它用途 */   
    filter:progid:DXImageTransform.Microsoft.AlphaImageLoader(sizingMethod=image);     
    visibility:hidden;   
}   
#image1, #image2, #image3, #image4, #image5{ /* 该对象用于在FF下显示预览图片 */   
    width:300px;   
    height:300px;   
}  
</style>
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
		<td>
			<div id="image1_wrapper">  
		        <div id="image1_fake">  
		            <img id="image1" onload="onPreviewLoad(this)"/>  
		        </div>  
		    </div> 
    		<input type="file" name="file1" id="file1" onchange="onUploadImgChange(this, 'image1');"/>
		</td>
	</tr>
	<tr>
		<td>实名认证</td>
	</tr>
	<tr>
		<td>
			<div id="image2_wrapper">  
		        <div id="image2_fake">  
		            <img id="image2" onload="onPreviewLoad(this)"/>  
		        </div>  
		    </div> 
    		<input type="file" name="file2" id="file2" onchange="onUploadImgChange(this, 'image2');"/>
		</td>
	</tr>
	<tr>
		<td>资质认证</td>
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