
<%@ page language="java" contentType="text/plain; charset=utf-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="sky" tagdir="/tags"%>
<fmt:setLocale value="zh_CN"/>
<c:set var="ignoreListAccessControl" value="${true}"/>


<c:if test="${not empty recommandProduct}">

<div class="col-xs-12 col-ms-4 col-md-3 action-section" >
	<b title="A RecommandProduct" style="color: green">${userContext.localeMap['recommand_product']}</b>
	<hr/>
	<ul>
	
	
	<li><span>${userContext.localeMap['recommand_product.id']}</span> ${recommandProduct.id}</li>
<li><span>${userContext.localeMap['recommand_product.name']}</span> ${recommandProduct.name}</li>
<li><span>${userContext.localeMap['recommand_product.product_cover_image']}</span> ${recommandProduct.productCoverImage}</li>
<li><span>${userContext.localeMap['recommand_product.origin']}</span> ${recommandProduct.origin}</li>
<li><span>${userContext.localeMap['recommand_product.remark']}</span> ${recommandProduct.remark}</li>
<li><span>${userContext.localeMap['recommand_product.last_update_time']}</span> <fmt:formatDate pattern="yyyy-MM-dd" value="${recommandProduct.lastUpdateTime}" /></li>

	
	</ul>
</div>



</c:if>


