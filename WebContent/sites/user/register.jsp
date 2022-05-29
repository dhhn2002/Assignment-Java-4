<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/register.css">
    <title>Register</title>
</head>

<body>
    <div class="wrapper">
        <div class="login__body">
            <div class="login__box">
                <h2>Sign up</h2>
                <form action="Register" method="post">
                    <div class="input__wrap">
                        <input type="text" name="username" placeholder="Username" value="${user.username }">
                    </div>
                    <div class="input__wrap">
                        <input type="password" name="password" placeholder="Password">
                    </div>
                    <div class="input__wrap">
                        <input type="text" name="fullname" placeholder="Fullname" value="${user.fullname }">
                    </div>
                    <div class="input__wrap">
                        <input type="text" name="email" placeholder="Email" value="${user.email }">
                    </div>
                    
                    <jsp:include page="/common/inform.jsp"></jsp:include>
                    
                    <div class="input__wrap">
                        <button type="submit">Sign up</button>
                    </div>
                    <div class="sign__in">
                        <p>
                            Already have account?
                            <a href="/ASM_Java4/Login">Sign in</a>
                        </p>
                    </div>
                </form>
            </div>
        </div>
    </div>
</body>

</html>