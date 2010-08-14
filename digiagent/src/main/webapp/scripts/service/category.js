// edit event
$(document).ready(function() {
	// validate
	$('#caetgoryForm').ajaxForm({ 
		beforeSubmit: validate, 
		dataType:  'json', 
        success:   processJson 
    }); 
});
// call back
function processJson(data) { 
    alert(data.message); 
    $('#tt').datagrid('reload');
}
// validate method
function validate(formData, jqForm, options) {
	var queryString = $.param(formData);
	alert(queryString);
	var form = jqForm[0]; 
	if (form.categoryName.value.length == 0) {
		alert('请输入类别名！');
		form.categoryName.focus();
		return false;
	}
}
// list
$(function(){
	// edit
	$('#dd').dialog();
	$('#dd').dialog('close');
	var lastIndex;
	$('#tt').datagrid({
		title:'类别维护',
		iconCls:'icon-edit',
		width:650,
		height:'auto',
		singleSelect:true,
		idField:'itemid',
		url:'data/category.json',
		pagination:true,
		columns:[[
			{field:'categoryId',title:'序号',width:80},
			{field:'categoryName',title:'类别',width:100},
			{field:'actionFlag',title:'状态',width:100}
		]],
		toolbar:[{
				id:'btnadd',
				text:'Add',
				iconCls:'icon-add',
				handler:function(){
					$('#categoryName').text('');
					$('#dd').dialog({title:'Add', modal: true, icon:'icon-add'});
				}
			},'-',{
				text:'edit',
				iconCls:'icon-edit',
				handler:function(){
					var row = $('#tt').datagrid('getSelected');
					if ($(row).length == 0) {
						alert("please select a row!");
						return;
					}
					$('#categoryName').text(row['categoryName']);
					$('#dd').dialog({title:'Edit', modal: true});
				}
			},'-',{
				text:'delete',
				iconCls:'icon-remove',
				handler:function(){
					var row = $('#tt').datagrid('getSelected');
					/*if (row){
						var index = $('#tt').datagrid('getRowIndex', row);
						$('#tt').datagrid('deleteRow', index);
					}*/
					if ($(row).length == 0) {
						alert("please select a row!");
						return;
					}
					if (confirm("Are you sure delete this row?")) {
						var index = $('#tt').datagrid('getRowIndex', row);
						$('#tt').datagrid('deleteRow', index);
					}
				}
		}],
		onBeforeLoad:function(){
			$(this).datagrid('rejectChanges');
		}
	});
});