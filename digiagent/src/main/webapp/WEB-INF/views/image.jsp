<%@ page info="Loaded Image Show"  pageEncoding="UTF-8" contentType="image/jpg" autoFlush="true" buffer="16kb" session="false" %>
<%
byte[] image = (byte[])request.getAttribute("image");
ServletOutputStream sos = response.getOutputStream();  
sos.write(image);
sos.flush(); 
sos.close();  
out.clear();
out = pageContext.pushBody();
%>