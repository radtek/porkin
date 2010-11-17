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
	var actionUrl = "";
	if ($('input[name="categoryName"]').val() == undefined) {
		actionUrl = "../commodity/releaseCommodity";
	} else {
		actionUrl = "../commodity/release";
	}
	$('#commodityForm').ajaxForm({ 
		url: actionUrl,
		beforeSubmit: validate, 
		dataType:  'json', 
        success:   processJson,
        error:   function(err){
        	alert('数据操作失败！');
		} 
	});
}

function validate(formData, jqForm, options) {
	var form = jqForm[0];  
	
	if (form.categoryName == undefined && form.categoryId.value.length == 0) {
    	alert('请选择类别！');
		form.categoryId.focus();
		return false;
	}
	if (form.categoryName != undefined && form.categoryName.value.length == 0) {
		alert('请输入类别！');
		form.categoryName.focus();
		return false;
	}
	if (form.productName == undefined  && form.productId.value.length == 0) {
    	alert('请选择产品！');
		form.productId.focus();
		return false;
	}
	if (form.productName != undefined && form.productName.value.length == 0) {
		alert('请输入产品！');
		form.productName.focus();
		return false;
	}
	if (form.commodityName.value.length == 0) {
    	alert('请输入商品名称！');
		form.commodityName.focus();
		return false;
	}
	if (form.commodityPrice.value.length == 0) {
    	alert('请输入商品单价！');
		form.commodityPrice.focus();
		return false;
	}
	if (!/^\d+\.{0,}\d{0,}$/.test(form.commodityPrice.value)) {
    	alert('商品单价格式错误！');
		form.commodityPrice.focus();
		return false;
	}
	if (form.commodityPriceOld != undefined && form.commodityPriceOld.value > 0 && !/^\d+\.{0,}\d{0,}$/.test(form.commodityPriceOld.value)) {
    	alert('商品原价格式错误！');
		form.commodityPriceOld.focus();
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
    if (data.commodityId == -1) {
		alert('商品已存在，请重新操作！');
    	return;
    }
    if (data.commodityId == -2) {
		alert('商品图片大小应小于65K，请重新操作！');
    	return;
    }
    if (data.commodityId > 0) {
	    alert("发布成功！");
	    $('#commodityId').val(data.commodityId);
	    window.location.href= "../company/basicInfo";
    } else {
    	alert("发布失败！");
    }
}

function setProductSelect(productId) {
	$.ajax({
		url:"../productBrand/getProductList",
		data:"id=" + $('select[name="categoryId"]').val(),
		dataType:"html",
		type: "GET",
		success: function(data) {
			$('select[name="productId"]').empty().append(data).val($('select[name="categoryId"]').val());
		},
		error:function(err) {
	    	alert('数据读取失败！');
		}
	});
	$("input[name='categoryName']").remove();
	$("input[name='productName']").remove();
	//$('select[name="productId"]').attr('disabled', false);
	if ($('select[name="categoryId"]').val() == 9999) {
		$("<input type='text' name='categoryName' maxlength='20' size='20'/>").insertBefore('select[name="categoryId"]');
		$("<input type='text' name='productName' maxlength='20' size='20'/>").insertBefore('select[name="productId"]');
		//$('select[name="productId"]').attr('disabled', true);
	}
}

function setCategorySelect(categoryId, productId) {
	$.ajax({
		url:"../product/getCategoryList",
		dataType:"html",
		type: "GET",
		success: function(data) {
			$('select[name="categoryId"]').empty().append(data).append("<option value='9999'>其它</option>");
			if (productId > 0) {
				setProductSelect(productId);
			}
		},
		error:function(err) {
	    	alert('数据读取失败！');
		}
	});
}

$(document).ready(function() {
	$('select[name="categoryId"]').bind('change', setProductSelect);
	setCategorySelect('', -1);
});
