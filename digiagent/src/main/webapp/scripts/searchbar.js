/**
 * 全局变量
 */
var target = null;
var categoryId = null;
var productBarId = null;
var _categoryName;
var _productName;
var _brandName;
/**
 * 提取所有类别列表
 * @return
 */
var getCategoryJson = function(_target) {
	target = _target;
	$(target).empty();
	$.ajax({
		url:"searchComponentBar/getCategoryList",
		dataType:"json",
		type: "GET",
		success: function(data) {
			if (data.length==0) return;
			categoryId = target + "_categoryBar";
			$('<div></div>').attr('id', categoryId.replace(/#/g,'')).empty().append('类别: ').appendTo(target);
			$.each(data, function(index, category) {
				$(categoryId).append($('<a></a>').attr('href', 'javascript:void(0)').text(category.categoryName).click(function() {
					var param = encodeURI($(this).text());
					if (_target == "#searchBar") {
						_categoryName = param;
						clearParam();
					}
					getProductJson(param);
				}));
				if ((index + 1) < data.length) {
					$(categoryId).append(" | ");
				}
			});
			// 从商家返回再次定位
			if (_target == "#searchBar" && $('input[name="categoryName"]').val().length > 0) {
				var param = encodeURI($('input[name="categoryName"]').val());
				_categoryName = $('input[name="categoryName"]').val();
				getProductJson(param);
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
	$(target).empty();
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
var getProductJson = function(categoryName) {
	$('#supplierInfo').remove();
	$('#brandBar').remove();
	$(productBarId).remove();
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
		data:{categoryName:categoryName},
		success: function(data) {
			if (data.length==0) return;
			productBarId = target + "_productBar";
			$('<div></div>').attr('id', productBarId.replace(/#/g,'')).empty().append('<br>产品: ').appendTo(categoryId);
			$.each(data, function(index, product) {
				// 搜索TAB
				if (target == "#searchBar") {
					$(productBarId).append($('<a></a>').attr('href', 'javascript:void(0)').text(product.productName).click(function() {
						var param = encodeURI($(this).text());
						_productName = param;
						clearParam();
						getBrandJson(param);
					}));
				} else {
					// 其它TAB
					$(productBarId).append($('<a></a>').attr('href', 'javascript:void(0)').text(product.productName).click(function() {
						var productName = encodeURI($(this).text());
						var commodityType = "";
						// 促销商品
						if (target == '#searchBar2') {
							commodityType = "P";
						} 
						// 二手商品
						if (target == '#searchBar3') {
							commodityType = "S";
						}
						queryCommodityList(1, commodityType, false, productName);
					}));
				}
				if ((index + 1) < data.length) {
					$(productBarId).append(" | ");
				}
			});
			
			// 从商家返回再次定位
			if (target == "#searchBar" && $('input[name="productName"]').val().length > 0) {
				var param = encodeURI($('input[name="productName"]').val());
				_productName = $('input[name="productName"]').val();
				getBrandJson(param);
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
var getBrandJson = function(productName) {
	$('#supplierInfo').remove();
	$('#brandBar').remove();
	$.ajax({
		url: "searchComponentBar/getBrandList",
		dataType: "json",
		type: "GET",
		data: {productName:productName},
		success: function(data) {
			if (data.length==0) return;
			$('<div id="brandBar"></div>').empty().append('<br>品牌: ').appendTo(productBarId);
			$.each(data, function(index, brand) {
				$('#brandBar').append($('<a></a>').attr('href', 'javascript:void(0)').text(brand.brandName).click(function() {
					var param = encodeURI($(this).text());
					_brandName = param;
					clearParam();
					getSupplierJson(param);
				}));
				if ((index + 1) < data.length) {
					$('#brandBar').append(" | ");
				}
			});
			
			// 从商家返回再次定位
			if (target == "#searchBar" && $('input[name="brandName"]').val().length > 0) {
				var param = encodeURI($('input[name="brandName"]').val());
				_brandName = $('input[name="brandName"]').val();
				getSupplierJson(param);
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
var getSupplierJson = function(brandName) {
	$('#supplierInfo').remove();
	$('#pic').remove();
	$.ajax({
		url: "searchComponentBar/getSupplierList",
		dataType: "json",
		cache: false,
		type: "GET",
		data: {brandName:brandName},
		success: function(data) {
			if (data.length==0) return;
			$('<div id="supplierInfo" style="height:30px;padding:30px"></div>').empty().appendTo(target);
			$.each(data, function(index, supplier) {
				$('<div class="supplierInfo" style="padding-top:30px"></div>').appendTo('#supplierInfo').attr('id', "supplierInfo_" + index).ready(function() {
				});
				// 供应商图片
				$('<div style="float:left"></div>').attr('id', "contentLeft_" + index).appendTo("#supplierInfo_" + index);
				var $enlargedCover = $('<img/>')
				.css('position', 'absolute')
				.css('z-index', 9999)
				.css('cursor', 'pointer')
				.hide()
				.appendTo('body');
				// 供应商信息
				$('<div></div>').attr('id', "contentRight_" + index).appendTo("#supplierInfo_" + index);
				$('<li></li>').attr("id", "supplierName_" + index).appendTo("#contentRight_" + index);
				$("<a>"+supplier.supplierName+"</a>").css('text-decoration','underline').attr('href', "supplier/" + supplier.supplierId + "?categoryName=" + _categoryName + "&productName=" + _productName + "&brandName=" + _brandName).appendTo("#supplierName_" + index);
				$('<li></li>').text("地址：" + supplier.supplierAddress).appendTo("#contentRight_" + index);
				$('<li></li>').attr('id', 'tel_' + index).text("联系电话：" + supplier.supplierTelephone).appendTo("#contentRight_" + index);
				$('<span>>></span>').css('padding-left', '100px').attr('id', 'blank_' + index).appendTo("#tel_" + index);
				$('<a>详情</a>').attr('href', "supplier/" + supplier.supplierId).appendTo("#blank_" + index);
				// 加载放大镜事件驱动
				$('<img id="pic" width="50" height="50"/>').attr('src', "supplier/getImage?id=" + supplier.supplierId + "&uuid=" + createUUID()).appendTo("#contentLeft_" + index);
				/*.click(function(event) {
					var startPos = $(this).offset();
					startPos.width = $(this).width();
					startPos.height = $(this).height();
					var endPos = {};
					endPos.width = startPos.width * 6;
					endPos.height = startPos.height * 6;
					endPos.top = 50;
					endPos.left = ($('body').width() - endPos.width) / 2;
					$enlargedCover.attr('src', $(this).attr('src'))
					.css(startPos)
					.show();
					var performAnimation = function() {
						$enlargedCover.animate(endPos, 'normal',
							function() {
						  $enlargedCover.one('click', function() {
							$enlargedCover.fadeOut();
						  });
						});
					};
					if ($enlargedCover[0].complete) {
					  performAnimation();
					}
					else {
					  $enlargedCover.bind('load', performAnimation);
					}
					event.preventDefault();
				})
				.hover(function() {
					$(this).css('cursor', 'pointer');
				}, function() {
					$(this).css('cursor', '');
				});
				*/
			});
		},
		error: function(xhr, ajaxOptions, thrownError){
			alert("数据读取失败！");
		}
	});
};

/**
 * 页面加载初始化
 */
$(document).ready(function() {
	getCategoryJson('#searchBar');
});

/**
 * 清空返回定位参数
 * @return
 */
function clearParam() {
	$('input[name="categoryName"]').val('');
	$('input[name="productName"]').val('');
	$('input[name="brandName"]').val('');
}