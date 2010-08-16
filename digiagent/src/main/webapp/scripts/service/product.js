function setCategorySelect(categoryId) {
	$.ajax({
		url:"../product/getCategoryList",
		dataType:"html",
		type: "GET",
		success: function(data) {alert(data);
			$('select[name="categoryId"]').empty();
			$('select[name="categoryId"]').append(data).val(categoryId);
		},
		error:function(err) {
			alert(err);
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
    	alert("产品名称已存在，请重新操作！");
    	return;
    }
	$('#productEdit').dialog('close');
    $('#productList').datagrid('reload');
}
// validate method
function validate(formData, jqForm, options) {
	var queryString = $.param(formData);
	var form = jqForm[0]; 
	if (form.categoryId.value.length == 0) {
		alert('请选择类别！');
		form.categoryId.focus();
		return false;
	}
	if (form.productName.value.length == 0) {
		alert('请输入产品名称！');
		form.productName.focus();
		return false;
	}
}
function onEditClickHandler(id) {
	$.get('../product/get', { id: id } ,function(data) {
		setCategorySelect(data.categoryId);
		$('input[name="productId"]').val(id);
		$('input[name="productName"]').val(data.productName);
		$('select[name="activeFlag"]').val(data.activeFlag);
		$('#productEdit').css('display','block');
		$('#productEdit').dialog({title:'Edit', modal: true});
	});
	formSubmit('../product/update');
}

	
function onDeleteClickHandler(id) {
	if (confirm("确定要删除该记录吗？")) {
		$.get('../product/delete', { id: id } ,function(data) {
			if (data == "success") {
			    $('#productList').datagrid('reload');
				alert('删除成功！');
			}
		});
	}
}

$(document).ready(function() {
	
});
// list
$(function(){
	// edit
	var lastIndex;
	$('#productList').datagrid({
		title:'产品维护',
		iconCls:'icon-edit',
		width:850,
		height:'auto',
		singleSelect:true,
		sortName: 'productName',
		sortOrder: 'asc',
		remoteSort: false,
		idField:'productId',
		method:'get',
		url:'../product/search',
//		queryParams:{skipResults:0, maxResults:10},
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
				},
				formatter: function(value,rec){
					return format_cn(value);
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
					// set category list
//			$('<option value=1>11</option><option value=2>22</option>').appendTo($('select[name="categoryId"]'));
					setCategorySelect('');
					$('input[name="productId"]').val('');
					$('select[name="categoryId"]').val('');
					$('input[name="productName"]').val('');
					$('select[name="activeFlag"]').val('Y');
					$('#productEdit').css('display','block');
					$('#productEdit').dialog({title:'Add', modal: true, icon:'icon-add'});
					formSubmit('../product/create');
				}
		}],
		onBeforeLoad:function(){
			$(this).datagrid('rejectChanges');
		},
		onLoadSuccess:function() {
			
		}
	});
	
});