<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Gallery - www.hightech.co.kr</title>
    <link rel="stylesheet" href="css/style.css">
    <style>
        * {
            margin: 0;
            padding: 0;
            box-sizing: border-box;
        }
        
        .gallery {
            width: 100%;
            padding: 100px 0;
            background: #f5f5f5;
        }
        
        .gallery .inner {
            width: 1180px;
            margin: 0 auto;
        }
        
        .gallery h1 {
            font: bold 24px/1 "arial";
            color: #555;
            text-align: center;
            margin-bottom: 50px;
        }
        
        .gallery .wrap {
            display: flex;
            flex-wrap: wrap;
            gap: 20px;
            justify-content: space-between;
        }
        
        .gallery .wrap .item {
            flex: 1 1 calc(25% - 20px); /* 4 items per row */
            background: #fff;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            transition: transform 0.3s, box-shadow 0.3s;
            display: flex;
            flex-direction: column;
            height: 380px; /* 고정 높이 설정 */
        }
        
        .gallery .wrap .item:hover {
            transform: translateY(-10px);
            box-shadow: 0 15px 20px rgba(0, 0, 0, 0.2);
        }
        
        .gallery .wrap .item img {
            width: 100%;
            height: 200px;
            object-fit: cover;
        }
        
        .gallery .wrap .item h2 {
            font: bold 16px/1 "arial";
            color: #333;
            padding: 10px;
            margin: 0; /* 여백 제거 */
        }
        
        .gallery .wrap .item p {
            font: 14px/1.4 "arial";
            color: #777;
            padding: 0 10px 10px;
            flex-grow: 1; /* 텍스트가 빈 공간을 채우도록 설정 */
            margin: 0; /* 여백 제거 */
        }
    </style>
</head>
<body>
    <header>
        <div class="inner">
            <h1><a href="index.jsp">InnovateTech</a></h1>
            <ul id="gnb">
                <li><a href="#">DEPARTMENT</a></li>
                <li><a href="gallery.jsp">GALLERY</a></li>
                <li><a href="#">YOUTUBE</a></li>
                <li><a href="#">COMMUNITY</a></li>
                <li><a href="board.jsp">COMMUNICATION</a></li>
            </ul>
            <ul class="util">
                <li><a href="#">Contact</a></li>
                <li><a href="#">Help</a></li>
                <% if (session.getAttribute("userId") != null) { %>
                    <li class="username"><%= session.getAttribute("username") %></li>
                    <li><a href="logout.jsp">Logout</a></li>
                <% } else { %>
                    <li><a href="login.jsp">Login</a></li>
                    <li><a href="signup.jsp">Join</a></li>
                <% } %>
                <li><a href="#">Sitemap</a></li>
            </ul>
        </div>
    </header>

    <section class="gallery">
        <div class="inner">
            <h1>Gallery</h1>
            <div class="wrap">
                <div class="item">
                    <img src="img/gallery1.jpg" alt="Gallery Image 1">
                    <h2>Gallery Image 1</h2>
                    <p>Description of the first gallery image.</p>
                </div>
                <div class="item">
                    <img src="img/gallery2.jpg" alt="Gallery Image 2">
                    <h2>Gallery Image 2</h2>
                    <p>Description of the second gallery image.</p>
                </div>
                <div class="item">
                    <img src="img/gallery3.jpg" alt="Gallery Image 3">
                    <h2>Gallery Image 3</h2>
                    <p>Description of the third gallery image.</p>
                </div>
                <div class="item">
                    <img src="img/gallery4.jpg" alt="Gallery Image 4">
                    <h2>Gallery Image 4</h2>
                    <p>Description of the fourth gallery image.</p>
                </div>
                <div class="item">
                    <img src="img/gallery5.jpg" alt="Gallery Image 5">
                    <h2>Gallery Image 5</h2>
                    <p>Description of the fifth gallery image.</p>
                </div>
                <div class="item">
                    <img src="img/gallery6.jpg" alt="Gallery Image 6">
                    <h2>Gallery Image 6</h2>
                    <p>Description of the sixth gallery image.</p>
                </div>
                <div class="item">
                    <img src="img/gallery7.jpg" alt="Gallery Image 7">
                    <h2>Gallery Image 7</h2>
                    <p>Description of the seventh gallery image.</p>
                </div>
                <div class="item">
                    <img src="img/gallery8.jpg" alt="Gallery Image 8">
                    <h2>Gallery Image 8</h2>
                    <p>Description of the eighth gallery image.</p>
                </div>
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
