<%@ page import='java.util.*,com.doublechaintech.uxs.*'%>
<%@ page language="java" contentType="text/plain; charset=utf-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="sky" tagdir="/tags"%>
<fmt:setLocale value="zh_CN"/>
<c:set var="ignoreListAccessControl" value="${true}"/>


<c:if test="${ empty userAlertList}" >
	<div class="row" style="font-size: 30px;">
		<div class="col-xs-12 col-md-12" style="padding-left:20px">
		 ${userContext.localeMap['@not_found']}${userContext.localeMap['user_alert']}! 
		 <a href="./${ownerBeanName}Manager/addUserAlert/${result.id}/"><i class="fa fa-plus-square" aria-hidden="true"></i></a>
		 
		 
		 
		 </div>
	</div>

</c:if>




	

 <c:if test="${not empty userAlertList}" >
    
    
<%

 	SmartList list=(SmartList)request.getAttribute("userAlertList"); 
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
		<i class='fa fa-table'></i> ${userContext.localeMap['user_alert']}(${totalCount})
		<a href="./${ownerBeanName}Manager/addUserAlert/${result.id}/"><i class="fa fa-plus-square" aria-hidden="true"></i></a>
		 
		 		 	<div class="btn-group" role="group" aria-label="Button group with nested dropdown">		
	<c:forEach var="action" items="${result.actionList}">
		<c:if test="${'userAlertList' eq action.actionGroup}">
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
		<a href='#${ownerBeanName}Manager/load${ownerClassName}/${result.id}/${userAlertListName};${userAlertListName}CurrentPage=${page.pageNumber};${userAlertListName}RowsPerPage=${rowsPerPage}/' 
			class='page-link page-action '>${page.title}</a>
	</li>
</c:forEach>
 </ul>
</nav>


   


	<table class="table table-striped" pageToken='userAlertListCurrentPage=${currentPageNumber}'>
		<thead><tr>
		<c:if test="${param.referName ne 'id'}">
	<th>${userContext.localeMap['user_alert.id']}</th>
</c:if>
<c:if test="${param.referName ne 'message'}">
	<th>${userContext.localeMap['user_alert.message']}</th>
</c:if>
<c:if test="${param.referName ne 'profile'}">
	<th>${userContext.localeMap['user_alert.profile']}</th>
</c:if>
<c:if test="${param.referName ne 'location'}">
	<th>${userContext.localeMap['user_alert.location']}</th>
</c:if>
<c:if test="${param.referName ne 'lastUpdate'}">
	<th>${userContext.localeMap['user_alert.last_update']}</th>
</c:if>
<c:if test="${param.referName ne 'platform'}">
	<th>${userContext.localeMap['user_alert.platform']}</th>
</c:if>
<th>${userContext.localeMap['@action']}</th>
		</tr></thead>
		<tbody>
			
			<c:forEach var="item" items="${userAlertList}">
				<tr currentVersion='${item.version}' id="userAlert-${item.id}" ><td><a class="link-action-removed" href="./userAlertManager/view/${item.id}/"> ${item.id}</a></td>
<c:if test="${param.referName ne 'message'}">	<td contenteditable='true' class='edit-value'  propertyToChange='message' storedCellValue='${item.message}' prefix='${ownerBeanName}Manager/updateUserAlert/${result.id}/${item.id}/'>${item.message}</td>
</c:if><c:if test="${param.referName ne 'profile'}">
	<td class="select_candidate_td"
			data-candidate-method="./userAlertManager/requestCandidateProfile/${ownerBeanName}/${item.id}/"
			data-switch-method="./userAlertManager/transferToAnotherProfile/${item.id}/"
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
<c:if test="${param.referName ne 'location'}">	<td contenteditable='true' class='edit-value'  propertyToChange='location' storedCellValue='${item.location}' prefix='${ownerBeanName}Manager/updateUserAlert/${result.id}/${item.id}/'>${item.location}</td>
</c:if><c:if test="${param.referName ne 'lastUpdate'}">	<td contenteditable='true' class='edit-value'  propertyToChange='lastUpdate' storedCellValue='${item.lastUpdate}' prefix='${ownerBeanName}Manager/updateUserAlert/${result.id}/${item.id}/'><fmt:formatDate pattern="yyyy-MM-dd'T'HH:mm:ss" value="${item.lastUpdate}" /></td>
</c:if><c:if test="${param.referName ne 'platform'}">
	<td class="select_candidate_td"
			data-candidate-method="./userAlertManager/requestCandidatePlatform/${ownerBeanName}/${item.id}/"
			data-switch-method="./userAlertManager/transferToAnotherPlatform/${item.id}/"
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

				<a href='#${ownerBeanName}Manager/removeUserAlert/${result.id}/${item.id}/' class='delete-action btn btn-danger btn-xs'><i class="fa fa-trash-o fa-lg"></i> ${userContext.localeMap['@delete']}</a>
				<a href='#${ownerBeanName}Manager/copyUserAlertFrom/${result.id}/${item.id}/' class='copy-action btn btn-success btn-xs'><i class="fa fa-files-o fa-lg"></i> ${userContext.localeMap['@copy']} </a>

				</td>
				</tr>
			</c:forEach>
		
		</tbody>
	</table>	
	

</div></c:if>


