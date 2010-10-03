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
	queryCommodityList(obj.value, commodityType);
}

/**
 * 查询商品信息列表
 * @param pageNum
 * 		跳转页码
 * @return
 */
function queryCommodityList(pageNum, commodityType) {
	$.ajax({
		url:"commodity/queryCommodityList",
		dataType:"json",
		data:"page=" + pageNum + "&commodityType=" + commodityType + "&activeFlag=Y",
		type: "GET",
		success: function(data) {
			if (data.total==0) return;
			if (commodityType == 'S') {
				$('#commodityS').empty();
			}
			if (commodityType == 'P') {
				$('#commodityP').empty();
			}
			var result = jQuery.parseJSON(data.resultList);
			if (result.length == 0) return;
			$.each(result, function(index, commodity) {
				var str = $('#commodityTemplate').html();
				str = str.replace('rowNum', (pageNum - 1) * 10 + index + 1);
				str = str.replace(/commodityName/g, commodity.commodityName == null ? '暂无' : commodity.commodityName);
				str = str.replace(/commodityPrice/g, commodity.commodityPrice == null ? '暂无' : commodity.commodityPrice);
				str = str.replace(/imageId/g, commodity.imageId + "&uuid=" + createUUID());
				str = str.replace(/supplierContactname/g, commodity.supplierContactname == null ? '暂无' : commodity.supplierContactname);
				str = str.replace(/supplierMobile/g, commodity.supplierMobile == null ? '暂无' : commodity.supplierMobile);
				str = str.replace(/supplierTelephone/g, commodity.supplierTelephone == null ? '暂无' : commodity.supplierTelephone);
				str = str.replace(/supplierAddress/g, commodity.supplierAddress == null ? '暂无' : commodity.supplierAddress);
				str = str.replace(/userEmail/g, commodity.userEmail == null ? '暂无' : commodity.userEmail);
				if (commodityType == 'S') {
					$('#commodityS').append('<div class="supplierInfo">' + str + '</div>');
				}
				if (commodityType == 'P') {
					$('#commodityP').append('<div class="supplierInfo"c>' + str + '</div>');
				}
		    });
			var totalPage = Math.ceil(data.total/10.0);
			var prePageNum = (pageNum - 1 < 1) ? 1 : pageNum - 1;
			var nextPageNum = (pageNum + 1 > totalPage) ? totalPage : pageNum + 1;
			
			if (commodityType == 'S') {
				$('#commodityS').next().empty().append('<a href="javascript:void(0)" onclick="queryCommodityList(1, \''+commodityType+'\')">首页</a>&nbsp;<a href="javascript:void(0)" onclick="queryCommodityList('+prePageNum+', \''+commodityType+'\')">前一页</a>&nbsp;共<input type="text" name="pageNum" size=2 value="'+pageNum+'" onkeyup="CheckInputInt(this);" onchange="go(this, \''+commodityType+'\', '+totalPage+');"/>/' + totalPage + '页&nbsp;<a href="javascript:void(0)" onclick="queryCommodityList('+nextPageNum+', \''+commodityType+'\')">后一页</a>&nbsp;<a href="javascript:void(0)" onclick="queryCommodityList('+totalPage+', \''+commodityType+'\')">末页</a>&nbsp;共'+data.total+'条记录');
			}
			if (commodityType == 'P') {
				$('#commodityP').next().empty().append('<a href="javascript:void(0)" onclick="queryCommodityList(1, \''+commodityType+'\')">首页</a>&nbsp;<a href="javascript:void(0)" onclick="queryCommodityList('+prePageNum+', \''+commodityType+'\')">前一页</a>&nbsp;共<input type="text" name="pageNum" size=2 value="'+pageNum+'" onkeyup="CheckInputInt(this);" onchange="go(this, \''+commodityType+'\', '+totalPage+');"/>/' + totalPage + '页&nbsp;<a href="javascript:void(0)" onclick="queryCommodityList('+nextPageNum+', \''+commodityType+'\')">后一页</a>&nbsp;<a href="javascript:void(0)" onclick="queryCommodityList('+totalPage+', \''+commodityType+'\')">末页</a>&nbsp;共'+data.total+'条记录');
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