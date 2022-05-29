<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

          <div class="filter-container">
        <button class="click">Filter</button>
        <div class="list">
            <c:forEach var="item" items="${cats}">
	            <button class="links">
	            	<a href="FindVideoByCategory?category=${item.categoryName}">
	            		${item.categoryName}
					</a> 
	            </button>
	        </c:forEach>    
        </div>
    </div>
	<!-- CARTOONS SECTION -->
	<c:forEach var="item" items="${cats}">
	    <div class="section">
	        <div class="container">
	
	            <div class="section-header-manager">
	                <div class="section-header">
	                    ${item.categoryName}
	                </div>
	            </div>
	            <div class="movies-slide">
					<c:forEach var="video" items="${videos}">
						<c:if test="${video.category == item.categoryName }">        
			                <!-- MOVIE ITEM -->
			                <a href="VideoDetail?id=${video.videoId}" class="movie-item">
			                    <img src="${video.poster}">
			                    <div class="movie-item-content">
			                        <div class="movie-item-title">
			                            ${video.title}
			                        </div>
			                        <div class="movie-infos">
			                            <div class="movie-info">
			                                <i class="bx bxs-low-vision"></i>
			                                <span>
			                                	<fmt:formatNumber type = "number" 
			                                	maxFractionDigits = "3" value = "${video.views}"/>
			                                	views
											</span>
			                            </div>
			                            <div class="movie-info">
			                                <i class="bx bxs-category"></i>
			                                <span>${video.category}</span>
			                            </div>
			                        </div>
			                    </div>
			                </a>
			                <!-- END MOVIE ITEM -->
			            </c:if>  
					</c:forEach>
	            </div>
	        </div>
	    </div>
	</c:forEach>    
    <!-- END CARTOONS SECTION -->
