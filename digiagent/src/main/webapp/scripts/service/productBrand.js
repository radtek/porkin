function setProductSelect(productId) {
	$.ajax({
		url:"../productBrand/getProductList",
		dataType:"html",
		type: "GET",
		success: function(data) {
			$('select[name="productId"]').empty().append(data).val(productId);
		},
		error:function(err) {
			alert(err);
		}
	});
}

function setBrandSelect(brandId) {
	$.ajax({
		url:"../productBrand/getBrandList",
		dataType:"html",
		type: "GET",
		success: function(data) {
			$('select[name="brandId"]').empty().append(data).val(brandId);
		},
		error:function(err) {
			alert(err);
		}
	});
}

// edit event
function formSubmit(actionUrl) {
	// validate
	$('#productBrandForm').ajaxForm({ 
		url: actionUrl,
		beforeSubmit: validate, 
		dataType:  'json', 
        success:   processJson 
    }); 
}
// call back
function processJson(data) { 
    if (data.productBrandId == -1) {
    	alert("该品牌的此产品已存在，请重新操作！");
    	return;
    }
	$('#productBrandEdit').dialog('close');
    $('#productBrandList').datagrid('reload');
}
// validate method
function validate(formData, jqForm, options) {
	var queryString = $.param(formData);
	var form = jqForm[0]; 
	if (form.brandId.value.length == 0) {
		alert('请选择品牌！');
		form.brandId.focus();
		return false;
	}
	if (form.productId.value.length == 0) {
		alert('请选择产品！');
		form.productId.focus();
		return false;
	}
}
function onEditClickHandler(id) {
	$.get('../productBrand/get', { id: id } ,function(data) {
		setBrandSelect(data.brandId);
		setProductSelect(data.productId);
		$('input[name="productbrandId"]').val(id);
//		$('input[name="productId"]').val(data.productId);
//		$('input[name="brandId"]').val(data.brandId);
		$('select[name="activeFlag"]').val(data.activeFlag);
		$('#productBrandEdit').css('display','block');
		$('#productBrandEdit').dialog({title:'Edit', modal: true});
	});
	formSubmit('../productBrand/update');
}

	
function onDeleteClickHandler(id) {
	if (confirm("确定要删除该记录吗？")) {
		$.get('../productBrand/delete', { id: id } ,function(data) {
			if (data == "success") {
			    $('#productBrandList').datagrid('reload');
				alert('删除成功！');
			}
		});
	}
}

$(document).ready(function() {
	
});
// list
$(function(){
	setBrandSelect();
	setProductSelect();
	// edit
	var lastIndex;
	$('#productBrandList').datagrid({
		title:'城市维护',
		iconCls:'icon-edit',
		width:950,
		height:'auto',
		singleSelect:true,
		sortName: 'provinceName,productBrandName',
		sortOrder: 'asc,asc',
		remoteSort: false,
		idField:'productBrandId',
		method:'get',
		url:'../productBrand/search',
		queryParams:{productBrandName:''},
		pagination:true,
		loadMsg:'数据加载中,请稍候...',
		columns:[[
			{field:'productbrandId',title:'编号',width:80,align:'center'},
			{field:'brandName',title:'品牌',width:100,align:'center',sortable:true,
				sorter:function(a,b,order){
					return (a>b?1:-1)*(order=='asc'?1:-1);
				}
			},
			{field:'brandEnglish',title:'英文',width:100,align:'center',sortable:true,
				sorter:function(a,b,order){
					return (a>b?1:-1)*(order=='asc'?1:-1);
				}
			},
			{field:'productName',title:'产品',width:100,align:'center',sortable:true,
				sorter:function(a,b,order){
					return (a>b?1:-1)*(order=='asc'?1:-1);
				}
			},
			{field:'activeFlag',title:'状态',width:100,align:'center',sortable:true,
				sorter:function(a,b,order){
					return (a>b?1:-1)*(order=='asc'?1:-1);
				},
				formatter:function(value,rec){
					if (value == 'Y') {
						return '开启';
					} else {
						return '禁用';
					}
				}
			},
			{field:'createdBy',title:'创建人',width:100,align:'center',sortable:true,
				sorter:function(a,b,order){
				return (a>b?1:-1)*(order=='asc'?1:-1);
			}},
			{field:'createdDate',title:'创建时间',width:130	,align:'center',sortable:true,
					sorter:function(a,b,order){
					return (a>b?1:-1)*(order=='asc'?1:-1);
				}
			},
			{field:'opt',title:'操作',width:100,align:'center',
				formatter:function(value,rec){
					return '<span><image onClick="onEditClickHandler(' + rec['productbrandId'] + ')" onmouseover="this.style.cursor=\'pointer\';" src="../images/datagrid/icon_list_edit.gif"/>&nbsp;&nbsp;<image onClick="onDeleteClickHandler(' + rec['productbrandId'] + ')" onmouseover="this.style.cursor=\'pointer\';" height="15" width="15" src="../images/datagrid/icon_list_delete.gif"/></span>';
				}
			}
		]],
		rownumbers:true,
		toolbar:[{
				id:'btnadd',
				text:'新增',
				iconCls:'icon-add',
				handler:function(){
					// set province list
//			$('<option value=1>11</option><option value=2>22</option>').appendTo($('select[name="provinceId"]'));
					setBrandSelect('');
					setProductSelect('');
					$('input[name="productbrandId"]').val('');
//					$('select[name="productId"]').val('');
//					$('select[name="brandId"]').val('');
					$('select[name="activeFlag"]').val('Y');
					$('#productBrandEdit').css('display','block');
					$('#productBrandEdit').dialog({title:'Add', modal: true, icon:'icon-add'});
					formSubmit('../productBrand/create');
				}
		}],
		onBeforeLoad:function(){
			$(this).datagrid('rejectChanges');
		},
		onLoadSuccess:function() {
			
		}
	});
	
	$('#productBrandList').datagrid('getPager').pagination({
		displayMsg:'显示 {from} 至 {to} 条  共 {total} 条记录',
		afterPageText:'/{pages}',
		beforePageText:'页'
	});
});