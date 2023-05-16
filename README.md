# Mapping 👋

## Frameworks and Language used:
 - Spring
 - Spring boot
 - My-Sql
 - Java


 ## Data Flow
 #### Controller
---Student----
 - getAllStudent
 - addStudent
 - deleteStudentById
 - updateStudent

 ---Address----
 - getAllAddress
 - addAddress
 - deleteAddressById
 - updateAddress

 ---Book----
 - getAllBook
 - addBook
 - deleteBookById
 - updateBook

 ---Course----
 - getAllCourse
 - addCourse
 - deleteCourseById
 - updateCourse

---Laptop----
 - getAllLaptop
 - addLaptop
 - deleteLaptopById
 - updateLaptop

 #### Service
  ---Student----
 - getAllStudent
 - addStudent
 - deleteStudentById
 - updateStudent

 ---Address----
 - getAllAddress
 - addAddress
 - deleteAddressById
 - updateAddress

 ---Book----
 - getAllBook
 - addBook
 - deleteBookById
 - updateBook

 ---Course----
 - getAllCourse
 - addCourse
 - deleteCourseById
 - updateCourse

---Laptop----
 - getAllLaptop
 - addLaptop
 - deleteLaptopById
 - updateLaptop

 #### Repository
 ---Student----

 IStudentRepository

 ---Address----

 IAddressRepository

 ---Laptop----

 ILaptopRepository

 ---Course----

 ICourseRepository

 ---Book----

 IBookRepository

 #### Model
 ---Student----
 - id
 - name
 - age
 - phoneNumber
 - department
 - address
 
 ---Address----
 - addressId
 - landmark
 - zipcode
 - district
 - state
 - country

 ---Book----
 - id
 - title
 - Author
 - description
 - price
 - Student

 ---Course----
 - id
 - title
 - description
 - duration
 - studentList

---Laptop----
- id
- name
- brand
- price
- student
 
### Project Summary
Created a simple Mapping project to show all the mapping like @OnetoOne, @ManytoMany, @OnetoMany, @ManytoOne.Created 5 different models with having different foreign key relationship with each other.

### How to use in your system?
 - Just Simply clone this reposit
 - Start your server
 - Perform operations 
