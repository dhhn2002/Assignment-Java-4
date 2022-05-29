<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

    <div class="section">
        <div class="container">
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
            
            <div class="section-header-manager">
                <div class="section-header">
                    all movies
                </div>
            </div>
            <div class="movies-slide">
            	<c:forEach items="${videos}" var="item">
	                <!-- MOVIE ITEM -->
	                <a href="VideoDetail?id=${item.videoId}" class="movie-item">
	                    <img src="${item.poster}" alt="">
	                    <div class="movie-item-content">
	                        <div class="movie-item-title">
	                            ${item.title}
	                        </div>
	                        <div class="movie-infos">
	                            <div class="movie-info">
	                                <i class="bx bxs-low-vision"></i>
	                                <span>
	                                	<fmt:formatNumber type = "number" 
	                                	maxFractionDigits = "3" value = "${item.views}"/>
	                                	views
									</span>
	                            </div>
	                            <div class="movie-info">
	                                <i class="bx bxs-category"></i>
	                                <span>${item.category}</span>
	                            </div>
	                        </div>
	                    </div>
	                </a>
	                    
                	<!-- END MOVIE ITEM -->
                </c:forEach>	
            </div>
        </div>
    </div>