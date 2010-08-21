// edit event
function formSubmit(actionUrl) {
	// validate
	$('#categoryForm').ajaxForm({ 
		url: actionUrl,
		beforeSubmit: validate, 
		dataType:  'json', 
        success:   processJson 
    }); 
}
// call back
function processJson(data) { 
    if (data.categoryId == -1) {
    	$.messager.alert('消息','类别名已存在，请重新操作！','warning');
    	return;
    }
    var optMsg = "新增成功！";
    if ($('input[name="categoryId"]').val() > 0) {
    	optMsg = "更新成功！";
    }
    $.messager.show({
		title:'消息',
		msg:optMsg,
		timeout:optSuccessTime,
		showType:'slide'
	});
	$('#categoryEdit').dialog('close');
    $('#categoryList').datagrid('reload');
}
// validate method
function validate(formData, jqForm, options) {
	var queryString = $.param(formData);
	var form = jqForm[0]; 
	if (form.categoryName.value.length == 0) {
    	$.messager.alert('消息','请输入类别名！','info');
		form.categoryName.focus();
		return false;
	}
}
function onEditClickHandler(id) {
	$.get('../category/get', { id: id } ,function(data) {
		$('input[name="categoryId"]').val(id);
		$('input[name="categoryName"]').val(data.categoryName);
		$('select[name="activeFlag"]').val(data.activeFlag);
		$('#categoryEdit').css('display','block');
		$('#categoryEdit').dialog({title:'修改', modal: true});
	});
	formSubmit('../category/update');
}

function onDeleteClickHandler(id) {
	$.messager.confirm('消息', '确认要删除该记录吗?', function(r){
		if (r){
			$.get('../category/delete', { id: id } ,function(data) {
				if (data == "success") {
					$.messager.show({
						title:'消息',
						msg:'删除成功！',
						timeout:optSuccessTime,
						showType:'slide'
					});
				    $('#categoryList').datagrid('reload');
				} else if (data == "reference") {
					$.messager.alert('消息','有产品关联此类，暂时无法删除！','warning');
				} else {
					$.messager.alert('消息','删除失败！','error');
				}
			});
		}
	});
}
// list
$(function(){
	// edit
	var lastIndex;
	$('#categoryList').datagrid({
		title:'类别维护',
		iconCls:'icon-edit',
		width:700,
		height:'auto',
		singleSelect:true,
		sortName: 'categoryName',
		sortOrder: 'asc',
		remoteSort: false,
		idField:'categoryId',
		method:'get',
		url:'../category/search',
		queryParams:{categoryName:''},
		pagination:true,
		loadMsg:'数据加载中,请稍候...',
		columns:[[
			{field:'categoryId',title:'编号',width:80,align:'center'},
			{field:'categoryName',title:'类别',width:100,align:'center',sortable:true,
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
					return '<span><image onClick="onEditClickHandler(' + rec['categoryId'] + ')" onmouseover="this.style.cursor=\'pointer\';" src="../images/datagrid/icon_list_edit.gif"/>&nbsp;&nbsp;<image onClick="onDeleteClickHandler(' + rec['categoryId'] + ')" onmouseover="this.style.cursor=\'pointer\';" height="15" width="15" src="../images/datagrid/icon_list_delete.gif"/></span>';
				}
			}
		]],
		rownumbers:true,
		toolbar:[{
				id:'btnadd',
				text:'新增',
				iconCls:'icon-add',
				handler:function(){
					$('input[name="categoryId"]').val('');
					$('input[name="categoryName"]').val('');
					$('select[name="activeFlag"]').val('Y');
					$('#categoryEdit').css('display','block');
					$('#categoryEdit').dialog({title:'新增', modal: true, icon:'icon-add'});
					formSubmit('../category/create');
				}
		}],
		onBeforeLoad:function(){
			$(this).datagrid('rejectChanges');
		},
		onLoadSuccess:function() {
			
		}
	});
	
	$('#categoryList').datagrid('getPager').pagination({
		displayMsg:'显示 {from} 至 {to} 条  共 {total} 条记录',
		afterPageText:'/{pages}',
		beforePageText:'页'
	});
	
});

