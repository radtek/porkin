<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page session="true"%>
<%@ include file="/common/taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Sortable</title>
<script type="text/javascript" src="${ctx}/scripts/jquery-1.4.2.min.js"></script>
<script type="text/javascript"
	src="${ctx}/scripts/jquery-ui-1.8.6.custom.min.js"></script>
<link rel="stylesheet" href="${ctx}/styles/jquery-ui-1.8.6.custom.css" />
<style>
#sortable {
	list-style-type: none;
	margin: 0;
	padding: 0;
	width: 60%;
}

#sortable li {
	margin: 0 3px 3px 3px;
	padding: 0.4em;
	padding-left: 1.5em;
	font-size: 1.4em;
	height: 18px;
}

#sortable li span {
	position: absolute;
	margin-left: -1.3em;
}
</style>

<script>
	$(function() {
		$("#sortable").sortable({
			placeholder: "ui-state-highlight"
		});
		$("#sortable").disableSelection();
	});

	function setValue() {
		var data = [];
		$.each($("#sortable").children(), function (index, category) {
			data.push($(category).find(".ui-icon").text());
		});
		//alert(JSON.stringify(data));
		$('input[name="categoryIds"]').val(JSON.stringify(data));
	}
</script>
</head>
<body>
<div>
<ul id=sortable>
	<c:forEach var="item" items="${categoryList}">
		<li class=ui-state-default><span class="ui-icon">${item.categoryId}</span>${item.categoryName}</li>
	</c:forEach>
</ul>
<form action="save" method=post name="test" onsubmit="setValue()">
<input name="categoryIds" type="hidden"/>
<input type="submit" value="Save"/>
</form>
</div>
</body>
</html>
