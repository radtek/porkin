function setRoleSelect(roleId) {
	$.ajax({
		url:"../user/getRoleList",
		dataType:"html",
		type: "GET",
		success: function(data) {
			$('select[name="roleId"]').empty().append(data).val(roleId);
		},
		error:function(err) {
			$.messager.alert('消息',err,'error');
		}
	});
}

// edit event
function formSubmit(actionUrl) {
	// validate
	$('#userForm').ajaxForm({ 
		url: actionUrl,
		beforeSubmit: validate, 
		dataType:  'json', 
        success:   processJson 
    }); 
}
// call back
function processJson(data) {
    if (data.userId == -1) {
		$.messager.alert('消息','品牌名称已存在，请重新操作！','warning');
    	return;
    }
    var optMsg = "新增成功！";
    if ($('input[name="userId"]').val() > 0) {
    	optMsg = "更新成功！";
    }
    $.messager.show({
		title:'消息',
		msg:optMsg,
		timeout:optSuccessTime,
		showType:'slide'
	});
	$('#userEdit').dialog('close');
    $('#userList').datagrid('reload');
}
// validate method
function validate(formData, jqForm, options) {
	var queryString = $.param(formData);
	var form = jqForm[0];
	if (form.userName.value.length == 0) {
		$.messager.alert('消息','请输入用户名！','info');
		form.userName.focus();
		return false;
	}
	if (form.userEmail.value.length == 0) {
		$.messager.alert('消息','请输入邮件地址！','info');
		form.userEmail.focus();
		return false;
	}
	if (form.userPassword.value.length == 0) {
		$.messager.alert('消息','请输入密码！','info');
		form.userPassword.focus();
		return false;
	}
	if (form.userPassword2.value.length == 0) {
		$.messager.alert('消息','请输入确认密码！','info');
		form.userPassword2.focus();
		return false;
	}
	if (form.userPassword2.value != form.userPassword.value) {
		$.messager.alert('消息','两次密码不一致！','info');
		form.userPassword2.focus();
		return false;
	} 
	if (form.roleId.value.length == 0) {
		$.messager.alert('消息','请选择角色！','info');
		form.roleId.focus();
		return false;
	}
}
function onEditClickHandler(id) {
	$.get('../user/get', { id: id } ,function(data) {alert(data.roleId);
		setRoleSelect(data.roleId);
		$('input[name="userId"]').val(id);
		$('input[name="userName"]').val(data.userName);
		$('input[name="userPassword"]').val(data.userPassword);
		$('input[name="userPassword2"]').val(data.userPassword);
		$('input[name="userEmail"]').val(data.userEmail);
		$('select[name="activeFlag"]').val(data.activeFlag);
		$('#userEdit').css('display','block');
		$('#userEdit').dialog({title:'修改', modal: true});
	});
	formSubmit('../user/update');
}

	
function onDeleteClickHandler(id) {
	$.messager.confirm('消息', '确认要删除该记录吗?', function(r){
		if (r){
			$.get('../user/delete', { id: id } ,function(data) {
				if (data == "success") {
				    $('#userList').datagrid('reload');
				    $.messager.show({
						title:'消息',
						msg:'删除成功！',
						timeout:optSuccessTime,
						showType:'slide'
					});
				} else if (data == "reference") {
					$.messager.alert('消息','有角色关联此用户，暂时无法删除！','warning');
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
	setRoleSelect();
	// edit
	var lastIndex;
	$('#userList').datagrid({
		title:'用户维护',
		iconCls:'icon-edit',
		width:1250,
		height:'auto',
		singleSelect:true,
		sortName: 'userName',
		sortOrder: 'asc',
		remoteSort: false,
		idField:'userId',
		method:'get',
		url:'../user/search',
		queryParams:{userName:''},
		pagination:true,
		loadMsg:'数据加载中,请稍候...',
		columns:[[
			{field:'userId',title:'编号',width:80,align:'center'},
			{field:'userName',title:'用户名',width:100,align:'center',sortable:true,
				sorter:function(a,b,order){
					return (a>b?1:-1)*(order=='asc'?1:-1);
				}
			},
			{field:'userEmail',title:'邮件',width:100,align:'center',sortable:true,
				sorter:function(a,b,order){
					return (a>b?1:-1)*(order=='asc'?1:-1);
				}
			},
			{field:'lastlogintime',title:'上次登录时间',width:130,align:'center',sortable:true,
				sorter:function(a,b,order){
					return (a>b?1:-1)*(order=='asc'?1:-1);
				}
			},
			{field:'registertime',title:'注册时间',width:130,align:'center',sortable:true,
				sorter:function(a,b,order){
					return (a>b?1:-1)*(order=='asc'?1:-1);
				}
			},
			{field:'logonsum',title:'登录次数',width:80,align:'center',sortable:true,
				sorter:function(a,b,order){
					return (a>b?1:-1)*(order=='asc'?1:-1);
				}
			},
			{field:'roleName',title:'角色',width:100,align:'center',sortable:true,
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
					return '<span><image onClick="onEditClickHandler(' + rec['userId'] + ')" onmouseover="this.style.cursor=\'pointer\';" src="../images/datagrid/icon_list_edit.gif"/>&nbsp;&nbsp;<image onClick="onDeleteClickHandler(' + rec['userId'] + ')" onmouseover="this.style.cursor=\'pointer\';" height="15" width="15" src="../images/datagrid/icon_list_delete.gif"/></span>';
				}
			}
		]],
		rownumbers:true,
		toolbar:[{
				id:'btnadd',
				text:'新增',
				iconCls:'icon-add',
				handler:function(){
					setRoleSelect('');
					$('input[name="userId"]').val('');
					$('select[name="roleId"]').val('');
					$('input[name="userName"]').val('');
					$('input[name="userPassword"]').val('');
					$('input[name="userPassword2"]').val('');
					$('input[name="userEmail"]').val('');
					$('select[name="activeFlag"]').val('Y');
					$('#userEdit').css('display','block');
					$('#userEdit').dialog({title:'新增', modal: true, icon:'icon-add'});
					formSubmit('../user/create');
				}
		}],
		onBeforeLoad:function(){
			$(this).datagrid('rejectChanges');
		},
		onLoadSuccess:function() {
			
		}
	});
	
	$('#userList').datagrid('getPager').pagination({
		displayMsg:'显示 {from} 至 {to} 条  共 {total} 条记录',
		afterPageText:'/{pages}',
		beforePageText:'页'
	});
});