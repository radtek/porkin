function $(objID){
return document.getElementById(objID);
}

function reDivHeight(objid,clickobj){
 var obj=$(objid);
 if (obj!=null)
 {
  obj.style.height=obj.offsetHeight+"px";
  obj.className+=" overflow_hidden";
  if (obj.style.display!="none")
  {
//   obj.height=obj.offsetHeight;
   if (clickobj!=null)
   {
    clickobj.title=unescape("open");
   }
   obj.height=obj.offsetHeight;
   changeDivHeight(objid,0);
  }else{
   obj.style.display="block";
   if (clickobj!=null)
   {
    clickobj.title=unescape("close");
   }
   changeDivHeight(objid,1);
  }
 }
}
var changeCounter=0;
function changeDivHeight(objid,changeType){
 var obj=$(objid);

	 if (changeCounter<10)
	 {
	  if (changeType==0)
	  {
	   var allHeight=obj.offsetHeight;
	   var newHeight=allHeight/(changeCounter+1);
	  }else{
		   
		if (typeof(obj.height)=='undefined') {
			var allHeight = 117;
		} else {
			var allHeight=obj.height;
		}
	
	  
	   
	   var newHeight=allHeight+allHeight/11-allHeight/(changeCounter+1);
	  }
		
	  obj.style.height=newHeight+"px";
	  changeCounter++;
	
	  setTimeout("changeDivHeight('"+objid+"',"+changeType+")",20);
	 }else{
		 
	  if (changeType==0)
	  {
	   obj.style.display="none";
	  }else{
		  
	   //obj.style.height="";
	   obj.className=obj.className.replace("overflow_hidden","");
	
	  }
	  changeCounter=0;
	 }
}
function closeDiv(objid) {
	var obj = $(objid);
	obj.style.display='none';
}

function splash(li)
{
	var ul = li.parentNode;
	var lis = ul.getElementsByTagName("li");
	for(var i=0; i<lis.length; i++)
	{
		if(lis[i].className != 'li_more')
		{
			lis[i].className = '';
		}
	}
	li.className = 'li_here';
}
