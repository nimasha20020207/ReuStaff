<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Update Event Page</title>
<link rel="stylesheet" type="text/css" href="css/home.css">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
	crossorigin="anonymous">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css">

<style>
body {
	background-color: #f4f7f6;
}

.form-container {
	margin-top: 50px;
	background-color: #fff;
	padding: 30px;
	box-shadow: 0 0 15px rgba(0, 0, 0, 0.1);
	border-radius: 10px;
}

.form-heading {
	text-align: center;
	margin-bottom: 20px;
	font-size: 28px;
	font-weight: bold;
}

.form-group label {
	font-weight: bold;
}

.btn-submit {
	background-color: #198754;
	color: white;
}

.btn-cancel {
	background-color: #6c757d;
	color: white;
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

/* Announcement Section */
.announcement-section {
	background: radial-gradient(circle at top left, #91ddd2, #bec4c5);
	/* Radial gradient */
	padding: 40px;
	border-radius: 10px;
	box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
}

h2 {
	font-size: 36px;
	margin-bottom: 20px;
}

.table th {
	font-size: 18px;
	font-weight: bold;
	text-align: left;
}

.table tbody th {
	font-weight: normal;
}

/* Add User and Search Bar Section */
.search-bar-section {
	margin: 20px 0;
}

.search-bar-section form {
	display: flex;
	align-items: center;
	justify-content: space-between;
}

.search-bar-section .btn {
	margin-left: 10px;
}

.add-user-btn {
	background-color: #0d6efd;
	color: white;
}

.find-user-btn {
	background-color: #198754;
	color: white;
}
</style>
</head>
<body>

	<div class="container-fluid">
		<div class="row align-items-center">
			<!-- Logo Section -->
			<div class="col-md-6">
				<img src="image/logo1.jpg" alt="Reuban College Logo"
					class="img-fluid" style="width: 70%; height: 30%;">
			</div>
			<!-- User Profile Section -->
			<div class="col-md-6 text-end">
				<div class="d-flex align-items-center justify-content-end">
					<a href="/profile" class="username-link">Username</a> <a href=""
						class="username-link1"><i class="bi bi-person-circle"
						style="font-size: 50px; margin-right: 10px;"></i></a>
				</div>
			</div>
		</div>
	</div>

	<!-- Header Section -->
	<header class="d-flex justify-content-end align-items-center"
		style="background-color: #839492; color: #fff; padding: 10px;">
		<nav>
			<ul class="nav">
				<li class="nav-item"><a class="btn custom-btn me-4"
					href="adminHome.jsp">Home</a></li>
				<li class="nav-item"><a class="btn custom-btn me-4"
					href="managepri.jsp">Manage Events</a></li>
				<!-- <li class="nav-item">
                    <a class="btn custom-btn me-4" href="">Make An Announcement</a>
                </li>
                <li class="nav-item">
                    <a class="btn custom-btn me-4" href="">Check Attendance</a>
                </li>
                <li class="nav-item">
                    <a class="btn custom-btn me-4" href="">Communication</a>
                </li> -->
				<li class="nav-item"><a class="btn custom-btn me-4" href="">Log	out</a></li>
			</ul>
		</nav>
	</header>

	<div class="container">
		<div class="row justify-content-center">
			<div class="col-md-8 form-container">
				<h2 class="form-heading">Update Event</h2>

				<!-- Form for adding user -->
				<form action="updatevent" method="post">
					<div class="mb-3 form-group">
                        <label for="name">eventid</label>
                        <input type="text" class="form-control" id="is" name="id" value='${ptss.eventid}' / readonly>
                    </div>
                    <div class="mb-3 form-group">
                        <label for="name">eventName</label>
                        <input type="text" class="form-control" id="name" name="name" value='${ptss.eventName}'>
                    </div>
                    <div class="mb-3 form-group">
                        <label for="InCharge">eventInCharge</label>
                        <input type="text" class="form-control" id="InCharge" name="InCharge" value='${ptss.eventInCharge}'>
                    </div>
                    <div class="mb-3 form-group">
                        <label for="userType">eventDate</label>
                        <input type="text" class="form-control" id="Date" name="Date" value='${ptss.eventDate}'>
                        
                    </div>
                    
					<!-- Buttons -->
					<div class="form-group mb-2 row">
						<input type="submit" class="btn btn-warning" value="Update Event">
					</div>
				</form>
			</div>
		</div>
	</div>
	<br>
	<br>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
	<!-- Footer Section -->
	<footer class>
		<p>
			&copy; 2024 Reuban College G10. <br>All rights reserved.
		</p>
	</footer>

</body>
</html>
