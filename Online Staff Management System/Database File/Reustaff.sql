-----User Account Table-----

CREATE TABLE userst (
    id INT PRIMARY KEY AUTO_INCREMENT,
    username VARCHAR(50),
    password VARCHAR(50),
    type VARCHAR(20) 
);

----Insert Data-----

INSERT INTO userst (username, password, type) 
VALUES ('admin1', '123', 'admin');
INSERT INTO userst (username, password, type) 
VALUES ('P001', '123', 'principle');
INSERT INTO userst (username, password, type) 
VALUES ('A001', 'a123', 'admin');
INSERT INTO userst (username, password, type) 
VALUES ('T001', 'a123', 'teacher');
INSERT INTO userst (username, password, type) 
VALUES ('PF001', 'a123', 'payrall');

----Staff member Table----

CREATE TABLE staffmember (
    memberid varchar(20) PRIMARY KEY,
    sname VARCHAR(100) NOT NULL,              
    mail VARCHAR(100) NOT NULL,               
    stype VARCHAR(50) NOT NULL                 
);

----Insert Data-----

INSERT INTO staffmember (memberid, sname, mail, stype) VALUES
('A001', 'John Doe', 'john.doe@example.com', 'Admin'),
('T002', 'Jane Smith', 'jane.smith@example.com', 'Teacher'),
('P003', 'Alex Johnson', 'alex.johnson@example.com', 'Payroll Officer');


----Event Table---

CREATE TABLE eventde (
	eventid varchar(20) PRIMARY KEY,
	eventName varchar(100) NOT NULL,
	eventInCharge varchar(100) NOT NULL,
	EventDate varchar(100) NOT NULL
); 


----Insert Data-----

INSERT INTO eventde (eventid, eventName, eventInCharge, EventDate) VALUES
('E001', 'Annual Sports Day', 'John Doe', '2024-10-20'),
('E002', 'Science Fair', 'Jane Smith', '2024-11-15'),
('E003', 'Music Festival', 'Emily Davis', '2024-12-01'),
('E004', 'Art Exhibition', 'Michael Brown', '2024-12-10'),
('E005', 'Graduation Ceremony', 'Sarah Johnson', '2025-01-15');


---pay Slip----

create table payslip(
payslipID int primary key,
staffMemberID varchar(20),
Month varchar(20),
Bonus float,
Basic float,
Total float,
PayRollOfficerID varchar(20)
);


---Insert Data-----

INSERT INTO payslip (payslipID, staffMemberID, Month, Bonus, Basic, Total, PayRollOfficerID)
VALUES 
(1, 'SM001', 'January', 500.00, 3000.00, 3500.00, 'PRO001'),
(2, 'SM002', 'February', 450.00, 3200.00, 3650.00, 'PRO002'),
(3, 'SM003', 'March', 600.00, 3100.00, 3700.00, 'PRO001'),
(4, 'SM004', 'April', 400.00, 2900.00, 3300.00, 'PRO003'),
(5, 'SM005', 'May', 550.00, 3050.00, 3600.00, 'PRO002');

