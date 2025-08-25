<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Home Page</title>
    <link rel="stylesheet" type="text/css" href="css/manageu.css">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css">
    <!--BoxIcon CDN Link-->
    <link href='https://unpkg.com/boxicons@2.1.4/css/boxicons.min.css' rel='stylesheet'>
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.2/css/all.min.css" rel="stylesheet">

   <style>
    
   .content-container {
            display: flex;
            justify-content: center;
            align-items: center;
            padding: 20px;

        }

        .content {
            display: flex;
            flex-direction: column;
            align-items: center;
            border-radius: 10px;
            padding: 20px;
            width: 350px;
            text-align: center;
        }

        .support {
            display: flex;
            flex-direction: column;
            align-items: center;
        }

        .support i {
            font-size: 48px;
            color: white;
            margin-bottom: 10px;
        }

        .support h2 {
            font-size: 24px;
            margin-bottom: 10px;
            color: white;
        }

        .support p {
            font-size: 14px;
            color: white;
            margin-bottom: 20px;
        }

        /* Submit button with hover effect */
        .btn.find-user-btn {
            background-color: #4CAF50;
            color: white;
            padding: 10px 20px;
            border: none;
            border-radius: 5px;
            font-size: 16px;
            cursor: pointer;
        }

        .btn.find-user-btn:hover {
            background-color: #45a049;
        }

        .username-link {
            color: #0d0d0e; /* Color of the username */
            text-decoration: none; /* Remove underline */
            font-weight: bold; /* Make it bold */
            margin-right: 50px;
            font-size: 30px;
        }

        .username-link1 {
            color: #0d0d0e; /* Color of the username */
            text-decoration: none; /* Remove underline */
            font-weight: bold; /* Make it bold */
            font-size: 30px;
        }

        .username-link:hover {
            color: rgb(14, 85, 85);
            text-decoration: none; /* No underline on hover */
        }

        .username-link1:hover {
            color: rgb(14, 85, 85);
            text-decoration: none; /* No underline on hover */
        }
        
       
    </style>
</head>
<body>

    <div class="container-fluid">
        <div class="row align-items-center">
            <!-- Logo Section -->
            <div class="col-md-6">
                <img src="image/logo1.jpg" alt="Reuban College Logo" class="img-fluid" style="width: 70% height 30%">
            </div>
            <!-- User Profile Section -->
            <div class="col-md-6 text-end">
                <div class="d-flex align-items-center justify-content-end">
                    <a href="/profile" class="username-link" >${username}</a> 
                    <a href="" class="username-link1"><i class="bi bi-person-circle" style="font-size: 50px; margin-right: 10px;"></i></a>
                </div>
            </div>
        </div>
    </div>

    <!-- Header Section -->
    <header class="d-flex justify-content-end align-items-center" style="background-color: #839492; color: #fff; padding: 10px;">
        <nav>
            <ul class="nav">
                <li class="nav-item">
                    <a class="btn custom-btn me-4" href="principalHome.jsp">Home</a>
                </li>
                <li class="nav-item">
                    <a class="btn custom-btn me-4" href="managepri.jsp">Manage Events</a>
                </li>
                <li class="nav-item">
                    <a class="btn custom-btn me-4" href="logout">Log out</a>
                </li>
            </ul>
        </nav>
    </header>
        
    
     <!--Flex boxes-->
     
        <!-- Search Bar form submits to search_user.html page with query parameter -->
            
            
   <form action="addevent" method="post">
    <div class="content-container">
        <!-- Flexbox for styling -->
        <div class="content">
            <!-- Support container for icon, title, and description -->
            <div class="support">
                <!-- Font Awesome icon for user addition -->
                <i class="bi bi-calendar-event-fill"></i>
                <!-- Heading for the action -->
                <h2>Manage Event</h2>
                <!-- Description for the action -->
                <p>You can Manage Event here</p>
                <!-- Submit button styled like the content block -->
                <input type="submit" class="btn find-user-btn" value="Add Event" style="margin-top: 10px;">
            </div>
        </div>
    </div>
</form>

     <!-- Footer Section -->
    <footer>
        <p>&copy; 2024 Reuban College G10. <br>All rights reserved.</p>
    </footer>
    
</body>
</html>
