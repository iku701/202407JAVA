<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Signup - www.hightech.co.kr</title>
    <link rel="stylesheet" href="css/style.css">
</head>
<body>

    <header>
        <div class="inner">
            <h1><a href="index.jsp">InnovateTech</a></h1>
        </div>
    </header>

    <section>
        <div class="inner">
            <h1>SIGN UP</h1>
            <form action="signupProcess.jsp" method="post">
                <label for="username">Username:</label>
                <input type="text" id="username" name="username" required><br>
                <label for="password">Password:</label>
                <input type="password" id="password" name="password" required><br>
                <label for="email">Email:</label>
                <input type="email" id="email" name="email" required><br>
                <button type="submit">Join</button>
            </form>
        </div>
    </section>

    <footer>
        <div class="inner">
            <div class="upper">
                <h1>INNOVATETECH</h1>
                <ul>
                    <li><a href="#">How to come</a></li>   	
                    <li><a href="#">Policy</a></li>
                    <li><a href="#">Terms</a></li>
                    <li><a href="#">Family Site</a></li>
                    <li><a href="#">Sitemap</a></li>
                </ul>
            </div>

            <div class="lower">
                <address>
                    7 Gukhoe-daero 70-gil, Yeongdeungpo-gu, Seoul<br>
                    TEL : 031-111-1234 C.P : 010-1234-5678
                </address>
                <p>
                    2020 INNOVATETECH &copy; copyright all right reserved.
                </p>
            </div>
        </div>
    </footer>

</body>
</html>
