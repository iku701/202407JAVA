<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%
    Integer userId = (Integer) session.getAttribute("userId");
    String username = (String) session.getAttribute("username");
%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>www.hightech.co.kr</title>
    <link rel="icon" href="favicon.ico" type="image/x-icon">
    <script src="https://kit.fontawesome.com/c47106c6a7.js" crossorigin="anonymous"></script>
    <link rel="stylesheet" href="css/style.css">
    <style>
        .util li.username {
            font-weight: bold;
            color: #333;
            font-size: 14px;
        }

        .util li a {
            font-weight: bold;
            color: #007BFF;
            text-decoration: none;
        }

        .util li a:hover {
            color: #0056b3;
        }
    </style>
</head>
<body>
    <header>
        <div class="inner">
            <h1><a href="#">InnovateTech</a></h1>
            <ul id="gnb">
                <li><a href="#">DEPARTMENT</a></li>
                <li><a href="#">YOUTUBE</a></li>
                <li><a href="#">COMMUNITY</a></li>
                <li><a href="board.jsp">COMMUNICATION</a></li> 
                <li><a href="gallery.jsp">GALLERY</a></li>
            </ul>
            <ul class="util">
                <li><a href="#">Contact</a></li>
                <li><a href="#">Help</a></li>
                <% if (userId != null) { %>
                    <li class="username"><%= username %></li>
                    <li><a href="logout.jsp">Logout</a></li>
                <% } else { %>
                    <li><a href="login.jsp">Login</a></li>
                    <li><a href="signup.jsp">Join</a></li>
                <% } %>
                <li><a href="#">Sitemap</a></li>
            </ul>
        </div>
    </header>

    <figure>
        <video src="img/HTblurVideo.mp4" autoplay muted loop></video>
        <div class="inner">
            <h1>INNOVATETECH</h1>
            <p>Is a leading technology company dedicated to innovation. <br>
                It provides cutting-edge solutions and services to enhance business efficiency and productivity.</p>
            <a href="#">View Detail</a>
        </div>
    </figure>

    <section>
        <div class="inner">
            <h1>Recent News</h1>
            <div class="wrap">
                <article>
                    <div class="pic">
                        <img src="img/news1.jpg" alt="1번째 콘텐츠 이미지">
                    </div>
                    <h2><a href="#">Lorem ipsum dolor sit.</a></h2>
                    <p>Lorem ipsum dolor sit, amet consectetur adipisicing elit. Vitae minus, eaque corrupti vero ad maiores!</p>
                </article>

                <article>
                    <div class="pic">
                        <img src="img/news2.jpg" alt="2번째 콘텐츠 이미지">
                    </div>
                    <h2><a href="#">Lorem ipsum dolor sit.</a></h2>
                    <p>Lorem ipsum dolor sit, amet consectetur adipisicing elit. Vitae minus, eaque corrupti vero ad maiores!</p>
                </article>

                <article>
                    <div class="pic">
                        <img src="img/news3.jpg" alt="3번째 콘텐츠 이미지">
                    </div>
                    <h2><a href="#">Lorem ipsum dolor sit.</a></h2>
                    <p>Lorem ipsum dolor sit, amet consectetur adipisicing elit. Vitae minus, eaque corrupti vero ad maiores!</p>
                </article>

                <article>
                    <div class="pic">
                        <img src="img/news4.jpg" alt="4번째 콘텐츠 이미지">
                    </div>
                    <h2><a href="#">Lorem ipsum dolor sit.</a></h2>
                    <p>Lorem ipsum dolor sit, amet consectetur adipisicing elit. Vitae minus, eaque corrupti vero ad maiores!</p>
                </article>
            </div>
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
                    TEL: 031-111-1234 C.P: 010-1234-5678
                </address>
                <p>2020 INNOVATETECH &copy; copyright all rights reserved.</p>
            </div>
        </div>
    </footer>
</body>
</html>
