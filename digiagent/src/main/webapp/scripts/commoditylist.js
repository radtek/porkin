/**
 * 全局变量定义
 */
var prefix = "";
var productId = "";
var commodityType = "";
var pageNum;
var prefix;
var keywork;

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
	queryCommodityList(obj.value, commodityType, prefix, productId);
}

/**
 * 翻页
 * @param pageNum
 * @param commodityType
 * @return
 */
function skip(pageNum, commodityType) {
	queryCommodityList(pageNum, commodityType, prefix, productId);
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
function queryCommodityList(pageNum, commodityType, isParentPath, _productId) {
	productId = _productId;
	if (isParentPath) {
		prefix = "../";
	}
	this.commodityType = commodityType;
	this.pageNum = pageNum;
	$.ajax({
		url:prefix + "commodity/queryCommodityList",
		dataType:"json",
		data: {page:pageNum, commodityType:commodityType, activeFlag:'Y', productId:productId, kw:keywork},
		type: "GET",
		success: result,
		error: function(xhr, ajaxOptions, thrownError){
	        alert("数据读取失败！");
	    }
	});
}

var result = function(data) {
	$('.supplierInfo').remove();
	if (data.total==0) return;
	var result = jQuery.parseJSON(data.resultList);
	if (result.length == 0) return;
	$.each(result, function(index, commodity) {
		$('<table border="0" cellspacing="0" cellpadding="0" width="620" align="center" class="supplierInfo"></table>').insertAfter('#supplierBR').attr('id', "supplierInfo_" + index).ready(function() {
			// 供应商信息
			$('<tr id="supplierTR_' + index + '"></tr>').appendTo("#supplierInfo_" + index);
			$('<td rowspan="11" width="70" id="image_' + index + '"></td><td rowspan="11" width="15"></td>').appendTo("#supplierTR_" + index);
			$('<img width="200" height="200" class="img_border"/>').attr('src',  commodity.imageId == null ? prefix + "images/common/nopic.jpg" : prefix + "commodity/getImage?id=" + commodity.imageId + '&uuid=' + createUUID()).appendTo('#image_' + index);
			$('<td colspan="2" id="title_' + index + '"></td>').appendTo("#supplierTR_" + index);
			$('<tr></tr>').append("<td colspan='2'>类别：" + (commodity.categoryName == null ? '暂无' : commodity.categoryName) + '</td>').appendTo('#title_' + index);
			$('<tr></tr>').append("<td colspan='2'>产品：" + (commodity.productName == null ? '暂无' : commodity.productName) + '</td>').appendTo("#supplierInfo_" + index);
			$('<tr></tr>').append("<td colspan='2'>商品名称：" + (commodity.commodityName == null ? '暂无' : commodity.commodityName) + '</td>').appendTo("#supplierInfo_" + index);
			$('<tr></tr>').append("<td colspan='2'>商品单价：" + (commodity.commodityPrice == null ? '暂无' : commodity.commodityPrice) + '</td>').appendTo("#supplierInfo_" + index);
			if (commodityType == 'P') {
				$('<tr></tr>').append("<td colspan='2'>商品原价：" + (commodity.commodityPriceOld == null ? '暂无' : commodity.commodityPriceOld) + '</td>').appendTo("#supplierInfo_" + index);
			}
			$('<tr></tr>').append("<td colspan='2'>联 系 人：" + (commodity.supplierContactname == null ? '暂无' : commodity.supplierContactname) + '</td>').appendTo("#supplierInfo_" + index);
			$('<tr></tr>').append("<td colspan='2'>联系电话：" + (commodity.supplierMobile == null ? '暂无' : commodity.supplierMobile) + '</td>').appendTo("#supplierInfo_" + index);
			$('<tr></tr>').append("<td colspan='2'>手机号码：" + (commodity.supplierTelephone == null ? '暂无' : commodity.supplierTelephone) + '</td>').appendTo("#supplierInfo_" + index);
			$('<tr></tr>').append("<td colspan='2'>电子邮箱：" + (commodity.supplierAddress == null ? '暂无' : commodity.supplierAddress) + '</td>').appendTo("#supplierInfo_" + index);
			$('<tr></tr>').append("<td colspan='2'>联系地址：" + (commodity.userEmail == null ? '暂无' : commodity.userEmail) + '</td>').appendTo("#supplierInfo_" + index);
			$('<tr></tr>').append("<td colspan='2'>备注：" + (commodity.commodityDescription == null ? '暂无' : commodity.commodityDescription) + '</td>').appendTo("#supplierInfo_" + index);
			$('<tr><td height="5" colspan="4"></td></tr>').appendTo("#supplierInfo_" + index);
			$('<tr><td height="25" background="' + prefix + 'images/line_01a.jpg" align="right" colspan="4"><img src="' + prefix + 'images/line_01b.jpg"></td></tr>').appendTo("#supplierInfo_" + index);
		});
    });
	var totalPage = Math.ceil(data.total/10.0);
	var prePageNum = (pageNum - 1 < 1) ? 1 : pageNum - 1;
	var nextPageNum = (pageNum + 1 > totalPage) ? totalPage : pageNum + 1;
	$('<tr class="supplierInfo"></tr>').append('<td colspan="4" style="text-align:center"><a href="javascript:void(0)" onclick="skip(1, \''+commodityType+'\')">首页</a>&nbsp;<a href="javascript:void(0)" onclick="skip('+prePageNum+', \''+commodityType+'\')">前一页</a>&nbsp;共<input type="text" name="pageNum" size=2 value="'+pageNum+'" onkeyup="CheckInputInt(this);" onchange="go(this, \''+commodityType+'\', '+totalPage+');"/>/' + totalPage + '页&nbsp;<a href="javascript:void(0)" onclick="skip('+nextPageNum+', \''+commodityType+'\')">后一页</a>&nbsp;<a href="javascript:void(0)" onclick="skip('+totalPage+', \''+commodityType+'\')">尾页</a>&nbsp;共'+data.total+'条记录</td>').appendTo("#supplierInfo_0");
}

var commoditySearch = function(event) {
	commodityType = event.data.commodityType;
	var kw;
	prefix = '';
	pageNum = 1;
	if (commodityType == 'P') {
		kw = $('input[name="searchkw"]').val();
	} else if (commodityType == 'S') {
		kw = $('input[name="searchkw"]').val();
	}
	keywork = encodeURI(kw);
	productId = '';
	$.ajax({
		url:prefix + "commodity/queryCommodityList",
		dataType:"json",
		data: {page:pageNum, commodityType:commodityType, activeFlag:'Y', productId:'', kw:keywork},
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
	$('input[name="btnP"]').bind('click', {commodityType:'P'}, commoditySearch);
	$('input[name="btnS"]').bind('click', {commodityType:'S'}, commoditySearch);
});