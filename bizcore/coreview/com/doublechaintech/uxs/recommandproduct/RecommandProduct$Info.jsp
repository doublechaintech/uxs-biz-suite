
<%@ page language="java" contentType="text/plain; charset=utf-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="sky" tagdir="/tags"%>
<fmt:setLocale value="zh_CN"/>
<c:set var="ignoreListAccessControl" value="${true}"/>


<c:if test="${not empty recommandProduct}">
<div class="col-xs-12 col-ms-6 col-md-4 section">
	
	<div class="inner-section">
	
	<b title="A RecommandProduct">${userContext.localeMap['recommand_product']} </b><a href="#"><i class="fa fa-refresh" aria-hidden="true"></i></a>
	<hr/>
	<ul>
	
	
	<li><span>ID</span><a class="link-action-removed" href="./recommandProductManager/view/${recommandProduct.id}/"> ${recommandProduct.id}</a></li>
<li><span>${userContext.localeMap['recommand_product.name']}</span> ${recommandProduct.name}</li>
<li><span>${userContext.localeMap['recommand_product.product_cover_image']}</span> ${recommandProduct.productCoverImage}</li>
<li><span>${userContext.localeMap['recommand_product.origin']}</span> ${recommandProduct.origin}</li>
<li><span>${userContext.localeMap['recommand_product.remark']}</span> ${recommandProduct.remark}</li>
<li><span>${userContext.localeMap['recommand_product.last_update_time']}</span> <fmt:formatDate pattern="yyyy-MM-dd" value="${recommandProduct.lastUpdateTime}" /></li>

	
	</ul>
	
	</div><!-- end of inner-section -->
	
</div>

</c:if>




