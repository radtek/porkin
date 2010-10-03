<%@page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href="styles/main.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="scripts/jquery-1.4.2.min.js"></script>
<script type="text/javascript" src="scripts/jquery.form.js"></script>
<script type="text/javascript" src="scripts/Calendar.js"></script>
<style>
li {
	color:#076ac5; width:80px; float:left; padding:5px
}
.link-title {
	padding:10px;font-size:20px;background-color:#076ac5;color:white;font-weight:bold
}
.info-left{  
	line-height:30px; font-size:14px; float:left; width:200px; height:600px;
}
.info-right{  
	line-height:30px; font-size:14px; 
}
#info-content {	
	float: left; width:800px; border:solid 1px #ccc;margin-left:10px;
}
</style>
<script type="text/javascript" language="javascript">
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
function releaseInfo() {
	$('#commodityForm').ajaxForm({ 
		url: "commodity/release",
		beforeSubmit: validate, 
		dataType:  'text', 
        success:   processJson,
        error:   function(err){
        	alert(err);
		} 
	});
}

function validate(formData, jqForm, options) {
	var form = jqForm[0]; 
	if (form.commodityName.value.length == 0) {
    	alert('请输入商品名称！');
		form.commodityName.focus();
		return false;
	}
	if (form.commodityDescription.value.length == 0) {
    	alert('请输入商品描述！');
		form.commodityDescription.focus();
		return false;
	}
	if (form.startDate.value.length == 0) {
    	alert('请选择开始时间！');
		return false;
	}
	if (form.endDate.value.length == 0) {
    	alert('请选择结束时间！');
		return false;
	}
	if (form.startDate.value.replace(/\//g,'') > form.endDate.value.replace(/\//g,'')) {
		alert('开始时间应大于结束时间！');
		return false;
	}
	var ext = form.file1.value.split('.').pop().toLowerCase(); 
	var allow = new Array('gif','png','jpg','jpeg'); 
	if(form.file1.value.length > 0 && jQuery.inArray(ext, allow) == -1) {
	
	   alert('请选择图片1格式为：gif,png,jpg,jpeg！');
	   return false;
	} 
	var ext = form.file2.value.split('.').pop().toLowerCase(); 
	if(form.file2.value.length > 0 && jQuery.inArray(ext, allow) == -1) {
	
	   alert('请选择图片2格式为：gif,png,jpg,jpeg！');
	   return false;
	} 
	var ext = form.file3.value.split('.').pop().toLowerCase(); 
	if(form.file3.value.length > 0 && jQuery.inArray(ext, allow) == -1) {
	
	   alert('请选择图片3格式为：gif,png,jpg,jpeg！');
	   return false;
	} 
	var ext = form.file4.value.split('.').pop().toLowerCase(); 
	if(form.file4.value.length > 0 && jQuery.inArray(ext, allow) == -1) {
	
	   alert('请选择图片4格式为：gif,png,jpg,jpeg！');
	   return false;
	} 
	var ext = form.file5.value.split('.').pop().toLowerCase(); 
	if(form.file5.value.length > 0 && jQuery.inArray(ext, allow) == -1) {
	
	   alert('请选择图片5格式为：gif,png,jpg,jpeg！');
	   return false;
	} 
}

function processJson(data) {
	data = data.replace(/<[^>].*?>/g,"");
    if (data.commodityId == -1) {
		alert('商品已存在，请重新操作！');
    	return;
    }
    if (data.commodityId == -2) {
		alert('商品图片大小应小于65K，请重新操作！');
    	return;
    }
    alert("新增成功！");
    $('#commodityId').val(data.commodityId);
}

//wait for the DOM to be loaded 
$(document).ready(function() {
}); 
</script>
</head>
<body>
<div id="info-content">
	<div class="link-title">二手发布 </div>
	<form id="commodityForm" name="commodityForm" action="commodity/release" method="post" enctype="multipart/form-data">
	<ul class="info-left">
    	<li>商品名称<input type="hidden" name="commodityId" id="commodityId" size="30"/><input type="text" name="commodityName" id="commodityName" size="30"/></li>
        <li>商品单价<input type="text" name="commodityPrice" id="commodityPrice" size="30"/></li>
        <li>开始时间<input type="text" name="startDate" id="startDate" size="30" readonly="readonly" onclick="SelectDate(this,'yyyy/MM/dd');"/></li>
		<li>结束时间<input type="text" name="endDate" id="endDate" size="30" readonly="readonly" onclick="SelectDate(this,'yyyy/MM/dd');"/></li>
		<li>商品描述<textarea name="commodityDescription" id="commodityDescription" cols="50" rows="5"></textarea></li>
		<li><input type="submit" value="发布" onclick="releaseInfo()"/><input type="reset" name="reset" value="取消"/>
					<input type="hidden" name="MAX_FILE_SIZE" value="100000" /> 
					<input type="hidden" name="commodityType" value="S" /></li>
    </ul>
    <ul class="info-right">
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