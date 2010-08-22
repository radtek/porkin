//edit event
function formSubmit() {
	$('#commodityForm').ajaxForm({ 
		url: "../commodity/create",
		beforeSubmit: validate, 
		dataType:  'json', 
        success:   processJson,
        error:   function(err){
			$.messager.alert('消息',"图片大小超过65K，不能上传！",'error');
			$('#image').empty();
		} 
	});
}

function validate(formData, jqForm, options) {
	var form = jqForm[0]; 
	if (form.file.value.length == 0) {
		$.messager.alert('消息','请选择图片！','info');
		form.file.focus();
		return false;
	}
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
	$('#image').empty().append('<iframe scrolling="auto" frameborder="0"  src="'+url+'" style="width:600;height:300;"></iframe>');
	$('#image').append('<image  onClick="onDeleteClickHandler(' + data.commodityId + ')" onmouseover="this.style.cursor=\'pointer\';" height="15" width="15" src="../images/datagrid/icon_list_delete.gif"/>');
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
				} else {
					$.messager.alert('消息','删除失败！','error');
				}
			});
		}
	});
}

$(document).ready(function() {
	formSubmit();
});
