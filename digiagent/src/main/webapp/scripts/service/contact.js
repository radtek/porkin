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
			alert(err);
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
			alert(err);
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
			}
		},
		error:function(err) {
			alert(err);
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
    	alert("商家联系内容已存在，请重新操作！");
    	return;
    }
	$('#contactEdit').dialog('close');
    $('#contactList').datagrid('reload');
}
// validate method
function validate(formData, jqForm, options) {
	var queryString = $.param(formData);
	var form = jqForm[0];
	if (form.provinceId.value.length == 0) {
		alert('请选择省份！');
		form.provinceId.focus();
		return false;
	}
	if (form.cityId.value.length == 0) {
		alert('请选择城市！');
		form.cityId.focus();
		return false;
	}
	if (form.supplierId.value.length == 0) {
		alert('请选择供应商！');
		form.supplierId.focus();
		return false;
	}
	if (form.contactContent.value.length == 0) {
		alert('请输入联系内容！');
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
		$('#contactEdit').dialog({title:'Edit', modal: true});
	});
	formSubmit('../contact/update');
}

	
function onDeleteClickHandler(id) {
	if (confirm("确定要删除该记录吗？")) {
		$.get('../contact/delete', { id: id } ,function(data) {
			if (data == "success") {
			    $('#contactList').datagrid('reload');
				alert('删除成功！');
			}
		});
	}
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
					$('#contactEdit').dialog({title:'Add', modal: true, icon:'icon-add'});
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