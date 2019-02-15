<%@ page import='java.util.*,com.doublechaintech.uxs.*'%>
<%@ page language="java" contentType="text/plain; charset=utf-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="sky" tagdir="/tags"%>
<fmt:setLocale value="zh_CN"/>
<c:set var="ignoreListAccessControl" value="${true}"/>


<c:if test="${ empty ratingList}" >
	<div class="row" style="font-size: 30px;">
		<div class="col-xs-12 col-md-12" style="padding-left:20px">
		 ${userContext.localeMap['@not_found']}${userContext.localeMap['rating']}! 
		 <a href="./${ownerBeanName}Manager/addRating/${result.id}/"><i class="fa fa-plus-square" aria-hidden="true"></i></a>
		 
		 
		 
		 </div>
	</div>

</c:if>




	

 <c:if test="${not empty ratingList}" >
    
    
<%

 	SmartList list=(SmartList)request.getAttribute("ratingList"); 
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
		<i class='fa fa-table'></i> ${userContext.localeMap['rating']}(${totalCount})
		<a href="./${ownerBeanName}Manager/addRating/${result.id}/"><i class="fa fa-plus-square" aria-hidden="true"></i></a>
		 
		 		 	<div class="btn-group" role="group" aria-label="Button group with nested dropdown">		
	<c:forEach var="action" items="${result.actionList}">
		<c:if test="${'ratingList' eq action.actionGroup}">
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
		<a href='#${ownerBeanName}Manager/load${ownerClassName}/${result.id}/${ratingListName};${ratingListName}CurrentPage=${page.pageNumber};${ratingListName}RowsPerPage=${rowsPerPage}/' 
			class='page-link page-action '>${page.title}</a>
	</li>
</c:forEach>
 </ul>
</nav>


   


	<table class="table table-striped" pageToken='ratingListCurrentPage=${currentPageNumber}'>
		<thead><tr>
		<c:if test="${param.referName ne 'id'}">
	<th>${userContext.localeMap['rating.id']}</th>
</c:if>
<c:if test="${param.referName ne 'user'}">
	<th>${userContext.localeMap['rating.user']}</th>
</c:if>
<c:if test="${param.referName ne 'product'}">
	<th>${userContext.localeMap['rating.product']}</th>
</c:if>
<c:if test="${param.referName ne 'score'}">
	<th>${userContext.localeMap['rating.score']}</th>
</c:if>
<c:if test="${param.referName ne 'updateTime'}">
	<th>${userContext.localeMap['rating.update_time']}</th>
</c:if>
<th>${userContext.localeMap['@action']}</th>
		</tr></thead>
		<tbody>
			
			<c:forEach var="item" items="${ratingList}">
				<tr currentVersion='${item.version}' id="rating-${item.id}" ><td><a class="link-action-removed" href="./ratingManager/view/${item.id}/"> ${item.id}</a></td>
<c:if test="${param.referName ne 'user'}">
	<td class="select_candidate_td"
			data-candidate-method="./ratingManager/requestCandidateUser/${ownerBeanName}/${item.id}/"
			data-switch-method="./ratingManager/transferToAnotherUser/${item.id}/"
			data-link-template="./profileManager/view/${'$'}{ID}/">
		<span class="display_span">
			<c:if test="${not empty  item.user}">
			<a href='./profileManager/view/${item.user.id}/'>${item.user.displayName}</a>
			</c:if>
			<c:if test="${empty  item.user}">
			<a href='#'></a>
			</c:if>
			<button class="btn btn-link candidate-action">...</button>
		</span>
		<div class="candidate_span" style="display:none;">
			<input type="text" data-provide="typeahead" class="input-sm form-control candidate-filter-input" autocomplete="off" />
		</div>
	</td>
</c:if>
<c:if test="${param.referName ne 'product'}">
	<td class="select_candidate_td"
			data-candidate-method="./ratingManager/requestCandidateProduct/${ownerBeanName}/${item.id}/"
			data-switch-method="./ratingManager/transferToAnotherProduct/${item.id}/"
			data-link-template="./productManager/view/${'$'}{ID}/">
		<span class="display_span">
			<c:if test="${not empty  item.product}">
			<a href='./productManager/view/${item.product.id}/'>${item.product.displayName}</a>
			</c:if>
			<c:if test="${empty  item.product}">
			<a href='#'></a>
			</c:if>
			<button class="btn btn-link candidate-action">...</button>
		</span>
		<div class="candidate_span" style="display:none;">
			<input type="text" data-provide="typeahead" class="input-sm form-control candidate-filter-input" autocomplete="off" />
		</div>
	</td>
</c:if>
<c:if test="${param.referName ne 'score'}">	<td contenteditable='true' class='edit-value'  propertyToChange='score' storedCellValue='${item.score}' prefix='${ownerBeanName}Manager/updateRating/${result.id}/${item.id}/'>${item.score}</td>
</c:if><c:if test="${param.referName ne 'updateTime'}">	<td contenteditable='true' class='edit-value'  propertyToChange='updateTime' storedCellValue='${item.updateTime}' prefix='${ownerBeanName}Manager/updateRating/${result.id}/${item.id}/'><fmt:formatDate pattern="yyyy-MM-dd'T'HH:mm:ss" value="${item.updateTime}" /></td>
</c:if>
				<td>

				<a href='#${ownerBeanName}Manager/removeRating/${result.id}/${item.id}/' class='delete-action btn btn-danger btn-xs'><i class="fa fa-trash-o fa-lg"></i> ${userContext.localeMap['@delete']}</a>
				<a href='#${ownerBeanName}Manager/copyRatingFrom/${result.id}/${item.id}/' class='copy-action btn btn-success btn-xs'><i class="fa fa-files-o fa-lg"></i> ${userContext.localeMap['@copy']} </a>

				</td>
				</tr>
			</c:forEach>
		
		</tbody>
	</table>	
	

</div></c:if>


