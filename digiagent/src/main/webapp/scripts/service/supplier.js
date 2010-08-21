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

// edit event
function formSubmit(actionUrl) {
	// validate
	$('#supplierForm').ajaxForm({ 
		url: actionUrl,
		beforeSubmit: validate, 
		dataType:  'json', 
        success:   processJson 
    }); 
}
// call back
function processJson(data) { 
    if (data.supplierId == -1) {
    	$.messager.alert('消息','商家名称已存在，请重新操作！','warning');
    	return;
    }
    var optMsg = "新增成功！";
    if ($('input[name="supplierId"]').val() > 0) {
    	optMsg = "更新成功！";
    }
    $.messager.show({
		title:'消息',
		msg:optMsg,
		timeout:optSuccessTime,
		showType:'slide'
	});
	$('#supplierEdit').dialog('close');
    $('#supplierList').datagrid('reload');
}
// validate method
function validate(formData, jqForm, options) {
	var queryString = $.param(formData);
	var form = jqForm[0]; 
	if (form.provinceId.value.length == 0) {
		$.messager.alert('消息','请选择省份！','info');
		form.provinceId.focus();
		return false;
	}
	if (form.cityId.value.length == 0) {
		$.messager.alert('消息','请选择城市！','info');
		form.cityId.focus();
		return false;
	}
	if (form.supplierName.value.length == 0) {
		$.messager.alert('消息','请输入商家中文名！','info');
		form.supplierName.focus();
		return false;
	}
}
function onEditClickHandler(id) {
	$.get('../supplier/get', { id: id } ,function(data) {
		$('input[name="supplierId"]').val(id);
		setProvinceByCityId(data.cityId);
		setCitySelect(data.cityId);
		$('input[name="supplierName"]').val(data.supplierName);
		$('select[name="activeFlag"]').val(data.activeFlag);
		$('#supplierEdit').css('display','block');
		$('#supplierEdit').dialog({title:'修改', modal: true});
	});
	formSubmit('../supplier/update');
}

function setProvinceByCityId(cityId) {
	$.get('../city/get', { id: cityId } ,function(data) {
		setProvinceSelect(data.provinceId, cityId);
	});
}

	
function onDeleteClickHandler(id) {
	$.messager.confirm('消息', '确认要删除该记录吗?', function(r){
		if (r){
			$.get('../supplier/delete', { id: id } ,function(data) {
				if (data == "success") {
				    $('#supplierList').datagrid('reload');
				    $.messager.show({
						title:'消息',
						msg:'删除成功！',
						timeout:optSuccessTime,
						showType:'slide'
					});
				} else if (data == "referenceSupplierProduct") {
					$.messager.alert('消息','有商家与产品关系关联此商家，暂时无法删除！','warning');
				} else if (data == "referenceContact") {
					$.messager.alert('消息','有商家联系方式关联此商家，暂时无法删除！','warning');
				} else {
					$.messager.alert('消息','删除失败！','error');
				}
			});
		}
	});
}

$(document).ready(function() {
	$('select[name="provinceId"]').bind('change', setCitySelect);
});
// list
$(function(){
	setProvinceSelect('', -1);
	// edit
	var lastIndex;
	$('#supplierList').datagrid({
		title:'商家维护',
		iconCls:'icon-edit',
		width:950,
		height:'auto',
		singleSelect:true,
		sortName: 'provinceName,cityName,supplierName',
		sortOrder: 'asc,asc,asc',
		remoteSort: false,
		idField:'supplierId',
		method:'get',
		url:'../supplier/search',
		queryParams:{supplierName:''},
		pagination:true,
		loadMsg:'数据加载中,请稍候...',
		columns:[[
			{field:'supplierId',title:'编号',width:80,align:'center'},
			{field:'provinceName',title:'省份',width:100,align:'center',sortable:true,
				sorter:function(a,b,order){
					return (a>b?1:-1)*(order=='asc'?1:-1);
				}
			},
			{field:'cityName',title:'城市',width:100,align:'center',sortable:true,
				sorter:function(a,b,order){
					return (a>b?1:-1)*(order=='asc'?1:-1);
				}
			},
			{field:'supplierName',title:'商家名称',width:100,align:'center',sortable:true,
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
					return '<span><image onClick="onEditClickHandler(' + rec['supplierId'] + ')" onmouseover="this.style.cursor=\'pointer\';" src="../images/datagrid/icon_list_edit.gif"/>&nbsp;&nbsp;<image onClick="onDeleteClickHandler(' + rec['supplierId'] + ')" onmouseover="this.style.cursor=\'pointer\';" height="15" width="15" src="../images/datagrid/icon_list_delete.gif"/></span>';
				}
			}
		]],
		rownumbers:true,
		toolbar:[{
				id:'btnadd',
				text:'新增',
				iconCls:'icon-add',
				handler:function(){
					$('input[name="supplierId"]').val('');
					$('select[name="provinceId"]').val('');
					setProvinceSelect('', -1);
					setCitySelect('');
					$('input[name="supplierName"]').val('');
					$('select[name="activeFlag"]').val('Y');
					$('#supplierEdit').css('display','block');
					$('#supplierEdit').dialog({title:'新增', modal: true, icon:'icon-add'});
					formSubmit('../supplier/create');
				}
		}],
		onBeforeLoad:function(){
			$(this).datagrid('rejectChanges');
		},
		onLoadSuccess:function() {
			
		}
	});
	
	$('#supplierList').datagrid('getPager').pagination({
		displayMsg:'显示 {from} 至 {to} 条  共 {total} 条记录',
		afterPageText:'/{pages}',
		beforePageText:'页'
	});
});