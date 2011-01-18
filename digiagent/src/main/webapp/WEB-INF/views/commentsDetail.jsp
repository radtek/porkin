<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page pageEncoding="UTF-8"%>
<%@ page session="true"%>
<%@ include file="/common/taglibs.jsp"%>
<link href="${ctx}/styles/main2.css" rel="stylesheet" type="text/css" />
<style>
body
{
	background-color:#ffffff;
	background-image: url();
}
</style>
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
<c:forEach items="${commentsList}" var="comments" varStatus="status">
	<table width="700" border="0" align="center" cellpadding="0"
		cellspacing="0" class="user_list">
		<tr>
			<th colspan="2">评论</th>
		</tr>
		<tr>
			<td colspan="2"><c:out value="${comments.content}" /></td>
		</tr>
		<tr>
			<td style="padding: 2px 10px 0px 15px">${(total -(((page -1) *
			10) + status.index))}楼</td>
			<td style="text-align: right; padding: 2px 20px 0px 15px">作者：${comments.username}
			回复时间：${comments.createdDate }</td>
		</tr>
	</table>
	<br />
</c:forEach>
<table width="560" border="0" align="center" cellpadding="0"
		cellspacing="0">
		<tr style="font-size:12px">
			<td align="center" class="page_number"><a
				href="javascript:void(0)" onclick="skip(1)">首页</a> &nbsp;&nbsp; <a
				href="javascript:void(0)"
				onclick="skip(${page <= 1 ? 1 : (page - 1)})">前一页</a> &nbsp;&nbsp; 共
			<input type="text" name="pageNum" size=2 value="${page}" class="page_input"
				onkeyup="CheckInputInt(this);" onchange="go(this, ${pageSize });" />/${pageSize}
			&nbsp;&nbsp; <a href="javascript:void(0)"
				onclick="skip(${page >= pageSize ? pageSize : (page + 1)})">后一页</a>
			&nbsp;&nbsp; <a href="javascript:void(0)" onclick="skip(${pageSize})">尾页</a>
			&nbsp;&nbsp; 共${total }条记录</td>
		</tr>
	</table>
<iframe id="iframeC" name="iframeC" src="" width="0" height="0"
	style="display: none;"></iframe>
<script type="text/javascript"> 
function sethash(){
    hashH = document.documentElement.scrollHeight; 
    urlC = "${ctx}/supplier/iframe"; 
    document.getElementById("iframeC").src=urlC+"#"+hashH; 
}
window.onload=sethash();
</script>



