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
	// 搜索
	if (showContent == 'tagContent0') {
		getCategoryJson('#searchBar');
	}
	// 促销商品
	if (showContent == 'tagContent2') {
		getCategoryJson('#searchBar2');
		queryCommodityList(1, 'P', false);
	}
	// 二手商品
	if (showContent == 'tagContent3') {
		getCategoryJson('#searchBar3');
		queryCommodityList(1, 'S', false);
	}
	document.getElementById(showContent).style.display = "block";
}