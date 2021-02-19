USE master
IF  EXISTS (SELECT name FROM sys.databases WHERE name = 'SchoolManagementSystem')
DROP DATABASE SchoolManagementSystem;
GO

CREATE DATABASE SchoolManagementSystem;
GO

USE SchoolManagementSystem
GO

DROP TABLE IF EXISTS dbo.AdminCode
CREATE TABLE AdminCode(
	access_code VARCHAR(6) UNIQUE,
	CHECK (access_code LIKE '[0-9]%') 
)
GO

DROP TABLE IF EXISTS dbo.Account
CREATE TABLE Account (
	name				   VARCHAR(255),
	username			   VARCHAR(255),
	password               VARCHAR(255),
	role				   INT,
	ID					   INT,
	CHECK (password <> username),
	UNIQUE (username, password)
)
GO

DROP TABLE IF EXISTS dbo.Class;
CREATE TABLE Class (
    class_ID				VARCHAR(255)		PRIMARY KEY,
	class_section			VARCHAR(255)		NOT NULL,
);
GO

DROP TABLE IF EXISTS dbo.Student;
CREATE TABLE Student (
    student_ID				INT					PRIMARY KEY,
    student_name			VARCHAR(255)		NOT NULL,
    student_gender			VARCHAR(6)			NOT NULL,
	class_ID				VARCHAR(255)		REFERENCES Class (class_ID)			
							ON DELETE CASCADE	ON UPDATE SET NULL,
	level					VARCHAR(255)		NOT NULL
);
GO

DROP TABLE IF EXISTS dbo.Staff;
CREATE TABLE Staff (
    staff_ID               INT					PRIMARY KEY,
    staff_name             VARCHAR(255)			NOT NULL,
);
GO

DROP TABLE IF EXISTS dbo.Subject;
CREATE TABLE Subject (
	subject_ID			   VARCHAR(255)			PRIMARY KEY,
	subject_name		   VARCHAR(255)			NOT NULL,
	subject_group		   INT					NOT NULL
)
GO

DROP TABLE IF EXISTS dbo.Check_student_enrollment;
CREATE TABLE Check_student_enrollment(
	enrollment_ID		   INT					PRIMARY KEY ,
	student_ID			   INT					REFERENCES Student (student_ID)
						   ON DELETE CASCADE	ON UPDATE NO ACTION,
	subject_name	       VARCHAR(255),
	subject_ID		       VARCHAR(255)			REFERENCES Subject (subject_ID)
						   ON DELETE CASCADE	ON UPDATE SET NULL,
	UNIQUE (student_ID, subject_name) 
)
GO

DROP TABLE IF EXISTS dbo.Class_allocation;
CREATE TABLE Class_allocation (
	enrollment_ID		   INT					REFERENCES Check_student_enrollment(enrollment_ID)
						   ON DELETE CASCADE	ON UPDATE CASCADE,
    subject_ID			   VARCHAR(255)			,
    staff_ID			   INT					REFERENCES Staff (staff_ID)
						   ON DELETE SET NULL	ON UPDATE SET NULL,
    student_ID		       INT,
	class_ID			   VARCHAR(255),
	room			       VARCHAR(255)			NOT NULL,
);
GO

DROP TABLE IF EXISTS dbo.Classroom_assignments;
CREATE TABLE Classroom_assignments (
    assignment_ID		   INT					PRIMARY KEY,
    staff_ID               INT					REFERENCES Staff (staff_ID)
						   ON DELETE CASCADE	ON UPDATE NO ACTION,
    subject_ID             VARCHAR(255)			REFERENCES Subject (subject_ID)
						   ON DELETE CASCADE	ON UPDATE NO ACTION,
    assignment_details     VARCHAR(255)			NOT NULL,
);
GO

DROP TABLE IF EXISTS dbo.Staff_salary
CREATE TABLE Staff_salary (
    staff_ID			   INT					REFERENCES Staff (staff_ID)
						   ON DELETE CASCADE	ON UPDATE NO ACTION,
    staff_name			   VARCHAR(255)			NOT NULL,
    salary				   MONEY				NOT NULL,
    payment_status         VARCHAR(3)			DEFAULT 'NO'
);
GO

DROP TABLE IF EXISTS dbo.Student_fee_information
CREATE TABLE Student_fee_information (
    fee_ID				   INT					PRIMARY KEY,
    student_ID			   INT					REFERENCES Student (student_ID)
						   ON DELETE CASCADE	ON UPDATE NO ACTION,
    fee					   MONEY				NOT NULL,
    payment_status		   VARCHAR(3)			DEFAULT 'NO',
	day_of_payment		   DATE					NOT NULL,
);
GO

--Here below are queries to import data from .xls (excel) files into the tables:

/*	Before you can run a distributed query, 
	you have to enable the ad hoc distributed queries server configuration option, as shown in the following example. 

	sp_configure 'show advanced options', 1;
	RECONFIGURE;
	GO
	sp_configure 'Ad Hoc Distributed Queries', 1;
	RECONFIGURE;
	GO

	**COMMON ERRORS**
	1) Microsoft.ACE.OLEDB.12.0" has not been registered
		This error occurs because the OLEDB provider is not installed. 
		Install it from Microsoft Access Database Engine 2010 Redistributable. 
		Be sure to install the 64-bit version if Windows and SQL Server are both 64-bit.

		The full error is:

			[...]
			The OLE DB provider "Microsoft.ACE.OLEDB.12.0" has not been registered.

		Please download from below link and set up it. 	
		https://www.microsoft.com/en-us/download/details.aspx?id=13255

	2) Cannot create an instance of OLE DB provider "Microsoft.ACE.OLEDB.12.0" for linked server "(null)"
		This indicates that the Microsoft OLEDB has not been configured properly. 
		The full error is:

			[...]
			Cannot create an instance of OLE DB provider "Microsoft.ACE.OLEDB.12.0" for linked server "(null)".

		Run the following Transact-SQL code to resolve this:

				EXEC sp_MSset_oledb_prop N'Microsoft.ACE.OLEDB.12.0', N'AllowInProcess', 1
				EXEC sp_MSset_oledb_prop N'Microsoft.ACE.OLEDB.12.0', N'DynamicParameters', 1
	3) The 32-bit OLE DB provider "Microsoft.ACE.OLEDB.12.0" cannot be loaded in-process on a 64-bit SQL Server
		This occurs when a 32-bit version of the OLD DB provider is installed with a 64-bit SQL Server. 
		To resolve this issue, uninstall the 32-bit version and install the 64-bit version of the OLE DB provider instead.

		The full error is:

			[...]
			The 32-bit OLE DB provider "Microsoft.ACE.OLEDB.12.0" cannot be loaded in-process on a 64-bit SQL Server.
	
	4) For further error, please visit the link below:
		https://docs.microsoft.com/en-us/sql/relational-databases/import-export/import-data-from-excel-to-sql?view=sql-server-ver15#common-errors

*/

-- Note: Please CHANGE the path name of address of all the import queries below:

DROP TABLE IF EXISTS dbo.ImportIntoTable
SELECT * INTO ImportIntoTable
FROM OPENROWSET('Microsoft.ACE.OLEDB.12.0',
'Excel 12.0; Database=C:\SQL Lab\ASSIGNMENT\Import Data - Excel Files\Admin_code.xls; HDR=YES; IMEX=1',
'SELECT * FROM [Sheet1$]');
GO
INSERT INTO AdminCode
SELECT * FROM ImportIntoTable
GO

DROP TABLE IF EXISTS dbo.ImportIntoTable
SELECT * INTO ImportIntoTable
FROM OPENROWSET('Microsoft.ACE.OLEDB.12.0',
'Excel 12.0; Database=C:\SQL Lab\ASSIGNMENT\Import Data - Excel Files\Account.xls; HDR=YES; IMEX=1',
'SELECT * FROM [Sheet1$]');
GO
INSERT INTO Account
SELECT * FROM ImportIntoTable
GO

DROP TABLE IF EXISTS dbo.ImportIntoTable
SELECT * INTO ImportIntoTable
FROM OPENROWSET('Microsoft.ACE.OLEDB.12.0',
'Excel 12.0; Database=C:\SQL Lab\ASSIGNMENT\Import Data - Excel Files\Class.xls; HDR=YES; IMEX=1',
'SELECT * FROM [Sheet1$]');
GO
INSERT INTO Class
SELECT * FROM ImportIntoTable
GO

DROP TABLE IF EXISTS dbo.ImportIntoTable
SELECT * INTO ImportIntoTable
FROM OPENROWSET('Microsoft.ACE.OLEDB.12.0',
'Excel 12.0; Database=C:\SQL Lab\ASSIGNMENT\Import Data - Excel Files\Student.xls; HDR=YES; IMEX=1',
'SELECT * FROM [Sheet1$]');
GO
INSERT INTO Student
SELECT * FROM ImportIntoTable
GO

DROP TABLE IF EXISTS dbo.ImportIntoTable
SELECT * INTO ImportIntoTable
FROM OPENROWSET('Microsoft.ACE.OLEDB.12.0',
'Excel 12.0; Database=C:\SQL Lab\ASSIGNMENT\Import Data - Excel Files\Staff.xls; HDR=YES; IMEX=1',
'SELECT * FROM [Sheet1$]');
GO
INSERT INTO Staff
SELECT * FROM ImportIntoTable
GO

DROP TABLE IF EXISTS dbo.ImportIntoTable
SELECT * INTO ImportIntoTable
FROM OPENROWSET('Microsoft.ACE.OLEDB.12.0',
'Excel 12.0; Database=C:\SQL Lab\ASSIGNMENT\Import Data - Excel Files\Subject.xls; HDR=YES; IMEX=1',
'SELECT * FROM [Sheet1$]');
GO
INSERT INTO Subject
SELECT * FROM ImportIntoTable
GO

DROP TABLE IF EXISTS dbo.ImportIntoTable
SELECT * INTO ImportIntoTable
FROM OPENROWSET('Microsoft.ACE.OLEDB.12.0',
'Excel 12.0; Database=C:\SQL Lab\ASSIGNMENT\Import Data - Excel Files\Check_student_enrollment.xls; HDR=YES; IMEX=1',
'SELECT * FROM [Sheet1$]');
GO
INSERT INTO Check_student_enrollment
SELECT * FROM ImportIntoTable
GO

DROP TABLE IF EXISTS dbo.ImportIntoTable
SELECT * INTO ImportIntoTable
FROM OPENROWSET('Microsoft.ACE.OLEDB.12.0',
'Excel 12.0; Database=C:\SQL Lab\ASSIGNMENT\Import Data - Excel Files\Class_allocation.xls; HDR=YES; IMEX=1',
'SELECT * FROM [Sheet1$]');
GO
INSERT INTO Class_allocation
SELECT * FROM ImportIntoTable
GO

DROP TABLE IF EXISTS dbo.ImportIntoTable
SELECT * INTO ImportIntoTable
FROM OPENROWSET('Microsoft.ACE.OLEDB.12.0',
'Excel 12.0; Database=C:\SQL Lab\ASSIGNMENT\Import Data - Excel Files\Classroom_assignments.xls; HDR=YES; IMEX=1',
'SELECT * FROM [Sheet1$]');
GO
INSERT INTO Classroom_assignments
SELECT * FROM ImportIntoTable
GO

DROP TABLE IF EXISTS dbo.ImportIntoTable
SELECT * INTO ImportIntoTable
FROM OPENROWSET('Microsoft.ACE.OLEDB.12.0',
'Excel 12.0; Database=C:\SQL Lab\ASSIGNMENT\Import Data - Excel Files\Staff_Salary.xls; HDR=YES; IMEX=1',
'SELECT * FROM [Sheet1$]');
GO
INSERT INTO Staff_Salary
SELECT * FROM ImportIntoTable
GO

DROP TABLE IF EXISTS dbo.ImportIntoTable
SELECT * INTO ImportIntoTable
FROM OPENROWSET('Microsoft.ACE.OLEDB.12.0',
'Excel 12.0; Database=C:\SQL Lab\ASSIGNMENT\Import Data - Excel Files\Student_fee_information.xls; HDR=YES; IMEX=1',
'SELECT * FROM [Sheet1$]');
GO
INSERT INTO Student_fee_information
SELECT * FROM ImportIntoTable
GO

DROP TABLE IF EXISTS dbo.ImportIntoTable
GO


--Some queries that to retrieve all the tables data

SELECT * FROM Class;					
GO
SELECT * FROM Student;					
GO
SELECT * FROM Staff;					
GO
SELECT * FROM Subject;					
GO
SELECT * FROM Check_student_enrollment; 
GO
SELECT * FROM Class_allocation;			
GO
SELECT * FROM Classroom_assignments;	
GO 
SELECT * FROM Staff_salary;				
GO
SELECT * FROM Student_fee_information;	
GO
SELECT * FROM Account;
GO
SELECT * FROM AdminCode;
GO


--Select all student name and their ID who enrolled all Subject

SELECT DISTINCT S.student_name, S.class_ID
FROM Student S, Class_allocation C
WHERE S.student_ID = C.student_ID
AND C.student_ID IN 
(
	SELECT DISTINCT C.student_ID
	FROM Class_allocation C
	GROUP BY C.student_ID
	HAVING COUNT(*) = 
	(
		SELECT COUNT(Result.sub_name)
		FROM
		(
			SELECT S.subject_name AS sub_name
			FROM Subject S
			GROUP BY S.subject_name
		)	AS Result
	)	
)
GO

--Find all student name and their ID who is Junior student and paid for school fee before 10/04/2020

SELECT S.student_name, S.student_ID, S.level, Sf.day_of_payment
FROM Student S, Student_fee_information Sf
WHERE S.student_ID = Sf.student_ID
AND S.level = 'Junior'
AND Sf.payment_status = 'YES' and Sf.day_of_payment <= '2020-04-10' 
GO

--Find all the staff and their class who is teaching 4 classes

SELECT S.staff_ID, S.staff_name, Result1.number_of_teaching_classes
FROM Staff S,	
(
	SELECT Result.staff_ID, COUNT(Result.subject_ID) AS number_of_teaching_classes
	FROM
	(
		SELECT DISTINCT C.subject_ID, C.staff_ID
		FROM Class_allocation C
	)	AS Result
	GROUP BY Result.staff_ID
) AS Result1
WHERE S.staff_ID = Result1.staff_ID 
AND Result1.number_of_teaching_classes = 4
GO

--Find all student who is female:
SELECT * 
FROM Student WHERE student_gender = 'Female';
GO

--Find staff who teaches Marxism:
SELECT DISTINCT S.staff_name
FROM Staff S, Class_allocation C, Subject Su
WHERE S.staff_Id = C.staff_ID 
AND C.subject_ID = Su.subject_ID 
AND Su.subject_name = 'Marxism';
GO

--Find all the subject name and subject group of staff name “Vo Thi Luu Phuong”:
SELECT DISTINCT S.subject_name, S.subject_group 
FROM Subject S, Class_allocation C , Staff Sf
WHERE S.subject_ID = C.subject_ID 
AND Sf.staff_name = 'Vo Thi Luu Phuong'
AND C.staff_ID = Sf.staff_ID
GO