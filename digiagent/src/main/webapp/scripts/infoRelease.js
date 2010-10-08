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
		url: "../commodity/release",
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