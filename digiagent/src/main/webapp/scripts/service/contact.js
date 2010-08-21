function setSupplierSelect(supplierId) {
	$.ajax({
		url:"../contact/getSupplierList",
		data: "id=" + $('select[name="cityId"]').val(),
		dataType:"html",
		type: "GET",
		success: function(data) {
			$('select[name="supplierId"]').empty().append(data).val(supplierId);
		},
		error:function(err) {
			$.messager.alert('消息',err,'error');
		}
	});
}

function setProvinceSelect(provinceId, cityId, supplierId) {
	$.ajax({
		url:"../city/getProvinceList",
		dataType:"html",
		type: "GET",
		success: function(data) {
			$('select[name="provinceId"]').empty().append(data).val(provinceId);
			if (cityId >= 0) {
				setCitySelect(cityId, supplierId);
			}
		},
		error:function(err) {
			$.messager.alert('消息',err,'error');
		}
	});
}

function setCitySelect(cityId, supplierId) {
	$.ajax({
		url:"../supplier/getCityList",
	    data: "id=" + $('select[name="provinceId"]').val(),
		dataType:"html",
		type: "GET",
		success: function(data) {
			$('select[name="cityId"]').empty().append(data).val(cityId);
			if (supplierId > 0) {
				setSupplierSelect(supplierId);
			} else {
				$('select[name="supplierId"]').empty().append("<option value=''>请选择...</option>");
			}
		},
		error:function(err) {
			$.messager.alert('消息',err,'error');
		}
	});
}

function setProvinceByCityId(cityId, supplierId) {
	$.get('../city/get', { id: cityId } ,function(data) {
		setProvinceSelect(data.provinceId, cityId, supplierId);
	});
}

function setCityBySupplierId(supplierId) {
	$.get('../supplier/get', { id: supplierId } ,function(data) {
		setProvinceByCityId(data.cityId, supplierId);
	});
}

// edit event
function formSubmit(actionUrl) {
	// validate
	$('#contactForm').ajaxForm({ 
		url: actionUrl,
		beforeSubmit: validate, 
		dataType:  'json', 
        success:   processJson 
    }); 
}
// call back
function processJson(data) {
    if (data.contactId == -1) {
    	$.messager.alert('消息','商家联系内容已存在，请重新操作！','warning');
    	return;
    }
    var optMsg = "新增成功！";
    if ($('input[name="contactId"]').val() > 0) {
    	optMsg = "更新成功！";
    }
    $.messager.show({
		title:'消息',
		msg:optMsg,
		timeout:optSuccessTime,
		showType:'slide'
	});
	$('#contactEdit').dialog('close');
    $('#contactList').datagrid('reload');
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
	if (form.supplierId.value.length == 0) {
		$.messager.alert('消息','请选择商家！','info');
		form.supplierId.focus();
		return false;
	}
	if (form.contactContent.value.length == 0) {
		$.messager.alert('消息','请输入联系内容！','info');
		form.contactContent.focus();
		return false;
	}
}
function onEditClickHandler(id) {
	$.get('../contact/get', { id: id } ,function(data) {
		$('input[name="contactId"]').val(id);
		setCityBySupplierId(data.supplierId);
		$('select[name="contactType"]').val(data.contactType);
		$('input[name="contactContent"]').val(data.contactContent);
		$('select[name="activeFlag"]').val(data.activeFlag);
		$('#contactEdit').css('display','block');
		$('#contactEdit').dialog({title:'修改', modal: true});
	});
	formSubmit('../contact/update');
}

	
function onDeleteClickHandler(id) {
	$.messager.confirm('消息', '确认要删除该记录吗?', function(r){
		if (r){
			$.get('../contact/delete', { id: id } ,function(data) {
				if (data == "success") {
				    $('#contactList').datagrid('reload');
				    $.messager.show({
						title:'消息',
						msg:'删除成功！',
						timeout:optSuccessTime,
						showType:'slide'
					});
				} else {
					$.messager.alert('消息','删除失败！','error');
				}
			});
		}
	});
}

$(document).ready(function() {
	$('select[name="provinceId"]').bind('change', setCitySelect);
	$('select[name="cityId"]').bind('change', setSupplierSelect);
});

// list
$(function(){
	setProvinceSelect('', 0, -1);
	// edit
	var lastIndex;
	$('#contactList').datagrid({
		title:'商家联系信息维护',
		iconCls:'icon-edit',
		width:1150,
		height:'auto',
		singleSelect:true,
		sortName: 'provinceName,cityName,supplierName,contactContent',
		sortOrder: 'asc,asc,asc,asc',
		remoteSort: false,
		idField:'contactId',
		method:'get',
		url:'../contact/search',
		queryParams:{contactContent:''},
		pagination:true,
		loadMsg:'数据加载中,请稍候...',
		columns:[[
			{field:'contactId',title:'编号',width:80,align:'center'},
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
			{field:'contactType',title:'联系方式',width:100,align:'center',sortable:true,
				sorter:function(a,b,order){
					return (a>b?1:-1)*(order=='asc'?1:-1);
				},
				formatter:function(value,rec){
					switch (value) {
					case "Q":
						return "qq";
					case "T":
						return "电话";
					case "E":
						return "电子邮件";
					case "M":
						return "手机";
					}
				}
			},
			{field:'contactContent',title:'联系内容',width:100,align:'center',sortable:true,
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
					return '<span><image onClick="onEditClickHandler(' + rec['contactId'] + ')" onmouseover="this.style.cursor=\'pointer\';" src="../images/datagrid/icon_list_edit.gif"/>&nbsp;&nbsp;<image onClick="onDeleteClickHandler(' + rec['contactId'] + ')" onmouseover="this.style.cursor=\'pointer\';" height="15" width="15" src="../images/datagrid/icon_list_delete.gif"/></span>';
				}
			}
		]],
		rownumbers:true,
		toolbar:[{
				id:'btnadd',
				text:'新增',
				iconCls:'icon-add',
				handler:function(){
					$('input[name="contactId"]').val('');
					$('select[name="cityId"]').val('');
					$('select[name="supplierId"]').val('');
					setProvinceSelect('', -1, -1);
					setCitySelect('', -1);
					setSupplierSelect('');
					$('select[name="contactType"]').val('');
					$('input[name="contactContent"]').val('');
					$('select[name="activeFlag"]').val('Y');
					$('#contactEdit').css('display','block');
					$('#contactEdit').dialog({title:'新增', modal: true, icon:'icon-add'});
					formSubmit('../contact/create');
				}
		}],
		onBeforeLoad:function(){
			$(this).datagrid('rejectChanges');
		},
		onLoadSuccess:function() {
			
		}
	});
	
	$('#contactList').datagrid('getPager').pagination({
		displayMsg:'显示 {from} 至 {to} 条  共 {total} 条记录',
		afterPageText:'/{pages}',
		beforePageText:'页'
	});
});