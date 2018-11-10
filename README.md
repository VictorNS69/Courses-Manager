# Courses Manager

The goal of this project is the development of a Java program to manage the students that are enrolled in the different courses offered by the university.

### Authors:
- [Victor Nieves Sanchez](https://twitter.com/VictorNS69)

- [Alejandro Carmona Ayllon](https://twitter.com/alejandro_C_A)

### Description of the methods:
A **new course** can be registered. The information associated to a course is its code, its name and its coordinator.

A **new student** can be registered. The information associated to a student is its identification
number, its name and its email address. 

The system can **enroll a student** in a course, by using the identification number of the student
and the course code. 

Given a course code, the system must return the **list of matriculated students**, returning its
identification number, name and surname. 

The student can **cancel** its enrollment in a course.

A course can be **restarted** and this operation must remove all students matriculated in the course.

The **list of all users registered** in the system, including its name, email and identification
number, can be obtained. 

The **list of all courses**, sorted by their code, can be obtained.

### Structure of the project:
	├── pom.xml
	├── PProject_TDDAssignment.pdf
	├── README.md
	├── src
	│   ├── main
	│   │   └── java
	│   │       └── es
	│   │           └── upm
	│   │               └── pproject
	│   │                   └── tdd
	│   │                       ├── Course.java
	│   │                       ├── exceptions
	│   │                       │   ├── AlreadyInTheSystemException.java
	│   │                       │   ├── DuplicatedException.java
	│   │                       │   ├── EmptyListException.java
	│   │                       │   ├── InvalidInputArgumentException.java
	│   │                       │   ├── MaxCapacityException.java
	│   │                       │   └── NotInTheSystemException.java
	│   │                       ├── Manager.java
	│   │                       ├── MyInterface.java
	│   │                       └── Student.java
	│   └── test
	│       └── java
	│           └── es
	│               └── upm
	│                   └── pproject
	│                       └── tdd
	│                           ├── CancelTest.java
	│                           ├── EnrollStudentTest.java
	│                           ├── ListCoursesTest.java
	│                           ├── ListStudentsInCourseTest.java
	│                           ├── ListUsersTest.java
	│                           ├── ManagerTest.java
	│                           ├── NewCourseTest.java
	│                           ├── NewStudentTest.java
	│                           └── RestartedTest.java


### Copyright:
This exercise was proposed in the 2018/2019 course of the **_Programming Project_** subject. All rights reserved for authors and the teacher **_Guillermo Roman_**.

[Escuela Técnica Superior de Ingenieros Informáticos](http://www.etsiinf.upm.es/)

[Universidad Politécnica de Madrid](http://www.upm.es/)

### Tools Used:
```
Java 1.8

OpenJDK 8

GIT 2.19.1

Maven 3.5.4

JUnit 5.20

Sonar 3.3.0
```  
