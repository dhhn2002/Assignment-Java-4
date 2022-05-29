<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

    <!-- LATEST CARTOONS SECTION -->
    <div class="section">
        <div class="container">
            <div class="filter-container">
		        <button class="click">Filter</button>
		        <div class="list">
		            <button class="links">
		            	<a href="FindVideoByCategory?category="Anime"">Anime</a> 
		            </button>
		            <button class="links">
						<a href="FindVideoByCategory?category="CN Animation"">CN Animation</a> 
					</button>
		            <button class="links">
						<a href="FindVideoByCategory?category="Cartoons"">Cartoons</a> 		
					</button>
					<button class="links">
						<a href="FindVideoByCategory?category="Action"">Action</a> 		
					</button>
					<button class="links">
						<a href="FindVideoByCategory?category="Science fiction"">Science fiction</a> 		
					</button>
		        </div>
		    </div>
            <div class="section-header-manager">
                <div class="section-header">
                    favorite movies
                </div>
            </div>
            <div class="movies-slide">
                <!-- MOVIE ITEM -->
                <a href="#" class="movie-item">
                    <img src="${pageContext.request.contextPath}/images/cartoons/croods.jpg" alt="">
                    <i class=" fa-solid fa-trash remove-btn"></i>
                    <div class="movie-item-content">
                        <div class="movie-item-title">
                            Croods
                        </div>
                        <div class="movie-infos">
                            <div class="movie-info">
                                <i class="bx bxs-star"></i>
                                <span>9.5</span>
                            </div>
                            <div class="movie-info">
                                <i class="bx bxs-time"></i>
                                <span>120 mins</span>
                            </div>
                            <div class="movie-info">
                                <span>HD</span>
                            </div>
                            <div class="movie-info">
                                <span>16+</span>
                            </div>
                        </div>
                    </div>
                </a>
                <!-- END MOVIE ITEM -->
                <!-- MOVIE ITEM -->
                <a href="#" class="movie-item">
                    <img src="${pageContext.request.contextPath}/images/cartoons/dragon.jpg" alt="">
                    <i class=" fa-solid fa-trash remove-btn"></i>
                    <div class="movie-item-content">
                        <div class="movie-item-title">
                            Dragonball
                        </div>
                        <div class="movie-infos">
                            <div class="movie-info">
                                <i class="bx bxs-star"></i>
                                <span>9.5</span>
                            </div>
                            <div class="movie-info">
                                <i class="bx bxs-time"></i>
                                <span>120 mins</span>
                            </div>
                            <div class="movie-info">
                                <span>HD</span>
                            </div>
                            <div class="movie-info">
                                <span>16+</span>
                            </div>
                        </div>
                    </div>
                </a>
                <!-- END MOVIE ITEM -->
                <!-- MOVIE ITEM -->
                <a href="#" class="movie-item">
                    <img src="${pageContext.request.contextPath}/images/cartoons/over-the-moon.jpg" alt="">
                    <i class=" fa-solid fa-trash remove-btn"></i>
                    <div class="movie-item-content">
                        <div class="movie-item-title">
                            Over The Moon
                        </div>
                        <div class="movie-infos">
                            <div class="movie-info">
                                <i class="bx bxs-star"></i>
                                <span>9.5</span>
                            </div>
                            <div class="movie-info">
                                <i class="bx bxs-time"></i>
                                <span>120 mins</span>
                            </div>
                            <div class="movie-info">
                                <span>HD</span>
                            </div>
                            <div class="movie-info">
                                <span>16+</span>
                            </div>
                        </div>
                    </div>
                </a>
                <!-- END MOVIE ITEM -->
                <!-- MOVIE ITEM -->
                <a href="#" class="movie-item">
                    <img src="${pageContext.request.contextPath}/images/cartoons/weathering.jpg" alt="">
                    <i class=" fa-solid fa-trash remove-btn"></i>
                    <div class="movie-item-content">
                        <div class="movie-item-title">
                            Weathering With You
                        </div>
                        <div class="movie-infos">
                            <div class="movie-info">
                                <i class="bx bxs-star"></i>
                                <span>9.5</span>
                            </div>
                            <div class="movie-info">
                                <i class="bx bxs-time"></i>
                                <span>120 mins</span>
                            </div>
                            <div class="movie-info">
                                <span>HD</span>
                            </div>
                            <div class="movie-info">
                                <span>16+</span>
                            </div>
                        </div>
                    </div>
                </a>
                <!-- END MOVIE ITEM -->
                <!-- MOVIE ITEM -->
                <a href="#" class="movie-item">
                    <img src="${pageContext.request.contextPath}/images/cartoons/your-name.jpg" alt="">
                    <i class=" fa-solid fa-trash remove-btn"></i>
                    <div class="movie-item-content">
                        <div class="movie-item-title">
                            Your Name
                        </div>
                        <div class="movie-infos">
                            <div class="movie-info">
                                <i class="bx bxs-star"></i>
                                <span>9.5</span>
                            </div>
                            <div class="movie-info">
                                <i class="bx bxs-time"></i>
                                <span>120 mins</span>
                            </div>
                            <div class="movie-info">
                                <span>HD</span>
                            </div>
                            <div class="movie-info">
                                <span>16+</span>
                            </div>
                        </div>
                    </div>
                </a>
                <!-- END MOVIE ITEM -->
                <!-- MOVIE ITEM -->
                <a href="#" class="movie-item">
                    <img src="${pageContext.request.contextPath}/images/cartoons/coco.jpg" alt="">
                    <i class=" fa-solid fa-trash remove-btn"></i>
                    <div class="movie-item-content">
                        <div class="movie-item-title">
                            Coco
                        </div>
                        <div class="movie-infos">
                            <div class="movie-info">
                                <i class="bx bxs-star"></i>
                                <span>9.5</span>
                            </div>
                            <div class="movie-info">
                                <i class="bx bxs-time"></i>
                                <span>120 mins</span>
                            </div>
                            <div class="movie-info">
                                <span>HD</span>
                            </div>
                            <div class="movie-info">
                                <span>16+</span>
                            </div>
                        </div>
                    </div>
                </a>
                <!-- END MOVIE ITEM -->
                <!-- MOVIE ITEM -->
                <a href="#" class="movie-item">
                    <img src="${pageContext.request.contextPath}/images/cn-animation/HGH-Bat-Luong-Nhan-5.jpg" alt="">
                    <i class=" fa-solid fa-trash remove-btn"></i>
                    <div class="movie-item-content">
                        <div class="movie-item-title">
                            Huajianghu Zhi Buliang Ren
                        </div>
                        <div class="movie-infos">
                            <div class="movie-info">
                                <i class="bx bxs-star"></i>
                                <span>9.5</span>
                            </div>
                            <div class="movie-info">
                                <i class="bx bxs-time"></i>
                                <span>120 mins</span>
                            </div>
                            <div class="movie-info">
                                <span>HD</span>
                            </div>
                            <div class="movie-info">
                                <span>16+</span>
                            </div>
                        </div>
                    </div>
                </a>
                <!-- END MOVIE ITEM -->
                <!-- MOVIE ITEM -->
                <a href="#" class="movie-item">
                    <img src="${pageContext.request.contextPath}/images/cn-animation/Ta-La-Dai-Than-Tien.jpg" alt="">
                    <i class=" fa-solid fa-trash remove-btn"></i>
                    <div class="movie-item-content">
                        <div class="movie-item-title">
                            Wo Shi Da Shen Xian
                        </div>
                        <div class="movie-infos">
                            <div class="movie-info">
                                <i class="bx bxs-star"></i>
                                <span>9.5</span>
                            </div>
                            <div class="movie-info">
                                <i class="bx bxs-time"></i>
                                <span>120 mins</span>
                            </div>
                            <div class="movie-info">
                                <span>HD</span>
                            </div>
                            <div class="movie-info">
                                <span>16+</span>
                            </div>
                        </div>
                    </div>
                </a>
                <!-- END MOVIE ITEM -->
                <!-- MOVIE ITEM -->
                <a href="#" class="movie-item">
                    <img src="${pageContext.request.contextPath}/images/cn-animation/Dau-Pha-Thuong-Khung-OVA-3.jpg" alt="">
                    <i class=" fa-solid fa-trash remove-btn"></i>
                    <div class="movie-item-content">
                        <div class="movie-item-title">
                            Battle Through The Heavens
                        </div>
                        <div class="movie-infos">
                            <div class="movie-info">
                                <i class="bx bxs-star"></i>
                                <span>9.5</span>
                            </div>
                            <div class="movie-info">
                                <i class="bx bxs-time"></i>
                                <span>120 mins</span>
                            </div>
                            <div class="movie-info">
                                <span>HD</span>
                            </div>
                            <div class="movie-info">
                                <span>16+</span>
                            </div>
                        </div>
                    </div>
                </a>
                <!-- END MOVIE ITEM -->

                <!-- MOVIE ITEM -->
                <a href="#" class="movie-item">
                    <img src="${pageContext.request.contextPath}/images/cn-animation/Thon-Phe-Tinh-Khong.jpg" alt="">
                    <i class=" fa-solid fa-trash remove-btn"></i>
                    <div class="movie-item-content">
                        <div class="movie-item-title">
                            Swallowed Star
                        </div>
                        <div class="movie-infos">
                            <div class="movie-info">
                                <i class="bx bxs-star"></i>
                                <span>9.5</span>
                            </div>
                            <div class="movie-info">
                                <i class="bx bxs-time"></i>
                                <span>120 mins</span>
                            </div>
                            <div class="movie-info">
                                <span>HD</span>
                            </div>
                            <div class="movie-info">
                                <span>16+</span>
                            </div>
                        </div>
                    </div>
                </a>
                <!-- END MOVIE ITEM -->
                <!-- MOVIE ITEM -->
                <a href="#" class="movie-item">
                    <img src="${pageContext.request.contextPath}/images/cn-animation/Vinh-Sinh.jpg" alt="">
                    <i class=" fa-solid fa-trash remove-btn"></i>
                    <div class="movie-item-content">
                        <div class="movie-item-title">
                            Immortality
                        </div>
                        <div class="movie-infos">
                            <div class="movie-info">
                                <i class="bx bxs-star"></i>
                                <span>9.5</span>
                            </div>
                            <div class="movie-info">
                                <i class="bx bxs-time"></i>
                                <span>120 mins</span>
                            </div>
                            <div class="movie-info">
                                <span>HD</span>
                            </div>
                            <div class="movie-info">
                                <span>16+</span>
                            </div>
                        </div>
                    </div>
                </a>
                <!-- END MOVIE ITEM -->
            </div>
        </div>
    </div>
    <!-- END LATEST CARTOONS SECTION -->