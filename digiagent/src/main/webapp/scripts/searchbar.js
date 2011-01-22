/**
 * 全局变量
 */
var target = null;
var commodityType = null;
var categoryId = null;
var productBarId = null;
var _categoryId;
var _productId;
var _productBrandId;
/**
 * 提取所有类别列表
 * @return
 */
var getCategoryJson = function(_target) {
	$.ajax({
		url:"searchComponentBar/getCategoryList",
		dataType:"json",
		type: "GET",
		success: function(data) {
			if (data==null) return;
			categoryId = _target + "_categoryBar";
			$('<td background="images/bg_pic05a.gif" width="75"><table border="0" cellspacing="0" cellpadding="0" width="100%"><tr><td height="25" bgcolor="#ffffff" class="title_color01">类别:</td></tr></table></td>').appendTo(_target);
			$('<td class="text_guide"></td>').attr('id', 'categoryDetail').appendTo(_target);
			$.each(data, function(index, category) {
				$('#categoryDetail').append($('<a class="Agray"></a>').attr('href', 'javascript:void(0)').attr('id', category.categoryId).text(category.categoryName).click(function() {
					_categoryId = $(this).attr('id');
					getProductJson($(this).attr('id'));
				}));
				if ((index + 1) < data.length) {
					$('#categoryDetail').append(" | ");
				}
			});
			// 从商家返回再次定位
			if ($('input[name="categoryId"]').val().length > 0) {
				_categoryId =  $('input[name="categoryId"]').val();
				$('input[name="categoryId"]').val('');
				getProductJson(_categoryId);
			}
		},
		error: function(xhr, ajaxOptions, thrownError){
			alert("数据读取失败！");
		}
	});
};


/**
 * 提取所有类别列表
 * @return
 */
var getRankDetail = function(_target) {
	target = _target;
	$.ajax({
		url:"report/rankList",
		dataType:"html/text",
		type: "GET",
		success: function(data) {
			if (data.length==0) return;
			$('#searchBar4').html(data);
		},
		error: function(xhr, ajaxOptions, thrownError){
			alert("数据读取失败！");
		}
	});
};

/**
 * 根据所选类别提取产品列表
 * @return
 */
var getProductJson = function(parentId) {
	$('.supplierInfo').remove();
	$('.brandClass').remove();
	$('.productClass').remove();
	// 促销商品
	if (target == '#searchBar2') {
		$('#commodityP').next().empty();
		$('#commodityP').empty();
	} 
	// 二手商品
	if (target == '#searchBar3') {
		$('#commodityS').next().empty();
		$('#commodityS').empty();
	}
	$.ajax({
		url: "searchComponentBar/getProductList",
		dataType: "json",
		type: "GET",
		data:{categoryId:parentId},
		success: function(data) {
			if (data.length==0) return;
			$('<tr class="productClass"><td height="20"></td></tr>').appendTo(target);
			$('<tr class="productClass" valign="top"><td width="400"><table border="0" cellspacing="0" cellpadding="0" width="100%"><tbody><tr valign="top" id="productTR"><td background="images/bg_pic05a.gif" width="75"><table border="0" cellspacing="0" cellpadding="0" width="100%"><tr><td height="25" bgcolor="#ffffff" class="title_color02">产品:</td></tr></table></td></tr></tbody></table></td></tr>').appendTo(target);
			$('<td class="text_guide productClass"></td>').attr('id', 'productDetail').appendTo('#productTR');
			$.each(data, function(index, product) {
				$('#productDetail').append($('<a class="Agray"></a>').attr('href', 'javascript:void(0)').attr('id', product.productId).text(product.productName).click(function() {
					if (commodityType == null) {
						_productId = $(this).attr('id');
						getBrandJson($(this).attr('id'));
					} else {
						keywork = '';
						queryCommodityList(1, commodityType, false, $(this).attr('id'));
					}
				}));
				if ((index + 1) < data.length) {
					$('#productDetail').append(" | ");
				}
			});
			
			// 从商家返回再次定位
			if ($('input[name="productId"]').val().length > 0) {
				_productId = $('input[name="productId"]').val();
				$('input[name="productId"]').val('');
				getBrandJson(_productId);
			}
		},
		error: function(xhr, ajaxOptions, thrownError){
			alert("数据读取失败！");
		}
	});
};

/**
 * 根据所选产品提取品牌列表
 * @return
 */
var getBrandJson = function(parentId) {
	$('.supplierInfo').remove();
	$('.brandClass').remove();
	$.ajax({
		url: "searchComponentBar/getBrandList",
		dataType: "json",
		type: "GET",
		data: {productId:parentId},
		success: function(data) {
			if (data.length==0) return;
			$('<tr class="brandClass"><td height="20"></td></tr>').appendTo(target);
			$('<tr class="brandClass" valign="top"><td width="400"><table border="0" cellspacing="0" cellpadding="0" width="100%"><tbody><tr valign="top" id="brandTR"><td background="images/bg_pic05a.gif" width="75"><table border="0" cellspacing="0" cellpadding="0" width="100%"><tr><td height="25" bgcolor="#ffffff" class="title_color03">品牌:</td></tr></table></td></tr></tbody></table></td></tr>').appendTo(target);
			$('<td class="text_guide brandClass"></td>').attr('id', 'brandDetail').appendTo('#brandTR');
			$.each(data, function(index, brand) {
				$('#brandDetail').append($('<a class="Agray"></a>').attr('href', 'javascript:void(0)').attr('id', brand.productBrandId).text(brand.brandName).click(function() {
					_productBrandId = $(this).attr('id');
					getSupplierJson($(this).attr('id'));
				}));
				if ((index + 1) < data.length) {
					$('#brandDetail').append(" | ");
				}
			});
			
			// 从商家返回再次定位
			if ($('input[name="productBrandId"]').val().length > 0) {
				_productBrandId = $('input[name="productBrandId"]').val();
				$('input[name="productBrandId"]').val('');
				getSupplierJson(_productBrandId);
			}
		},
		error: function(xhr, ajaxOptions, thrownError){
			alert("数据读取失败！");
		}
	});
};

/**
 * 根据所选品牌提取供应商列表
 * @return
 */
var getSupplierJson = function(parentId) {
	$('.supplierInfo').remove();
	$.ajax({
		url: "searchComponentBar/getSupplierList",
		dataType: "json",
		cache: false,
		type: "GET",
		data: {productBrandId:parentId},
		success: function(data) {
			if (data.length==0) return;
			$.each(data, function(index, supplier) {
				$('<table border="0" cellspacing="0" cellpadding="0" width="620" align="center" class="supplierInfo"></table>').insertAfter('#supplierBR').attr('id', "supplierInfo_" + index).ready(function() {
					// 供应商信息
					$('<tr id="supplierTR_' + index + '"></tr>').appendTo("#supplierInfo_" + index);
					$('<td rowspan="3" width="70" id="image_' + index + '"></td><td rowspan="3" width="15"></td>').appendTo("#supplierTR_" + index);
					$('<img width="70" height="55" class="img_border"/>').attr('src', "supplier/getImage?id=" + supplier.supplierId + '&uuid=' + createUUID()).appendTo('#image_' + index);
					$('<td colspan="2" id="title_' + index + '"></td>').appendTo("#supplierTR_" + index);
					$('<a></a>').attr('target', '_black').attr('href', "supplier/" + supplier.supplierId + "?categoryId=" + _categoryId + "&productId=" + _productId + "&productBrandId=" + _productBrandId).append('<strong>' + supplier.supplierName + '</strong>').appendTo('#title_' + index);
					
					$('<tr><td colspan="2"></td></tr>').text("地址：" + supplier.supplierAddress).appendTo("#supplierInfo_" + index);
					$('<tr id="lastRow_' + index + '"><td width="460" id="contact_' + index + '"></td></tr>').text('电话：' + supplier.supplierTelephone).appendTo("#supplierInfo_" + index);
					$('<td width="75" id="detail_' + index + '"></td>').appendTo("#lastRow_" + index);
					$('<a class="Aorange"></a>').attr('href', "supplier/" + supplier.supplierId).text('>>查看详情').appendTo("#detail_" + index);
					$('<tr><td height="5" colspan="4"></td></tr>').appendTo("#supplierInfo_" + index);
					$('<tr><td height="25" background="images/line_01a.jpg" align="right" colspan="4"><img src="images/line_01b.jpg"></td></tr>').appendTo("#supplierInfo_" + index);
				});
			});
		},
		error: function(xhr, ajaxOptions, thrownError){
			alert("数据读取失败！");
		}
	});
};

var addAD = function(_target) {
	var html = '<tr valign="top"><td width="400"><table border="0" cellspacing="0" cellpadding="0" width="100%"><tbody><tr valign="top" id="categoryTR"></tr></tbody></table><td rowspan="6" width="30"></td><td rowspan="6"><table border="0" cellspacing="0" cellpadding="0"><tr><td class="img_border_w"><img src="images/ad_pic/ad001.jpg" width="180" height="200" /></td></tr></table></td></tr>';
	target = _target;
	$(target).empty();
	$(target).append(html);
}

/**
 * 清空返回定位参数
 * @return
 */
function clearParam() {
	$('input[name="categoryId"]').val('');
	$('input[name="productId"]').val('');
	$('input[name="productBrandId"]').val('');
}