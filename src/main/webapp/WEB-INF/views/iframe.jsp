<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head><title>iframe</title></head>

<body>

<script>
function  pseth() {
    var iObj = parent.parent.document.getElementById('frame_content');
    iObjH = parent.parent.frames["frame_content"].frames["iframeC"].location.hash; 
    iObj.style.height = iObjH.split("#")[1]+"px"; 
}
window.onload = pseth();
</script>

</body>
</html>