
/**
 * 生成全局唯一ID
 * Creating a UUID
 * @return
 */
function createUUID() {
    // http://www.ietf.org/rfc/rfc4122.txt
    var s = [];
    var hexDigits = "0123456789ABCDEF";
    for (var i = 0; i < 32; i++) {
        s[i] = hexDigits.substr(Math.floor(Math.random() * 0x10), 1);
    }
    s[12] = "4";  // bits 12-15 of the time_hi_and_version field to 0010
    s[16] = hexDigits.substr((s[16] & 0x3) | 0x8, 1);  // bits 6-7 of the clock_seq_hi_and_reserved to 01

    var uuid = s.join("");
    return uuid;
}


function setProvinceSelect(provinceId, cityId) {
	$.ajax({
		url:"../city/getProvinceList",
		dataType:"html",
		type: "GET",
		success: function(data) {
			$('select[name="provinceId"]').empty().append(data).val(provinceId);
			if (cityId > 0) {
				setCitySelect(cityId);
			}
		},
		error:function(err) {
			alert(err);
		}
	});
}

function setCitySelect(cityId) {
	$.ajax({
		url:"../supplier/getCityList",
	    data: "id=" + $('select[name="provinceId"]').val(),
		dataType:"html",
		type: "GET",
		success: function(data) {
			$('select[name="cityId"]').empty().append(data).val(cityId);
		},
		error:function(err) {
	    	$.messager.alert('消息',err,'error');
		}
	});
}

function setCountrySelect(countryId) {
	$.ajax({
		url:"../brand/getCountryList",
		dataType:"html",
		type: "GET",
		success: function(data) {
			$('select[name="countryId"]').empty().append(data).val(countryId);
		},
		error:function(err) {
			$.messager.alert('消息',err,'error');
		}
	});
}

function setProductSelect(productId) {
	$.ajax({
		url:"../productBrand/getProductList",
		data:"id=" + $('select[name="categoryId"]').val(),
		dataType:"html",
		type: "GET",
		success: function(data) {
			$('select[name="productId"]').empty().append(data).val(productId);
		},
		error:function(err) {
	    	$.messager.alert('消息',err,'error');
		}
	});
}

function setProductWinSelect(productId) {
	$.ajax({
		url:"../productBrand/getProductList",
		data:"id=" + $('select[name="categoryIdWin"]').val(),
		dataType:"html",
		type: "GET",
		success: function(data) {
			$('select[name="productIdWin"]').empty().append(data).val(productId);
		},
		error:function(err) {
	    	$.messager.alert('消息',err,'error');
		}
	});
}

function setCategorySelect(categoryId, productId) {
	$.ajax({
		url:"../product/getCategoryList",
		dataType:"html",
		type: "GET",
		success: function(data) {
			$('select[name="categoryId"]').empty().append(data).val(categoryId);
			if (productId > 0) {
				setProductSelect(productId);
			}
		},
		error:function(err) {
	    	$.messager.alert('消息',err,'error');
		}
	});
}


function setCategoryWinSelect(categoryId, productId) {
	$.ajax({
		url:"../product/getCategoryList",
		dataType:"html",
		type: "GET",
		success: function(data) {
			$('select[name="categoryIdWin"]').empty().append(data).val(categoryId);
			if (productId > 0) {
				setProductSelect(productId);
			}
		},
		error:function(err) {
	    	$.messager.alert('消息',err,'error');
		}
	});
}

function setCategoryByProductId(productId) {
	$.get('../product/get', { id: productId } ,function(data) {
		setCategorySelect(data.categoryId, productId);
	});
}

function setBrandSelect(brandId) {
	$.ajax({
		url:"../productBrand/getBrandList",
		data:"id=" + $('select[name="countryId"]').val(),
		dataType:"html",
		type: "GET",
		success: function(data) {
			$('select[name="brandId"]').empty().append(data).val(brandId);
		},
		error:function(err) {
	    	$.messager.alert('消息',err,'error');
		}
	});
}

function setBrandWinSelect(brandId) {
	$.ajax({
		url:"../productBrand/getBrandList",
		data:"id=" + $('select[name="countryIdWin"]').val(),
		dataType:"html",
		type: "GET",
		success: function(data) {
			$('select[name="brandIdWin"]').empty().append(data).val(brandId);
		},
		error:function(err) {
	    	$.messager.alert('消息',err,'error');
		}
	});
}

function setCountrySelect(countryId, brandId) {
	$.ajax({
		url:"../brand/getCountryList",
		dataType:"html",
		type: "GET",
		success: function(data) {
			$('select[name="countryId"]').empty().append(data).val(countryId);
			if (brandId > 0) {
				setBrandSelect(brandId);
			}
		},
		error:function(err) {
	    	$.messager.alert('消息',err,'error');
		}
	});
}


function setCountryWinSelect(countryId, brandId) {
	$.ajax({
		url:"../brand/getCountryList",
		dataType:"html",
		type: "GET",
		success: function(data) {
			$('select[name="countryIdWin"]').empty().append(data).val(countryId);
			if (brandId > 0) {
				setBrandSelect(brandId);
			}
		},
		error:function(err) {
	    	$.messager.alert('消息',err,'error');
		}
	});
}

function setCountryByBrandId(brandId) {
	$.get('../brand/get', { id: brandId } ,function(data) {
		setCountrySelect(data.countryId, brandId);
	});
}


