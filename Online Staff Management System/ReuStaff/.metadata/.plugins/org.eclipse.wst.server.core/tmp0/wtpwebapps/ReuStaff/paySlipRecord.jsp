<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Home Page</title>
    <!-- Corrected CSS path with context -->
    <link rel="stylesheet" type="text/css" href="css/home.css">
    
    <!-- Bootstrap CDN -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" 
    integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    
    <!-- Bootstrap Icons -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css">

    <style>
        /* Inline styling as you have it */
        .username-link {
            color: #0d0d0e;
            text-decoration: none;
            font-weight: bold;
            margin-right: 50px;
            font-size: 30px;
        }

        .username-link1 {
            color: #0d0d0e;
            text-decoration: none;
            font-weight: bold;
            font-size: 30px;
        }

        .username-link:hover, .username-link1:hover {
            color: rgb(14, 85, 85);
            text-decoration: none;
        }

        /* Announcement Section */
        .announcement-section {
            background: radial-gradient(circle at top left, #91ddd2, #bec4c5);
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
<%
    String username = (String) session.getAttribute("username");
    if (username == null) {
        response.sendRedirect("index.jsp");
    }
%>
    <div class="container-fluid">
        <div class="row align-items-center">
            <!-- Corrected image path with context -->
            <div class="col-md-6">
                <img src="image/logo1.jpg" alt="Reuban College Logo" class="img-fluid" style="width: 70%; height: 30%;">
            </div>
            <div class="col-md-6 text-end">
                <div class="d-flex align-items-center justify-content-end">
                    <a href="/profile" class="username-link">${username}</a> 
                    <a href="" class="username-link1">
                        <i class="bi bi-person-circle" style="font-size: 50px; margin-right: 10px;"></i>
                    </a>
                </div>
            </div>
        </div>
    </div>

    <!-- Header Section -->
    <header class="d-flex justify-content-end align-items-center" style="background-color: #839492; color: #fff; padding: 10px;">
        <nav>
            <ul class="nav">
                <!-- Updated navigation links with context paths -->
                <li class="nav-item">
                    <a class="btn custom-btn me-4" href="payHome.jsp">Home</a>
                </li>
                <li class="nav-item">
                    <a class="btn custom-btn me-4" href="payrollPaySlip.jsp">Issue Pay Slip</a>
                </li>
                <li class="nav-item">
                    <a class="btn custom-btn me-4" href="logout">Log out</a>
                </li>
            </ul>
        </nav>
    </header>

    
    <!-- Table Section (Replaces the Form Section) -->
    <div class="container mt-4 position-relative">
        <h2 class="text-left">Payslip Details</h2>
        <hr size="6" class="mt-6">
			
			
		
        <!-- Table showing pay slip details -->
		<table class="table table-striped table-bordered">
			<thead class="thead-dark">
				<tr>
					<th>PaySlip ID</th>
					<th>Staff Member ID</th>
					<th>Month</th>
					<th>Bonus Amount</th>
					<th>Basic Amount</th>
					<th>Total Amount</th>
					<th>Issued By</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="p" items="${pt}">
					<tr>
						<td><c:out value='${p.payslipID}'/></td>
						<td><c:out value='${p.memberID}'/></td>
						<td><c:out value='${p.month}'/></td>
						<td><c:out value='${p.bonus}'/></td>
						<td><c:out value='${p.basic}'/></td>
						<td><c:out value='${p.total}'/></td>
						<td><c:out value='${p.officer}'/></td>
						 
						<td>
						<td>
            			<a href="update?id=${p.payslipID}" class="btn btn-success" style="display:inline">Update</a>
            			<form action="deleteSlip" method="get" style="display:inline">
            				<input type="hidden" name="id" value="${p.payslipID }">
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
        <p>&copy; 2024 Reuban College G10. <br>All rights reserved.</p>
    </footer>
    
</body>
</html>
