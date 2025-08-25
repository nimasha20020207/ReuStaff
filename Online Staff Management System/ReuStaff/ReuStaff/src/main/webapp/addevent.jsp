<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Add Event Page</title>
<link rel="stylesheet" type="text/css" href="css/home.css">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
	crossorigin="anonymous">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css">

<style>
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

/* Adjusting the height of the search bar */
.search-bar-section input {
	height: 40px; /* Adjust the height */
	font-size: 16px; /* Adjust the font size to match the new height */
}
</style>

<script type="text/javascript">
function confirmDelete(event) {
    var result = confirm("Are you sure?"); // Correct spelling of 'confirm'
    
    if (result) {
        // If confirmed, submit the form
        document.getElementById("com").submit();
    } else {
    	event.preventDefault(); // Correct spelling of 'alert'
        
    }
}
</script>
</head>
<body>

	<div class="container-fluid">
		<div class="row align-items-center">
			<!-- Logo Section -->
			<div class="col-md-6">
				<img src="image/logo1.jpg" alt="Reuban College Logo"class="img-fluid" style="width: 70%; height: 30%;">
			</div>
			<!-- User Profile Section -->
			<div class="col-md-6 text-end">
				<div class="d-flex align-items-center justify-content-end">
					<a href="/profile" class="username-link">${username}</a> <a href=""
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
				<li class="nav-item"><a class="btn custom-btn me-4" href="managepri.jsp">Manage
						Events</a></li>
				<!-- <li class="nav-item">
                    <a class="btn custom-btn me-4" href="">Make An Announcement</a>
                </li>
                <li class="nav-item">
                    <a class="btn custom-btn me-4" href="">Check Attendance</a>
                </li>
                <li class="nav-item">
                    <a class="btn custom-btn me-4" href="">Communication</a>
                </li> -->
				<li class="nav-item"><a class="btn custom-btn me-4" href="logout">Logout</a></li>
			</ul>
		</nav>
	</header>

	<!-- Search Bar and Add User Section -->
	<div class="container search-bar-section">
		<div class="row">
			<!-- Add User button -->
			<div class="col-auto">
				<form>
					<a href="insertevent.jsp" class="btn btn-primary custom-btn-lg mx-1">Add New Event</a>
				</form>
			</div>

			<!-- View button -->
			<div class="col-auto">
				<form action="addevent" method="post" style="display: inline;">
					<button type="submit" class="btn btn-success">View Event Details</button>
				</form>
			</div>
		</div>
	</div>

	<div class="row w-75 mx-auto">
		<h2 class="he text-center">Event List</h2>
		<hr size="6" class="mt-6">
		<table class="table mt-2">
			<thead class="table-secondary">
				<tr>
                    <th>Event ID</th>
                    <th>Event Name</th>
                    <th>Event Incharge</th>
                    <th>Event Date</th>
                    <th>Action</th>
                </tr>
			</thead>
			<tbody>
                <c:forEach var="ptss" items="${pts}">
                    <tr>
                        <td><c:out value='${ptss.eventid}' /></td>
                        <td><c:out value='${ptss.eventName}' /></td>
                        <td><c:out value='${ptss.eventInCharge}' /></td>
                        <td><c:out value='${ptss.eventDate}' /></td>
                        <td>
                            <a href="updateuu?eventid=${ptss.eventid}" class="btn btn-success">Edit</a>
                            <form action="delete" method="post" style="display: inline;">
                                <input type="hidden" name="eventid" value="${ptss.eventid}">
                                <button type="submit" class="btn btn-danger" onclick="confirmDelete(event)">Delete</button>
                            </form>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
		</table>
	</div>

	<!-- Footer Section -->
	<footer>
		<p>
			&copy; 2024 Reuban College G10. <br>All rights reserved.
		</p>
	</footer>

</body>
</html>
