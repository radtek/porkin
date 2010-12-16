function addTab(title, url){
    if ($('#mytab').tabs('exists', title)){
        $('#mytab').tabs('select', title);
    } else {
        var content = '<iframe scrolling="auto" frameborder="0"  src="'+url+'" style="width:100%;height:100%;"></iframe>';
        $('#mytab').tabs('add',{
            title:title,
            content:content,
            closable:true
        });
    }
}

$(document).ready(function() {
	$('#menuAccordion').accordion({
		onSelect:function(title) {
			switch (title) {
			case "基础数据":
				basicFunction();
				break;
			case "Basic data":
				basicFunction();
				break;
			case "报表管理":
				reportFunction();
				break;
			case "Report manage":
				reportFunction();
				break;
			case "系统设置":
				systemFunction();
				break;
			case "System config":
				systemFunction();
				break;
			default:
				break;
			}
		}
	});
});

var basicFunction = function() {
	var map = $('#basic').find('.tree-title');
	$.each(map, function(key) {
		if ($(map[key]).text().toLowerCase() == '类别维护') {
			$(map[key]).click(function() {
				addTab($(this).text(), 'category/list');
			});
		}
		if ($(map[key]).text().toLowerCase() == '品牌维护') {
			$(map[key]).click(function() {
				addTab($(this).text(), 'brand/list');
			});
		}
		if ($(map[key]).text().toLowerCase() == '商家维护') {
			$(map[key]).click(function() {
				addTab($(this).text(), 'supplier/list');
			});
		}
		if ($(map[key]).text().toLowerCase() == '国家维护') {
			$(map[key]).click(function() {
				addTab($(this).text(), 'country/list');
			});
		}
		if ($(map[key]).text().toLowerCase() == '省份维护') {
			$(map[key]).click(function() {
				addTab($(this).text(), 'province/list');
			});
		}
		if ($(map[key]).text().toLowerCase() == '城市维护') {
			$(map[key]).click(function() {
				addTab($(this).text(), 'city/list');
			});
		}
		if ($(map[key]).text().toLowerCase() == '产品维护') {
			$(map[key]).click(function() {
				addTab($(this).text(), 'product/list');
			});
		}
		if ($(map[key]).text().toLowerCase() == '品牌与产品关系维护') {
			$(map[key]).click(function() {
				addTab($(this).text(), 'productBrand/list');
			});
		}
		if ($(map[key]).text().toLowerCase() == '商家联系信息维护') {
			$(map[key]).click(function() {
				addTab($(this).text(), 'contact/list');
			});
		}
		if ($(map[key]).text().toLowerCase() == '商家与产品关系维护') {
			$(map[key]).click(function() {
				addTab($(this).text(), 'supplierProduct/list');
			});
		}
		if ($(map[key]).text().toLowerCase() == '商品') {
			$(map[key]).click(function() {
				addTab($(this).text(), 'commodity/list');
			});
		}
		if ($(map[key]).text().toLowerCase() == '排序') {
			$(map[key]).click(function() {
				addTab($(this).text(), 'sortable/0/0');
			});
		}
	});
};

var reportFunction = function() {
	var map = $('#report').find('.tree-title');
	$.each(map, function(key) {
		if ($(map[key]).text().toLowerCase() == '每天') {
			$(map[key]).click(function() {
				addTab($(this).text(), 'report/everyday');
			});
		}
		if ($(map[key]).text().toLowerCase() == '每周') {
			$(map[key]).click(function() {
				addTab($(this).text(), 'report/weekly');
			});
		}
		if ($(map[key]).text().toLowerCase() == '每月') {
			$(map[key]).click(function() {
				addTab($(this).text(), 'report/monthly');
			});
		}
	});
};

var systemFunction = function() {
	var map = $('#system').find('.tree-title');
	$.each(map, function(key) {
		if ($(map[key]).text().toLowerCase() == '用户维护') {
			$(map[key]).click(function() {
				addTab($(this).text(), 'user/list');
			});
		}
	});
};
