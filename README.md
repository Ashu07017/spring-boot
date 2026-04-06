# spring-boot
I am building a Spring Boot RBAC project.

Setup:
- Spring Boot + H2 database
- Users stored in data.sql
- Using Basic Auth
- NoOpPasswordEncoder
- Custom UserDetailsService implemented

Working:
- Login works in frontend
- H2 console working
- Users visible in DB

Issue:
- Postman request to /api/admin/users returns 401 Unauthorized

AdminController:
(GET /api/admin/users exists)

SecurityConfig:
- /api/admin/** requires ADMIN role

What could be wrong?
