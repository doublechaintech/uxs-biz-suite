
<%@ page language="java" contentType="text/plain; charset=utf-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="sky" tagdir="/tags"%>
<fmt:setLocale value="zh_CN"/>
<c:set var="ignoreListAccessControl" value="${true}"/>


<c:if test="${not empty editorPickProduct}">

<div class="col-xs-12 col-ms-4 col-md-3 action-section" >
	<b title="A EditorPickProduct" style="color: green">${userContext.localeMap['editor_pick_product']}</b>
	<hr/>
	<ul>
	
	
	<li><span>${userContext.localeMap['editor_pick_product.id']}</span> ${editorPickProduct.id}</li>
<li><span>${userContext.localeMap['editor_pick_product.name']}</span> ${editorPickProduct.name}</li>
<li><span>${userContext.localeMap['editor_pick_product.product_cover_image']}</span> ${editorPickProduct.productCoverImage}</li>
<li><span>${userContext.localeMap['editor_pick_product.origin']}</span> ${editorPickProduct.origin}</li>
<li><span>${userContext.localeMap['editor_pick_product.remark']}</span> ${editorPickProduct.remark}</li>
<li><span>${userContext.localeMap['editor_pick_product.last_update_time']}</span> <fmt:formatDate pattern="yyyy-MM-dd" value="${editorPickProduct.lastUpdateTime}" /></li>

	
	</ul>
</div>



</c:if>


