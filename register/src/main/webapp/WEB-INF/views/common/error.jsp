<%@ page contentType="text/html;charset=UTF-8" isErrorPage="true" %>
<%@ page import="org.apache.commons.logging.LogFactory" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
	<title>Error Page</title>
	<script src="<c:url value="/scripts/prototype.js"/>" type="text/javascript"></script>
	<script language="javascript">
		function showDetail()
		{
			$('detail_error_msg').toggle();
		}
	</script>
</head>

<body>


</body>
</html>