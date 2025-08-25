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

     <!-- Form Section  -->
    <div class="container mt-4 position-relative">
        <h2 class="text-left">Update payslip</h2>
        <hr size="6" class="mt-6">

        <!-- Form with renamed input fields -->
        <form class="bg-light p-4 rounded" action="updateCatch" method="GET">
        
        	 <div class="mb-3">
                <input type="text" class="form-control" id="pid" name="PayID" value="<c:out value='${pslip.payslipID}'/>" readonly>
            </div>
            
            <div class="mb-3">
                <label for="staffID" class="form-label">Enter Staff Member ID</label>
                <input type="text" class="form-control" id="staffID" name="staffID" value="<c:out value='${pslip.memberID}'/>">
            </div>
            <div class="mb-3">
                <label for="month" class="form-label">Month</label>
                <select class="form-control" id="month" name="month">
                <option value="January" <c:if test="${pslip.month == 'January'}">selected</c:if>>January</option>
                <option value="February" <c:if test="${pslip.month == 'February'}">selected</c:if>>February</option>
                <option value="March" <c:if test="${pslip.month == 'March'}">selected</c:if>>March</option>
                <option value="April" <c:if test="${pslip.month == 'April'}">selected</c:if>>April</option>
                <option value="May" <c:if test="${pslip.month == 'May'}">selected</c:if>>May</option>
                <option value="June" <c:if test="${pslip.month == 'June'}">selected</c:if>>June</option>
                <option value="July" <c:if test="${pslip.month == 'July'}">selected</c:if>>July</option>
                <option value="August" <c:if test="${pslip.month == 'August'}">selected</c:if>>August</option>
                <option value="September" <c:if test="${pslip.month == 'September'}">selected</c:if>>September</option>
                <option value="October" <c:if test="${pslip.month == 'October'}">selected</c:if>>October</option>
                <option value="November" <c:if test="${pslip.month == 'November'}">selected</c:if>>November</option>
                <option value="December" <c:if test="${pslip.month == 'December'}">selected</c:if>>December</option>
            </select>
            </div>
            <div class="mb-3">
                <label for="bonusAmount" class="form-label">Bonus Amount</label>
                <input type="number" class="form-control" id="bonusAmount" name="bonusAmount" value="<c:out value='${pslip.bonus }'/>">
            </div>
            <div class="mb-3">
                <label for="basicAmount" class="form-label">Basic Amount</label>
                <input type="number" class="form-control" id="basicAmount" name="basicAmount" value="<c:out value='${pslip.basic }'/>">
            </div>
            <div class="mb-3">
                <label for="salaryTotal" class="form-label">Salary Total</label>
                <input type="number" class="form-control" id="salaryTotal" name="salaryTotal" value="<c:out value='${pslip.total }'/>">
            </div>
            <div class="mb-3">
                <label for="issuedBy" class="form-label">Payslip Issued By</label>
                <input type="text" class="form-control" id="issuedBy" name="issuedBy" value="<c:out value='${pslip.officer}'/>">
            </div>
            <button type="submit" class="btn btn-primary">Save & exit</button>
        </form>
    </div>
    
    
    
    
    
    
    <!-- Footer Section -->
    <footer>
        <p>&copy; 2024 Reuban College G10. <br>All rights reserved.</p>
    </footer>
    
</body>
</html>
