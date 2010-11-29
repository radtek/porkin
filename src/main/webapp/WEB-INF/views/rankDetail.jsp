<%@page contentType="text/html;charset=UTF-8"%>
<%@page pageEncoding="UTF-8"%>
<%@ page session="true" %>
<%@ include file="/common/taglibs.jsp" %>
 <div class="purductListLeftA purductListLeftMargin">
      <p>日访问量前十</p>
      <ul class="plphbox">
      <c:set var="dayNo" value="0"/>
      <c:forEach items="${daily}" var="dataMap">
      	<c:set var="supplierName" value=""/>
      	<c:set var="supplierId" value="0"/>
      	<c:set var="supplierCount" value="0"/>
      	<c:set var="dayNo" value="${dayNo +1 }"/>
      	<c:forEach var="mapItem" items="${dataMap}">
      		<c:if test="${mapItem.key =='SUPPLIER'}">
      			<c:set var="supplierName" value="${mapItem.value}"/>
　　			</c:if>
			<c:if test="${mapItem.key =='SUPPLIER_ID'}">
	      		<c:set var="supplierId" value="${mapItem.value}"/>　　
	      	</c:if>
			<c:if test="${mapItem.key =='COUNT'}">
	      		<c:set var="supplierCount" value="${mapItem.value}"/>
	　　		</c:if>
		</c:forEach>
		<li>第<c:out value= "${dayNo}" />名</li>
		
      	<li>
      		
          <span>
          	<a  href='${ctx}/supplier/<c:out value= "${supplierId}" />'><c:out value= "${supplierName}" /></a>
          </span>
          <span>共<c:out value= "${supplierCount}" />次</span> 
        </li>
      </c:forEach>
        
        
      </ul>

    </div>
    
<div class="purductListLeftA purductListLeftMargin">
      <p>周访问量前十</p>
      <ul class="plphbox">
       <c:set var="weekNo" value="0"/>
      <c:forEach items="${weekly}" var="dataMap">
      	<c:set var="supplierName" value=""/>
      	<c:set var="supplierId" value="0"/>
      	<c:set var="supplierCount" value="0"/>
      	<c:set var="weekNo" value="${weekNo +1}"/>
      	<c:forEach var="mapItem" items="${dataMap}">
      		<c:if test="${mapItem.key =='SUPPLIER'}">
      			<c:set var="supplierName" value="${mapItem.value}"/>
　　			</c:if>
			<c:if test="${mapItem.key =='SUPPLIER_ID'}">
	      		<c:set var="supplierId" value="${mapItem.value}"/>　　
	      	</c:if>
			<c:if test="${mapItem.key =='COUNT'}">
	      		<c:set var="supplierCount" value="${mapItem.value}"/>
	　　		</c:if>
		</c:forEach>
		
		<li>第<c:out value= "${weekNo}" />名</li>
		
      	<li>
          <span>
          	<a  href='${ctx}/supplier/<c:out value= "${supplierId}" />'><c:out value= "${supplierName}" /></a>
          </span>
          <span>共<c:out value= "${supplierCount}" />次</span> 
        </li>
      </c:forEach>
        
        
      </ul>

    </div>
    
    
<div class="purductListLeftA purductListLeftMargin">
      <p>月访问量前十</p>
      <ul class="plphbox">
      <c:set var="monthNo" value="0"/>
      <c:forEach items="${monthly}" var="dataMap">
      	<c:set var="supplierName" value=""/>
      	<c:set var="supplierId" value="0"/>
      	<c:set var="supplierCount" value="0"/>
      	<c:set var="monthNo" value="${monthNo+1}"/>
      	<c:forEach var="mapItem" items="${dataMap}">
      		<c:if test="${mapItem.key =='SUPPLIER'}">
      			<c:set var="supplierName" value="${mapItem.value}"/>
　　			</c:if>
			<c:if test="${mapItem.key =='SUPPLIER_ID'}">
	      		<c:set var="supplierId" value="${mapItem.value}"/>　　
	      	</c:if>
			<c:if test="${mapItem.key =='COUNT'}">
	      		<c:set var="supplierCount" value="${mapItem.value}"/>
	　　		</c:if>
		</c:forEach>
		
		<li>第<c:out value= "${monthNo}" />名</li>
		
      	<li>
          <span>
          	<a  href='${ctx}/supplier/<c:out value= "${supplierId}" />'><c:out value= "${supplierName}" /></a>
          </span>
          <span>共<c:out value= "${supplierCount}" />次</span> 
        </li>
      </c:forEach>
        
        
      </ul>

    </div>    