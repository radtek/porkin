//edit event
function formSubmit(actionUrl) {
	$('#commodityForm').ajaxForm({ 
		url: actionUrl,
		beforeSubmit: validate, 
		dataType:  'json', 
        success:   processJson,
        error:   function(err){
			$('#image').empty();
		} 
	});
}

function validate(formData, jqForm, options) {
	var form = jqForm[0]; 
	if (form.commodityName.value.length == 0) {
    	$.messager.alert('消息','请输入商品名称！','info');
		form.commodityName.focus();
		return false;
	}
	if (form.commodityDescription.value.length == 0) {
    	$.messager.alert('消息','请输入商品描述！','info');
		form.commodityDescription.focus();
		return false;
	}
	if (form.startDate.value.length == 0) {
    	$.messager.alert('消息','请选择开始时间！','info');
		form.startDate.focus();
		return false;
	}
	if (form.endDate.value.length == 0) {
    	$.messager.alert('消息','请选择结束时间！','info');
		form.endDate.focus();
		return false;
	}
	if (form.file.value.length == 0) {
		$.messager.alert('消息','请选择图片！','info');
		form.file.focus();
		return false;
	}
	var ext = form.file.value.split('.').pop().toLowerCase(); 
	var allow = new Array('gif','png','jpg','jpeg'); 
	if(jQuery.inArray(ext, allow) == -1) {
	
	   $.messager.alert('消息','请选择图片格式为：gif,png,jpg,jpeg！','info');
	   return false;
	} 
//	$.messager.alert('消息',"图片大小超过65K，不能上传！",'warning');
//	var oas = new ActiveXObject("Scripting.FileSystemObject");
//	var filePath = form.file.value;
//	var fileContent = oas.getFile(filePath);
//	var fileSize = fileContent.size;
//	alert(fileSize + " bytes");
	$('#image').append('<image src="../images/loader.gif"/> ');
}

function processJson(data) {
    if (data.commodityId == -1) {
		$.messager.alert('消息','商品已存在，请重新操作！','warning');
    	return;
    }
    $.messager.show({
		title:'消息',
		msg:'上传成功！',
		timeout:optSuccessTime,
		showType:'slide'
	});
    $('#commodityId').val(data.commodityId);
    var url = "../commodity/getImage?id=" +data.commodityId;
    $('#image').empty().append('<img  src="'+url+'"/>');
	$('#image').append('<image  onClick="onDeleteClickHandler(' + data.commodityId + ')" onmouseover="this.style.cursor=\'pointer\';" height="15" width="15" src="../images/datagrid/icon_list_delete.gif"/>');
	$('#commodityList').datagrid('reload');
}

function onEditClickHandler(id) {
	$.get('../commodity/get', { id: id } ,function(data) {
		$('input[name="commodityId"]').val(id);
		$('input[name="commodityName"]').val(data.commodityName);
		$('input[name="commodityDescription"]').val(data.commodityDescription);
		$('input[name="startDate"]').val(new Date(data.startDate).format('yyyy/MM/dd'));
		$('input[name="endDate"]').val(new Date(data.endDate).format('yyyy/MM/dd'));
		$('select[name="activeFlag"]').val(data.activeFlag);
		$('#commodityEdit').css('display','block');
		$('#commodityEdit').dialog({title:'修改', modal: true});
		var url = "../commodity/getImage?id=" +id;
		$('#image').empty().append('<img  src="'+url+'"/>');
		$('#image').append('<image  onClick="onDeleteClickHandler(' + id + ')" onmouseover="this.style.cursor=\'pointer\';" height="15" width="15" src="../images/datagrid/icon_list_delete.gif"/>');
	});
	formSubmit('../commodity/update');
}

function onDeleteClickHandler(id) {
	$.messager.confirm('消息', '确认要删除该记录吗?', function(r){
		if (r){
			$.get('../commodity/delete', { id: id } ,function(data) {
				if (data == "success") {
					$('#image').empty();
				    $.messager.show({
						title:'消息',
						msg:'删除成功！',
						timeout:optSuccessTime,
						showType:'slide'
					});
				    $('#commodityList').datagrid('reload');
				} else {
					$.messager.alert('消息','删除失败！','error');
				}
			});
		}
	});
}


//list
$(function(){
	$('#startDate').datebox({
		formatter:function(value) {
		return new Date(value).format('yyyy/MM/dd');
		}
	});
	$('#endDate').datebox({
		formatter:function(value) {
		return new Date(value).format('yyyy/MM/dd');
		}
	});
	// edit
	var lastIndex;
	$('#commodityList').datagrid({
		title:'商品维护',
		iconCls:'icon-edit',
		width:1050,
		height:'auto',
		singleSelect:true,
		sortName: 'commodityName',
		sortOrder: 'asc',
		remoteSort: false,
		idField:'commodityId',
		method:'get',
		url:'../commodity/search',
		queryParams:{commodityName:''},
		pagination:true,
		loadMsg:'数据加载中,请稍候...',
		columns:[[
			{field:'commodityId',title:'编号',width:80,align:'center'},
			{field:'commodityName',title:'商品名称',width:100,align:'center',sortable:true,
				sorter:function(a,b,order){
					return (a>b?1:-1)*(order=='asc'?1:-1);
				}
			},
			{field:'commodityDescription',title:'描述',width:100,align:'center',sortable:true,
				sorter:function(a,b,order){
					return (a>b?1:-1)*(order=='asc'?1:-1);
				}
			},
			{field:'startDate',title:'开始时间',width:130,align:'center',sortable:true,
				sorter:function(a,b,order){
					return (a>b?1:-1)*(order=='asc'?1:-1);
				}
			},
			{field:'endDate',title:'结束时间',width:130,align:'center',sortable:true,
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
					return '<span><image onClick="onEditClickHandler(' + rec['commodityId'] + ')" onmouseover="this.style.cursor=\'pointer\';" src="../images/datagrid/icon_list_edit.gif"/>&nbsp;&nbsp;<image onClick="onDeleteClickHandler(' + rec['commodityId'] + ')" onmouseover="this.style.cursor=\'pointer\';" height="15" width="15" src="../images/datagrid/icon_list_delete.gif"/></span>';
				}
			}
		]],
		rownumbers:true,
		toolbar:[{
				id:'btnadd',
				text:'新增',
				iconCls:'icon-add',
				handler:function(){
					$('input[name="commodityId"]').val('');
					$('input[name="commodityName"]').val('');
					$('input[name="commodityDescription"]').val('');
					$('input[name="startDate"]').val('');
					$('input[name="endDate"]').val('');
					$('input[name="file"]').val('');
					$('#image').empty();
					$('select[name="activeFlag"]').val('Y');
					$('#commodityEdit').css('display','block');
					$('#commodityEdit').dialog({title:'新增', modal: true, icon:'icon-add'});
					formSubmit('../commodity/create');
				}
		}],
		onBeforeLoad:function(){
			$(this).datagrid('rejectChanges');
		},
		onLoadSuccess:function() {
			
		}
	});
	
	$('#commodityList').datagrid('getPager').pagination({
		displayMsg:'显示 {from} 至 {to} 条  共 {total} 条记录',
		afterPageText:'/{pages}',
		beforePageText:'页'
	});
});
