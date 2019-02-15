<%@ page import='java.util.*,com.doublechaintech.uxs.*'%>
<%@ page language="java" contentType="text/plain; charset=utf-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="sky" tagdir="/tags"%>
<fmt:setLocale value="zh_CN"/>
<c:set var="ignoreListAccessControl" value="${true}"/>


<c:if test="${ empty blogList}" >
	<div class="row" style="font-size: 30px;">
		<div class="col-xs-12 col-md-12" style="padding-left:20px">
		 ${userContext.localeMap['@not_found']}${userContext.localeMap['blog']}! 
		 <a href="./${ownerBeanName}Manager/addBlog/${result.id}/"><i class="fa fa-plus-square" aria-hidden="true"></i></a>
		 
		 
		 
		 </div>
	</div>

</c:if>




	

 <c:if test="${not empty blogList}" >
    
    
<%

 	SmartList list=(SmartList)request.getAttribute("blogList"); 
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
		<i class='fa fa-table'></i> ${userContext.localeMap['blog']}(${totalCount})
		<a href="./${ownerBeanName}Manager/addBlog/${result.id}/"><i class="fa fa-plus-square" aria-hidden="true"></i></a>
		 
		 		 	<div class="btn-group" role="group" aria-label="Button group with nested dropdown">		
	<c:forEach var="action" items="${result.actionList}">
		<c:if test="${'blogList' eq action.actionGroup}">
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
		<a href='#${ownerBeanName}Manager/load${ownerClassName}/${result.id}/${blogListName};${blogListName}CurrentPage=${page.pageNumber};${blogListName}RowsPerPage=${rowsPerPage}/' 
			class='page-link page-action '>${page.title}</a>
	</li>
</c:forEach>
 </ul>
</nav>


   


	<table class="table table-striped" pageToken='blogListCurrentPage=${currentPageNumber}'>
		<thead><tr>
		<c:if test="${param.referName ne 'id'}">
	<th>${userContext.localeMap['blog.id']}</th>
</c:if>
<c:if test="${param.referName ne 'title'}">
	<th>${userContext.localeMap['blog.title']}</th>
</c:if>
<c:if test="${param.referName ne 'content'}">
	<th>${userContext.localeMap['blog.content']}</th>
</c:if>
<c:if test="${param.referName ne 'user'}">
	<th>${userContext.localeMap['blog.user']}</th>
</c:if>
<c:if test="${param.referName ne 'product'}">
	<th>${userContext.localeMap['blog.product']}</th>
</c:if>
<c:if test="${param.referName ne 'updateTime'}">
	<th>${userContext.localeMap['blog.update_time']}</th>
</c:if>
<th>${userContext.localeMap['@action']}</th>
		</tr></thead>
		<tbody>
			
			<c:forEach var="item" items="${blogList}">
				<tr currentVersion='${item.version}' id="blog-${item.id}" ><td><a class="link-action-removed" href="./blogManager/view/${item.id}/"> ${item.id}</a></td>
<c:if test="${param.referName ne 'title'}">	<td contenteditable='true' class='edit-value'  propertyToChange='title' storedCellValue='${item.title}' prefix='${ownerBeanName}Manager/updateBlog/${result.id}/${item.id}/'>${item.title}</td>
</c:if><c:if test="${param.referName ne 'content'}">	<td contenteditable='true' class='edit-value'  propertyToChange='content' storedCellValue='${item.content}' prefix='${ownerBeanName}Manager/updateBlog/${result.id}/${item.id}/'><a title='${item.content}'>${fn:substring(item.content,0,10)}...</a></td>
</c:if><c:if test="${param.referName ne 'user'}">
	<td class="select_candidate_td"
			data-candidate-method="./blogManager/requestCandidateUser/${ownerBeanName}/${item.id}/"
			data-switch-method="./blogManager/transferToAnotherUser/${item.id}/"
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
			data-candidate-method="./blogManager/requestCandidateProduct/${ownerBeanName}/${item.id}/"
			data-switch-method="./blogManager/transferToAnotherProduct/${item.id}/"
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
<c:if test="${param.referName ne 'updateTime'}">	<td contenteditable='true' class='edit-value'  propertyToChange='updateTime' storedCellValue='${item.updateTime}' prefix='${ownerBeanName}Manager/updateBlog/${result.id}/${item.id}/'><fmt:formatDate pattern="yyyy-MM-dd'T'HH:mm:ss" value="${item.updateTime}" /></td>
</c:if>
				<td>

				<a href='#${ownerBeanName}Manager/removeBlog/${result.id}/${item.id}/' class='delete-action btn btn-danger btn-xs'><i class="fa fa-trash-o fa-lg"></i> ${userContext.localeMap['@delete']}</a>
				<a href='#${ownerBeanName}Manager/copyBlogFrom/${result.id}/${item.id}/' class='copy-action btn btn-success btn-xs'><i class="fa fa-files-o fa-lg"></i> ${userContext.localeMap['@copy']} </a>

				</td>
				</tr>
			</c:forEach>
		
		</tbody>
	</table>	
	

</div></c:if>


