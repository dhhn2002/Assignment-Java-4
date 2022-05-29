<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/login.css">
    <title>Login</title>
    <style type="text/css">
</style>
</head>

<body>
    <div class="wrapper">
        <div class="login__body">
            <div class="login__box">
                <h2>Sign in</h2>
                <form action="" method="post">
                    <div class="input__wrap">
                        <input class="username" type="text" name="username" placeholder="Username">
                    </div>
                    <div class="input__wrap">
                        <input class="password" type="password" name="password" placeholder="Password">
                    </div>
                    <div class="input__wrap">
                        <button type="submit" >Sign in</button>
                    </div>
                    
                    <input class="isRemember-btn" type="checkbox" name="remember"> Remember
                    
                    <jsp:include page="/common/inform.jsp"></jsp:include>
                    
                    <div class="sign__up">
                        <p>
                            New to Flix?
                            <a href="/ASM_Java4/Register">Sign up</a>
                        </p>
                    </div>
                </form>
            </div>
        </div>
    </div>
</body>

</html>