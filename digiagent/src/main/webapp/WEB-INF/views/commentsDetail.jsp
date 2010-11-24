<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page pageEncoding="UTF-8"%>
<%@ page session="true"%>
<%@ include file="/common/taglibs.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title></title>
<link href="${ctx}/styles/main.css" rel="stylesheet" type="text/css" />
<script language="javascript">
/**
 * 验证输入页码
 * @param oInput
 * @return
 */
function CheckInputInt(oInput)
{
    if('' != oInput.value.replace(/\d{1,}/,''))
    {
        oInput.value = oInput.value.match(/\d{1,}/) == null ? '' :oInput.value.match(/\d{1,}/);
    }
}
/**
 * 跳页
 * @param obj
 * @param totalPage
 * @return
 */
function go(obj, totalPage) {
	if (obj.value - 0 > totalPage) {
		obj.value = totalPage;
    }
	if (obj.value - 0 < 1) {
		obj.value = 1;
    }
	window.location.href = "${ctx}/supplier/comments/${supplierId}?page=" + obj.value + "&rows=10";
}

/**
 * 翻页
 * @param pageNum
 * @return
 */
function skip(pageNum) {
	window.location.href = "${ctx}/supplier/comments/${supplierId}?page=" + pageNum + "&rows=10";
}
</script>
</head>
<body>
<div style="height: 10px"></div>
<c:forEach items="${commentsList}" var="comments" varStatus="status">
	<div id="companyLeft" style="margin:1px; width: 100%">
		<div style="text-align:right">作者：${comments.username} <span style="padding-left: 10px"></span>回复日期：${comments.createdDate }<span style="padding-right: 10px"></span></div>
		<div style="padding:10px"><c:out value="${comments.content}"/><div style="text-align:right">${(total -(((page -1) * 10) + status.index))}楼</div></div>
	</div>
	<div style="height: 2px"></div>
</c:forEach>
<div style="height: 5px"></div>
<div style="padding-left:100px"><a href="javascript:void(0)" onclick="skip(1)">首页</a>&nbsp;<a href="javascript:void(0)" onclick="skip(${page <= 1 ? 1 : (page - 1)})">前一页</a>&nbsp;共<input type="text" name="pageNum" size=2 value="${page}" onkeyup="CheckInputInt(this);" onchange="go(this, ${pageSize });"/>/${pageSize}页&nbsp;<a href="javascript:void(0)" onclick="skip(${page >= pageSize ? pageSize : (page + 1)})">后一页</a>&nbsp;<a href="javascript:void(0)" onclick="skip(${pageSize})">尾页</a>&nbsp;共${total }条记录</div>
<div style="height: 10px"></div>
<iframe id="iframeC" name="iframeC" src="" width="0" height="0" style="display:none;" ></iframe>
<script type="text/javascript"> 
function sethash(){
    hashH = document.documentElement.scrollHeight; 
    urlC = "${ctx}/supplier/iframe"; 
    document.getElementById("iframeC").src=urlC+"#"+hashH; 
}
window.onload=sethash();
</script>
</body>
</html>



