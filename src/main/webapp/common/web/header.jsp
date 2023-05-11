<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp" %>
<!-- ----------------------------------------------------------------------------------Header -->
<link href="../../template/web/css/style.css" rel="stylesheet" type="text/css"/>
<!-- ----------------------------------------------------------------------------Header-Banner-->
<div class="header">
	<!-- --------------------------------------------------------------------------Header-Top-Bar-->
	<div class="top-bar">
	    <div class="top-bar__container">
                <div class="top-bar__container-wrap">
                    <a href='<c:url value="/all-product-by-category?categoryId=1"></c:url>' class="top-bar__container-wrap-link">
                        <span>Công ty</span>
                    </a>
                    <a href='<c:url value="/all-product-by-category?categoryId=2"></c:url>' class="top-bar__container-wrap-link">
                        <span>Công việc</span>
                    </a> 
                    <a href='<c:url value="/all-product-by-category?categoryId=3"></c:url>' class="top-bar__container-wrap-link">
                        <span>CV</span>
                    </a>
                </div>
	    </div>
	</div>
        
        
        
        
	<!-- -------------------------------------------------------------------------Header-Masthead-->
	<div class="masthead">
	    <div class="masthead__container">
	        <div class="masthead__logo">  
	            <a href="<c:url value='/trang-chu'/>" class="masthead__logo-text">Practical Education</a>
	            <i class="fas fa-bars masthead__menu-toggle"></i>
	        </div>
        	<form class="masthead__find" action='<c:url value="/all-product-by-brand"></c:url>' method="get">
        		<input type="hidden" name="search" value ="true">
	        	<input type="text" name="keyWord" class="masthead__find-input" placeholder="Tìm kiếm cơ hội việc làm của bạn tại đây ...">
	            <button type="submit" class="masthead__find-btn" >
	                <i class="fa fa-search"></i>
	                <span>Search</span>
	                <span></span>
	            </button>
        	</form>       
	        <div class="masthead__icon">
	        	<c:if test="${not empty USERMODEL}">
					<a  href="<c:url value='/profile'/>" class="masthead__login">
					<i class="fa fa-user"></i>
                    <p class="masthead__login-item">${USERMODEL.fullName}</p></a>
				</c:if>
				<c:if test="${empty USERMODEL}">
					<a href="<c:url value='/dang-nhap?action=login'/>" class="masthead__login">
		                <i class="fa fa-user"></i>
		                <p class="masthead__login-item">Login</p>
	            	</a>
				</c:if>
                    <a href="<%=request.getContextPath()%>/admin-dashboard" class="masthead__cart">
	                <p class="masthead__cart-item" >Admin</p>
	            	</a>
	        </div>
		</div>
	</div>
</div>