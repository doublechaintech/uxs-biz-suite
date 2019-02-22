<%@ page import='java.util.*,com.doublechaintech.uxs.*'%>
<%@ page language="java" contentType="text/plain; charset=utf-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="sky" tagdir="/tags"%>
<fmt:setLocale value="zh_CN"/>
<c:set var="ignoreListAccessControl" value="${true}"/>


<c:if test="${ empty editorPickProductList}" >
	<div class="row" style="font-size: 30px;">
		<div class="col-xs-12 col-md-12" style="padding-left:20px">
		 ${userContext.localeMap['@not_found']}${userContext.localeMap['editor_pick_product']}! 
		 <a href="./${ownerBeanName}Manager/addEditorPickProduct/${result.id}/"><i class="fa fa-plus-square" aria-hidden="true"></i></a>
		 
		 
		 
		 </div>
	</div>

</c:if>




	

 <c:if test="${not empty editorPickProductList}" >
    
    
<%

 	SmartList list=(SmartList)request.getAttribute("editorPickProductList"); 
 	int totalCount = list.getTotalCount();
 	List pages = list.getPages();
 	pageContext.setAttribute("rowsPerPage",list.getRowsPerPage()); 
 	
 	pageContext.setAttribute("pages",pages); 
 	pageContext.setAttribute("totalCount",totalCount); 
 	//pageContext.setAttribute("accessible",list.isAccessible()); 
 	//the reason using scriptlet here is the el express is currently not able resolv common property from a subclass of list
%>
    
 	   
    <div class="row" style="font-size: 30px;">
		<div class="col-xs-12 col-md-12" style="padding-left:20px">
		<i class='fa fa-table'></i> ${userContext.localeMap['editor_pick_product']}(${totalCount})
		<a href="./${ownerBeanName}Manager/addEditorPickProduct/${result.id}/"><i class="fa fa-plus-square" aria-hidden="true"></i></a>
		 
		 		 	<div class="btn-group" role="group" aria-label="Button group with nested dropdown">		
	<c:forEach var="action" items="${result.actionList}">
		<c:if test="${'editorPickProductList' eq action.actionGroup}">
		<a class="btn btn-${action.actionLevel} btn-sm" href="${action.managerBeanName}/${action.actionPath}">${userContext.localeMap[action.localeKey]}</a>
		</c:if>
	</c:forEach>
	</div><!--end of div class="btn-group" -->
	
		 
		 
		 
		 </div>
 </div>
    
    
<div class="table-responsive">


<c:set var="currentPageNumber" value="1"/>	



<nav aria-label="Page navigation example">
  <ul class="pagination">
<c:forEach var="page" items="${pages}"> 
<c:set var="classType" value=""/>
<c:if test='${page.selected}' >
<c:set var="classType" value="active"/>
<c:set var="currentPageNumber" value="${page.pageNumber}"/>
</c:if>


	<li class="page-item ${classType}">
		<a href='#${ownerBeanName}Manager/load${ownerClassName}/${result.id}/${editorPickProductListName};${editorPickProductListName}CurrentPage=${page.pageNumber};${editorPickProductListName}RowsPerPage=${rowsPerPage}/' 
			class='page-link page-action '>${page.title}</a>
	</li>
</c:forEach>
 </ul>
</nav>


   


	<table class="table table-striped" pageToken='editorPickProductListCurrentPage=${currentPageNumber}'>
		<thead><tr>
		<c:if test="${param.referName ne 'id'}">
	<th>${userContext.localeMap['editor_pick_product.id']}</th>
</c:if>
<c:if test="${param.referName ne 'name'}">
	<th>${userContext.localeMap['editor_pick_product.name']}</th>
</c:if>
<c:if test="${param.referName ne 'parentCategory'}">
	<th>${userContext.localeMap['editor_pick_product.parent_category']}</th>
</c:if>
<c:if test="${param.referName ne 'brand'}">
	<th>${userContext.localeMap['editor_pick_product.brand']}</th>
</c:if>
<c:if test="${param.referName ne 'productCoverImage'}">
	<th>${userContext.localeMap['editor_pick_product.product_cover_image']}</th>
</c:if>
<c:if test="${param.referName ne 'origin'}">
	<th>${userContext.localeMap['editor_pick_product.origin']}</th>
</c:if>
<c:if test="${param.referName ne 'catalog'}">
	<th>${userContext.localeMap['editor_pick_product.catalog']}</th>
</c:if>
<c:if test="${param.referName ne 'profile'}">
	<th>${userContext.localeMap['editor_pick_product.profile']}</th>
</c:if>
<c:if test="${param.referName ne 'remark'}">
	<th>${userContext.localeMap['editor_pick_product.remark']}</th>
</c:if>
<c:if test="${param.referName ne 'lastUpdateTime'}">
	<th>${userContext.localeMap['editor_pick_product.last_update_time']}</th>
</c:if>
<c:if test="${param.referName ne 'platform'}">
	<th>${userContext.localeMap['editor_pick_product.platform']}</th>
</c:if>
<th>${userContext.localeMap['@action']}</th>
		</tr></thead>
		<tbody>
			
			<c:forEach var="item" items="${editorPickProductList}">
				<tr currentVersion='${item.version}' id="editorPickProduct-${item.id}" ><td><a class="link-action-removed" href="./editorPickProductManager/view/${item.id}/"> ${item.id}</a></td>
<c:if test="${param.referName ne 'name'}">	<td contenteditable='true' class='edit-value'  propertyToChange='name' storedCellValue='${item.name}' prefix='${ownerBeanName}Manager/updateEditorPickProduct/${result.id}/${item.id}/'>${item.name}</td>
</c:if><c:if test="${param.referName ne 'parentCategory'}">
	<td class="select_candidate_td"
			data-candidate-method="./editorPickProductManager/requestCandidateParentCategory/${ownerBeanName}/${item.id}/"
			data-switch-method="./editorPickProductManager/transferToAnotherParentCategory/${item.id}/"
			data-link-template="./levelNCategoryManager/view/${'$'}{ID}/">
		<span class="display_span">
			<c:if test="${not empty  item.parentCategory}">
			<a href='./levelNCategoryManager/view/${item.parentCategory.id}/'>${item.parentCategory.displayName}</a>
			</c:if>
			<c:if test="${empty  item.parentCategory}">
			<a href='#'></a>
			</c:if>
			<button class="btn btn-link candidate-action">...</button>
		</span>
		<div class="candidate_span" style="display:none;">
			<input type="text" data-provide="typeahead" class="input-sm form-control candidate-filter-input" autocomplete="off" />
		</div>
	</td>
</c:if>
<c:if test="${param.referName ne 'brand'}">
	<td class="select_candidate_td"
			data-candidate-method="./editorPickProductManager/requestCandidateBrand/${ownerBeanName}/${item.id}/"
			data-switch-method="./editorPickProductManager/transferToAnotherBrand/${item.id}/"
			data-link-template="./brandManager/view/${'$'}{ID}/">
		<span class="display_span">
			<c:if test="${not empty  item.brand}">
			<a href='./brandManager/view/${item.brand.id}/'>${item.brand.displayName}</a>
			</c:if>
			<c:if test="${empty  item.brand}">
			<a href='#'></a>
			</c:if>
			<button class="btn btn-link candidate-action">...</button>
		</span>
		<div class="candidate_span" style="display:none;">
			<input type="text" data-provide="typeahead" class="input-sm form-control candidate-filter-input" autocomplete="off" />
		</div>
	</td>
</c:if>
<c:if test="${param.referName ne 'productCoverImage'}">	<td contenteditable='true' class='edit-value'  propertyToChange='productCoverImage' storedCellValue='${item.productCoverImage}' prefix='${ownerBeanName}Manager/updateEditorPickProduct/${result.id}/${item.id}/'>${item.productCoverImage}</td>
</c:if><c:if test="${param.referName ne 'origin'}">	<td contenteditable='true' class='edit-value'  propertyToChange='origin' storedCellValue='${item.origin}' prefix='${ownerBeanName}Manager/updateEditorPickProduct/${result.id}/${item.id}/'>${item.origin}</td>
</c:if><c:if test="${param.referName ne 'catalog'}">
	<td class="select_candidate_td"
			data-candidate-method="./editorPickProductManager/requestCandidateCatalog/${ownerBeanName}/${item.id}/"
			data-switch-method="./editorPickProductManager/transferToAnotherCatalog/${item.id}/"
			data-link-template="./catalogManager/view/${'$'}{ID}/">
		<span class="display_span">
			<c:if test="${not empty  item.catalog}">
			<a href='./catalogManager/view/${item.catalog.id}/'>${item.catalog.displayName}</a>
			</c:if>
			<c:if test="${empty  item.catalog}">
			<a href='#'></a>
			</c:if>
			<button class="btn btn-link candidate-action">...</button>
		</span>
		<div class="candidate_span" style="display:none;">
			<input type="text" data-provide="typeahead" class="input-sm form-control candidate-filter-input" autocomplete="off" />
		</div>
	</td>
</c:if>
<c:if test="${param.referName ne 'profile'}">
	<td class="select_candidate_td"
			data-candidate-method="./editorPickProductManager/requestCandidateProfile/${ownerBeanName}/${item.id}/"
			data-switch-method="./editorPickProductManager/transferToAnotherProfile/${item.id}/"
			data-link-template="./profileManager/view/${'$'}{ID}/">
		<span class="display_span">
			<c:if test="${not empty  item.profile}">
			<a href='./profileManager/view/${item.profile.id}/'>${item.profile.displayName}</a>
			</c:if>
			<c:if test="${empty  item.profile}">
			<a href='#'></a>
			</c:if>
			<button class="btn btn-link candidate-action">...</button>
		</span>
		<div class="candidate_span" style="display:none;">
			<input type="text" data-provide="typeahead" class="input-sm form-control candidate-filter-input" autocomplete="off" />
		</div>
	</td>
</c:if>
<c:if test="${param.referName ne 'remark'}">	<td contenteditable='true' class='edit-value'  propertyToChange='remark' storedCellValue='${item.remark}' prefix='${ownerBeanName}Manager/updateEditorPickProduct/${result.id}/${item.id}/'>${item.remark}</td>
</c:if><c:if test="${param.referName ne 'lastUpdateTime'}">	<td contenteditable='true' class='edit-value'  propertyToChange='lastUpdateTime' storedCellValue='${item.lastUpdateTime}' prefix='${ownerBeanName}Manager/updateEditorPickProduct/${result.id}/${item.id}/'><fmt:formatDate pattern="yyyy-MM-dd'T'HH:mm:ss" value="${item.lastUpdateTime}" /></td>
</c:if><c:if test="${param.referName ne 'platform'}">
	<td class="select_candidate_td"
			data-candidate-method="./editorPickProductManager/requestCandidatePlatform/${ownerBeanName}/${item.id}/"
			data-switch-method="./editorPickProductManager/transferToAnotherPlatform/${item.id}/"
			data-link-template="./platformManager/view/${'$'}{ID}/">
		<span class="display_span">
			<c:if test="${not empty  item.platform}">
			<a href='./platformManager/view/${item.platform.id}/'>${item.platform.displayName}</a>
			</c:if>
			<c:if test="${empty  item.platform}">
			<a href='#'></a>
			</c:if>
			<button class="btn btn-link candidate-action">...</button>
		</span>
		<div class="candidate_span" style="display:none;">
			<input type="text" data-provide="typeahead" class="input-sm form-control candidate-filter-input" autocomplete="off" />
		</div>
	</td>
</c:if>

				<td>

				<a href='#${ownerBeanName}Manager/removeEditorPickProduct/${result.id}/${item.id}/' class='delete-action btn btn-danger btn-xs'><i class="fa fa-trash-o fa-lg"></i> ${userContext.localeMap['@delete']}</a>
				<a href='#${ownerBeanName}Manager/copyEditorPickProductFrom/${result.id}/${item.id}/' class='copy-action btn btn-success btn-xs'><i class="fa fa-files-o fa-lg"></i> ${userContext.localeMap['@copy']} </a>

				</td>
				</tr>
			</c:forEach>
		
		</tbody>
	</table>	
	

</div></c:if>


