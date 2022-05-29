<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<div class="container">
        <div class="movie-item">
            <img class="movie-item-img" src="${video.poster }" alt="">

            <div class="movie-item-content">
                <div class="movie-item-title">
                    ${video.title }
                </div>

                <div class="movie-item-infos">
                    <div class="movie-item-info">
                        <i class="bx bxs-low-vision"></i>
                        <span>
                           	<fmt:formatNumber type = "number" 
                           	maxFractionDigits = "3" value = "${video.views}"/>
                           	views
						</span>
                    </div>

                    <div class="movie-item-fo">
                        <i class="bx bxs-category"></i>
                        <span>${video.category }</span>
                    </div>
                </div>

                <div class="movie-item-description">
                    ${video.description }
                </div>

                <a href="watchVideo?id=${video.videoId}" class="btn btn-hover">
                    <i class="bx bxs-right-arrow"></i>
                    <span>Watch now</span>
                </a>

            </div>
        </div>
    </div>
