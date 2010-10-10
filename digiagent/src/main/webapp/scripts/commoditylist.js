/**
 * 全局变量定义
 */
var prefix = "";
var productName = "";

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
	$.ajax({
		url:prefix + "commodity/queryCommodityList",
		dataType:"json",
		data: {page:pageNum, commodityType:commodityType, activeFlag:'Y', productName:productName},
		type: "GET",
		success: function(data) {
			if (commodityType == 'S') {
				$('#commodityS').next().empty();
				$('#commodityS').empty();
			}
			if (commodityType == 'P') {
				$('#commodityP').next().empty();
				$('#commodityP').empty();
			}
			if (data.total==0) return;
			var result = jQuery.parseJSON(data.resultList);
			if (result.length == 0) return;
			$.each(result, function(index, commodity) {
				var str = $('#commodityTemplate').html();
				str = str.replace('rowNum', (pageNum - 1) * 10 + index + 1);
				str = str.replace(/categoryName/g, commodity.categoryName == null ? '暂无' : commodity.categoryName);
				str = str.replace(/productName/g, commodity.commodityName == null ? '暂无' : commodity.productName);
				str = str.replace(/commodityName/g, commodity.commodityName == null ? '暂无' : commodity.commodityName);
				str = str.replace(/commodityPrice/g, commodity.commodityPrice == null ? '暂无' : commodity.commodityPrice);
				str = str.replace(/imageSrc/g, prefix + "commodity/getImage?id=" + commodity.imageId + "&uuid=" + createUUID());
				str = str.replace(/supplierContactname/g, commodity.supplierContactname == null ? '暂无' : commodity.supplierContactname);
				str = str.replace(/supplierMobile/g, commodity.supplierMobile == null ? '暂无' : commodity.supplierMobile);
				str = str.replace(/supplierTelephone/g, commodity.supplierTelephone == null ? '暂无' : commodity.supplierTelephone);
				str = str.replace(/supplierAddress/g, commodity.supplierAddress == null ? '暂无' : commodity.supplierAddress);
				str = str.replace(/userEmail/g, commodity.userEmail == null ? '暂无' : commodity.userEmail);
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
				$('#commodityS').next().empty().append('<a href="javascript:void(0)" onclick="skip(1, \''+commodityType+'\')">首页</a>&nbsp;<a href="javascript:void(0)" onclick="skip('+prePageNum+', \''+commodityType+'\')">前一页</a>&nbsp;共<input type="text" name="pageNum" size=2 value="'+pageNum+'" onkeyup="CheckInputInt(this);" onchange="go(this, \''+commodityType+'\', '+totalPage+');"/>/' + totalPage + '页&nbsp;<a href="javascript:void(0)" onclick="skip('+nextPageNum+', \''+commodityType+'\')">后一页</a>&nbsp;<a href="javascript:void(0)" onclick="skip('+totalPage+', \''+commodityType+'\')">尾页</a>&nbsp;共'+data.total+'条记录');
			}
			if (commodityType == 'P') {
				$('#commodityP').next().empty().append('<a href="javascript:void(0)" onclick="skip(1, \''+commodityType+'\')">首页</a>&nbsp;<a href="javascript:void(0)" onclick="skip('+prePageNum+', \''+commodityType+'\')">前一页</a>&nbsp;共<input type="text" name="pageNum" size=2 value="'+pageNum+'" onkeyup="CheckInputInt(this);" onchange="go(this, \''+commodityType+'\', '+totalPage+');"/>/' + totalPage + '页&nbsp;<a href="javascript:void(0)" onclick="skip('+nextPageNum+', \''+commodityType+'\')">后一页</a>&nbsp;<a href="javascript:void(0)" onclick="skip('+totalPage+', \''+commodityType+'\')">尾页</a>&nbsp;共'+data.total+'条记录');
			}
		},
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
});