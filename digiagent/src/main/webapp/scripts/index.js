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
		$('#commodityP').next().empty();
		$('#commodityP').empty();
	}
	// 二手商品
	if (showContent == 'tagContent3') {
		getCategoryJson('#searchBar3');
		$('#commodityS').next().empty();
		$('#commodityS').empty();
	}
	if (showContent == 'tagContent4') {
		getRankDetail('#searchBar4');
	}
	document.getElementById(showContent).style.display = "block";
}