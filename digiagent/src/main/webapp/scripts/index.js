/**
 * 页签选择
 * @param showContent
 * @param selfObj
 * @return
 */
function selectTag(showContent,selfObj){
	// 操作标签
	var tag = document.getElementById("tags").getElementsByTagName("li");
	var taglength = tag.length;
	for(i=0; i<taglength; i++){
		tag[i].className = "";
	}
	selfObj.parentNode.className = "selectTag";
	// 操作内容
	for(i=0; j=document.getElementById("tagContent"+i); i++){
		j.style.display = "none";
	}
	// 二手商品
	if (showContent == 'tagContent2') {
		queryCommodityList(1, 'P');
	}
	// 促销商品
	if (showContent == 'tagContent3') {
		queryCommodityList(1, 'S');
	}
	document.getElementById(showContent).style.display = "block";
}