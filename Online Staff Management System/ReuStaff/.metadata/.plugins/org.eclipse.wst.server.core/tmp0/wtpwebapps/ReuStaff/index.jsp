<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Login Page</title>
    <link rel="stylesheet" href="css/loging.css">
</head>
<body>
    <div class="container">
        <div class="image-container">
            <img src="image/l.jpg" width="100%">
        </div>

        <div class="login-form">
            <div class="imge">
                <img src="image/bac.png" class="logo">
            </div>
            <h1>Login</h1>
     <form action=LoginUser method="POST">
        <label>Enter username: </label>
        <input type="text" id="uname" name="uname" required> <!-- Added 'required' -->
        <br><br>
        
        <label>Enter password: </label>
        <input type="password" id="upass" name="upass" required><br><br> <!-- Added 'required' -->
        
       <button type="submit" value="Login">Login</button>
    </form>
        </div>
    </div>
</body>
</html>
