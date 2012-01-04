function setCategorySelect(categoryId) {
	$.ajax({
		url:"../product/getCategoryList",
		dataType:"html",
		type: "GET",
		success: function(data) {
			$('select[name="categoryId"]').empty().append(data).val(categoryId);
		},
		error:function(err) {
	    	$.messager.alert('消息',err,'error');
		}
	});
}

// edit event
function formSubmit(actionUrl) {
	// validate
	$('#productForm').ajaxForm({ 
		url: actionUrl,
		beforeSubmit: validate, 
		dataType:  'json', 
        success:   processJson 
    }); 
}
// call back
function processJson(data) { 
    if (data.productId == -1) {
    	$.messager.alert('消息','产品名称已存在，请重新操作！','warning');
    	return;
    }
    var optMsg = "新增成功！";
    if ($('input[name="productId"]').val() > 0) {
    	optMsg = "更新成功！";
    }
    $.messager.show({
		title:'消息',
		msg:optMsg,
		timeout:optSuccessTime,
		showType:'slide'
	});
	$('#productEdit').dialog('close');
    $('#productList').datagrid('reload');
}
// validate method
function validate(formData, jqForm, options) {
	var queryString = $.param(formData);
	var form = jqForm[0]; 
	if (form.categoryId.value.length == 0) {
		$.messager.alert('消息','请选择类别！','info');
		form.categoryId.focus();
		return false;
	}
	if (form.productName.value.length == 0) {
		$.messager.alert('消息','请输入产品名称！','info');
		form.productName.focus();
		return false;
	}
}
function onEditClickHandler(id) {
	$.get('../product/get', { id: id } ,function(data) {
		setCategorySelect(data.categoryId);
		$('input[name="productId"]').val(id);
		$('input[name="productName"]').val(data.productName);
		$('select[name="displayType"]').val(data.displayType);
		$('select[name="activeFlag"]').val(data.activeFlag);
		$('#productEdit').css('display','block');
		$('#productEdit').dialog({title:'修改', modal: true});
	});
	formSubmit('../product/update');
}

	
function onDeleteClickHandler(id) {
	$.messager.confirm('消息', '确认要删除该记录吗?', function(r){
		if (r){
			$.get('../product/delete', { id: id } ,function(data) {
				if (data == "success") {
				    $('#productList').datagrid('reload');
				    $.messager.show({
						title:'消息',
						msg:'删除成功！',
						timeout:optSuccessTime,
						showType:'slide'
					});
				} else if (data == "reference") {
					$.messager.alert('消息','有品牌产品此产品，暂时无法删除！','warning');
				} else {
					$.messager.alert('消息','删除失败！','error');
				}
			});
		}
	});
}

$(document).ready(function() {
	
});
// list
$(function(){
	setCategorySelect();
	// edit
	var lastIndex;
	$('#productList').datagrid({
		title:'产品维护',
		iconCls:'icon-edit',
		width:850,
		height:'auto',
		singleSelect:true,
		sortName: 'categoryName,productName',
		sortOrder: 'asc,asc',
		remoteSort: false,
		idField:'productId',
		method:'get',
		url:'../product/search',
		queryParams:{productName:''},
		pagination:true,
		loadMsg:'数据加载中,请稍候...',
		columns:[[
			{field:'productId',title:'编号',width:80,align:'center'},
			{field:'categoryName',title:'类别',width:100,align:'center',sortable:true,
				sorter:function(a,b,order){
					return (a>b?1:-1)*(order=='asc'?1:-1);
				}
			},
			{field:'productName',title:'产品名称',width:100,align:'center',sortable:true,
				sorter:function(a,b,order){
					return (a>b?1:-1)*(order=='asc'?1:-1);
				}
			},
			{field:'displayType',title:'显示方式',width:100,align:'center',sortable:true,
				sorter:function(a,b,order){
					return (a>b?1:-1)*(order=='asc'?1:-1);
				},
				formatter:function(value,rec){
					if (value == '1') {
						return '导购';
					}
					if (value == '2') {
						return '二手';
					}
					if (value == '3') {
						return '导购+二手';
					}
					if (value == '4') {
						return '促销';
					}
					if (value == '5') {
						return '导购+促销';
					}
					if (value == '6') {
						return '二手+:促销';
					}
					if (value == '7') {
						return '导购+二手+促销';
					}
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
					return '<span><image onClick="onEditClickHandler(' + rec['productId'] + ')" onmouseover="this.style.cursor=\'pointer\';" src="../images/datagrid/icon_list_edit.gif"/>&nbsp;&nbsp;<image onClick="onDeleteClickHandler(' + rec['productId'] + ')" onmouseover="this.style.cursor=\'pointer\';" height="15" width="15" src="../images/datagrid/icon_list_delete.gif"/></span>';
				}
			}
		]],
		rownumbers:true,
		toolbar:[{
				id:'btnadd',
				text:'新增',
				iconCls:'icon-add',
				handler:function(){
					setCategorySelect('');
					$('input[name="productId"]').val('');
					$('select[name="categoryId"]').val('');
					$('input[name="productName"]').val('');
					$('select[name="displayType"]').val('');
					$('select[name="activeFlag"]').val('Y');
					$('#productEdit').css('display','block');
					$('#productEdit').dialog({title:'新增', modal: true, icon:'icon-add'});
					formSubmit('../product/create');
				}
		}],
		onBeforeLoad:function(){
			$(this).datagrid('rejectChanges');
		},
		onLoadSuccess:function() {
			
		}
	});
	
	$('#productList').datagrid('getPager').pagination({
		displayMsg:'显示 {from} 至 {to} 条  共 {total} 条记录',
		afterPageText:'/{pages}',
		beforePageText:'页'
	});
});

function search() {
	var lastIndex;
	var categoryIdVal = $('#categoryId').val() == null ? '' : $('#categoryId').val();
	var productNameVal =$('#productName').val() == null ? '' : $('#productName').val();
	$('#productList').datagrid({
		title:'产品维护',
		iconCls:'icon-edit',
		width:850,
		height:'auto',
		singleSelect:true,
		sortName: 'categoryName,productName',
		sortOrder: 'asc,asc',
		remoteSort: false,
		idField:'productId',
		method:'get',
		url:'../product/search',
		queryParams:{categoryId: categoryIdVal,productName:productNameVal},
		pagination:true,
		loadMsg:'数据加载中,请稍候...',
		columns:[[
			{field:'productId',title:'编号',width:80,align:'center'},
			{field:'categoryName',title:'类别',width:100,align:'center',sortable:true,
				sorter:function(a,b,order){
					return (a>b?1:-1)*(order=='asc'?1:-1);
				}
			},
			{field:'productName',title:'产品名称',width:100,align:'center',sortable:true,
				sorter:function(a,b,order){
					return (a>b?1:-1)*(order=='asc'?1:-1);
				}
			},
			{field:'displayType',title:'显示方式',width:100,align:'center',sortable:true,
				sorter:function(a,b,order){
					return (a>b?1:-1)*(order=='asc'?1:-1);
				},
				formatter:function(value,rec){
					if (value == '1') {
						return '导购';
					}
					if (value == '2') {
						return '二手';
					}
					if (value == '3') {
						return '导购+二手';
					}
					if (value == '4') {
						return '促销';
					}
					if (value == '5') {
						return '导购+促销';
					}
					if (value == '6') {
						return '二手+:促销';
					}
					if (value == '7') {
						return '导购+二手+促销';
					}
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
					return '<span><image onClick="onEditClickHandler(' + rec['productId'] + ')" onmouseover="this.style.cursor=\'pointer\';" src="../images/datagrid/icon_list_edit.gif"/>&nbsp;&nbsp;<image onClick="onDeleteClickHandler(' + rec['productId'] + ')" onmouseover="this.style.cursor=\'pointer\';" height="15" width="15" src="../images/datagrid/icon_list_delete.gif"/></span>';
				}
			}
		]],
		rownumbers:true,
		toolbar:[{
				id:'btnadd',
				text:'新增',
				iconCls:'icon-add',
				handler:function(){
					setCategorySelect('');
					$('input[name="productId"]').val('');
					$('select[name="categoryId"]').val('');
					$('input[name="productName"]').val('');
					$('select[name="displayType"]').val('');
					$('select[name="activeFlag"]').val('Y');
					$('#productEdit').css('display','block');
					$('#productEdit').dialog({title:'新增', modal: true, icon:'icon-add'});
					formSubmit('../product/create');
				}
		}],
		onBeforeLoad:function(){
			$(this).datagrid('rejectChanges');
		},
		onLoadSuccess:function() {
			
		}
	});
	
	$('#productList').datagrid('getPager').pagination({
		displayMsg:'显示 {from} 至 {to} 条  共 {total} 条记录',
		afterPageText:'/{pages}',
		beforePageText:'页'
	});
}