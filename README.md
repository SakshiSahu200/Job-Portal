# Job-Portal

# 🧰 Job Portal Application

A full-featured Job Portal built with **Spring MVC**, **Spring Security**, **Spring Data JPA**, and **PostgreSQL** to facilitate job search, application tracking, and user management for both recruiters and candidates.

## 🚀 Features

- ✅ **Core Modules**: 
  - Job posting & application tracking
  - Profile management for recruiters and candidates
  - Role-based dashboards for different user types

- 📄 **Resume Handling**:
  - Job application functionality with resume upload/download support
  - Real-time email or UI notifications on job application status

- 🔐 **Secure Authentication**:
  - Implemented Spring Security with role-based access control
  - Custom login success handlers based on user roles (admin/recruiter/candidate)

- 🛠️ **Admin Controls**:
  - Approve/reject job posts
  - Monitor user activity
  - Manage overall platform operations

- 🔍 **Global Search**:
  - Integrated advanced search for jobs and candidates
  - Multi-criteria filtering (keywords, roles, location, etc.)

- 🗄️ **Database**:
  - PostgreSQL used to manage relational data: jobs, users, resumes, and applications
  - Optimized with JPA repositories and query abstraction

## 💻 Technologies Used

- Spring MVC
- Spring Security
- Spring Data JPA
- PostgreSQL
- Thymeleaf (UI Layer)
- jQuery & AJAX (Frontend-Backend communication)

