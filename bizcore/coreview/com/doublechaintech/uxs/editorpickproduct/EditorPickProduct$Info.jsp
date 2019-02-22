
<%@ page language="java" contentType="text/plain; charset=utf-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="sky" tagdir="/tags"%>
<fmt:setLocale value="zh_CN"/>
<c:set var="ignoreListAccessControl" value="${true}"/>


<c:if test="${not empty editorPickProduct}">
<div class="col-xs-12 col-ms-6 col-md-4 section">
	
	<div class="inner-section">
	
	<b title="A EditorPickProduct">${userContext.localeMap['editor_pick_product']} </b><a href="#"><i class="fa fa-refresh" aria-hidden="true"></i></a>
	<hr/>
	<ul>
	
	
	<li><span>ID</span><a class="link-action-removed" href="./editorPickProductManager/view/${editorPickProduct.id}/"> ${editorPickProduct.id}</a></li>
<li><span>${userContext.localeMap['editor_pick_product.name']}</span> ${editorPickProduct.name}</li>
<li><span>${userContext.localeMap['editor_pick_product.product_cover_image']}</span> ${editorPickProduct.productCoverImage}</li>
<li><span>${userContext.localeMap['editor_pick_product.origin']}</span> ${editorPickProduct.origin}</li>
<li><span>${userContext.localeMap['editor_pick_product.remark']}</span> ${editorPickProduct.remark}</li>
<li><span>${userContext.localeMap['editor_pick_product.last_update_time']}</span> <fmt:formatDate pattern="yyyy-MM-dd" value="${editorPickProduct.lastUpdateTime}" /></li>

	
	</ul>
	
	</div><!-- end of inner-section -->
	
</div>

</c:if>




