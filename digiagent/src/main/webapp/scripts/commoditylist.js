/**
 * 全局变量定义
 */
var prefix = "";
var productName = "";
var commodityType = "";
var pageNum;
var prefix;

/**
 * 验证输入页码
 * @param oInput
 * @return
 */
function CheckInputInt(oInput)
{
    if('' != oInput.value.replace(/\d{1,}/,''))
    {
        oInput.value = oInput.value.match(/\d{1,}/) == null ? '' :oInput.value.match(/\d{1,}/);
    }
}
/**
 * 跳页
 * @param obj
 * @param totalPage
 * @return
 */
function go(obj, commodityType, totalPage) {
	if (obj.value - 0 > totalPage) {
		obj.value = totalPage;
    }
	if (obj.value - 0 < 1) {
		obj.value = 1;
    }
	queryCommodityList(obj.value, commodityType, prefix, productName);
}

/**
 * 翻页
 * @param pageNum
 * @param commodityType
 * @return
 */
function skip(pageNum, commodityType) {
	queryCommodityList(pageNum, commodityType, prefix, productName);
}

/**
 * 查询商品信息列表
 * @param pageNum
 * 		跳转页码
 * @param commodityType
 * 		商品类型
 * @param isParentPath
 * 		是否上级路径
 * @return
 */
function queryCommodityList(pageNum, commodityType, isParentPath, _productName) {
	productName = _productName;
	if (isParentPath) {
		prefix = "../";
	}
	this.commodityType = commodityType;
	this.pageNum = pageNum;
	$.ajax({
		url:prefix + "commodity/queryCommodityList",
		dataType:"json",
		data: {page:pageNum, commodityType:commodityType, activeFlag:'Y', productName:productName},
		type: "GET",
		success: result,
		error: function(xhr, ajaxOptions, thrownError){
	        alert("数据读取失败！");
	    }
	});
}

var result = function(data) {
	if (commodityType == 'S') {
		$('#commodityS').next().empty();
		$('#commodityS').empty();
		$('.link1 div').eq(5).hide();
		$('.link1 div').eq(6).hide();
		$('.link1 div').eq(7).hide();
		$('.link1 div').eq(9).hide();
	}
	if (commodityType == 'P') {
		$('#commodityP').next().empty();
		$('#commodityP').empty();
		$('.link1 div').eq(5).show();
		$('.link1 div').eq(6).show();
		$('.link1 div').eq(7).show();
		$('.link1 div').eq(9).show();
	}
	if (data.total==0) return;
	var result = jQuery.parseJSON(data.resultList);
	if (result.length == 0) return;
	$.each(result, function(index, commodity) {
		$('#companyLeft').css('height', 250);
		var str = $('#commodityTemplate').html();
		str = str.replace('rowNum', (pageNum - 1) * 10 + index + 1);
		str = str.replace(/categoryName/g, commodity.categoryName == null ? '暂无' : commodity.categoryName);
		str = str.replace(/productName/g, commodity.productName == null ? '暂无' : commodity.productName);
		str = str.replace(/commodityName/g, commodity.commodityName == null ? '暂无' : commodity.commodityName);
		str = str.replace(/commodityPrice/, commodity.commodityPrice == null ? '暂无' : commodity.commodityPrice);
		str = str.replace(/commodityPrice/, commodity.commodityPrice == null ? '暂无' : commodity.commodityPrice);
		str = str.replace(/commodityPriceOld/, commodity.commodityPriceOld == null ? '暂无' : commodity.commodityPriceOld);
		if (commodity.imageId == null) {
			str = str.replace(/imageSrc/g, prefix + "images/common/nopic.jpg");
		} else {
			str = str.replace(/imageSrc/g, prefix + "commodity/getImage?id=" + commodity.imageId + "&uuid=" + createUUID());
		}
		str = str.replace(/supplierContactname/g, commodity.supplierContactname == null ? '暂无' : commodity.supplierContactname);
		str = str.replace(/supplierMobile/g, commodity.supplierMobile == null ? '暂无' : commodity.supplierMobile);
		str = str.replace(/supplierTelephone/g, commodity.supplierTelephone == null ? '暂无' : commodity.supplierTelephone);
		str = str.replace(/supplierAddress/g, commodity.supplierAddress == null ? '暂无' : commodity.supplierAddress);
		str = str.replace(/userEmail/g, commodity.userEmail == null ? '暂无' : commodity.userEmail);
		str = str.replace(/commodityDescription/g, commodity.commodityDescription == null ? '暂无' : commodity.commodityDescription);
		if (commodityType == 'S') {
			$('#commodityS').append('<div class="supplierInfo">' + str + '</div>');
		}
		if (commodityType == 'P') {
			$('#commodityP').append('<div class="supplierInfo">' + str + '</div>');
		}
    });
	var totalPage = Math.ceil(data.total/10.0);
	var prePageNum = (pageNum - 1 < 1) ? 1 : pageNum - 1;
	var nextPageNum = (pageNum + 1 > totalPage) ? totalPage : pageNum + 1;
	if (commodityType == 'S') {
		$('#commodityS').next().empty().append('<span style="padding-left:100px"></span><a href="javascript:void(0)" onclick="skip(1, \''+commodityType+'\')">首页</a>&nbsp;<a href="javascript:void(0)" onclick="skip('+prePageNum+', \''+commodityType+'\')">前一页</a>&nbsp;共<input type="text" name="pageNum" size=2 value="'+pageNum+'" onkeyup="CheckInputInt(this);" onchange="go(this, \''+commodityType+'\', '+totalPage+');"/>/' + totalPage + '页&nbsp;<a href="javascript:void(0)" onclick="skip('+nextPageNum+', \''+commodityType+'\')">后一页</a>&nbsp;<a href="javascript:void(0)" onclick="skip('+totalPage+', \''+commodityType+'\')">尾页</a>&nbsp;共'+data.total+'条记录');
		$(".oldPrice").hide();
	}
	if (commodityType == 'P') {
		$('#commodityP').next().empty().append('<span style="padding-left:100px"></span><a href="javascript:void(0)" onclick="skip(1, \''+commodityType+'\')">首页</a>&nbsp;<a href="javascript:void(0)" onclick="skip('+prePageNum+', \''+commodityType+'\')">前一页</a>&nbsp;共<input type="text" name="pageNum" size=2 value="'+pageNum+'" onkeyup="CheckInputInt(this);" onchange="go(this, \''+commodityType+'\', '+totalPage+');"/>/' + totalPage + '页&nbsp;<a href="javascript:void(0)" onclick="skip('+nextPageNum+', \''+commodityType+'\')">后一页</a>&nbsp;<a href="javascript:void(0)" onclick="skip('+totalPage+', \''+commodityType+'\')">尾页</a>&nbsp;共'+data.total+'条记录');
		$(".oldPrice").show();
	}
}

var commoditySearch = function(event) {
	commodityType = event.data.commodityType;
	var kw;
	prefix = '';
	pageNum = 1;
	if (commodityType == 'P') {
		kw = $('input[name="searchP"]').val();
	} else if (commodityType == 'S') {
		kw = $('input[name="searchS"]').val();
	}
	$.ajax({
		url:prefix + "commodity/queryCommodityList",
		dataType:"json",
		data: {page:pageNum, commodityType:commodityType, activeFlag:'Y', productName:'', kw:encodeURI(kw)},
		type: "GET",
		success: result,
		error: function(xhr, ajaxOptions, thrownError){
	        alert("数据读取失败！");
	    }
	});
}
/**
 * 页面初始化
 */
$(document).ready(function() {
	$('#commodityTemplate').css('display', 'none');
	$('input[name="btnP"]').bind('click', {commodityType:'P'}, commoditySearch);
	$('input[name="btnS"]').bind('click', {commodityType:'S'}, commoditySearch);
});