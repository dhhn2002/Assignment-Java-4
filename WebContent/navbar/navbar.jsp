<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<base href="/ASM_Java4/">
    <!-- NAV -->
    <div class="nav-wrapper">
        <div class="container">
            <div class="nav">
                <a href="Home" class="logo">
                    <i class='bx bx-movie-play bx-tada main-color'></i>Fl<span class="main-color">i</span>x
                </a>
                
                <form action="FindVideo" class="find-block">
                    <input type="text" class="find-input" name="find-input">
                    <button type="submit">
                        <i class="bx bxs-search-alt-2"></i>
                    </button>
                </form>
                
                <ul class="nav-menu" id="nav-menu">
                    <li><a href="Home">Home</a></li>
                    <li><a href="List">All</a></li>
                    <li><a href="Category">Category</a></li>
                    <c:if test="${!isLogin}">
	                    <li>
	                       <a href="Login" class="btn btn-hover"> 
	                           <span>Sign in</span>
	                       </a> 
	                    </li>
	                </c:if>  
	                  
	                <c:if test="${isLogin}">
	                    <li class="login-btn">
	                        <a href="#" class="btn btn-hover">
	                        <span>User</span>
	                        </a>
	                        <ul class="login-menu-lv2">
<!-- 	                            <li class="login-item-lv2"> -->
<!-- 	                            	<a href="/ASM_Java4/Favorites">Favorites</a>  -->
<!-- 	                            </li> -->
	                            <li class="login-item-lv2">
									<a href="Logout">Log out</a> 							
								</li>
	                        </ul>
	                    </li>
                    </c:if>    
                </ul>
                <!-- MOBILE MENU TOGGLE -->
                <div class="hamburger-menu" id="hamburger-menu">
                    <div class="hamburger"></div>
                </div>
            </div>
        </div>
    </div>
    <!-- END NAV -->
    